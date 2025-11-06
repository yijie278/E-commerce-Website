# Complete Run Guide - E-commerce Website

## 📊 Code Analysis Summary

### Application Overview
**"Jom Makan"** - A Jakarta EE e-commerce application for selling Malaysian spices and ingredients.

### Architecture
- **Backend**: Jakarta EE Servlets (10 servlets)
- **Frontend**: JSP pages with JSTL
- **Data Storage**: 
  - Products: CSV file (`products.csv`) - 12 products loaded at startup
  - Cart: HTTP Session (in-memory)
  - Orders: HTTP Session (in-memory)
- **Build Tool**: Maven (with wrapper included)

### Servlets & Their Functions

| Servlet | URL | Function |
|---------|-----|----------|
| `HomeServlet` | `/home-servlet` | Home page controller |
| `ShopServlet` | `/shop-servlet` | Display all products |
| `CategoryServlet` | `/category-servlet?category=X` | Filter by category (spices, spicy, nutty, herbal) |
| `ViewServlet` | `/view-servlet?id=X` | View product details |
| `LoginServlet` | `/login-servlet` | User login (hardcoded: test@example.com/password123) |
| `registerServlet` | `/register-servlet` | User registration (⚠️ has DB code but not configured) |
| `addToCartServlet` | `/addToCartServlet?id=X&qty=Y` | Add product to cart |
| `UpdateCartServlet` | `/updateCart?id=X&qty=Y` | Update cart quantity |
| `RemoveFromCartServlet` | `/removeFromCart?id=X` | Remove item from cart |
| `CheckoutServlet` | `/checkout` | Process order (creates order, clears cart) |

### Key Features
✅ Product browsing (12 Malaysian spices)  
✅ Category filtering (4 categories)  
✅ Product detail view  
✅ Shopping cart (session-based)  
✅ Order processing  
✅ User login (basic)  
⚠️ User registration (has database code but not configured)  

### Important Notes
- **No Database Required**: Products loaded from CSV, cart/orders in session
- **RegisterServlet Issue**: Contains MySQL code but database not configured (will fail if used)
- **Login Credentials**: Hardcoded - `test@example.com` / `password123`
- **Session-Based**: Cart and orders are lost on server restart

---

## 🚀 Step-by-Step Run Instructions

### Prerequisites Status
✅ Java 17 - Already installed  
✅ Maven - Use Maven Wrapper (`mvnw.cmd`)  
✅ Tomcat 10.x - Already installed (admin/123)  

---

## Step 1: Build the Project

Open **PowerShell** or **Command Prompt** and navigate to the project:

```powershell
cd "C:\Users\A\Downloads\E-commerce-Website"
```

Build the project using Maven Wrapper:

```powershell
.\mvnw.cmd clean package
```

**Expected Output:**
- `BUILD SUCCESS`
- WAR file created: `target\JakartaEE-1.0-SNAPSHOT.war`

**If build fails:**
- Check Java version: `java -version` (should be 17+)
- Check Maven wrapper: `.\mvnw.cmd -version`

---

## Step 2: Locate Tomcat Installation

Since you installed Tomcat with admin credentials, find your Tomcat installation:

**Common locations:**
- `C:\Program Files\Apache Software Foundation\Tomcat 10.x`
- `C:\apache-tomcat-10.x`
- `C:\Tomcat\apache-tomcat-10.x`

**Find Tomcat:**
1. Check Windows Services (if installed as service)
2. Check Start Menu for "Apache Tomcat"
3. Search for `startup.bat` in File Explorer

**Verify Tomcat:**
- Look for `bin\startup.bat` file
- Look for `webapps\` folder

---

## Step 3: Deploy WAR to Tomcat

### Option A: Copy WAR to webapps (Automatic Deployment)

```powershell
# Replace with your actual Tomcat path
$TOMCAT_HOME = "C:\apache-tomcat-10.1.20"

# Copy WAR file
copy target\JakartaEE-1.0-SNAPSHOT.war "$TOMCAT_HOME\webapps\"
```

### Option B: Manual Copy
1. Navigate to `target` folder in project
2. Copy `JakartaEE-1.0-SNAPSHOT.war`
3. Paste into Tomcat's `webapps` folder

**Note:** Tomcat will automatically extract the WAR file on startup.

---

## Step 4: Start Tomcat

### Method 1: Using startup.bat

```powershell
# Navigate to Tomcat bin folder
cd "C:\apache-tomcat-10.1.20\bin"

