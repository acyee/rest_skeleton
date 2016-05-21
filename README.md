# rest_skeleton
skeleton for building rest services in spring/jersey

To run call ./gradlew bootRun

sample calls

```
POST 
   url: localhost:8080/demo/
   
   body: {
            "text" : "hello world"
          }
    
    returns: new entity with id
```

```
GET
   url: localhost:8080/demo/{id}

```

```
PUT
   url: localhost:8080/demo/{id}
   body:
        {
            "text" : {updated text}
        }

```

```
DELETE
   url: localhost:8080/demo/{id}

```

TODO:

Test Cases

Comments

MongoDB integration



