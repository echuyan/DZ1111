import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class OtusTest {

    private Logger logger = LogManager.getLogger(OtusTest.class);
    protected static WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }

    @After
    public void end() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер погашен");
        }
    }

    @Test
    public void webDriverTest() throws Exception{
        ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
        final String titleCheck = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";

        driver.get(cfg.hostname());
        logger.info("Сайт открыт");

        //WebElement title  = driver.findElement(By.ByXPath.xpath("//div[contains(concat(' ',normalize-space(@class),' '),' title-new__text ')]//h1"));
        String title  = driver.getTitle();
        logger.info(title);
        Assert.assertEquals(title,titleCheck);
    }


}
