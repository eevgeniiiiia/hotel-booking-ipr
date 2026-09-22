# Hotel Booking

Учебное веб-приложение для автоматизации разработки, сборки и поставки программного модуля.

## Вариант

Вариант 3 — система бронирования гостиницы (Hotel Booking).

## Технологии

- Java 17
- Spring Boot 3
- Maven
- JUnit 5
- Checkstyle
- Docker
- GitHub Actions
- Docker Hub

## Функциональность

Приложение предоставляет REST API для работы с гостиницами.

### GET /hotels

Возвращает список всех гостиниц.

Команда:

    curl http://localhost:8080/hotels

### POST /hotels

Создаёт новую гостиницу.

Команда:

    curl -X POST http://localhost:8080/hotels \
      -H "Content-Type: application/json" \
      -d '{
        "name": "Victoria Hotel",
        "city": "Minsk",
        "room": "Deluxe",
        "pricePerNight": 150
      }'

## Сборка Maven

    mvn clean verify

После успешной сборки создаётся:

    target/hotel-booking-1.0.0.jar

## Запуск приложения

    mvn spring-boot:run

Приложение доступно по адресу:

    http://localhost:8080

## Docker

Сборка JAR:

    mvn clean package

Сборка Docker-образа:

    docker build -t hotel-booking:latest .

Запуск контейнера:

    docker run -d --name hotel-booking-ipr-app -p 8080:8080 hotel-booking:latest

Проверка:

    curl http://localhost:8080/hotels

## Docker Hub

Образ опубликован в Docker Hub:

https://hub.docker.com/r/eevgeniiiiia/hotel-booking

Имя образа:

    eevgeniiiiia/hotel-booking:latest

## Статический анализ

Для проверки качества кода используется Checkstyle.

    mvn checkstyle:check

При нарушении установленных правил Maven завершает выполнение с ошибкой.

## Модульные тесты

    mvn test

## CI/CD

GitHub Actions выполняет следующие этапы:

1. Checkout исходного кода.
2. Установка JDK 17.
3. Установка зависимостей Maven.
4. Сборка проекта.
5. Статический анализ Checkstyle.
6. Модульное тестирование.
7. Создание JAR-артефакта.
8. Сборка Docker-образа.

При ошибке статического анализа или тестов последующие этапы не выполняются.

## GitFlow

В проекте используются ветки:

    main
    develop
    feature/*

Ветка main предназначена для стабильной версии проекта.

Ветка develop используется для интеграции изменений.

Новые функциональные изменения разрабатываются в отдельных ветках feature/*.