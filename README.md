# rest_skeleton
skeleton for building rest services in spring/jersey/mongodb/swagger

To run call ./gradlew bootRun

requires a local instance of mongod to be running.

sample calls
```
Endpoint documentation 
   url: localhost:8080/api/swagger.json
   
```

```
POST 
   url: localhost:8080/api/demo/
   
   body: {
            "text" : "hello world"
          }
    
    returns: new entity with id
```

```
GET
   url: localhost:8080/api/demo/{id}

```

```
PUT
   url: localhost:8080/api/demo/{id}
   body:
        {
            "text" : {updated text}
        }

```

```
DELETE
   url: localhost:8080/api/demo/{id}

```

TODO:

Get swagger UI to consume swagger.json




