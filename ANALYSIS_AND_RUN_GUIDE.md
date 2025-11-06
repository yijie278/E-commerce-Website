# E-commerce Website - Code Analysis & Run Guide

## 📋 Project Overview

This is a **Jakarta EE (formerly Java EE) e-commerce web application** for selling Malaysian spices and ingredients. The application is called **"Jom Makan"** and provides an online shopping experience for customers to browse, view, and purchase Malaysian spices.

### Technology Stack
- **Backend**: Jakarta EE (Jakarta Servlet API 6.0)
- **Frontend**: JSP (JavaServer Pages) with JSTL
- **Build Tool**: Maven
- **Java Version**: 23 (configured, but can work with Java 17+)
- **Data Storage**: CSV file (`products.csv`) for product data
- **Session Management**: HTTP Sessions for cart management

---

## 🏗️ Application Architecture

### Project Structure
```
E-commerce-Website/
├── src/main/
│   ├── java/org/example/
│   │   ├── jakartaee/          # Servlets (Controllers)
│   │   │   ├── HomeServlet.java
│   │   │   ├── ShopServlet.java
│   │   │   ├── CategoryServlet.java
│   │   │   ├── ViewServlet.java
│   │   │   ├── LoginServlet.java
│   │   │   ├── registerServlet.java
│   │   │   ├── addToCartServlet.java
│   │   │   ├── RemoveFromCartServlet.java
│   │   │   ├── UpdateCartServlet.java
│   │   │   └── CheckoutServlet.java
│   │   └── project/            # Model Classes
│   │       ├── ProductProfile.java
│   │       ├── ProductProfileManager.java
│   │       ├── Cart.java
│   │       ├── CartItem.java
│   │       ├── Order.java
│   │       └── DisplayProducts.java
│   ├── resources/
│   │   └── products.csv        # Product data file
│   └── webapp/
│       ├── *.jsp               # JSP pages (Views)
│       ├── css/                # Stylesheets
│       ├── js/                 # JavaScript files
│       ├── images/             # Static images
│       └── WEB-INF/
│           ├── web.xml        # Deployment descriptor
│           └── lib/           # JAR dependencies
└── pom.xml                     # Maven configuration
```

---

## 🔍 Code Analysis

### 1. **Servlets (Controllers)**

All servlets use `@WebServlet` annotation for URL mapping:

| Servlet | URL Pattern | Purpose |
|---------|-------------|---------|
| `HomeServlet` | `/home-servlet` | Home page controller |
| `ShopServlet` | `/shop-servlet` | Display all products |
| `CategoryServlet` | `/category-servlet` | Filter products by category |
| `ViewServlet` | `/view-servlet` | View individual product details |
| `LoginServlet` | `/login-servlet` | Handle user login |
| `registerServlet` | `/register-servlet` | Handle user registration |
| `addToCartServlet` | `/addToCartServlet` | Add products to cart |
| `RemoveFromCartServlet` | `/removeFromCart` | Remove items from cart |
| `UpdateCartServlet` | `/updateCart` | Update cart quantities |
| `CheckoutServlet` | `/checkout` | Process checkout |

### 2. **Model Classes**

- **`ProductProfile`**: Represents a product with fields (id, name, price, image, origin, description, category)
- **`ProductProfileManager`**: Manages product data loaded from `products.csv`
- **`Cart`**: Shopping cart stored in HTTP session
- **`CartItem`**: Individual item in cart with quantity
- **`Order`**: Order information (likely for checkout)

### 3. **Data Management**

- Products are loaded from `src/main/resources/products.csv` at application startup
- CSV format: `id|name|price|image|origin|description|category`
- Cart data is stored in HTTP session (in-memory, lost on server restart)
- No database is used - all data is file-based or session-based

### 4. **Key Features**

✅ Product browsing and viewing  
✅ Category filtering (spices, spicy, nutty, herbal)  
✅ Shopping cart functionality  
✅ Session-based cart management  
✅ Product search capability  
✅ User authentication (basic implementation)  
✅ Order management  

---

## ⚠️ Issues Identified

### 1. **POM.xml Issues**
- Missing `maven-compiler-plugin` (though compiler properties are set)
- Java 23 specified (very new, may not be available)
- Conflicting dependencies: Both `javax.servlet` and `jakarta.servlet` are present
- Some legacy dependencies that may conflict

### 2. **Code Issues**
- `ProductProfileManager.loadAllProducts()` uses `getFile()` which may fail in JAR/WAR deployments
- Login uses hardcoded credentials (`test@example.com` / `password123`)
- No database persistence for users or orders
- Cart data is session-based (lost on server restart)

### 3. **Configuration Issues**
- `web.xml` only defines `ShopServlet`, but other servlets use `@WebServlet` (should work, but inconsistent)

---

## 🚀 How to Run the Application

### Prerequisites

1. **Java Development Kit (JDK)**
   - Required: JDK 17 or higher (Java 23 is specified but may not be available)
   - Check: `java -version`
   - Download: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)

