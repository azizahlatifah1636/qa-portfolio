# API Testing Methodology - Azizah Latifa

## 📋 Overview

This comprehensive guide outlines my approach to API testing, covering methodologies, tools, and best practices demonstrated across multiple projects in my QA portfolio.

## 🎯 API Testing Strategy

### Testing Pyramid Approach
```
    /\
   /  \     Unit Tests (Fastest, Most Reliable)
  /____\    
 /      \   Integration Tests (API Testing Focus)
/________\  
          \  End-to-End Tests (Complete User Flows)
```

### Core Testing Principles
- **Early Testing**: API testing in development phase
- **Comprehensive Coverage**: All endpoints and methods
- **Data-Driven Testing**: Multiple test scenarios
- **Automation First**: Repeatable and reliable tests

## 🛠️ Tools & Technologies

### Primary Testing Tools
- **REST Assured**: Java-based API testing framework
- **Postman**: Manual API testing and documentation
- **Jackson**: JSON processing and validation
- **TestNG/JUnit**: Test execution and reporting

### Supporting Technologies
- **Maven/Gradle**: Build automation and dependency management
- **GitHub Actions**: CI/CD pipeline integration
- **JSON Schema**: Response validation
- **Hamcrest**: Assertion library for readable tests

## 🔍 Testing Methodologies

### 1. Functional Testing

#### CRUD Operations Testing
```java
// Example Test Structure
@Test
public void testCreateUser() {
    given()
        .contentType(ContentType.JSON)
        .body(userPayload)
    .when()
        .post("/api/users")
    .then()
        .statusCode(201)
        .body("id", notNullValue())
        .body("name", equalTo(userPayload.getName()));
}
```

#### Test Scenarios Covered
- **Create (POST)**: Resource creation validation
- **Read (GET)**: Data retrieval and filtering
- **Update (PUT/PATCH)**: Modification operations
- **Delete (DELETE)**: Resource removal verification

### 2. Status Code Validation

#### HTTP Status Code Testing
- **2xx Success**: 200, 201, 202, 204
- **4xx Client Errors**: 400, 401, 403, 404, 422
- **5xx Server Errors**: 500, 502, 503

#### Implementation Example
```java
@Test
public void testStatusCodes() {
    // Valid request - 200 OK
    get("/api/users/1").then().statusCode(200);
    
    // Resource not found - 404
    get("/api/users/999").then().statusCode(404);
    
    // Unauthorized - 401
    given().auth().none()
           .get("/api/protected")
           .then().statusCode(401);
}
```

### 3. Response Validation

#### JSON Schema Validation
```java
@Test
public void testResponseSchema() {
    get("/api/users/1")
        .then()
        .assertThat()
        .body(matchesJsonSchemaInClasspath("user-schema.json"));
}
```

#### Data Type Validation
- **String Fields**: Non-null, proper format
- **Numeric Fields**: Range validation
- **Date Fields**: ISO format compliance
- **Boolean Fields**: True/false values

### 4. Performance Testing

#### Response Time Validation
```java
@Test
public void testResponseTime() {
    get("/api/users")
        .then()
        .time(lessThan(2000L)); // Response under 2 seconds
}
```

#### Load Testing Scenarios
- **Concurrent Users**: Multiple simultaneous requests
- **Data Volume**: Large dataset handling
- **Peak Load**: Maximum capacity testing

## 📊 Test Data Management

### Test Data Strategy
- **Static Data**: Predefined test datasets
- **Dynamic Data**: Generated test data
- **Database State**: Clean setup and teardown
- **Environment Isolation**: Separate test environments

### Data Generation Patterns
```java
public class TestDataFactory {
    public static User createValidUser() {
        return User.builder()
            .name("Test User " + System.currentTimeMillis())
            .email("test" + System.currentTimeMillis() + "@example.com")
            .build();
    }
}
```

## 🔐 Security Testing

### Authentication Testing
- **Valid Credentials**: Successful authentication
- **Invalid Credentials**: Proper error handling
- **Token Expiration**: Session management
- **Authorization Levels**: Role-based access

### Security Scenarios
```java
@Test
public void testUnauthorizedAccess() {
    given()
        .auth().none()
    .when()
        .get("/api/admin/users")
    .then()
        .statusCode(401)
        .body("error", equalTo("Unauthorized"));
}
```

