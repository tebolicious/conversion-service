# Metric to Imperial Converter
Metric to Imperial  and Imperial to Metric Converter

Requirements:

JDK 11
Spring Boot 2.2
Spring Data JPA
Hibernate
Maven
PostgreSQL


The application relies on a PostgreSQL database for persistence.

The application runs on port 8080.

There are 2 ways to run the application:
1. Using Docker.
2. As a standalone application.

Using Docker:
1
1. Run `mvn clean install -DskipTests`
2. Run `sudo docker-compose up --build -d`

As a standalone application:
1. Install [PostgreSQL](https://www.postgresql.org/download/)
2. Configure datasource in `application.yml`.
3. `cd backend`.
4. Run `mvn install`.
5. Run `mvn spring-boot:run`.
6. Spring Boot will import mock data into database by executing `import.sql` automatically.
7. The backend server is running on [localhost:8080]().
8. Application Context `api`



Endpoints:
List Conversions: GET http://localhost:8080/conversion/

Add Conversion: POST http://localhost:8080/api/conversion/add
                Example Body: {
                                "category" : "TESTCATEGORY",
                                "unitFrom" : "UnitFrom",
                                "unitTo" : "unitTo",
                                "valueFrom" : "10",
                                "valueTo" : "0.1"
                              }

Convert: POST http://localhost:8080/api/conversion
         Example Body: {
                        "sourceUnit" : "Kilometers",
                        "destinationUnit" : "Mile",
                        "category" : "LENGTH",
                        "amount": 100
                        }


