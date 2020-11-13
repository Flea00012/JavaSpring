# JavaSpring for SDA course

## Description

The project focused on the spring framework and implementing a Developer news website. The classes required in the project were articles entity, comments entity, likes entity and topics entity. The relationships in the project between the database entitities were many to one and many to many. These can be seen in the code.

## Notes

The project was implemented using the MVC architecture, and thus the entities each have a Controller and a Service. Each entity is a db entity and hence each have a Repository class to handle the db operations. 

Please note that the likes implementation for the project was done using ManyToMany relationship with the articles, and was the developers design decision, because the articles are made before the likes are generated for the articles. 

Please also note that the Postgres database has been used during this project along with Spring-Web. These dependancies need can be obtained from the Spring intialzr website. Any gradle dependancies can be obtain at MVN repository, and if so desired the gradle setup can be replaced with the Maven pom.xml setup.

## Running the code

After downloading the files from ``` bash git clone``` , please ensure that Docker is installed on the local machine, as well as ``` bash Docker-Compose```. To start the database please run the command ``` bash docker-compose up``` in the terminal, then use curl to generate data in the database. 

## MIT License



