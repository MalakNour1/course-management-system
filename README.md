# Course Management System

A Spring Boot REST API for managing students, instructors, courses, and enrollments.

The project is divided into two services:

- **Admin Service** – Full CRUD operations.
- **Public Service** – Read-only endpoints and student enrollment.

Both services share a PostgreSQL database and run with Docker Compose.

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Docker & Docker Compose
- MapStruct
- Lombok

---

## Project Structure

```
course-management-system/
├── admin/
├── public/
├── docker-compose.yml
└── README.md
```

---

## Features

### Admin Service
- Manage Students
- Manage Instructors
- Manage Courses
- Manage Enrollments

### Public Service
- View Students
- View Instructors
- View Courses
- Enroll Students in Courses

### Business Rules
- Prevent duplicate enrollments.
- Allow enrollment only during the course registration period.
- Soft delete for courses.
- Centralized exception handling.

---

## Running the Project

```bash
git clone https://github.com/MalakNour1/course-management-system.git
cd course-management-system
docker compose up
```

Services:

| Service | Port |
|----------|------|
| Admin API | 8080 |
| Public API | 8081 |
| PostgreSQL | 5432 |

Stop the application:

```bash
docker compose down
```

---

## Docker Images

- `malaknour/course-management-system-admin`
- `malaknour/course-management-system-public`

---

## API

### Admin Service

`http://localhost:8080`

- `/students`
- `/instructors`
- `/courses`
- `/enrollments`

### Public Service

`http://localhost:8081`

- `/students/{id}`
- `/courses`
- `/enrollments`

---
