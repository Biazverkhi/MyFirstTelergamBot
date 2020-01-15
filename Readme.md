# Telegram Bot @NewCityTourBot (tourist assistance Bot)

title         |  description|
------------- | -------------|
bot           | **tourist assistance Bot** |
username      | **@NewCityTourBot**|
token         | **957064798:AAHOIjKVXbX0b_5lIAhBmuagcT8uy_h58i8**|
DB            | **MySQL** [db4free.net](db4free.net) *(the database is hosted on a remote server)*  |
URL           | **[http://localhost:8080/cities](http://localhost:8080/cities)**|
Java version  |8  #Usage|  
  
##Usage

* [Click here to go to Telegram and add the @NewCityTourBot](https://telegram.me/NewCityTourBot)  
* [Download and unpack the source code archive](https://github.com/Biazverkhi/MyFirstTelergamBot)   
* Running an application in the development environment with Maven:
    * Run `com.github.biazverkhi.bot.AppRunner` in module `rest`;
    * Or enter in the Terminal (in my case Intellij IDEA):  
    1.`mvn install`;  
    2.`cd rest\target`;  
    3.`java -jar rest-1.0-SNAPSHOT.jar`
*  Enter to telegram Bot any of the cities:
    * Минск;
    * Прага;
    * Москва;
    * Рим;
    * Венеция;
    * Лиманск;  
*use [Insomnia REST client](https://insomnia.rest/download/) to test the RESTful API that I provided below

##RESTful API:

Resource      |  GET      | POST      | PUT      | PATH     | DELETE      |
------------- | -------------|-------------|-------------|-------------|-------------|
/cities       |return a list of entities*|add an entity |**|**|delete all entities|
/cities/3     | return an entity by id|**|update an entity|update an entity|delete an entity by id|
/cities/list  |**|add a list of entities|**|**|**| 
 
footnotes:  
*:entities - city with description;  
**:  Method not allowed (405)

    
Application settings to `application.yml`: 
```yaml
server:
  port: 8080
  servlet:
    context-path: /
spring:
  datasource:
    url: jdbc:mysql://db4free.net:3306/botexample?logger=com.mysql.cj.log.StandardLogger&profileSQL=true&useTimezone=true&serverTimezone=GMT%2B3
    username: abiazverkhi
    password: assembler
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: validate
```

