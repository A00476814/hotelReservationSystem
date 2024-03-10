# Hotel Reservation System

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java JDK 21**: Make sure Java Development Kit (JDK) 21 is installed on your system. You can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) or through any OpenJDK version that matches JDK 21 features.
- **IDE for Spring Development**: You need an Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or Spring Tool Suite (STS) that supports Spring development.
- **Maven 3.9.6**: Apache Maven is used for project management and build. Ensure Maven 3.9.6 is installed. You can download it from the [Apache Maven Project website](https://maven.apache.org/download.cgi).

This project is built using Java JDK 21 and Maven 3.9.6.

## API Endpoints

The Hotel Reservation System provides the following endpoints:

### Add a New Hotel

To add a new hotel to the system, use the following `curl` command:

```bash
curl --location 'http://localhost:8080/mcda5550/hotels/addHotel' \
--header 'Content-Type: application/json' \
--data '{
    "name": "J W Marriot",
    "location": "Halifax",
    "noOfRooms": 90,
    "rating": 4.6
}'

```
### Get List of all Hotels

To get list of all hotels from the system, use the following `curl` command:


```bash
curl --location 'http://localhost:8080/mcda5550/hotels/getAllHotels' \
--header 'Content-Type: application/json' \
--data ''
```

Note: Above curls assume that the application is up loacally on port 8080. Please update the port number in URL as per scenario.

### Image of successfull postman execution of Post Command
<img src="https://drive.google.com/file/d/1L7pyXPY982dbhHz_Pp9rDILRzQOi7mZH/view?usp=sharing" alt="Add Hotel" width="500"/>

### Image of successfull postman execution of Get Command
<img src="https://drive.google.com/file/d/1L7pyXPY982dbhHz_Pp9rDILRzQOi7mZH/view?usp=sharing" alt="Get All Hotels" width="500"/>
