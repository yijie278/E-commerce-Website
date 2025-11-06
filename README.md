# E-Commerce Web Application - Jom Makan

A full-stack e-commerce web application built with Jakarta EE for selling Malaysian spices and ingredients. This application demonstrates enterprise-level Java web development with a complete shopping experience including product catalog management, shopping cart functionality, and order processing.

## Demo
<img width="871" height="535" alt="image" src="https://github.com/user-attachments/assets/ca67fba0-1b57-4ce6-bf60-9c05abde74b2" />
<img width="1918" height="862" alt="image" src="https://github.com/user-attachments/assets/7274fe85-9182-459d-a238-721b0c51ede2" />
<img width="1919" height="865" alt="image" src="https://github.com/user-attachments/assets/46b05b92-3979-492e-8abf-56d2b2c5bf44" />
<img width="928" height="871" alt="image" src="https://github.com/user-attachments/assets/f400f704-3466-44e7-b69b-d1d8f73a8d47" />
<img width="935" height="810" alt="image" src="https://github.com/user-attachments/assets/cd79209e-3ebc-49ab-9eb9-4bffb3b15aa4" />
<img width="823" height="413" alt="image" src="https://github.com/user-attachments/assets/7af89817-228f-4d44-9d1e-4bdf4292f838" />

<img width="872" height="643" alt="image" src="https://github.com/user-attachments/assets/e11b1381-0f59-4106-bdf7-4a53d9eac59d" />
<img width="840" height="489" alt="image" src="https://github.com/user-attachments/assets/150d260d-744e-45d9-8648-a2490fda5be9" />
<img width="916" height="487" alt="image" src="https://github.com/user-attachments/assets/89f66de9-57b2-4870-b08b-1bf8d1be3ce9" />
<img width="1632" height="688" alt="image" src="https://github.com/user-attachments/assets/3fec21b6-8ac3-4c95-89cf-bd58be7aaa5a" />


## Project Overview

Jom Makan is a Jakarta EE-based e-commerce platform that provides customers with an intuitive interface to browse, view, and purchase Malaysian spices. The application implements a Model-View-Controller (MVC) architecture pattern using Java servlets for request handling, JSP for presentation, and session management for stateful user interactions.

## Technologies Used

### Programming Languages
- **Java 17** - Core application development using object-oriented programming principles
- **JavaScript** - Client-side interactivity and dynamic content manipulation
- **HTML5** - Semantic markup and page structure
- **CSS3** - Responsive styling and user interface design

### Frameworks and Libraries
- **Jakarta EE (Java EE)** - Enterprise Java platform for building scalable web applications
- **Jakarta Servlet API 6.0** - Server-side request handling and response management
- **JavaServer Pages (JSP)** - Dynamic web page generation with server-side rendering
- **JSTL (JSP Standard Tag Library) 3.0** - Standard tag library for JSP development
- **Gson 2.10.1** - JSON serialization and deserialization for data exchange

### Build Tools and Dependency Management
- **Apache Maven 3.8+** - Project build automation and dependency management
- **Maven Compiler Plugin 3.11.0** - Java source code compilation
- **Maven WAR Plugin 3.4.0** - Web application archive packaging

### Application Server
- **Apache Tomcat 10.1** - Servlet container and web server for application deployment

### Testing Framework
- **JUnit 5.10.2** - Unit testing framework for Java applications

### Data Management
- **CSV File Processing** - Product data persistence and retrieval using file-based storage
- **HTTP Session Management** - Server-side session handling for shopping cart and user state

## Key Features

### Product Catalog Management
- **Product Browsing**: Comprehensive product catalog displaying 12 Malaysian spice products with detailed information including origin, description, and pricing
- **Category Filtering**: Advanced product filtering system supporting four distinct categories (Aromatic Spices, Hot and Spicy, Sweet and Nutty, Herbal)
- **Product Details**: Individual product pages with comprehensive information including images, descriptions, origin details, and pricing
- **Dynamic Product Loading**: CSV-based product data management with automatic loading at application startup

### Shopping Cart Functionality
- **Add to Cart**: Seamless product addition to shopping cart with quantity selection
- **Cart Management**: Real-time cart updates including quantity modification and item removal
- **Session-Based Storage**: Persistent shopping cart using HTTP session management for stateful user experience
- **Cart Total Calculation**: Automatic subtotal and total calculation based on product quantities and pricing

### Order Processing
- **Checkout System**: Complete order processing workflow with order ID generation using UUID
- **Order Confirmation**: Detailed order summary page displaying order information, items, quantities, and total amount
- **Order History**: Session-based order tracking for user order management

### User Interface
- **Responsive Design**: Modern, responsive web interface optimized for various screen sizes
- **Dynamic Content Rendering**: Server-side rendering using JSP with JSTL for dynamic content generation
- **User Experience**: Intuitive navigation with header, footer, and consistent design patterns throughout the application

### Authentication System
- **User Login**: Secure authentication mechanism with credential validation
- **Session Management**: User session handling for authenticated user experience

## Architecture

### Design Pattern
The application follows the **Model-View-Controller (MVC)** architectural pattern:

