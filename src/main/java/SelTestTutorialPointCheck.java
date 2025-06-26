import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;


public class SelTestTutorialPointCheck {

    private WebDriver ovladac;

    @BeforeEach
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Adulik\\IdeaProjects\\SeleniumSkillmea\\src\\main\\resources\\chromedriver.exe");
        //ovladac = new ChromeDriver();

        WebDriverManager.chromedriver().setup();
        ovladac = new ChromeDriver();

    }

    @AfterEach
    public void tearDown(){
        ovladac.quit();
    }

    @Test
    public void checkbox(){
        //Prepnutie na stranku
        ovladac.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");
        //Najdenie plus elementu
        ovladac.findElement(By.xpath("//*[@id=\"bs_1\"]/span[1]")).click();
        //Kliknutie na checkboxy
        ovladac.findElement(By.id("c_bs_1")).click();
        ovladac.findElement(By.id("c_bs_2")).click();
        //KOntrola zaskrtnutia nadradeneho prvku
        assertTrue(ovladac.findElement(By.id("c_bs_1")).isSelected());
        ovladac.findElement(By.id("c_bs_1")).click();
        //Kontrola odskrtnutia nadradeneho prvku
        assertFalse(ovladac.findElement(By.id("c_bs_1")).isSelected());



    }




}
