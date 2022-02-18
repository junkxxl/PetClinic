# Тестирование Spring PetClinic - REST API
___

В данном проекте происходит параллельное тестирование основного функционала
серверной версии приложения Spring PetСlinic REST API.

## ПО нужное для локального запуска
````
- JDK 8 - установить
- Docker Desktop - установить
- WSL 2 - установить
````
## Инструкция для локального запуска
___
````
* Для запуска тестов потребуется:
  * Docker Desktop
    * Запустить docker run -p 9966:9966 springcommunity/spring-petclinic-rest
    * Запустить docker run --name postgres-petclinic -e POSTGRES_PASSWORD=petclinic 
    -e POSTGRES_DB=petclinic -p 5432:5432 -d postgres:9.6.0
  * Запустить тесты me.junkxxl.testing  
````
###Переменные окружения
````
* PETCLINIC - "http://localhost:9966/petclinic/api/"
````