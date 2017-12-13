# README #

This README explains the design principle and setup guidelines to execute this app

### Design Principle ###

* Spring Boot Framework is used to ease the development complexity with production ready quality
* Domain Driven Design is adopted and all the behaviors are attached directly to the domain objects
* io operation is separated out in a reader class
* basic test suite is included

### How do I run ###

* Keep the categories information in a csv file in the format of "category-name, discount-percent, parent-category-name"
example :
```
    Men's wear,0
    Shirts,0,Men's wear
    Trousers,0,Men's wear
    Casuals,30,Men's wear
    Jeans,20,Men's wear
    Women's wear,50
    Dresses,0,Women's wear
    Footwear,0,Women's wear
```
* Update the property "file.path.categories" in application.properties file with the location of the above file
example : file.path.categories=/home/sam/Dev/mall/categories.csv

* Keep the brands information in a csv file in the format of "brand-name, discount-percent"
example :
```
    Wrangler,10
    Arrow,20
    Vero Moda,60
    UCB,0
    Adidas,5
    Provogue,20
```
* Update the property "file.path.brands" in application.properties file with the location of the above file
example : file.path.brands=/home/sam/Dev/mall/brands.csv

* Keep the input file in a csv file with number of inventory items in the first line followed by the inventory items
* in the format of "item-id, brand-name, category-name, price" followed by a blank line and then followed by the number
* cart ( customer ) items and then followed by the cart information with comma separted value of item ids as below :
```
    5
    1,Arrow,Shirts,800
    2,Vero Moda,Dresses,1400
    3,Provogue,Footwear,1800
    4,Wrangler,Jeans,2200
    5,UCB,Shirts,1500

    2
    1,2,3,4
    1,5
```
* Update the property "file.path.input" in application.properties file with the location of the above file
 example :  file.path.input=/home/sam/Dev/mall/input.csv

### Who do I talk to? ###

* sivasamraj.m@gmail.com