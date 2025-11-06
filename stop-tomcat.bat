@echo off
echo ========================================
echo Stopping Apache Tomcat 10.1
echo ========================================
echo.

cd "C:\Program Files\Apache Software Foundation\Tomcat 10.1\bin"
call shutdown.bat

echo.
echo Tomcat stopped.
pause

