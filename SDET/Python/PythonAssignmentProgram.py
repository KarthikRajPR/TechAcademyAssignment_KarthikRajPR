import pytest
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
import time

CHROMEDRIVER_PATH = '/usr/local/bin/chromedriver'

@pytest.fixture(scope="module")
def driver():    service = Service(CHROMEDRIVER_PATH)
    options = webdriver.ChromeOptions()
    driver = webdriver.Chrome(service=service, options=options)
    driver.maximize_window()
    yield driver
    driver.quit()

def test_navigation(driver):
    base_url = "https://nocode.autify.com/"

    driver.get(base_url)
    time.sleep(2)  # wait for page to load

    mobile_link_xpath = "//a[contains(text(),'Mobile')]"
    mobile_link = driver.find_element(By.XPATH, mobile_link_xpath)
    mobile_link.click()
    time.sleep(2)  # wait for navigation

    assert driver.current_url == "https://nocode.autify.com/mobile/", \
        f"Expected URL https://nocode.autify.com/mobile/, but got {driver.current_url}"

    web_link_xpath = "//a[contains(text(),'Web')]"
    web_link = driver.find_element(By.XPATH, web_link_xpath)
    web_link.click()
    time.sleep(2)  # wait for navigation

    assert driver.current_url == base_url, \
        f"Expected URL {base_url}, but got {driver.current_url}"
