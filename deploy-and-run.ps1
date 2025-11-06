# Deploy and Run E-commerce Application
# Run this script as Administrator

$tomcatPath = "C:\Program Files\Apache Software Foundation\Tomcat 10.1"
$warFile = "target\JakartaEE-1.0-SNAPSHOT.war"
$webappsPath = "$tomcatPath\webapps"
$binPath = "$tomcatPath\bin"

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "E-commerce Application Deployment" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Check if WAR file exists
if (-not (Test-Path $warFile)) {
    Write-Host "ERROR: WAR file not found at: $warFile" -ForegroundColor Red
    Write-Host "Please build the project first: .\mvnw.cmd clean package" -ForegroundColor Yellow
    exit 1
}

Write-Host "[1/4] Checking WAR file..." -ForegroundColor Green
Write-Host "WAR file found: $warFile" -ForegroundColor Green
Write-Host ""

# Check if Tomcat exists
if (-not (Test-Path $tomcatPath)) {
    Write-Host "ERROR: Tomcat not found at: $tomcatPath" -ForegroundColor Red
    exit 1
}

Write-Host "[2/4] Deploying WAR file to Tomcat..." -ForegroundColor Green
try {
    Copy-Item $warFile $webappsPath -Force
    Write-Host "WAR file deployed successfully!" -ForegroundColor Green
} catch {
    Write-Host "ERROR: Failed to deploy WAR file. Access denied." -ForegroundColor Red
    Write-Host "Please run this script as Administrator (Right-click -> Run as Administrator)" -ForegroundColor Yellow
    exit 1
}
Write-Host ""

# Check if Tomcat is already running
Write-Host "[3/4] Checking if Tomcat is running..." -ForegroundColor Green
$tomcatRunning = Get-Process -Name "java" -ErrorAction SilentlyContinue | Where-Object {$_.Path -like "*Tomcat*"}

if ($tomcatRunning) {
    Write-Host "Tomcat is already running!" -ForegroundColor Yellow
    Write-Host "If you want to restart Tomcat, please stop it first using: $binPath\shutdown.bat" -ForegroundColor Yellow
} else {
    Write-Host "Starting Tomcat..." -ForegroundColor Green
    Start-Process -FilePath "$binPath\startup.bat" -WindowStyle Normal
    Write-Host "Tomcat is starting... Please wait a few seconds." -ForegroundColor Yellow
    Start-Sleep -Seconds 5
}
Write-Host ""

Write-Host "[4/4] Application URLs:" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Main Application: http://localhost:8080/JakartaEE-1.0-SNAPSHOT/" -ForegroundColor White
Write-Host "Home Page:        http://localhost:8080/JakartaEE-1.0-SNAPSHOT/home.jsp" -ForegroundColor White
Write-Host "Shop Page:       http://localhost:8080/JakartaEE-1.0-SNAPSHOT/shop-servlet" -ForegroundColor White
Write-Host "Cart Page:       http://localhost:8080/JakartaEE-1.0-SNAPSHOT/cart.jsp" -ForegroundColor White
Write-Host "Tomcat Manager:  http://localhost:8080/manager/html (admin/123)" -ForegroundColor White
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Opening application in browser..." -ForegroundColor Green
Start-Process "http://localhost:8080/JakartaEE-1.0-SNAPSHOT/"

Write-Host ""
Write-Host "Deployment completed successfully!" -ForegroundColor Green
Write-Host "To stop Tomcat, run: $binPath\shutdown.bat" -ForegroundColor Yellow

