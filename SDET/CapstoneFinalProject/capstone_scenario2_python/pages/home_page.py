from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class HomePage:
    DROPDOWN_CHECKBOX_RADIO = (By.XPATH, "//h1[text()='DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)']")

    def __init__(self, driver):
        self.driver = driver

    def open_home(self, url):
        self.driver.get(url)

    def get_title(self):
        return self.driver.title

    def click_dropdown_checkbox_radio_link(self):
        WebDriverWait(self.driver, 10).until(
            EC.element_to_be_clickable(self.DROPDOWN_CHECKBOX_RADIO)
        ).click()
