# OnlineBookManagementSpringBoot

How to Run 

http://13.232.35.6:8080/books/add - add Books
{
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "genre": "Classic",
    "availabilityStatus": "AVAILABLE"
}

http://13.232.35.6:8080/books/all - get all books

output

[
    {
        "id": 1,
        "title": "The Great Gatsby",
        "author": "F. Scott Fitzgerald",
        "genre": "Classic",
        "availabilityStatus": "AVAILABLE"
    }
]

http://13.232.35.6:8080/books/1  - Get Book By id

http://13.232.35.6:8080/books/search?title=The Great Gatsby - get Book by title

http://13.232.35.6:8080/books/1 - update the book by id


http://13.232.35.6:8080/books/1  - delete the book by id 
