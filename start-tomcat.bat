@echo off
echo ========================================
echo Starting Apache Tomcat 10.1
echo ========================================
echo.

cd "C:\Program Files\Apache Software Foundation\Tomcat 10.1\bin"
call startup.bat

echo.
echo ========================================
echo Tomcat is starting...
echo Please wait a few seconds, then open:
echo http://localhost:8080/JakartaEE-1.0-SNAPSHOT/
echo ========================================
echo.
pause

