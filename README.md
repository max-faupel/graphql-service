# MongoDB
```
docker run -d --name mongo -e MONGO_INITDB_DATABASE=books -e MONGO_INITDB_ROOT_USERNAME=user -e MONGO_INITDB_ROOT_PASSWORD=asdf -p 27017:27017 -v /home/user/dev/mongodb/data:/data/db mongo
```
# Queries
```
{
  bookById(id: "book-1"){
    id
    name
    pageCount
    author {
      firstName
      lastName
    }
  }
}
```

```
{
  authorByName(authorInput: {
    firstName: "Anne"
    lastName: "Rice"
  }) {
    id
    firstName
    lastName
  }
}
```