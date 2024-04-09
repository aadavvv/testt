from selenium import webdriver
from selenium.webdriver.chrome.service import Service

# Path to your ChromeDriver executable
chrome_driver_path = 'path/to/chromedriver.exe'

# Set Chrome options
chrome_options = webdriver.ChromeOptions()
# Uncomment the following line if you want to run Chrome in headless mode
# chrome_options.add_argument('--headless')

# Create a new Chrome session
service = Service(chrome_driver_path)
driver = webdriver.Chrome(service=service, options=chrome_options)

# Open google.com
driver.get("https://www.google.com")

# Close the browser
driver.quit()
