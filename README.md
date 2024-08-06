# Currency Converter
This is a simple currency converter that converts one currency to another. It uses the [Free Currency API](https://freecurrencyapi.com/) to get the exchange rates. In our controller user can pass the base currency, the target currencies and then the amount to convert. The controller will then return the converted amount. The errors are also handled in the controller. 

## Features
- Convert one currency to another
- Handle errors
- Get the exchange rates
- Logging
- Swagger UI
- Monitor the application using Actuator

## Technologies
- Java 21
- Spring Boot 3.3.2
- Maven
- MySQL
- S4J Logging
- Swagger UI
- Actuator

## Endpoints
- `/convert` - POST request to convert the currency
  - `?baseCurrency=USD` - The base currency
  - `&targetCurrencies=EUR,CAD,GBP` - The target currencies
  - `&amount=100` - The amount to convert
- `/actuator` - Monitor the application
- `/swagger-ui.html` - Swagger UI
- `/v3/api-docs` - API documentation


## How to run
1. Clone the repository
2. Open the project in your favorite IDE
3. Run the project

## 🚀 About Me

Tech-savvy learner/programmer pushing boundaries of online tech. Passionate about new tools, seeking challenges to advance skills.

## 🔗 Social Links

![Name](https://img.shields.io/badge/Name-Francis%20Rudra%20D%20Cruze-yellowgreen?style=for-the-badge)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/rudradcruze)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/rudradcruze)
[![Facebook](https://img.shields.io/badge/facebook-4267B2?style=for-the-badge&logo=facebook&logoColor=white)](https://facebook.com/rudradcruze)
[![francisrudra@gmail.com](https://img.shields.io/badge/gmail-4267B2?style=for-the-badge&logo=gmail&logoColor=white)](mailto:francisrudra@gmail.com)