2. **Apache Maven**
   - Required: Maven 3.6+
   - Check: `mvn -version`
   - Download: [Maven Download](https://maven.apache.org/download.cgi)
   - Or use the included Maven Wrapper (`mvnw` or `mvnw.cmd`)

3. **Application Server (Servlet Container)**
   - **Option 1**: Apache Tomcat 10.x (recommended for Jakarta EE)
   - **Option 2**: Jetty 11+
   - **Option 3**: Embedded Tomcat (using Maven plugin)

### Step-by-Step Instructions

#### **Method 1: Using Maven with Embedded Tomcat (Easiest)**

1. **Navigate to project directory**
   ```bash
   cd "C:\Users\A\Downloads\E-commerce-Website"
   ```

2. **Build the project**
   ```bash
   mvn clean package
   ```
   Or using Maven wrapper:
   ```bash
   .\mvnw.cmd clean package
   ```

3. **Run with embedded Tomcat** (if plugin is configured)
   ```bash
   mvn tomcat7:run
   ```
   Or deploy WAR to Tomcat manually (see Method 2)

#### **Method 2: Using Apache Tomcat (Recommended)**

1. **Download and Install Tomcat**
   - Download Tomcat 10.x from [Apache Tomcat](https://tomcat.apache.org/download-10.cgi)
   - Extract to a directory (e.g., `C:\apache-tomcat-10.1.0`)

2. **Build the WAR file**
   ```bash
   cd "C:\Users\A\Downloads\E-commerce-Website"
   mvn clean package
   ```
   This creates: `target/JakartaEE-1.0-SNAPSHOT.war`

3. **Deploy to Tomcat**
   - Copy `target/JakartaEE-1.0-SNAPSHOT.war` to `%CATALINA_HOME%\webapps\`
   - Or rename it to `ROOT.war` to deploy at root context

4. **Start Tomcat**
   ```bash
   cd C:\apache-tomcat-10.1.0\bin
   startup.bat
   ```

5. **Access the Application**
   - Open browser: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/`
   - Or if renamed to ROOT: `http://localhost:8080/`

#### **Method 3: Using Maven Cargo Plugin (Alternative)**

Add to `pom.xml`:
```xml
<plugin>
    <groupId>org.codehaus.cargo</groupId>
    <artifactId>cargo-maven2-plugin</artifactId>
    <version>1.10.0</version>
    <configuration>
        <container>
            <containerId>tomcat10x</containerId>
            <type>embedded</type>
        </container>
    </configuration>
</plugin>
```

Then run:
```bash
mvn cargo:run
```

---

## 🔧 Fixing Common Issues

### Issue 1: Java Version Mismatch

**Problem**: Project requires Java 23, but you have Java 17/11

**Solution**: Update `pom.xml`:
```xml
<maven.compiler.target>17</maven.compiler.target>
<maven.compiler.source>17</maven.compiler.source>
```

### Issue 2: Missing Maven Compiler Plugin

**Solution**: Add to `pom.xml` in `<build><plugins>`:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.11.0</version>
    <configuration>
        <source>17</source>
        <target>17</target>
    </configuration>
</plugin>
```

### Issue 3: Product CSV Not Loading

**Problem**: `ProductProfileManager` fails to load CSV from JAR

**Solution**: Use `getResourceAsStream()` instead of `getFile()`:
```java
InputStream is = ProductProfileManager.class.getClassLoader()
    .getResourceAsStream(FILE_NAME);
BufferedReader reader = new BufferedReader(
    new InputStreamReader(is));
```

### Issue 4: Port Already in Use

**Problem**: Port 8080 is already in use

**Solution**: 
- Change Tomcat port in `server.xml`
- Or stop the process using port 8080

---

## 📝 Testing the Application

### 1. **Home Page**
- URL: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/home.jsp`
- Or: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/home-servlet`

### 2. **Shop Page**
- URL: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/shop-servlet`
- Should display all products from `products.csv`

### 3. **Category Page**
- URL: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/category-servlet?category=spices`
- Categories: `spices`, `spicy`, `nutty`, `herbal`

### 4. **Login**
- URL: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/login.jsp`
- Test credentials: `test@example.com` / `password123`

### 5. **Cart**
- Add products via: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/addToCartServlet?id=1&qty=2`
- View cart: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/cart.jsp`

---

## 🎯 Quick Start Commands

```bash
# 1. Navigate to project
cd "C:\Users\A\Downloads\E-commerce-Website"

# 2. Build project
mvn clean package

# 3. Deploy to Tomcat (copy WAR to webapps folder)
copy target\JakartaEE-1.0-SNAPSHOT.war C:\apache-tomcat-10.1.0\webapps\

# 4. Start Tomcat
C:\apache-tomcat-10.1.0\bin\startup.bat

# 5. Open browser
start http://localhost:8080/JakartaEE-1.0-SNAPSHOT/
```

---

## 📚 Additional Notes

- **Session Management**: Cart is stored in HTTP session, so it persists during browser session
- **No Database**: All data is file-based (CSV) or session-based
- **Static Assets**: Images, CSS, JS are served from `webapp/` directory
- **JSP Compilation**: JSPs are compiled on first access (may be slow initially)

---

## 🆘 Troubleshooting

1. **404 Errors**: Check servlet URL mappings in `web.xml` or `@WebServlet` annotations
2. **Products Not Showing**: Verify `products.csv` is in `src/main/resources/`
3. **ClassNotFoundException**: Ensure all dependencies are in `WEB-INF/lib/`
4. **JSP Errors**: Check JSTL dependencies are correctly included

---

## 📞 Support

For issues, check:
- Tomcat logs: `%CATALINA_HOME%\logs\`
- Application logs: Check console output
- Maven build logs: Check `mvn` command output

---

**Good luck with your e-commerce application! 🚀**