## 📈 Error Handling Validation

### Error Response Testing
- **Malformed Requests**: Invalid JSON structure
- **Missing Parameters**: Required field validation
- **Invalid Data Types**: Type mismatch scenarios
- **Business Logic Errors**: Application-specific errors

### Error Response Structure
```json
{
  "error": {
    "code": "VALIDATION_ERROR",
    "message": "Invalid input data",
    "details": [
      {
        "field": "email",
        "message": "Invalid email format"
      }
    ]
  }
}
```

## 🔄 CI/CD Integration

### Automated Testing Pipeline
```yaml
# GitHub Actions Example
name: API Tests
on: [push, pull_request]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - name: Set up Java
        uses: actions/setup-java@v2
        with:
          java-version: '11'
      - name: Run API Tests
        run: mvn test
      - name: Generate Report
        run: mvn surefire-report:report
```

### Test Reporting
- **Detailed Test Results**: Pass/fail status
- **Performance Metrics**: Response times
- **Coverage Reports**: Endpoint coverage
- **Trend Analysis**: Historical test data

## 📋 Test Case Documentation

### Test Case Template
```
Test ID: API_001
Test Name: Create User with Valid Data
Endpoint: POST /api/users
Preconditions: Valid authentication token
Test Data: Valid user object
Expected Result: 201 Created status, user ID returned
Actual Result: [To be filled during execution]
Status: [Pass/Fail]
```

### Documentation Standards
- **Clear Test Descriptions**: Understandable objectives
- **Comprehensive Steps**: Detailed execution steps
- **Expected Results**: Specific validation criteria
- **Test Data**: Required input parameters

## 🎯 Best Practices

### API Testing Guidelines
1. **Test Early and Often**: Continuous testing approach
2. **Comprehensive Coverage**: All endpoints and scenarios
3. **Readable Tests**: Clear and maintainable code
4. **Independent Tests**: No dependencies between tests
5. **Data Isolation**: Clean test environment

### Code Quality Standards
```java
// Good Practice Example
@Test
@DisplayName("Should return user details when valid ID provided")
public void shouldReturnUserDetailsForValidId() {
    // Given
    int validUserId = 1;
    
    // When
    Response response = get("/api/users/" + validUserId);
    
    // Then
    response.then()
            .statusCode(200)
            .body("id", equalTo(validUserId))
            .body("name", notNullValue())
            .body("email", matchesPattern(".*@.*\\..*"));
}
```

## 📊 Project Examples

### Weather API Testing Project
**Repository**: [Weather-API-UI-Automation](https://github.com/azizahlatifah1636/Weather-API-UI-Automation)

**Key Features**:
- Weather data API validation
- Multiple city weather requests
- Response time performance testing
- Error handling for invalid locations

### JSON API Testing Suite
**Repository**: [qa-database-json-api](https://github.com/azizahlatifah1636/qa-database-json-api)

**Key Features**:
- Comprehensive JSON schema validation
- CRUD operations testing
- Authentication and authorization testing
- Database integration verification

## 📈 Metrics & Reporting

### Test Metrics Tracked
- **Test Coverage**: Percentage of endpoints tested
- **Pass Rate**: Successful test execution percentage
- **Response Time**: Average API response times
- **Defect Rate**: Number of bugs found per release

### Reporting Tools
- **TestNG Reports**: Detailed test execution results
- **Extent Reports**: Rich HTML test reports
- **Allure Reports**: Interactive test reporting
- **Custom Dashboards**: Project-specific metrics

## 🔮 Advanced Testing Techniques

### Contract Testing
- **API Contracts**: Pact-based contract testing
- **Schema Evolution**: Backward compatibility testing
- **Version Management**: Multiple API version support

### Mocking and Virtualization
- **Service Mocking**: WireMock for service simulation
- **Test Isolation**: Independent service testing
- **Dependency Management**: External service mocking

## 📞 Contact & Collaboration

For questions about API testing methodologies or collaboration opportunities:

**Azizah Latifa**  
📧 nurazizahlatifah@gmail.com  
💼 [LinkedIn](https://linkedin.com/in/azizahlatifah)  
🗂️ [GitHub](https://github.com/azizahlatifah1636)

---

*This API testing methodology demonstrates comprehensive knowledge of modern testing practices and tools essential for quality API development and maintenance.*