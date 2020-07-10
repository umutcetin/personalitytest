# Personality Test

## Running in Docker

To run, checkout the project, go to root folder and:
```
mvn package
docker build -t personality-test .
docker run -p 8080:8080 -t personality-test
```
## How to run automated tests
To run the tests:
```
mvn test
```

![img_get](https://raw.githubusercontent.com/umutcetin/personalitytest/master/screenshots/Screen%20Shot%202020-07-09%20at%2023.00.58.png)
![img_post](https://raw.githubusercontent.com/umutcetin/personalitytest/master/screenshots/Screen%20Shot%202020-07-09%20at%2023.00.39.png)

