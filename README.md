# anti-bot-check
Anti bot check

**App is running by default on port 9999**

## HOW TO RUN THE JAR FILE

- cd into the directory where the JAR file is
https://github.com/solivalle/anti-bot-check/blob/main/anti-bot-check-server/target/anti-bot-check-server-0.0.1-SNAPSHOT.jar

- you need to have JAVA 21 installed in your computer

- run it by executing the command

`java -jar anti-bot-check-server-0.0.1-SNAPSHOT.jar`

# APIs Definition

#### **PUT /verification/bot-test**

Generates and returns a 3 random numbers between 1-1000, the body for this PUT is empty

###### expected response 200

    {
        "message": "please sum these 3 numbers",
        "n1": 1,
        "n2": 2,
        "n3": 3
    }

#### GET /verification/check

Expected body, previous response must be included under "questionResponse" section

    {
        "sum" : 128,
        "questionResponse" : {
            "n1": 16,
            "n2": 20,
            "n3": 14
        }
    }

###### ResponsesResponses

###### 400 - when data type is violated

    {
        "timestamp": "2024-10-16T06:25:27.594+00:00",
        "status": 400,
        "error": "Bad Request",
        "path": "/verification/check"
    }

###### 500 - when operation hasn't been provided by the PUT API

    {
        "timestamp": "2024-10-16T06:27:16.936+00:00",
        "status": 500,
        "error": "Internal Server Error",
        "path": "/verification/check"
    }

###### 400 - when sum isn't good

    {
        "message": "bad"
    }

###### 200 - when sum is good

    {
        "message": "good"
    }