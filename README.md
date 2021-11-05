To build the `jar` file run:
```
cd back
mvn clean install
```

To start the whole stack:
```
docker-compose up -d
```

- `localhost:3000` - the React client 
- `localhost:8084` - backend GraphQL server (java 11 with Spring-Boot)
- `localhost:8081` - mongo-express to examine the database directly

To shut down all services:
```
docker-compose down
```