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
        String searchTextString = "SoftAssertions";
        String jUnitSearchString = "JUnit5 extend test class";


        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue(searchTextString);
        $(".filterable-active").shouldHave(Condition.text(searchTextString));

        $(".filterable-active").$(byText(searchTextString)).click();
        $(".markdown-body").shouldHave(Condition.text(jUnitSearchString));
        
        
        //$(withText(issueNumber)).shouldHave(Condition.visible);
        //$(withText(issueNumber)).shouldHave(Condition.visible);
    }
}
