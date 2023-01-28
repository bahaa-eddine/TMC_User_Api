Documentation for the Springboot API:

## User Registration

To register a new user, make a `POST` request to the `/users` endpoint with a JSON payload that includes the following fields:

-   `name`: a string that represents the user's name
-   `birthdate`: a date in the format `yyyy-mm-dd` that represents the user's birthdate
-   `country`: a string that represents the user's country of residence
-   `phoneNumber`: an optional string that represents the user's phone number
-   `gender`: an optional string that represents the user's gender

Example request:

`POST /users
{
"name": "John",
"birthdate": "2000-01-01",
"country": "France",
"phoneNumber": "555-555-5555",
"gender": "male"
}`

Successful requests will return a `201 Created` status and a JSON representation of the created user:

`{
"id": 1,
"name": "John",
"birthdate": "2000-01-01",
"country": "France",
"phoneNumber": "555-555-5555",
"gender": "male"
}`

Invalid requests will return a `400 Bad Request` status and a message describing the error:

`{
"message": "Invalid user: Must be a French resident"
}`

## User Retrieval

To retrieve the details of a registered user, make a `GET` request to the `/users/{id}` endpoint, where `{id}` is the ID of the user to retrieve.

Example request:

`GET /users/1`

Successful requests will return a `200 OK` status and a JSON representation of the user:

`{
"id": 1,
"name": "John",
"birthdate": "2000-01-01",
"country": "France",
"phoneNumber": "555-555-5555",
"gender": "male"
}`

Invalid requests will return a `404 Not Found` status and a message describing the error:

`{
"message": "User not found"
}`

Please note, API will only allow adult French residents to create an account and will validate the input and return proper error messages/http statuses.