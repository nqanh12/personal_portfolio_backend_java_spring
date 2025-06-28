# Personal Portfolio Backend API

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://openjdk.java.net/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green.svg)](https://spring.io/projects/spring-boot)
[![MongoDB](https://img.shields.io/badge/MongoDB-4.4+-blue.svg)](https://www.mongodb.com/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-red.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

Backend API cho website portfolio cá nhân được xây dựng bằng Spring Boot 3 và MongoDB. API này cung cấp các endpoint để quản lý thông tin cá nhân, dự án, kỹ năng, kinh nghiệm làm việc, học vấn và blog posts.

## 📋 Mục lục

- [Tính năng](#-tính-năng)
- [Công nghệ sử dụng](#-công-nghệ-sử-dụng)
- [Cấu trúc dự án](#-cấu-trúc-dự-án)
- [API Documentation](#-api-documentation)
- [Cài đặt và Chạy](#-cài-đặt-và-chạy)
- [Cấu hình](#-cấu-hình)
- [Đóng góp](#-đóng-góp)
- [License](#-license)

## ✨ Tính năng

### 🔐 Quản lý thông tin cá nhân
- Thông tin cơ bản (tên, tiêu đề, bio, địa chỉ)
- Thông tin liên hệ (email, số điện thoại)
- Links mạng xã hội (LinkedIn, GitHub, Twitter, etc.)
- URL CV và ảnh đại diện

### 🚀 Quản lý dự án
- Tên và mô tả dự án
- Tech stack sử dụng
- Links GitHub và Demo
- Hình ảnh thumbnail dự án

### 💻 Quản lý kỹ năng
- Phân loại kỹ năng (Frontend, Backend, Tools, Other)
- Cấp độ kỹ năng (Beginner, Intermediate, Advanced, Expert)
- Tìm kiếm theo loại kỹ năng

### 💼 Quản lý kinh nghiệm làm việc
- Vị trí công việc
- Tên công ty
- Thời gian làm việc (start date - end date)
- Mô tả chi tiết công việc

### 🎓 Quản lý học vấn
- Tên trường học
- Bằng cấp/Chứng chỉ
- Thời gian học tập
- Mô tả khóa học


## 🛠 Công nghệ sử dụng

| Technology | Version | Description |
|------------|---------|-------------|
| **Java** | 17 | Ngôn ngữ lập trình chính |
| **Spring Boot** | 3.x | Framework backend |
| **MongoDB** | 4.4+ | Database NoSQL |
| **Spring Data MongoDB** | - | ORM cho MongoDB |
| **Maven** | 3.6+ | Build tool |
| **Lombok** | - | Giảm boilerplate code |
| **Spring Validation** | - | Validation dữ liệu |
| **Swagger/OpenAPI** | 3.x | API documentation |

## 🏗 Cấu trúc dự án

```
src/main/java/com/quocanh/personal_portfolio_backend_java_spring/
├── 📁 config/
│   └── CorsConfig.java                    # Cấu hình CORS
├── 📁 controller/
│   ├── EducationController.java           # API endpoints cho education
│   ├── ExperienceController.java          # API endpoints cho experience
│   ├── PersonalInfoController.java        # API endpoints cho personal info
│   ├── ProjectController.java             # API endpoints cho projects
│   └── SkillController.java               # API endpoints cho skills
├── 📁 dto/
│   ├── EducationDTO.java
│   ├── ExperienceDTO.java
│   ├── PersonalInfoDTO.java
│   ├── ProjectDTO.java
│   └── SkillDTO.java
├── 📁 exception/
│   └── GlobalExceptionHandler.java        # Xử lý exception toàn cục
├── 📁 model/
│   ├── Education.java                     # Entity models
│   ├── Experience.java
│   ├── PersonalInfo.java
│   ├── Project.java
│   ├── Skill.java
│   └── 📁 enums/
│       ├── SkillLevel.java                # Enum cấp độ kỹ năng
│       └── SkillType.java                 # Enum loại kỹ năng
├── 📁 repository/
│   ├── EducationRepository.java           # MongoDB repositories
│   ├── ExperienceRepository.java
│   ├── PersonalInfoRepository.java
│   ├── ProjectRepository.java
│   └── SkillRepository.java
└── 📁 service/
    ├── 📁 impl/
    │   ├── EducationServiceImpl.java      # Service implementations
    │   ├── ExperienceServiceImpl.java
    │   ├── PersonalInfoServiceImpl.java
    │   ├── ProjectServiceImpl.java
    │   └── SkillServiceImpl.java
    ├── EducationService.java              # Service interfaces
    ├── ExperienceService.java
    ├── PersonalInfoService.java
    ├── ProjectService.java
    └── SkillService.java
```

## 📚 API Documentation

### Base URL
```
http://localhost:8080/api
```

### 🔐 Personal Info API

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `GET` | `/personal-info` | Lấy thông tin cá nhân đầu tiên | - | `PersonalInfo` |
| `POST` | `/personal-info` | Tạo thông tin cá nhân mới | `PersonalInfoDTO` | `PersonalInfo` |
| `PUT` | `/personal-info/{id}` | Cập nhật thông tin cá nhân | `PersonalInfoDTO` | `PersonalInfo` |
| `DELETE` | `/personal-info/{id}` | Xóa thông tin cá nhân | - | `204 No Content` |

**PersonalInfoDTO Structure:**
```json
{
  "id": "string",
  "fullName": "string (required)",
  "title": "string (required)",
  "bio": "string",
  "location": "string",
  "cvUrl": "string",
  "email": "string (email format)",
  "phone": "string",
  "profileImageUrl": "string",
  "socialLinks": {
    "linkedin": "string",
    "github": "string",
    "twitter": "string"
  }
}
```

### 🚀 Projects API

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `GET` | `/projects` | Lấy danh sách tất cả dự án | - | `List<Project>` |
| `GET` | `/projects/{id}` | Lấy chi tiết dự án theo ID | - | `Project` |
| `POST` | `/projects` | Tạo dự án mới | `ProjectDTO` | `Project` |
| `PUT` | `/projects/{id}` | Cập nhật dự án | `ProjectDTO` | `Project` |
| `DELETE` | `/projects/{id}` | Xóa dự án | - | `204 No Content` |

**ProjectDTO Structure:**
```json
{
  "id": "string",
  "name": "string (required)",
  "description": ["string"],
  "techStack": ["string"],
  "githubLink": "string",
  "demoLink": "string",
  "images": ["string"]
}
```

### 💻 Skills API

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `GET` | `/skills` | Lấy danh sách tất cả kỹ năng | - | `List<Skill>` |
| `GET` | `/skills/type/{type}` | Lấy kỹ năng theo loại | - | `List<Skill>` |
| `GET` | `/skills/{id}` | Lấy chi tiết kỹ năng theo ID | - | `Skill` |
| `POST` | `/skills` | Thêm kỹ năng mới | `SkillDTO` | `Skill` |
| `PUT` | `/skills/{id}` | Cập nhật kỹ năng | `SkillDTO` | `Skill` |
| `DELETE` | `/skills/{id}` | Xóa kỹ năng | - | `204 No Content` |

**SkillDTO Structure:**
```json
{
  "id": "string",
  "name": "string (required)",
  "type": "FRONTEND|BACKEND|TOOLS|OTHER (required)",
  "level": "BEGINNER|INTERMEDIATE|ADVANCED|EXPERT (required)"
}
```

### 💼 Experience API

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `GET` | `/experiences` | Lấy danh sách tất cả kinh nghiệm | - | `List<Experience>` |
| `GET` | `/experiences/{id}` | Lấy chi tiết kinh nghiệm theo ID | - | `Experience` |
| `POST` | `/experiences` | Thêm kinh nghiệm mới | `ExperienceDTO` | `Experience` |
| `PUT` | `/experiences/{id}` | Cập nhật kinh nghiệm | `ExperienceDTO` | `Experience` |
| `DELETE` | `/experiences/{id}` | Xóa kinh nghiệm | - | `204 No Content` |

**ExperienceDTO Structure:**
```json
{
  "id": "string",
  "position": "string (required)",
  "company": "string (required)",
  "startDate": "YYYY-MM-DD (required)",
  "endDate": "YYYY-MM-DD",
  "description": ["string"]
}
```

### 🎓 Education API

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `GET` | `/education` | Lấy danh sách tất cả học vấn | - | `List<Education>` |
| `GET` | `/education/{id}` | Lấy chi tiết học vấn theo ID | - | `Education` |
| `POST` | `/education` | Thêm học vấn mới | `EducationDTO` | `Education` |
| `PUT` | `/education/{id}` | Cập nhật học vấn | `EducationDTO` | `Education` |
| `DELETE` | `/education/{id}` | Xóa học vấn | - | `204 No Content` |

**EducationDTO Structure:**
```json
{
  "id": "string",
  "school": "string (required)",
  "degree": "string (required)",
  "startDate": "YYYY-MM-DD (required)",
  "endDate": "YYYY-MM-DD",
  "description": "string"
}
```

## ⚙️ Cài đặt và Chạy

### Yêu cầu hệ thống

- **Java**: 17 hoặc cao hơn
- **Maven**: 3.6 hoặc cao hơn
- **MongoDB**: 4.4 hoặc cao hơn
- **Memory**: Tối thiểu 512MB RAM

### Các bước cài đặt

1. **Clone repository:**
```bash
git clone <repository-url>
cd personal_portfolio_backend_java_spring
```

2. **Cấu hình MongoDB:**
   - Đảm bảo MongoDB đang chạy trên máy local
   - Hoặc cập nhật connection string trong `application.yaml`

3. **Build project:**
```bash
# Sử dụng Maven wrapper
./mvnw clean install

# Hoặc sử dụng Maven trực tiếp
mvn clean install
```

4. **Chạy ứng dụng:**
```bash
# Sử dụng Maven wrapper
./mvnw spring-boot:run

# Hoặc sử dụng Maven trực tiếp
mvn spring-boot:run

# Hoặc chạy JAR file
java -jar target/personal-portfolio-backend-0.0.1-SNAPSHOT.jar
```

5. **Kiểm tra ứng dụng:**
   - API sẽ chạy tại: `http://localhost:8080`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`
   - Health check: `http://localhost:8080/actuator/health`

## 🔧 Cấu hình

### Application Properties

Tạo file `src/main/resources/application.yaml`:

```yaml
server:
  port: 8080

spring:
  application:
    name: personal-portfolio-backend
  
  data:
    mongodb:
      host: localhost
      port: 27017
      database: portfolio_db
      # Hoặc sử dụng connection string
      # uri: mongodb://localhost:27017/portfolio_db

# CORS Configuration
cors:
  allowed-origins: http://localhost:3000,http://localhost:3001
  allowed-methods: GET,POST,PUT,DELETE,OPTIONS
  allowed-headers: "*"
  allow-credentials: true

# Logging
logging:
  level:
    com.quocanh.personal_portfolio_backend_java_spring: DEBUG
    org.springframework.web: DEBUG
```

### Environment Variables

Bạn có thể override các giá trị cấu hình bằng environment variables:

```bash
export SPRING_DATA_MONGODB_URI=mongodb://localhost:27017/portfolio_db
export SERVER_PORT=8080
export CORS_ALLOWED_ORIGINS=http://localhost:3000
```

## 🚀 Deployment

### Docker Deployment

1. **Tạo Dockerfile:**
```dockerfile
FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

2. **Build và chạy Docker:**
```bash
docker build -t portfolio-backend .
docker run -p 8080:8080 portfolio-backend
```

### Production Deployment

1. **Build JAR file:**
```bash
./mvnw clean package -DskipTests
```

2. **Chạy với production profile:**
```bash
java -jar -Dspring.profiles.active=prod target/personal-portfolio-backend-0.0.1-SNAPSHOT.jar
```

## 🧪 Testing

### Unit Tests
```bash
./mvnw test
```

### Integration Tests
```bash
./mvnw verify
```

### Manual Testing với Swagger UI
1. Truy cập: `http://localhost:8080/swagger-ui.html`
2. Test các API endpoints trực tiếp từ giao diện

## 🔒 Security

### CORS Configuration
- CORS được cấu hình trong `CorsConfig.java`
- Mặc định cho phép origin: `http://localhost:3000`
- Có thể tùy chỉnh trong `application.yaml`

### Validation
- Sử dụng Bean Validation cho tất cả DTOs
- Global exception handler xử lý validation errors
- Trả về HTTP 400 với thông báo lỗi chi tiết

## 📊 Monitoring

### Health Check
```bash
curl http://localhost:8080/actuator/health
```

### Metrics (nếu cần)
Thêm dependency `spring-boot-starter-actuator` để monitoring.

## 🤝 Đóng góp

1. Fork dự án
2. Tạo feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Tạo Pull Request

### Coding Standards
- Sử dụng Java 17 features
- Tuân thủ Spring Boot conventions
- Viết unit tests cho tất cả services
- Sử dụng meaningful commit messages

## 📝 License

Dự án này được phân phối dưới giấy phép MIT. Xem file `LICENSE` để biết thêm chi tiết.

## 📞 Liên hệ

- **Author**: Quoc Anh
- **Email**: nqanh120503@gmail.comcom
- **GitHub**: https://github.com/nqanh12

## 🙏 Acknowledgments

- Spring Boot team cho framework tuyệt vời
- MongoDB team cho database NoSQL
- Cộng đồng open source

---

⭐ Nếu dự án này hữu ích, hãy cho một star! 