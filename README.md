# library-service

## APIs

* `/borrowers`
  * POST `/borrowers/create`
* `/isbns`
  * POST `/isbns/create`
  * GET `/isbns/list`
* `/books`
  * POST `/books/create`
  * GET `/books/list`
  * GET `/books/list-available`
  * POST `/books/borrow`
  * POST `/books/return`



## Borrower APIs

### POST `/borrowers/create`

#### Request sample

```json
{
    "name": "Xiao Ming",
    "email": "xiaoming@gmail.com"
}
```



#### Response sample

```json
{
    "id": 152,
    "name": "Xiao Ming",
    "email": "xiaoming@gmail.com"
}
```

* HTTP Status Code: 201 CREATED



## ISBN APIs

### POST `/isbns/create`

#### Request sample

```json
{
    "id": "978-15-03215-15-3",
    "title": "Around the World in 80 Days",
    "author": "Jules Verne"
}
```

* Requires ISBN to not already exist in database



#### Response sample

```json
{
    "id": "978-15-03215-15-3",
    "title": "Around the World in 80 Days",
    "author": "Jules Verne"
}
```

* HTTP Status Code: 201 CREATED



#### Response sample, when ISBN already exists

```
ISBN already exists! ID: 978-15-03215-15-3
```

* HTTP Status Code: 409 CONFLICT



### GET `/isbns/list`

#### Request sample

* No request parameter
* No request body



#### Response sample

```json
[
    {
        "id": "978-15-03215-15-3",
        "title": "Around the World in 80 Days",
        "author": "Jules Verne"
	},
    {
        "id": "978-18-53261-07-7",
        "title": "The Railway Children",
        "author": "Edith Nesbit"
	}
]
```



## Book APIs

### POST `/books/create`

#### Request sample

```json
{
    "isbn": "978-15-03215-15-3"
}
```

* Requires ISBN to already exist
* Multiple books with the same ISBN can be registered
  * Each book will be assigned a different book ID



#### Response sample

```json
{
    "id": 152,
    "isbn": {
        "id": "978-15-03215-15-3",
        "title": "Around the World in 80 Days",
        "author": "Jules Verne"
    },
    "borrower": null
}
```

* HTTP Status Code: 201 CREATED



#### Response sample, when ISBN does not exist

```
ISBN: 978-15-03215-15-4
```

* HTTP Status Code: 404 NOT FOUND



### GET `/books/list`

#### Request sample

* No request parameter
* No request body



#### Response sample

```json
[
    {
        "id": 152,
        "isbn": {
            "id": "978-15-03215-15-3",
            "title": "Around the World in 80 Days",
            "author": "Jules Verne"
        },
        "borrower": null
    },
    {
        "id": 154,
        "isbn": {
            "id": "978-18-53261-07-7",
            "title": "The Railway Children",
            "author": "Edith Nesbit"
        },
        "borrower": null
    },
    {
        "id": 155,
        "isbn": {
            "id": "978-18-53261-07-7",
            "title": "The Railway Children",
            "author": "Edith Nesbit"
        },
        "borrower": null
    },
    {
        "id": 153,
        "isbn": {
            "id": "978-18-53261-07-7",
            "title": "The Railway Children",
            "author": "Edith Nesbit"
        },
        "borrower": {
            "id": 152,
            "name": "Xiao Gang",
            "email": "xiaogang@gmail.com"
        }
    }
]
```



### GET `/books/list-available`

* A convenience API to filter out books that are not borrowed yet



#### Request sample

* No request parameter
* No request body



#### Response sample

```json
[
    {
        "id": 152,
        "isbn": {
            "id": "978-15-03215-15-3",
            "title": "Around the World in 80 Days",
            "author": "Jules Verne"
        },
        "borrower": null
    },
    {
        "id": 154,
        "isbn": {
            "id": "978-18-53261-07-7",
            "title": "The Railway Children",
            "author": "Edith Nesbit"
        },
        "borrower": null
    },
    {
        "id": 155,
        "isbn": {
            "id": "978-18-53261-07-7",
            "title": "The Railway Children",
            "author": "Edith Nesbit"
        },
        "borrower": null
    }
]
```

* Note that `borrower` field are all `null`
* Note that book ID `153` is now missing



### POST `/books/borrow`

#### Request sample

```json
{
    "borrowerId": "152",
    "bookId": "153"
}
```

* Requires borrower ID to exist
* Requires book ID to exist
* Requires book to be available



#### Response sample

```json
{
    "borrowDateTime": "2024-05-23T22:56:44.9208668+08:00"
}
```



#### Response sample, when borrower ID does not exist

```
Invalid borrower ID: 1999
```



#### Response sample, when book ID does not exist

```
Invalid book ID: 1999
```



#### Response sample, when the book is in a borrowed state

```
Book is already borrowed! ID: 154
```



### POST `/books/return`

#### Request sample

```json
{
    "bookId": "153"
}
```

* Requires book ID to exist
* Requires book to be in a borrowed state



#### Response sample

```json
{
    "returnDateTime": "2024-05-23T23:00:55.984978+08:00"
}
```



#### Response sample, when book ID does not exist

```
Invalid book ID: 1999
```



#### Response sample, when the book is not borrowed

```
Book is already returned! ID: 153
```

