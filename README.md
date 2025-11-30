# Student Management

This is a small Spring Boot (Thymeleaf) project for managing students. It contains simple authentication, CRUD for students, server-rendered UI, and tests.

Quick notes
- Java: 21 (project configured to compile with release 21)
- Build: Maven (wrapper included)
- Web: Spring Boot + Thymeleaf (server-rendered UI)
- Security: Spring Security with username/password authentication

Local development
1. Build & run tests:

```powershell
cd "C:\Users\prakash\Desktop\student-management"
.\mvnw.cmd -B test
```

2. Run the app locally:

```powershell
.\mvnw.cmd spring-boot:run
# then open http://localhost:8080
```

Sign up / authentication
- Signup: GET /signup — register a new user
- Login: GET /login — sign in

Notes / next steps
- Add sign-up tests and end-to-end tests if needed
- Consider migrating to standardized DB migrations (Flyway) before making schema changes in production

License
- Add a license if you'd like this repository to be public and shareable.
