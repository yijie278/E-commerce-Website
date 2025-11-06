# Installation Guide - Prerequisites for E-commerce Website

This guide will help you install all required software to run the Jakarta EE e-commerce application on Windows.

---

## 📋 Prerequisites Checklist

- [ ] Java JDK 17 or higher
- [ ] Apache Maven (or use Maven Wrapper)
- [ ] Apache Tomcat 10.x

---

## 1️⃣ Installing Java JDK 17 or Higher

### Option A: Install Oracle JDK (Recommended for beginners)

1. **Download JDK**
   - Visit: https://www.oracle.com/java/technologies/downloads/#java17
   - Select **Windows x64 Installer** (`.exe` file)
   - Accept the license agreement and download

2. **Install JDK**
   - Run the downloaded `.exe` installer
   - Follow the installation wizard
   - **Important**: Note the installation path (usually `C:\Program Files\Java\jdk-17`)
   - Complete the installation

3. **Set JAVA_HOME Environment Variable**
   - Press `Win + X` and select **System**
   - Click **Advanced system settings**
   - Click **Environment Variables**
   - Under **System variables**, click **New**
   - Variable name: `JAVA_HOME`
   - Variable value: `C:\Program Files\Java\jdk-17` (or your JDK path)
   - Click **OK**

4. **Add Java to PATH**
   - In **System variables**, find `Path` and click **Edit**
   - Click **New** and add: `%JAVA_HOME%\bin`
   - Click **OK** on all dialogs

5. **Verify Installation**
   - Open **Command Prompt** or **PowerShell**
   - Run: `java -version`
   - You should see: `java version "17.x.x"` or higher
   - Run: `javac -version`
   - You should see: `javac 17.x.x` or higher

### Option B: Install OpenJDK (Free alternative)

1. **Download OpenJDK**
   - Visit: https://adoptium.net/ (Eclipse Temurin)
   - Select **Version**: 17 LTS
   - Select **Operating System**: Windows
   - Select **Architecture**: x64
   - Select **Package Type**: JDK
   - Click **Download**

2. **Install OpenJDK**
   - Run the downloaded `.msi` installer
   - Follow the installation wizard
   - **Important**: Check "Set JAVA_HOME variable" during installation
   - Complete the installation

3. **Verify Installation**
   - Open **Command Prompt** or **PowerShell**
   - Run: `java -version`
   - Run: `javac -version`

### Option C: Use Chocolatey (Package Manager)

If you have Chocolatey installed:
```powershell
choco install openjdk17
```

---

## 2️⃣ Installing Apache Maven

### Option A: Install Maven Manually

1. **Download Maven**
   - Visit: https://maven.apache.org/download.cgi
   - Download **apache-maven-3.9.x-bin.zip** (latest version)
   - Extract to a location like `C:\Program Files\Apache\maven`

2. **Set MAVEN_HOME Environment Variable**
   - Press `Win + X` and select **System**
   - Click **Advanced system settings**
   - Click **Environment Variables**
   - Under **System variables**, click **New**
   - Variable name: `MAVEN_HOME`
   - Variable value: `C:\Program Files\Apache\maven` (or your Maven path)
   - Click **OK**

3. **Add Maven to PATH**
   - In **System variables**, find `Path` and click **Edit**
   - Click **New** and add: `%MAVEN_HOME%\bin`
   - Click **OK** on all dialogs

4. **Verify Installation**
   - Open a **NEW** Command Prompt or PowerShell (important: restart terminal)
   - Run: `mvn -version`
   - You should see Maven version and Java version information

### Option B: Use Chocolatey

```powershell
choco install maven
```

### Option C: Use Maven Wrapper (No Installation Needed!)

**Good News**: Your project already includes Maven Wrapper! You can skip Maven installation.

- Use `mvnw.cmd` (Windows) or `mvnw` (Linux/Mac) instead of `mvn`
- The wrapper will download Maven automatically on first use
- Example: `.\mvnw.cmd clean package` instead of `mvn clean package`

---

## 3️⃣ Installing Apache Tomcat 10.x

### Option A: Install Tomcat Manually (Recommended)

1. **Download Tomcat**
   - Visit: https://tomcat.apache.org/download-10.cgi
   - Under **10.1.x** section, download **64-bit Windows zip** (e.g., `apache-tomcat-10.1.20-windows-x64.zip`)
   - **Note**: Make sure to download Tomcat 10.x (not 9.x or 11.x) for Jakarta EE compatibility

2. **Extract Tomcat**
   - Extract the zip file to a location like `C:\Program Files\Apache\tomcat10`
   - Or extract to `C:\apache-tomcat-10.1.20` (simpler path)

