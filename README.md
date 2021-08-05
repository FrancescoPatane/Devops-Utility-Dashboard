"# Devops-Utility-Dashboard" 

root progetto common ---> mvn clean install


root progetto dashboard ---> mvn clean compile package

docker build -t utility-dashboard . 



root progetto converter ---> mvn clean compile package

docker build -t utility-converter . 



root progetto bundlechecktool ---> mvn clean compile package

docker build -t utility-bundlechecktool . 



root progetto diagnostictool ---> mvn clean compile package

docker build -t utility-diagnostictool . 



docker-compose up -d


docker logs -f utility-converter

docker logs -f utility-dashboard

docker logs -f utility-bundlechecktool

...