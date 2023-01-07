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

# Mutations

```
{
  createBook(createBookInput: {
    id: "book-4"
    name: "Learning GraphQL: Declarative Data Fetching for Modern Web Apps"
    pageCount: 185
    createAuthorInput: [
      {
        id: "author-4"
        firstName: "Eve"
        lastName: "Porcello"
      }
      {
        id: "author-5"
        firstName: "Alex"
        lastName: "Banks"
      }
    ]
  }) {
    id
    name
  }
}
```
