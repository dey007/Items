# Items
Used SpringBoot and MongoDB for this project.
URI to create items:
http://localhost:8081/items/create
{
  "_id" : "1",
  "name" : "Pickle",
  "price":25.00,
  "inStock": 15
}
URI to get all the items:
http://localhost:8081/items

URI to do the Items order and if the item is out of stock it will through an exception which is shown by user friendly message
http://localhost:8081/items/order
[
  { 
    "name":"pickle",
    "no" : "2"
  },
  {
    "name" : "cadberry",
    "no" : "3" 
  }
]
