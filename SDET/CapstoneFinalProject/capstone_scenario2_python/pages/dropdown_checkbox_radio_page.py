from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select

class DropdownCheckboxRadioPage:
    # Locators
    DROPDOWN = (By.ID, "dropdowm-menu-1")
    CHECKBOXES = (By.CSS_SELECTOR, "input[type='checkbox']")
    RADIOS = (By.CSS_SELECTOR, "input[type='radio']")

    def __init__(self, driver):
        self.driver = driver

    def select_dropdown_value(self, value):
        dropdown = Select(self.driver.find_element(*self.DROPDOWN))
        dropdown.select_by_visible_text(value)
        return dropdown.first_selected_option.text

    def select_multiple_checkboxes(self, indices):
        checkboxes = self.driver.find_elements(*self.CHECKBOXES)
        for i in indices:
            if not checkboxes[i].is_selected():
                checkboxes[i].click()

    def get_checkbox_counts(self):
        checkboxes = self.driver.find_elements(*self.CHECKBOXES)
        checked = sum(1 for cb in checkboxes if cb.is_selected())
        unchecked = len(checkboxes) - checked
        return checked, unchecked

    def select_radio_button(self, index):
        radios = self.driver.find_elements(*self.RADIOS)
        if not radios[index].is_selected():
            radios[index].click()

    def get_radio_counts(self):
        radios = self.driver.find_elements(*self.RADIOS)
        checked = sum(1 for rb in radios if rb.is_selected())
        unchecked = len(radios) - checked
        return checked, unchecked
