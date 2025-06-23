# Personal Portfolio Backend

Backend API cho website portfolio cá nhân được xây dựng bằng Spring Boot và MongoDB.

## 🛠 Công nghệ sử dụng

- **Java 17**
- **Spring Boot 3.x**
- **MongoDB**
- **Maven**
- **Lombok**
- **Spring Data MongoDB**
- **Spring Validation**

## 🏗 Cấu trúc dự án

```
src/main/java/com/quocanh/personal_portfolio_backend_java_spring/
├── config/
│   └── CorsConfig.java              # Cấu hình CORS
├── controller/
│   ├── BlogPostController.java      # API endpoints cho blog
│   ├── EducationController.java     # API endpoints cho education
│   ├── ExperienceController.java    # API endpoints cho experience
│   ├── PersonalInfoController.java  # API endpoints cho personal info
│   ├── ProjectController.java       # API endpoints cho projects
│   └── SkillController.java         # API endpoints cho skills
├── dto/
│   ├── BlogPostDTO.java
│   ├── EducationDTO.java
│   ├── ExperienceDTO.java
│   ├── PersonalInfoDTO.java
│   ├── ProjectDTO.java
│   └── SkillDTO.java
├── model/
│   ├── BlogPost.java
│   ├── Education.java
│   ├── Experience.java
│   ├── PersonalInfo.java
│   ├── Project.java
│   ├── Skill.java
│   └── enums/
│       ├── SkillLevel.java
│       └── SkillType.java
├── repository/
│   ├── BlogPostRepository.java
│   ├── EducationRepository.java
│   ├── ExperienceRepository.java
│   ├── PersonalInfoRepository.java
│   ├── ProjectRepository.java
│   └── SkillRepository.java
└── service/
    ├── impl/
    │   ├── BlogPostServiceImpl.java
    │   ├── EducationServiceImpl.java
    │   ├── ExperienceServiceImpl.java
    │   ├── PersonalInfoServiceImpl.java
    │   ├── ProjectServiceImpl.java
    │   └── SkillServiceImpl.java
    ├── BlogPostService.java
    ├── EducationService.java
    ├── ExperienceService.java
    ├── PersonalInfoService.java
    ├── ProjectService.java
    └── SkillService.java
```

## 🚀 Các tính năng

1. **Quản lý thông tin cá nhân**
   - Thông tin cơ bản (tên, tiêu đề, bio)
   - Thông tin liên hệ (email, số điện thoại)
   - Links mạng xã hội

2. **Quản lý dự án**
   - Tên dự án
   - Mô tả
   - Tech stack
   - Links (GitHub, Demo)
   - Hình ảnh thumbnail

3. **Quản lý kỹ năng**
   - Phân loại (Frontend, Backend, Tools, Other)
   - Cấp độ (Beginner, Intermediate, Advanced, Expert)

4. **Quản lý kinh nghiệm làm việc**
   - Vị trí
   - Công ty
   - Thời gian
   - Mô tả công việc

5. **Quản lý học vấn**
   - Trường học
   - Bằng cấp
   - Thời gian
   - Mô tả

6. **Quản lý blog**
   - Tiêu đề
   - Nội dung
   - Tags
   - Thời gian tạo

## 📝 API Endpoints

### Personal Info
- GET `/api/personal-info` - Lấy thông tin cá nhân
- POST `/api/personal-info` - Tạo thông tin cá nhân
- PUT `/api/personal-info/{id}` - Cập nhật thông tin cá nhân
- DELETE `/api/personal-info/{id}` - Xóa thông tin cá nhân

### Projects
- GET `/api/projects` - Lấy danh sách dự án
- GET `/api/projects/{id}` - Lấy chi tiết dự án
- POST `/api/projects` - Tạo dự án mới
- PUT `/api/projects/{id}` - Cập nhật dự án
- DELETE `/api/projects/{id}` - Xóa dự án

### Skills
- GET `/api/skills` - Lấy danh sách kỹ năng
- GET `/api/skills/type/{type}` - Lấy kỹ năng theo loại
- GET `/api/skills/{id}` - Lấy chi tiết kỹ năng
- POST `/api/skills` - Thêm kỹ năng mới
- PUT `/api/skills/{id}` - Cập nhật kỹ năng
- DELETE `/api/skills/{id}` - Xóa kỹ năng

### Experience
- GET `/api/experiences` - Lấy danh sách kinh nghiệm
- GET `/api/experiences/{id}` - Lấy chi tiết kinh nghiệm
- POST `/api/experiences` - Thêm kinh nghiệm mới
- PUT `/api/experiences/{id}` - Cập nhật kinh nghiệm
- DELETE `/api/experiences/{id}` - Xóa kinh nghiệm

### Education
- GET `/api/education` - Lấy danh sách học vấn
- GET `/api/education/{id}` - Lấy chi tiết học vấn
- POST `/api/education` - Thêm học vấn mới
- PUT `/api/education/{id}` - Cập nhật học vấn
- DELETE `/api/education/{id}` - Xóa học vấn

### Blog Posts
- GET `/api/blog-posts` - Lấy danh sách bài viết
- GET `/api/blog-posts/{id}` - Lấy chi tiết bài viết
- GET `/api/blog-posts/tag/{tag}` - Lấy bài viết theo tag
- POST `/api/blog-posts` - Tạo bài viết mới
- PUT `/api/blog-posts/{id}` - Cập nhật bài viết
- DELETE `/api/blog-posts/{id}` - Xóa bài viết

## ⚙️ Cài đặt và Chạy

### Yêu cầu
- Java 17 hoặc cao hơn
- Maven 3.6 hoặc cao hơn
- MongoDB 4.4 hoặc cao hơn

### Các bước cài đặt

1. Clone repository:
```bash
git clone <repository-url>
cd personal_portfolio_backend_java_spring
```

2. Cấu hình MongoDB trong `src/main/resources/application.yaml`:
```yaml
spring:
  data:
    mongodb:
      host: localhost
      port: 27017
      database: portfolio_db
```

3. Build project:
```bash
./mvnw clean install
```

4. Chạy ứng dụng:
```bash
./mvnw spring-boot:run
```

Ứng dụng sẽ chạy tại `http://localhost:8080`

## 🔒 CORS Configuration

CORS được cấu hình trong `CorsConfig.java` và `application.yaml`. Mặc định cho phép:
- Origin: `http://localhost:3000`
- Methods: GET, POST, PUT, DELETE
- Headers: All
- Credentials: true

## 📝 License

MIT License 