- **Model**: Java classes representing business entities (ProductProfile, Cart, CartItem, Order) and data management (ProductProfileManager)
- **View**: JSP pages with JSTL for dynamic content presentation
- **Controller**: Jakarta EE servlets handling HTTP requests and coordinating between model and view

### Application Structure

```
src/main/
├── java/org/example/
│   ├── jakartaee/              # Controller Layer (Servlets)
│   │   ├── HomeServlet.java
│   │   ├── ShopServlet.java
│   │   ├── CategoryServlet.java
│   │   ├── ViewServlet.java
│   │   ├── LoginServlet.java
│   │   ├── registerServlet.java
│   │   ├── addToCartServlet.java
│   │   ├── UpdateCartServlet.java
│   │   ├── RemoveFromCartServlet.java
│   │   └── CheckoutServlet.java
│   └── project/               # Model Layer
│       ├── ProductProfile.java
│       ├── ProductProfileManager.java
│       ├── Cart.java
│       ├── CartItem.java
│       └── Order.java
├── resources/
│   └── products.csv           # Product data file
└── webapp/                     # View Layer
    ├── *.jsp                   # JSP pages
    ├── css/                    # Stylesheets
    ├── js/                     # JavaScript files
    ├── images/                 # Static images
    └── WEB-INF/
        ├── web.xml             # Deployment descriptor
        └── lib/                # JAR dependencies
```

### Request Flow

1. **Client Request**: User interacts with web interface, sending HTTP requests
2. **Servlet Processing**: Jakarta EE servlets receive requests, process business logic, and interact with model classes
3. **Data Retrieval**: ProductProfileManager loads product data from CSV file
4. **Session Management**: Cart and order data stored in HTTP session
5. **View Rendering**: JSP pages render dynamic content using JSTL tags
6. **Response**: HTML response sent to client browser

## Technical Implementation Details

### Servlet Configuration
- **Annotation-Based Mapping**: All servlets use @WebServlet annotation for URL pattern mapping, eliminating the need for extensive XML configuration
- **HTTP Method Handling**: Servlets implement doGet() and doPost() methods for handling different HTTP request types
- **Request Dispatching**: Forward and redirect mechanisms for navigation control

### Data Persistence
- **CSV File Processing**: Product data loaded from CSV file using BufferedReader and InputStreamReader for efficient file reading
- **Resource Loading**: Implementation uses getResourceAsStream() for proper resource loading in WAR deployment scenarios
- **Session Storage**: Shopping cart and order data maintained in HTTP session for user-specific state management

### Frontend Technologies
- **JSP with JSTL**: Server-side rendering with JSTL core tags for iteration, conditionals, and data display
- **CSS Styling**: Custom CSS for responsive design and user interface styling
- **JavaScript**: Client-side scripting for enhanced user interactions

## Installation and Setup

### Prerequisites
- Java Development Kit (JDK) 17 or higher
- Apache Maven 3.6+ (or use included Maven Wrapper)
- Apache Tomcat 10.1 or higher

### Build Instructions

1. Clone or download the project repository
2. Navigate to project directory
3. Build the project using Maven:
   ```
   mvn clean package
   ```
   Or use Maven Wrapper:
   ```
   ./mvnw.cmd clean package
   ```

### Deployment

1. Copy the generated WAR file from `target/JakartaEE-1.0-SNAPSHOT.war` to Tomcat's `webapps` directory
2. Start Apache Tomcat server
3. Access the application at `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/`

### Application URLs

- Home Page: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/home.jsp`
- Shop Page: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/shop-servlet`
- Category Filter: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/category-servlet?category={category}`
- Shopping Cart: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/cart.jsp`
- Login: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/login.jsp`

## Skills Demonstrated

### Backend Development
- Enterprise Java development using Jakarta EE platform
- Servlet-based web application architecture
- HTTP request/response handling and session management
- Object-oriented programming with Java
- File I/O operations and CSV data processing
- UUID generation for unique identifier creation

### Frontend Development
- Dynamic web page development using JSP
- JSTL implementation for server-side templating
- HTML5 semantic markup
- CSS3 responsive design
- JavaScript for client-side functionality

### Software Engineering
- MVC architectural pattern implementation
- Separation of concerns between model, view, and controller layers
- Code organization and project structure management
- Build automation with Maven
- Web application packaging and deployment

### Tools and Technologies
- Apache Maven for dependency management and build automation
- Apache Tomcat for application server deployment
- Version control and project management
- Web application development lifecycle

## Project Highlights

- Implemented complete e-commerce functionality including product catalog, shopping cart, and order processing
- Developed 10 servlets handling different aspects of the application workflow
- Created reusable model classes following object-oriented design principles
- Implemented session-based state management for shopping cart persistence
- Designed responsive user interface with modern web technologies
- Utilized Jakarta EE enterprise features for scalable web application development

## Future Enhancements

Potential areas for future development include:
- Database integration for persistent data storage
- User authentication and authorization system
- Payment gateway integration
- Product search functionality
- Admin panel for product and order management
- Email notification system for order confirmations

## License

This project is developed as part of academic coursework and is intended for educational and portfolio purposes.

## Contact

For questions or inquiries about this project, please refer to the project documentation or contact the development team.

