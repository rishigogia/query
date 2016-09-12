# Query application
##### The Movie database query application

### Downloading the application
The application can be downloaded from the github webside 

### Description
This is a console based application that uses the system properties to query a particular API for a movie.

The application supports flexibility of adding multiple APIs by simply putting a reference in the application context, and creating an implementation of the parser.

### Running the application
> Prerequisites
>> Java
>> Maven

The application can be executed using below command

###### Test cases (using maven)
Please make sure maven is installed in the system. Please go to the project root (where pom.xml is present) and execute
> mvn test

This will execute the test cases
###### Executing using command line
First execute the below command
> mvn clean install

Once the above is executed, all the related jars etc are downloaded. Now execute below command (from project_root/src/main/java)
> java -Dapi=imdb -Dmovie="movie name" com.tsubaka.query.Query

###### Executing using Jar file
First execute the below command
> mvn clean install

Once the above is executed, all the related jars etc are downloaded and a shade (unified) version of the Query jar is created in the target folder. Now go to project_root/target folder and execute below command
> java -Dapi=imdb -Dmovie="movie name" -jar Query.jar

### Limitations
Currenty this supports only IMDB API (using unofficial OMDB URI). Support for more APIs can be embedded as the application is flexible to incorporate such changes.

