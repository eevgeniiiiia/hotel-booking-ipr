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

```bash
curl http://localhost:8080/hotels