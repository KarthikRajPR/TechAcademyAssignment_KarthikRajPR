import time
from pages.home_page import HomePage
from pages.dropdown_checkbox_radio_page import DropdownCheckboxRadioPage

def test_dropdown_checkboxes_radios(driver):
    home = HomePage(driver)
    dropdown_page = DropdownCheckboxRadioPage(driver)

    # Step 1: Launch URL and verify title
    home.open_home("http://webdriveruniversity.com/index.html")
    assert home.get_title() == "Automation & AI Testing Courses by Gianni Bruno | WebDriver University"

    # Step 2: Click on Dropdown-Checkboxes-RadioButtons link
    home.click_dropdown_checkbox_radio_link()

    # Step 3: Switch to new tab
    tabs = driver.window_handles
    driver.switch_to.window(tabs[1])

    # Step 4: Select value from dropdown and verify
    selected_value = dropdown_page.select_dropdown_value("Python")
    assert selected_value == "Python"

    # Step 5: Select multiple checkboxes and verify counts
    dropdown_page.select_multiple_checkboxes([0, 2])  # Selecting checkbox 1 and 3
    checked_count, unchecked_count = dropdown_page.get_checkbox_counts()
    assert checked_count >= 2
    assert unchecked_count >= 1

    # Step 6: Select a radio button and verify counts
    dropdown_page.select_radio_button(1)  # Selecting 2nd radio button
    radio_checked, radio_unchecked = dropdown_page.get_radio_counts()
    assert radio_checked == 2
    assert radio_unchecked >= 2

    time.sleep(2)  # just to see result before closing
