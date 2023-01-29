
# User API

The User API provides endpoints for managing users.

## Endpoints

-   `POST /users/`: Register a new user.
-   `GET /users/{id}`: Retrieve a user by ID.

## Register a new user (`POST /users/`)

Registers a new user.

### Request Body

jsonCopy code

`{
"name": "John Doe",
"birthdate": "2000-01-01",
"country": "USA"
}`

#### Body Parameters

-   name: Name of the user.
-   birthdate: Birthdate of the user.
-   country: Country of the user.

### Response

#### 201 (Created)

jsonCopy code

`{
"id": 1,
"name": "John Doe",
"birthdate": "2000-01-01",
"country": "USA",
"phoneNumber": "123456789",
"gender": "Male"
}`

## Retrieve a user by ID (`GET /users/{id}`)

Retrieves a user by ID.

### Path Parameters

-   id: ID of the user.

### Response

#### 200 (OK)

jsonCopy code

`{
"id": 1,
"name": "John Doe",
"birthdate": "2000-01-01",
"country": "USA",
"phoneNumber": "123456789",
"gender": "Male"
}`

#### 404 (Not Found)

If the user with the specified ID does not exist.