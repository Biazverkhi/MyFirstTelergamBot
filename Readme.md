# Telegram Bot

[Click here to go to Telegram](https://telegram.me/NewCityTourBot)

bot         **tourist assistance Bot** \
username    **@NewCityTourBot**\
token       **957064798:AAHOIjKVXbX0b_5lIAhBmuagcT8uy_h58i8**\
DB          **MySQL** *the database is hosted on a remote server*\
URL         **[http://localhost:8080/cities](http://localhost:8080/cities)**


bot properties: rest\src\main\resources\bot.properties\
application settings: rest\src\main\resources\application.yml\


HTTP metods:

GET /cities - get all entities (city with description) with a description\ 
GET /cities/{id} - get an entity by id\
POST /cities - add an entity\
POST /cities/list - add a list of entities\
PUT /cities/{id} - update an entity\
PATH /cities/{id} - update an entity\
DELETE /cities/{id} - delete entity by id\
DELETE /cities/all - delete all entities\


