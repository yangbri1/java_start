## Summary & Requirements
- Property expense application for partners
- Partners can upload receipts and track expensives on a per property basis
- User control access to expense reports per property with logging of changes done in the expenses

## Technology Requirements
* Spring Boot
* Spring Web, Spring JPA (or JDBC)
* SQL (H2 embedded, Postres, etc.)
* React/Next.js
* Maven
* Github

## Deadlines
* 1st Checkpoint: 8/21
- 2nd Checkpoint: 8/28


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
`GET` | `/properties` | Display all properties |
`POST` | `/properties` | Create a new property to be added to the properties database |
`GET` | `/properties/:propertyId` | Retrieve a specific property by their unique "propertyId" |
`GET` | `/properties/location/local` | Present only LOCALLY listed properties |
`GET` | `/properties/work_arrangement/outof` | Present only REMOTE job offerings |
`GET` | `/jobs/work_arrangement/hybrid` | Present only HYBRID job offerings |
`PATCH` | `/jobs/:jobId` | Access an existing job verified by its "jobId" and update its info as pleased |
`DELETE` | `/jobs/:jobId` | Access a job by their "jobId" and delete it (moderator) |
`GET` | `/moderators` | Lay out all of the moderators listed in the database |
`POST` | `/moderators` | Assign a new moderator to be saved into the moderators database |
`GET` | `/moderators/:modId` | Pick out one moderator by their unique "modId" |
`GET` | `/moderators/:modId/jobs` | Filter out jobs posted by a particular moderator |
