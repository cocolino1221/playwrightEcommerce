import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
public class LoginTest {



    @BeforeEach
    void setup(Page page) {

        page.navigate("https://www.saucedemo.com/");
    }

    @Test
    void loginTest(Page page) {
        page.locator("[id=user-name]").click();
        page.locator("[data-test=\"username\"]").fill("standard_user");
        page.locator("[data-test=\"password\"]").click();
        page.locator("[data-test=\"password\"]").fill("secret_sauce");
        page.locator("[data-test=\"login-button\"]").click();
        assertThat(page.locator("[data-test=\"inventory-list\"]")).isVisible();

    }
    @Test
    void endToEnd(Page page){
        page.locator("#user-name").fill("standard_user");
        page.locator("#password").fill("secret_sauce");
        page.locator("#login-button").click();
        assertThat(page.locator(".title")).hasText("Products");
        page.locator("#add-to-cart-sauce-labs-backpack").click();
        assertThat(page.locator(".shopping_cart_badge")).isVisible();
        page.locator(".shopping_cart_link").click();
        assertThat(page.locator(".cart_quantity")).hasText("1");
        page.locator("#checkout").click();
        assertThat(page.locator(".title")).hasText("Checkout: Your Information");
        page.locator("#first-name").fill("John");
        page.locator("#last-name").fill("Doe");
        page.locator("#postal-code").fill("420003");
        page.locator("#continue").click();
        assertThat(page.locator(".title")).hasText("Checkout: Overview");
        page.locator("#finish").click();
        assertThat(page.locator(".complete-header")).hasText("Thank you for your order!");
        page.locator("#back-to-products").click();
        assertThat(page.locator(".title")).hasText("Products");


    }
}
