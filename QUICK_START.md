# Quick Start Guide - Run Your E-commerce Application

## ✅ Build Status: SUCCESS
Your WAR file is ready: `target\JakartaEE-1.0-SNAPSHOT.war`

---

## 🚀 Deploy to Tomcat (3 Steps)

### Step 1: Find Your Tomcat Installation

Since you installed Tomcat with admin credentials, find your Tomcat folder:

**Common locations:**
- `C:\Program Files\Apache Software Foundation\Tomcat 10.x`
- `C:\apache-tomcat-10.x`
- `C:\Tomcat\apache-tomcat-10.x`

**Or search for:**
- `startup.bat` file
- `webapps` folder

---

### Step 2: Deploy the WAR File

**Option A: Copy WAR to webapps folder**

```powershell
# Replace YOUR_TOMCAT_PATH with your actual Tomcat path
copy target\JakartaEE-1.0-SNAPSHOT.war "YOUR_TOMCAT_PATH\webapps\"
```

**Example:**
```powershell
copy target\JakartaEE-1.0-SNAPSHOT.war "C:\apache-tomcat-10.1.20\webapps\"
```

**Option B: Use Tomcat Manager (Web Interface)**

1. Start Tomcat first (see Step 3)
2. Open browser: `http://localhost:8080/manager/html`
3. Login with: `admin` / `123`
4. Scroll to "WAR file to deploy"
5. Click "Choose File" and select: `target\JakartaEE-1.0-SNAPSHOT.war`
6. Click "Deploy"

---

### Step 3: Start Tomcat

**Method 1: Using startup.bat**

```powershell
# Navigate to Tomcat bin folder
cd "YOUR_TOMCAT_PATH\bin"

# Start Tomcat
.\startup.bat
```

**Method 2: Using Windows Service**

1. Press `Win + R`
2. Type `services.msc` and press Enter
3. Find "Apache Tomcat" service
4. Right-click → **Start**

**Method 3: Using Tomcat Monitor**

- Look for Tomcat icon in system tray
- Right-click → **Start**

---

## 🌐 Access Your Application

Once Tomcat is running, open your browser:

### Main Application URL:
```
http://localhost:8080/JakartaEE-1.0-SNAPSHOT/
```

### Direct Links:
- **Home**: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/home.jsp`
- **Shop**: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/shop-servlet`
- **Cart**: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/cart.jsp`
- **Login**: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/login.jsp`

---

## 🧪 Test the Application

1. **Browse Products**: Go to shop page, you should see 12 Malaysian spices
2. **View Product**: Click on any product to see details
3. **Add to Cart**: Click "Add to Cart" on any product
4. **View Cart**: Click cart icon in header
5. **Checkout**: Click "Proceed to Checkout" in cart
6. **View Order**: You'll see order confirmation

---

## ⚠️ Troubleshooting

### Port 8080 Already in Use

```powershell
# Find process using port 8080
netstat -ano | findstr :8080

# Kill the process (replace PID)
taskkill /PID <PID> /F
```

### Application Not Loading

1. Check Tomcat logs: `TOMCAT_HOME\logs\catalina.out`
2. Verify WAR file is in `webapps` folder
3. Check if WAR was extracted (should see `JakartaEE-1.0-SNAPSHOT` folder)

### Products Not Showing

- Check `products.csv` exists in `src\main\resources\`
- Check Tomcat logs for errors

---

## 📝 Quick Commands Reference

```powershell
# Build project
.\mvnw.cmd clean package

# Deploy to Tomcat (replace path)
copy target\JakartaEE-1.0-SNAPSHOT.war "C:\apache-tomcat-10.1.20\webapps\"

# Start Tomcat
cd "C:\apache-tomcat-10.1.20\bin"
.\startup.bat

# Stop Tomcat
.\shutdown.bat

# Access application
start http://localhost:8080/JakartaEE-1.0-SNAPSHOT/
```

---

## 🎯 What to Expect

- **Home Page**: Welcome page with category links
- **Shop Page**: 12 products displayed in grid
- **Product Details**: Full product information
- **Shopping Cart**: Session-based cart functionality
- **Checkout**: Order processing
- **Order Confirmation**: Order details page

---

**Need more details?** Check `COMPLETE_RUN_GUIDE.md` for comprehensive documentation.

