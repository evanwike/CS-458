from selenium import webdriver

# Opens a new Chrome browser
browser = webdriver.Chrome()
# Navigates to Amazon.com
browser.get('https://www.amazon.com')

# Selects the search bar element by its HTML id
nav = browser.find_element_by_id('twotabsearchtextbox')
# Selects the search button by its tag and class (CSS selectors)
search = browser.find_element_by_css_selector('input.nav-input')
# Sends the string to the search bar
nav.send_keys('A friendly introduction to software testing')
# Clicks the search button
search.click()

# Waits for 1s to ensure the target element has loaded
browser.implicitly_wait(1)
# Finds the a element with the book's title and click it
link = browser.find_element_by_link_text('A Friendly Introduction to Software Testing')
link.click()

# Waits for 2s to ensure the target element has loaded
browser.implicitly_wait(2)
# Selects the Paperback element by its HTML id and clicks it
paperback = browser.find_element_by_id('a-autoid-5')
paperback.click()
# Selects the Add to Cart element by its HTML id and clicks it
add_to_cart = browser.find_element_by_id('add-to-cart-button-ubb')
add_to_cart.click()
# Selects the View Cart element by its HTML id and clicks it
view_cart = browser.find_element_by_id('hlb-view-cart-announce')
view_cart.click()
# Selects the Qty element by its HTML id and clicks it
qty = browser.find_element_by_id('a-autoid-0-announce')
qty.click()
# Selects the 0 element in the dropdown Qty box and clicks it
delete = browser.find_element_by_id('dropdown1_0')
delete.click()