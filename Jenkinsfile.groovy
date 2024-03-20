@Grab(group='org.seleniumhq.selenium', module='selenium-java', version='3.141.59')
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

// Set the path to chromedriver executable
System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe")

// Initialize ChromeDriver
WebDriver driver = new ChromeDriver()

// Open Jenkins URL
driver.get("http://your-jenkins-url")

// Find the username and password fields and login button
WebElement usernameField = driver.findElement(By.xpath("//input[@id='j_username']"))
WebElement passwordField = driver.findElement(By.xpath("//input[@name='j_password']"))
WebElement loginButton = driver.findElement(By.xpath("//input[@name='Submit']"))

// Enter username and password
usernameField.sendKeys("your-username")
passwordField.sendKeys("your-password")

// Click on the login button
loginButton.click()

// Wait for some time to let the login process complete
Thread.sleep(5000)

// Close the browser
driver.quit()
