# Car Sales Garage API

## Description

This is a Spring Boot API for managing a car sales garage. It provides the following functionalities:

- Add a new car to the catalog
- Search for cars by fuel type and maximum price
- Get a list of all distinct car makes in the catalog
- Update the picture of a car

## Prerequisites

- Java 8 or higher
- Maven
- H2 Database (or you can use the embedded H2 database)

## Installation Steps

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/carsalesgarage.git
    ```

2. Navigate to the project directory:

    ```bash
    cd carsalesgarage
    ```

3. Build the project:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    mvn spring-boot:run
    ```

## How to Run Tests

Run the following command in the project directory:

```bash
mvn test
```

## API Endpoints

- **Add a New Car**

  `POST /api/cars/add`

- **Search for Cars**

  `GET /api/cars/search?fuelType=<FUEL_TYPE>&maxPrice=<MAX_PRICE>`

- **List Distinct Makes**

  `GET /api/cars/makes`

- **Update Car Picture**

  `PUT /api/cars/update/picture/{id}?newPicture=<NEW_PICTURE_URL>`

## Acknowledgments
this project was developed as technical test for the DEVSLING Company by @Alaeddine Mahmoudi
