"# Devops-Utility-Dashboard" 



root progetto dashboard ---> mvn clean compile package

docker build -t utility-dashboard . 




root progetto converter ---> mvn clean compile package

docker build -t utility-converter . 




root progetto bundlechecktool ---> mvn clean compile package

docker build -t utility-bundlechecktool . 



docker-compose up -d



docker logs -f utility-converter

docker logs -f utility-dashboard