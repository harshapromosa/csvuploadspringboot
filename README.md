Running a Spring Boot Application
==================================
To run a Spring Boot application run the command: `docker-compose up` in the module directory

1) After changing the java files, please remove the image so that it will be build again when we use the above command.
2) for using application http://localhost:7000/authenticate post method below is the request body for rest api
    {
    "username":"admin",
    "password":"password"
	}
3) for the url http://localhost:7000/upload post method add an another param name file and multipart csv file.
    param key Authorization value : Bearer ****************