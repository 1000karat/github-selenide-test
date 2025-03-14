import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainTest {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1600x900";
        Configuration.headless = true;
    }

    @Test
    public void shouldHavePageSoftAssertionsTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(".filterable-active").shouldHave(Condition.text("SoftAssertions"));

        $(".filterable-active").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(Condition.text("JUnit5 extend test class"));
    }
}