3. **Set CATALINA_HOME (Optional but Recommended)**
   - Press `Win + X` and select **System**
   - Click **Advanced system settings**
   - Click **Environment Variables**
   - Under **System variables**, click **New**
   - Variable name: `CATALINA_HOME`
   - Variable value: `C:\apache-tomcat-10.1.20` (or your Tomcat path)
   - Click **OK**

4. **Verify Installation**
   - Navigate to Tomcat's `bin` folder: `cd C:\apache-tomcat-10.1.20\bin`
   - Run: `startup.bat`
   - Open browser: `http://localhost:8080`
   - You should see the Tomcat welcome page
   - To stop: Run `shutdown.bat` in the same folder

### Option B: Use Chocolatey

```powershell
choco install tomcat
```

**Note**: Chocolatey version might need manual configuration.

---

## 🔧 Quick Verification Commands

After installation, open **Command Prompt** or **PowerShell** and run:

```bash
# Check Java
java -version
javac -version

# Check Maven (if installed)
mvn -version

# Or check Maven Wrapper
cd "C:\Users\A\Downloads\E-commerce-Website"
.\mvnw.cmd -version

# Check Tomcat (navigate to bin folder first)
cd C:\apache-tomcat-10.1.20\bin
startup.bat
```

---

## 🚀 Quick Start After Installation

Once all prerequisites are installed:

1. **Navigate to project**
   ```bash
   cd "C:\Users\A\Downloads\E-commerce-Website"
   ```

2. **Build the project**
   ```bash
   # Using Maven Wrapper (recommended)
   .\mvnw.cmd clean package
   
   # OR using Maven (if installed)
   mvn clean package
   ```

3. **Deploy to Tomcat**
   ```bash
   # Copy WAR file to Tomcat webapps folder
   copy target\JakartaEE-1.0-SNAPSHOT.war C:\apache-tomcat-10.1.20\webapps\
   ```

4. **Start Tomcat**
   ```bash
   cd C:\apache-tomcat-10.1.20\bin
   startup.bat
   ```

5. **Access Application**
   - Open browser: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/`
   - Or: `http://localhost:8080/JakartaEE-1.0-SNAPSHOT/home.jsp`

---

## ⚠️ Common Issues & Solutions

### Issue 1: "java is not recognized"
**Solution**: 
- Verify JAVA_HOME is set correctly
- Verify PATH includes `%JAVA_HOME%\bin`
- **Restart Command Prompt/PowerShell** after setting environment variables

### Issue 2: "mvn is not recognized"
**Solution**: 
- Use Maven Wrapper instead: `.\mvnw.cmd`
- Or verify MAVEN_HOME and PATH are set correctly
- **Restart terminal** after setting environment variables

### Issue 3: Port 8080 already in use
**Solution**: 
- Stop other applications using port 8080
- Or change Tomcat port in `conf/server.xml` (change `port="8080"` to another port)

### Issue 4: Tomcat won't start
**Solution**: 
- Check if Java is installed: `java -version`
- Check Tomcat logs: `logs/catalina.out`
- Ensure no other application is using port 8080

### Issue 5: Environment variables not working
**Solution**: 
- **Always restart Command Prompt/PowerShell** after setting environment variables
- Or restart your computer
- Verify variables: `echo %JAVA_HOME%` and `echo %MAVEN_HOME%`

---

## 📝 Installation Checklist

After installation, verify each component:

- [ ] Java installed: `java -version` shows version 17 or higher
- [ ] Java compiler works: `javac -version` shows version 17 or higher
- [ ] Maven works: `mvn -version` OR `.\mvnw.cmd -version` works
- [ ] Tomcat starts: `startup.bat` runs without errors
- [ ] Tomcat accessible: `http://localhost:8080` shows Tomcat welcome page

---

## 🎯 Recommended Installation Order

1. **Java JDK 17** (most important - required for everything)
2. **Apache Maven** (or use Maven Wrapper - already in project)
3. **Apache Tomcat 10.x** (for deploying the application)

---

## 💡 Tips

- **Use Maven Wrapper**: Your project already has `mvnw.cmd`, so you might not need to install Maven separately
- **Restart Terminal**: Always open a new Command Prompt/PowerShell after setting environment variables
- **Check Versions**: Make sure you're using compatible versions (Java 17+, Tomcat 10.x)
- **Test Each Step**: Verify each installation before moving to the next

---

**Need Help?** Check the `ANALYSIS_AND_RUN_GUIDE.md` for more detailed information about running the application.

