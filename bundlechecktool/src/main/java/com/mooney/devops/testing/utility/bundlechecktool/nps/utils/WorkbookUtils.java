package com.mooney.devops.testing.utility.bundlechecktool.nps.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mooney.devops.testing.utility.bundlechecktool.nps.beans.BundleComparison;
import com.mooney.devops.testing.utility.bundlechecktool.web.dto.FileTransferDto;

@Component
public class WorkbookUtils {

	private  final Logger logger = Logger.getLogger(WorkbookUtils.class.getName());

	private  String fileNamePostfix;    
	private static final String FILENAME = "BundleVersion_";


	@Autowired
	private Environment springEnv;

	private WorkbookUtils() {}


	public FileTransferDto createExcelFile(List<BundleComparison> bundleComparisons, String mainEnv, String envToCheck) throws Exception {

		String[] columns = new String[4];

		try(Workbook workbook = new XSSFWorkbook()) {

			fileNamePostfix = "src."+mainEnv+"-dest."+envToCheck;
			//	    loadProps();

			columns[0] = "SRC ("+mainEnv+")";
			columns[1] = "SRC Bundle Versions";
			columns[2] = "DEST ("+envToCheck+")";
			columns[3] = "DEST Bundle Versions";

			Sheet sheet = workbook.createSheet("Bundle versions");

			Font headerFont = getHeaderFont(workbook);
			CellStyle headerCellStyle = getHeaderCellStyle(workbook, headerFont);
			Row headerRow = sheet.createRow(0);

			for(int i = 0 ; i < columns.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columns[i]);
				cell.setCellStyle(headerCellStyle);
			}

			int rowNumber = 1;
			for(BundleComparison bundleComparison : bundleComparisons) {
				Row row = sheet.createRow(rowNumber++);

				row.createCell(0).setCellValue(bundleComparison.getMainEnvBundleName());
				row.createCell(1).setCellValue(bundleComparison.getMainEnvBundleVersion());
				row.createCell(2).setCellValue(bundleComparison.getEnvToCheckBundleVersion());
				row.createCell(3).setCellValue(bundleComparison.getEnvToCheckBundleName());

				if(!bundleComparison.getMainEnvBundleVersion().equals(bundleComparison.getEnvToCheckBundleVersion())) {
					row.getCell(2).setCellStyle(getWrongVersionCellStyle(workbook));
				}
			}

			resizeAllColumns(sheet, columns);
			FileTransferDto file = writeOutputFile(workbook);
			return file;

		} 
		catch (IOException e) {
			e.printStackTrace();
			throw new Exception("ERROR creating excel file");
		}
	}

	private  Font getHeaderFont(Workbook workbook) {
		Font headerFont = workbook.createFont();

		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.BLACK.getIndex());

		return headerFont;
	}

	private  CellStyle getHeaderCellStyle(Workbook workbook, Font headerFont) {
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		return headerCellStyle;
	}

	private  Font getWrongVersionFont(Workbook workbook) {
		Font wrongVersionFont = workbook.createFont();

		wrongVersionFont.setBold(true);
		wrongVersionFont.setFontHeightInPoints((short) 12);
		wrongVersionFont.setColor(IndexedColors.RED.getIndex());

		return wrongVersionFont;
	}

	private  CellStyle getWrongVersionCellStyle(Workbook workbook) {
		CellStyle wrongVersionCellStyle = workbook.createCellStyle();
		wrongVersionCellStyle.setFont(getWrongVersionFont(workbook));

		return wrongVersionCellStyle;
	}

	private void resizeAllColumns(Sheet sheet, String[] columns) {
		for(int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}
	}

	private FileTransferDto writeOutputFile(Workbook workbook) throws IOException {        
			deleteFiles(Constants.PATH_COMPARATOR, FILENAME);
			String filePath= fileNameBuilder();
			File f = new File(filePath);
			if(!f.exists()){
				f.getParentFile().mkdirs();
				f.createNewFile();
			}

			FileOutputStream outputStream = new FileOutputStream(fileNameBuilder());

			workbook.write(outputStream);
			byte[] fileContent = Files.readAllBytes(f.toPath());
			byte[] encoded = Base64.getEncoder().encode(fileContent);
			String base64 = new String(encoded);
			FileTransferDto file = new FileTransferDto(f.getName(), "xlsx", "application/vnd.ms-excel", base64);
			f.delete();
			return file;
			
	}

	private void deleteFiles(String path, String filename) {
		try { 
			String delete = springEnv.getProperty("skipDeleteXlsx");
			if (Boolean.parseBoolean(delete)){
				return;
			}

			File directory = new File(path);
			for (File f : directory.listFiles()) {
				if (f.getName().startsWith(filename)) {
					f.delete();		        
					logger.info("Deletion successful.");
				}
			}	     
		} catch (Exception e) {
			logger.info("ERROR:"+e.getMessage());
			e.printStackTrace();
		} 	
	}

	private  String fileNameBuilder() {	
		StringBuilder sb = new StringBuilder();
		try {
			DateTimeFormatter timeStampFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			String fileNameCorrectDateTime = "_"+timeStampFormatter.format(LocalDateTime.now());

			sb.append(Constants.PATH_COMPARATOR);
			sb.append(FILENAME);
			sb.append(fileNamePostfix);
			sb.append(fileNameCorrectDateTime);
			sb.append(".xlsx");
		} catch (Exception e) {
			logger.info("ERROR:"+e.getMessage());
			e.printStackTrace();
		} 
		return sb.toString();
	}

	//    private  void loadProps() {
	//	try {
	//	    //props = new Properties();
	////	    FileInputStream inputStream = new FileInputStream(Constants.ENV_PROPERTIES);
	////	    props.load(inputStream);
	//	    props = Main.getProps();
	//	    if (props == null) {
	//		props = Utils.loadAllProperties(new Properties());
	//	    }	    
	//	    mainEnv = props.getProperty("env.main");
	//	    envToCheck = props.getProperty("env.tocheck");
	//	    
	//	    fileNamePostfix = "src."+mainEnv+"-dest."+envToCheck;
	//	}
	//	catch (Exception e){
	//	    e.printStackTrace();
	//	}
	////	} catch (FileNotFoundException e) {
	////	    e.printStackTrace();
	////	} catch (IOException e) {
	////	    e.printStackTrace();
	////	}
	//    }
}
