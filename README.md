"# Devops-Utility-Dashboard" 



root progetto dashboard ---> mvn clean compile package

docker build -t utility-dashboard . 

docker run -p 8080:8080 --name utility-dashboard -d utility-dashboard



root progetto converter ---> mvn clean compile package

docker build -t utility-converter . 

docker run -p 8081:8080 --name utility-converter -d utility-converter



docker-compose up -d



docker logs -f utility-converter

docker logs -f utility-dashboard