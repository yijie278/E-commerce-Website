# Deploy and Run Instructions

## Quick Start (Recommended)

### Option 1: Run PowerShell Script as Administrator

1. **Right-click** on `deploy-and-run.ps1`
2. Select **"Run with PowerShell"** (or **"Run as Administrator"**)
3. The script will:
   - Deploy the WAR file
   - Start Tomcat
   - Open the application in your browser

### Option 2: Manual Deployment

#### Step 1: Deploy WAR File

**Method A: Copy File (Requires Admin)**
1. Open File Explorer
2. Navigate to: `C:\Users\A\Downloads\E-commerce-Website\target`
3. Copy `JakartaEE-1.0-SNAPSHOT.war`
4. Navigate to: `C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps`
5. Paste the WAR file (you may need admin permission - click "Continue")

**Method B: Use Tomcat Manager (After Starting Tomcat)**
1. Start Tomcat first (see Step 2)
2. Open browser: `http://localhost:8080/manager/html`
3. Login: `admin` / `123`
4. Scroll to "WAR file to deploy"
5. Click "Choose File" → Select `target\JakartaEE-1.0-SNAPSHOT.war`
6. Click "Deploy"

#### Step 2: Start Tomcat

**Method A: Using startup.bat**
1. Open File Explorer
2. Navigate to: `C:\Program Files\Apache Software Foundation\Tomcat 10.1\bin`
3. Double-click `startup.bat`
4. A new window will open (keep it open)

**Method B: Using Windows Service**
1. Press `Win + R`
2. Type `services.msc` and press Enter
3. Find "Apache Tomcat" service
4. Right-click → **Start**

**Method C: Using Command Prompt (as Admin)**
```cmd
cd "C:\Program Files\Apache Software Foundation\Tomcat 10.1\bin"
startup.bat
```

#### Step 3: Access Application

Open your browser and go to:
```
http://localhost:8080/JakartaEE-1.0-SNAPSHOT/
```

---

## Step-by-Step Guide

### 1. Verify WAR File Exists

```powershell
cd "C:\Users\A\Downloads\E-commerce-Website"
Test-Path "target\JakartaEE-1.0-SNAPSHOT.war"
```

If it returns `False`, build the project first:
```powershell
.\mvnw.cmd clean package
```

### 2. Deploy WAR File

**PowerShell (Run as Administrator):**
```powershell
$warFile = "C:\Users\A\Downloads\E-commerce-Website\target\JakartaEE-1.0-SNAPSHOT.war"
$webappsPath = "C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps"
Copy-Item $warFile $webappsPath -Force
```

**Or manually:**
- Copy `target\JakartaEE-1.0-SNAPSHOT.war`
- Paste to `C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps\`

### 3. Start Tomcat

**PowerShell:**
```powershell
cd "C:\Program Files\Apache Software Foundation\Tomcat 10.1\bin"
.\startup.bat
```

**Or double-click:** `startup.bat` in the bin folder

### 4. Verify Tomcat is Running

Open browser: `http://localhost:8080`

You should see the Tomcat welcome page.

### 5. Access Your Application

Main URL:
```
http://localhost:8080/JakartaEE-1.0-SNAPSHOT/
```

Other URLs:
- Home: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/home.jsp`
- Shop: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/shop-servlet`
- Cart: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/cart.jsp`
- Login: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/login.jsp`

---

## Troubleshooting

### Issue: Access Denied When Copying WAR

**Solution:** Run PowerShell or File Explorer as Administrator
- Right-click PowerShell → "Run as Administrator"
- Or right-click File Explorer → "Run as Administrator"

### Issue: Port 8080 Already in Use

**Solution:**
```powershell
# Find process using port 8080
netstat -ano | findstr :8080

# Kill the process (replace PID)
taskkill /PID <PID> /F
```

### Issue: Tomcat Won't Start

**Check:**
1. Java is installed: `java -version`
2. JAVA_HOME is set (if needed)
3. Port 8080 is available

**Solution:**
- Check Tomcat logs: `C:\Program Files\Apache Software Foundation\Tomcat 10.1\logs\catalina.out`
- Verify Java installation

### Issue: Application Not Loading

**Check:**
1. WAR file is in `webapps` folder
2. WAR file was extracted (check for `JakartaEE-1.0-SNAPSHOT` folder in webapps)
3. Tomcat is running
4. No errors in Tomcat logs

**Solution:**
- Check Tomcat logs for errors
- Verify WAR file was deployed correctly
- Restart Tomcat

---

## Stop Tomcat

**Method 1: Using shutdown.bat**
```powershell
cd "C:\Program Files\Apache Software Foundation\Tomcat 10.1\bin"
.\shutdown.bat
```

**Method 2: Using Windows Service**
- Open Services (`services.msc`)
- Find "Apache Tomcat"
- Right-click → **Stop**

**Method 3: Kill Java Process**
```powershell
Get-Process -Name "java" | Where-Object {$_.Path -like "*Tomcat*"} | Stop-Process
```

---

## Quick Commands Summary

```powershell
# Build project
cd "C:\Users\A\Downloads\E-commerce-Website"
.\mvnw.cmd clean package

# Deploy WAR (Run as Admin)
$warFile = "target\JakartaEE-1.0-SNAPSHOT.war"
$webappsPath = "C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps"
Copy-Item $warFile $webappsPath -Force

# Start Tomcat
cd "C:\Program Files\Apache Software Foundation\Tomcat 10.1\bin"
.\startup.bat

# Access application
start http://localhost:8080/JakartaEE-1.0-SNAPSHOT/

# Stop Tomcat
.\shutdown.bat
```

---

**Need help?** Check the logs at: `C:\Program Files\Apache Software Foundation\Tomcat 10.1\logs\`