# Start Tomcat
.\startup.bat
```

### Method 2: Using Tomcat Manager (if installed as service)

1. Open **Services** (Win + R → `services.msc`)
2. Find "Apache Tomcat" service
3. Right-click → **Start**

### Method 3: Using Tomcat Monitor (if installed)

- Look for Tomcat icon in system tray
- Right-click → **Start**

**Verify Tomcat is Running:**
- Open browser: `http://localhost:8080`
- You should see Tomcat welcome page

---

## Step 5: Access the Application

### Main Application URL

```
http://localhost:8080/JakartaEE-1.0-SNAPSHOT/
```

Or directly to home page:

```
http://localhost:8080/JakartaEE-1.0-SNAPSHOT/home.jsp
```

### Key Pages

| Page | URL |
|------|-----|
| Home | `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/home.jsp` |
| Shop (All Products) | `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/shop-servlet` |
| Category (Spices) | `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/category-servlet?category=spices` |
| Category (Spicy) | `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/category-servlet?category=spicy` |
| Category (Nutty) | `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/category-servlet?category=nutty` |
| Category (Herbal) | `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/category-servlet?category=herbal` |
| View Product | `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/view-servlet?id=1` |
| Cart | `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/cart.jsp` |
| Login | `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/login.jsp` |
| Orders | `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/order.jsp` |

---

## Step 6: Test the Application

### Test Flow

1. **View Home Page**
   - URL: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/home.jsp`
   - Should see "Jom Makan" homepage

2. **Browse Products**
   - Click "shop" or go to `/shop-servlet`
   - Should see 12 products from CSV

3. **View Product Details**
   - Click on any product or eye icon
   - URL: `/view-servlet?id=1` (or any product ID 1-12)

4. **Add to Cart**
   - Click "Add to Cart" on any product
   - Cart count should increase in header

5. **View Cart**
   - Click cart icon or go to `/cart.jsp`
   - Should see added products

6. **Update Quantity**
   - Change quantity in cart
   - Click outside the input (auto-submits)

7. **Remove Item**
   - Click "Remove" button on any item

8. **Checkout**
   - Click "Proceed to Checkout"
   - Should redirect to order confirmation page

9. **View Orders**
   - Go to `/order.jsp`
   - Should see order details

10. **Category Filter**
    - Click category links (Spices, Spicy, Nutty, Herbal)
    - Should filter products by category

11. **Login** (Optional)
    - Go to `/login.jsp`
    - Email: `test@example.com`
    - Password: `password123`

---

## 🔧 Troubleshooting

### Issue 1: Port 8080 Already in Use

**Error:** `Address already in use: bind`

**Solution:**
```powershell
# Find process using port 8080
netstat -ano | findstr :8080

# Kill the process (replace PID with actual process ID)
taskkill /PID <PID> /F

# Or change Tomcat port in: TOMCAT_HOME/conf/server.xml
# Change: <Connector port="8080" ...> to <Connector port="8081" ...>
```

### Issue 2: Products Not Showing

**Symptoms:** Empty shop page

**Check:**
1. Verify `products.csv` exists in `src/main/resources/`
2. Check Tomcat logs: `TOMCAT_HOME/logs/catalina.out`
3. Look for errors in console output

**Solution:**
- Ensure CSV file is in correct location
- Check file encoding (should be UTF-8)
- Verify CSV format matches expected format

### Issue 3: 404 Errors

**Symptoms:** Page not found

**Check:**
1. Verify WAR file is in `webapps` folder
2. Check if WAR was extracted (should see folder `JakartaEE-1.0-SNAPSHOT`)
3. Verify servlet URL mappings

**Solution:**
- Redeploy WAR file
- Check `web.xml` and `@WebServlet` annotations
- Restart Tomcat

### Issue 4: Cart Not Working

**Symptoms:** Cart is empty or items disappear

**Check:**
- Cart is session-based (lost on browser close/restart)
- Ensure cookies are enabled
- Check session timeout in Tomcat

**Solution:**
- Clear browser cache
- Enable cookies
- Check Tomcat session configuration

### Issue 5: Images Not Loading

**Symptoms:** Product images not showing

**Check:**
1. Verify image paths in `products.csv`
2. Check if images exist in `webapp/project_images/`
3. Check browser console for 404 errors

**Solution:**
- Ensure image paths are correct
- Check file names match exactly (case-sensitive)
- Verify images are in `webapp` folder

### Issue 6: Build Errors

**Symptoms:** `mvnw.cmd clean package` fails

**Common Causes:**
- Java version mismatch
- Missing dependencies
- Compilation errors

**Solution:**
```powershell
# Clean and rebuild
.\mvnw.cmd clean
.\mvnw.cmd compile
.\mvnw.cmd package

