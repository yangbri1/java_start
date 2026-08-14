## Summary & Requirements
- Property expense application for partners
- Partners can upload receipts and track expensives on a per property basis
- User control access to expense reports per property with logging of changes done in the expenses

## Technology Requirements
* Spring Boot
* Spring Web, Spring JPA (or JDBC)
* SQL (H2 embedded, PostresSQL, etc.)
* React/Next.js
* Maven
* Github

- *Phase 1: Standard MVP --- Spring Boot, JPA, PostgresSQL + RESTful (CRUD)*
- *Phase 2: DTO's, Bean Validation, Global Exception Handling, Testing (Unit: JUnit, Mockito, Integration: Spring Boot Test, Testcontainers, PostgreSQL), Flyway, Spring Security, ... Docker*
- *Phase 3: Auditing (logging), events, (Kafka/Splunk) Monitoring, Async Processing, Analytics/ETL Pipelines, .... Cloud Deployment, Microservicess*

## Deadlines
* 1st Checkpoint: 8/21 (Standard MVP)
- 2nd Checkpoint: 8/28 (Production-Ready)
* 3rd Checkpoint: 9/4 (Enterprise Evolution)

## Getting Started
1. Clone down GitHub backend repository
    ```
    git clone [repo]
    ```
2. Install all necessary dependencies for this repo from pom.xl (Maven build tool)
    ```
    mvn clean install
    ```

## LINK TO FRONTEND
> TBA

## Backend Workflow
1. Head to https://start.spring.io/ to generate a boilerplate with desired dependencies. Download and extract the zip file to desired directory.
2. Check `application.properties` file to make sure all wanted dependencies are present, otherwise can always add more.
3. Start by working out the **Partner.java** & **Property.java** `@Entity` classes. In a sense the entity classes provides the schemas for `Partner` and `Property`.
4. DTO for obfuscating frontend code to others
5. Afterwards create **PartnerRepository.java** & **PropertyRepository.java** both *implements* from **JPARepository** which provides basic built-in CRUD methods. Also you could place customized method signatures here too.
6. Next, chisel out the business logic in the service layers **PartnerService.java** & **PropertyService.java**. Backend data validation could be instilled here.
7. Establish RESTful API endpoints as a way to expose the backend to frontend in `PartnerController.java` & `PropertyController.java`.
8. Run these commands in the terminal to build, compile, execute the Java program.
    ```
    mvn spring-boot:run
    ```
9. Utilize POSTMAN/Bruno for API endpoint testing (Thunder-Client & POSTMAN could be iffy) on default port:
    ```
    http://localhost:8080/partners
    ```
10. H2 console using SQL statements (if the SQL statements are funcitonal, this indirectly indicates that specific API endpoints are functional)
    ```
    http:/localhost:8080/h2-console/
    ```
    *(find your customized username & password under `application.properties`)
11. `exceptions` folder is there for future JUnits or any other type of testing --- Revisit blackbox, whitebox testing.
12. `data.sql` was included on a whim as a way to seed the `Partner` and `Property` database tables with some pre-existing records. Its location being in `resources` inherently invokes a Hibernate feature where Spring Boot will automatically detect and run `data.sql` after schema is created (depending on `@Entity` classes). Set up to trigger in `application.properties` file.
13. Initially the extracted Spring initializer package configures H2 to store data in memory:
    ```
    spring.datasource.url=jdbc:h2:mem:testdb
    ```
14. Sadly that means any newly created `Partner` or `Property` records would not persist in their respective database tables once the program halts. To combat this, configure H2 to store data in a FILE 'data/propertyexpenses-db' instead of in memory --- this way the DB records would persist regardless if the Spring Boot app were to close.
    ```
    spring.datasource.url=jdbc:h2:mem:testdb
    ```
    *Note: Occasionalyl after multiple `mvn spring-boot:run` there may be a need where the created `data` file may need to be deleted --- check for fix later*

## API Endpoints
   VERB 		 | 		  PATH 		 |  	 DESCRIPTION
------------ | ------------- | -------------------
`GET` | `/api/v1/properties` | Display all properties |
`POST` | `/api/v1/properties` | Create a new property to be added to the properties database |
`GET` | `/api/v1/properties/:propertyId` | Retrieve a specific property by their unique "propertyId" |
`GET` | `/api/v1/properties/location/local` | Present only LOCALLY listed properties |
`GET` | `/api/v1/properties/location/outofstate` | Present only REMOTE listed properties |
`PATCH` | `/api/v1/properties/:propertyId` | Access an existing property verified by its "propertyId" and update its info as pleased |
`DELETE` | `/api/v1/properties/:propertyId` | Access a property by their "propertyId" and delete it (admin access) |

`GET` | `/api/v1/transactions` | Lay out all of the transactions listed in the database |
`POST` | `/api/v1/transactions` | Assign a new transaction to be saved into the transaction database |
`GET` | `/api/v1/transactions/:transactionId` | Pick out one transaction by their unique "transactionId" |
`PUT` | `/api/v1/transactions/:transactionId` | Access an existing transaction verified by its "transactionId" and update its info as pleased |
`DELETE` | `/api/v1/transactions/:transactionId` | Access a transaction by their "transactionId" and delete it (admin access) |

`GET` | `/api/v1/properties/:propertyId/transactions` | Filter out transactions under a particular property |

## Upcoming TODO's
* Best length of description and field members for optiminal SEO 
https://www.baeldung.com/java-optional
https://theundercoverrecruiter.com/tips-writing-job-descriptions/
https://www.mentalfloss.com/article/646581/world-longest-place-names
https://atdata.com/blog/long-email-addresses/

* `@CreationTimestamp` annotation allows Hibernate to populate field automatically with timestamp of an entity first creation
https://stackoverflow.com/questions/49954812/how-can-you-make-a-created-at-column-generate-the-creation-date-time-automatical
https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html#mapping-generated-CreationTimestamp

* Explicitly force Spring Boot to load data to initialzie database from `data.sql`
https://stackoverflow.com/questions/45082574/spring-boot-doesnt-load-data-to-initialize-database-using-data-sql

* Enum for constants for `WorkArrangement` field
https://www.baeldung.com/a-guide-to-java-enums 
https://stackoverflow.com/questions/67233340/how-do-i-validate-or-restrict-enum-type-to-accept-only-specific-values
https://www.baeldung.com/jpa-persisting-enums-in-jpa

* Cross-Origin Resource Sharing (`@CrossOrigin` annotation) only included path relating to the origin: 
http://yangbri1.github.io

(DO NOT include the latter half of URL path `/fullstack_react_spring_boot_frontend/` otherwise CORS will fail)