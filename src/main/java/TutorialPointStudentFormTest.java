import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class TutorialPointStudentFormTest {

    private WebDriver ovladac;

    @Before
    public void totoNastanePredKazdymTestom(){
        WebDriverManager.chromedriver().setup();
        ovladac = new ChromeDriver();
    }

    @Given("Uzivatel je na stranke tutorial point student form")
    public void uzivatelJeNaStrankeTutorialPointStudentForm() {
        ovladac.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
    }

    @When("Uzivatel zada svoje meno {string}")
    public void uzivatelZadaSvojeMeno(String meno) {
        ovladac.findElement(By.id("name")).sendKeys(meno);
    }

    @And("Uzivatel zada svoj email {string}")
    public void uzivatelZadaSvojEmail(String email) {
        ovladac.findElement(By.id("email")).sendKeys(email);
    }

    @And("Uzivatel klikne na pohlavie {string}")
    public void uzivatelKlikneNaPohlavie(String pohlavie) {
        if(pohlavie.equals("male")){
            ovladac.findElement(By.id("gender")).click();
        } else if(pohlavie.equals("female")) {
            ovladac.findElement(By.xpath("//*[@id=\"practiceForm\"]/div[3]/div/div/div[2]/input")).click();
        }
    }

    @Then("Radiobutton male je zasrtnuty")
    public void radiobuttonMaleJeZasrtnuty() {
        assertTrue(ovladac.findElement(By.id("gender")).isSelected());
    }

    @Then("Radiobutton male je odsktnuty")
    public void radiobuttonMaleJeOdsktnuty() {
        assertFalse(ovladac.findElement(By.id("gender")).isSelected());
    }
}
