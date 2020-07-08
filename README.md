# personalitytest

To run, checkout the project, go to root folder and:
```
mvn package
docker build -t personality-test .
docker run -p 8080:8080 -t personality-test
```
