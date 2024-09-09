![logo](https://github.com/user-attachments/assets/8dbee840-0cad-4b35-8002-944635124122)


# 🏪 E-commerce
A personal e-commerce project, where you can simulate your purchases. register clients and products.

#  🧱 Stack used:

* [*Java*](https://docs.oracle.com/en/java/javase/17/docs/api/index.html) ♨️
* [*SpringBoot*](https://docs.spring.io/spring-boot/index.html) 🍃
* [*Maven*](https://maven.apache.org/guides/index.html) 🐦
* [*MySQL*](https://dev.mysql.com/doc/) 🐬
* [*ChatGPT*](https://chatgpt.com/g/g-mlCY3phIA-docs-gpt) 🤖

# 👨🏻‍💻 Running Locally:
clone the project
```
  git clone https://https://github.com/JelitonSoares/e-commerce-api.git
```

You will need:
* Java 17+
* MySQL 8+
* IDE (of your preference>
* Postman/Imsomnia to test

First, use the backup file to populate your database, it contains some products, clients and orders already registered, you can add products, clients of your choice and place orders. finally just start the project using your IDE and test with Postman.

# 📚 Doc:

This project was developed to exercise my knowledge of REST APIs, databases and their relationships, and Spring Boot.
The idea was to create a program where the user can assemble their order, simulating a supermarket. All the data contained in the MySQL backup was generated by the artificial intelligence of Chat GPT.

![cat-computer](https://github.com/user-attachments/assets/5c02538b-a6d6-4142-b6c9-5292843eb9ec)



# 🛍️ Products Endpoints:
We will start with the products, they are an important part of the program, as we will need them to assemble an order.

## 🌟 Create a Product

A product is composed of the following fields:
name, description, value, stock and category.
* name: is the abbreviated name of the product
* description: contains all additional information about the product
* value: is its purchase value
* stock: the quantity of this product available
* category: we have some such as: LIMPEZA, HIGIENE, ALIMENTICIOS, PADARIA, ACOUGUE, BEBIDAS, LATICINIOS, UTILIDADES, HORTFRUT and DOCES.


### ✏️ Request:

``` http
POST /ecommerce/products
```


#### Body:
```
{
    "name": "Espuma de Limpeza Facial Revitalizante Lumina 150ml",
    "description": "Espuma de limpeza facial com microbolhas revitalizantes, que removem impurezas e células mortas, deixando a pele macia e luminosa.",
    "value": 39.90,
    "stock": 30,
    "category": "HIGIENE"
}

```

### 🕙 Response:

Tthe program will return a JSON in the response body, containing the saved and detailed product, with the code 201 (CREATED) and the LOCATION field in the response header.

#### Body:
```
{
    "id": "d108275e-7d76-4893-b13f-a64c98e3e173",
    "name": "Espuma de Limpeza Facial Revitalizante Lumina 150ml",
    "description": "Espuma de limpeza facial com microbolhas revitalizantes, que removem impurezas e células mortas, deixando a pele macia e luminosa.",
    "value": 39.90,
    "stock": 30,
    "category": "HIGIENE",
    "registerDate": "2024-09-09"
}
```
|Status Code             | Location Header (example)                                                                |
|:-----------------------|:--------------------------------------------------------------------------------|
|201 (CREATED)           | "https://localhost:8080/ecommerce/products/d108275e-7d76-4893-b13f-a64c98e3e173"|
