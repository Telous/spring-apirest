# Getting Started

It is necessary to have java jdk 1.8 or higher 

clone the repo

```console
git clone https://github.com/Telous/spring-apirest.git
```

Navigate to the root project folder: /spring-apirest

#### For unix based systems
```properties
./mvnw clean install compile
```

#### For windows based systems
```properties
./mvnw.cmd clean install compile
```

#### To run the project
```properties
java -jar target/rest-0.0.1-SNAPSHOT.jar
```

home path:
http://localhost:8080/

post url: http://localhost:8080/user

Body request example:

```json
{
  "name": "prueba",
  "email": "a@domain.com",
  "password": "snch334nc*c",
  "phones": [
    {
      "number": 1234567,
      "cityCode": 12,
      "countryCode": 57
    }
  ]
}
```

Response example

```json
{
  "id": "5de8a545-f1b7-4c1a-8aae-07e3b81bf80c",
  "created": "2023-05-20T17:57:12.668",
  "modified": "2023-05-20T17:57:12.668",
  "lastLogin": "2023-05-20T17:57:12.668",
  "token": "efe2bf35-0530-4432-83a4-ea3d2b3bf726",
  "active": true
}
```
H2 Db console:
http://localhost:8080/h2-console

user: sa
password: password

SQL script src/main/resources/db.sql

```sql
CREATE TABLE USERS
(
    ID         UUID PRIMARY KEY,
    NAME       VARCHAR(100)        NOT NULL,
    EMAIL      VARCHAR(100) UNIQUE NOT NULL,
    PASSWORD   VARCHAR(255)        NOT NULL,
    CREATED    TIMESTAMP,
    MODIFIED   TIMESTAMP,
    LAST_LOGIN TIMESTAMP,
    TOKEN      VARCHAR(255),
    ACTIVE     BOOLEAN
);


CREATE TABLE PHONE
(
    ID         UUID PRIMARY KEY,
    USER_ID    UUID    NOT NULL,
    NUMBER INTEGER NOT NULL,
    CITY_CODE   TINYINT NOT NULL,
    COUNTRY_CODE TINYINT NOT NULL
);

ALTER TABLE PHONE
    ADD FOREIGN KEY (USER_ID)
        REFERENCES USERS (ID);
```