# Check Java version
java -version

# Check Maven wrapper
.\mvnw.cmd -version
```

---

## 📝 Quick Reference Commands

### Build Project
```powershell
cd "C:\Users\A\Downloads\E-commerce-Website"
.\mvnw.cmd clean package
```

### Deploy to Tomcat
```powershell
copy target\JakartaEE-1.0-SNAPSHOT.war "C:\apache-tomcat-10.1.20\webapps\"
```

### Start Tomcat
```powershell
cd "C:\apache-tomcat-10.1.20\bin"
.\startup.bat
```

### Stop Tomcat
```powershell
cd "C:\apache-tomcat-10.1.20\bin"
.\shutdown.bat
```

### View Tomcat Logs
```powershell
# Real-time log viewing
type "C:\apache-tomcat-10.1.20\logs\catalina.out"
```

### Access Tomcat Manager
```
http://localhost:8080/manager/html
Username: admin
Password: 123
```

---

## 🎯 Application Flow Diagram

```
User → Home Page → Shop → View Product → Add to Cart
                                              ↓
                                        Cart Page
                                              ↓
                                        Checkout → Order Confirmation
```

### Complete User Journey

1. **Landing**: User visits home page
2. **Browse**: User clicks "shop" to see all products
3. **Filter**: User can filter by category
4. **View**: User clicks product to see details
5. **Add**: User adds product to cart
6. **Cart**: User views cart, updates quantities
7. **Checkout**: User proceeds to checkout
8. **Order**: User sees order confirmation

---

## 📋 Product Categories

The application has **12 products** in **4 categories**:

### Spices (3 products)
- Kunyit (Turmeric)
- Bunga Lawang (Star Anise)
- Bunga Cengkih (Cloves)

### Spicy (3 products)
- Halia (Ginger)
- Asam Jawa (Tamarind)
- Lada Hitam (Black Pepper)

### Nutty (3 products)
- Buah Pili (Pili Nuts)
- Buah Keras (Candlenuts)
- Buah Gajus (Cashews)

### Herbal (3 products)
- Daun Pandan (Pandan Leaves)
- Serai (Lemongrass)
- Daun Limau Purut

---

## ⚠️ Known Issues & Limitations

1. **RegisterServlet**: Contains MySQL database code but database not configured
   - **Impact**: Registration will fail if attempted
   - **Workaround**: Use login with hardcoded credentials

2. **Session-Based Storage**: Cart and orders stored in HTTP session
   - **Impact**: Data lost on server restart or session timeout
   - **Workaround**: None (by design for this demo)

3. **Hardcoded Login**: Login uses hardcoded credentials
   - **Impact**: Only one user can login
   - **Workaround**: Use `test@example.com` / `password123`

4. **No Database**: No persistent storage
   - **Impact**: No user accounts, order history, etc.
   - **Workaround**: This is a demo application

---

## 🎉 Success Checklist

After following this guide, you should be able to:

- [ ] Build the project successfully
- [ ] Deploy WAR to Tomcat
- [ ] Start Tomcat server
- [ ] Access home page
- [ ] Browse all products
- [ ] Filter by category
- [ ] View product details
- [ ] Add products to cart
- [ ] Update cart quantities
- [ ] Remove items from cart
- [ ] Complete checkout
- [ ] View order confirmation

---

## 📞 Need Help?

1. **Check Tomcat Logs**: `TOMCAT_HOME/logs/catalina.out`
2. **Check Application Logs**: Console output when starting Tomcat
3. **Verify URLs**: Ensure servlet URLs match `@WebServlet` annotations
4. **Check Browser Console**: F12 → Console tab for JavaScript errors

---

**Good luck running your e-commerce application! 🚀**

