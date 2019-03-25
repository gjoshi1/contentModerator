# contentModerator

# Requirement :
Develop a REST API to moderate/validate the comment text to prevent customers from posting objectionable content. The REST API is expected to take a piece of text as an input and respond with feedback regarding objectionable content

# Solution
 ContentModerator REST API is built using Spring Boot and Mongo DB.

The API provides endpoints for BlackListContent management by CRUD operations.
The API supports the creation of objectionable content for different languages.
The UserContent is then reviewed/tested against this BlackListContent for specific language persisted in the application DB and the result contains the list of objectionable words present in the usercontent.

BlackListContent
{"id":"5c95d8ce3e668928df012554","word":"ob2","lang":"en"}

UserContent
{"id":...,"content":...,"lang":"en"}

ReviewResult
{
    "id": ...,
    "lang": "en",
    "blacklistedWords": [
        "ob2"
    ]
}



# Testing
Testing is implemented using JUnit and Mockito. 

# REST Endpoints

POST http://localhost:8080/create?word=&lang=en

GET http://localhost:8080/getAll

GET http://localhost:8080/getAllBlacklistContentByLang?lang=es

GET http://localhost:8080/getSupportedLanguages

DELETE http://localhost:8080/delete?id=122

DELETE http://localhost:8080/deleteAll

POST http://localhost:8080/update

Body : 
{"id":"5c9874873e66894e09d019c0","word":"ob11","lang":"en"}

POST http://localhost:8080/reviewContent

Body :

{"id":"111",
"lang":"en",
"content":"test ob2,content ob45 ob2 test again"
}





        


        


