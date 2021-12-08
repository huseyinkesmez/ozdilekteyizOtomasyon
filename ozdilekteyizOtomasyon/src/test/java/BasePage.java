import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;


import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class BasePage extends BaseTest {
    final static Logger logger = Logger.getLogger(BasePage.class.getName());

    @Step("<wait> saniye bekle")
    public void waitForsecond(int wait) throws InterruptedException {
        Thread.sleep(300 * wait);
        System.out.println(wait + "saniye bekledi !!!!");

    }

    @Step("sayfa kontrol")
    public void controlPage() {
        Assert.assertTrue(appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/textView")).isDisplayed());
        logger.info("giris kontrol edildi");
    }

    @Step("selectId <selectId> tiklandi")
    public void clickShopButton(String selectId) {
        appiumDriver.findElement(By.id(selectId)).click();
        System.out.println("Alisveris butonuna tiklandi");
    }

    @Step("Kategorilere <navBar> tiklandi")
    public void clickCategory(String navBar) throws InterruptedException {
        appiumDriver.findElement(By.id(navBar)).click();
        int waitt = 0;
        Thread.sleep(300 * waitt);
        System.out.println("Kategoriler butonuna tiklandi");
    }

    @Step("Kadin <selectGender> kategorisine tiklandi")
    public void clickGender(String selectGender) {
        appiumDriver.findElement(By.xpath(selectGender)).click();
        System.out.println("Kadin butonuna tiklandi");
    }

    @Step("Kadin pantolon <selectProd> kategorisine tiklanir")
    public void clickProd(String selectProd){
        appiumDriver.findElement(By.xpath(selectProd)).click();
        System.out.printf("Pantolon secenegine tiklandi");
    }

    @Step("Scroll")
    public void scrollDown(){
        TouchAction swipe = new TouchAction(appiumDriver).press(PointOption.point(540, 1824))
                .waitAction(waitOptions(ofMillis(800)))
                .moveTo(PointOption.point(540, 672))
                .release().perform();

    }


    @Step("random urun secilir")
    public void selectRandom() {
        List<MobileElement> elements = appiumDriver.findElements(By.xpath("//*[@resource-id=\"com.ozdilek.ozdilekteyim:id/imageView\"]\n"));
    Random random = new Random();
    int randomInt = random.nextInt(elements.size());
    elements.get(randomInt).click();
        logger.info("random seçim yapıldı");
    }

    @Step("Secilen urun favoriye <addFav> eklenir")
    public void clickToFav(String addFav){
        appiumDriver.findElement(By.id(addFav)).click();

        System.out.printf("urun favoriye eklendi");
    }
    @Step("Giriş Yap Sayfası Kontrol Edilir")
    public void checkLoginPage() throws InterruptedException {
        Thread.sleep(1000);
        String checkText = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/btnLogin")).getText();
        Assert.assertEquals("Giriş Yap", checkText);

        logger.info("login kontrol yapildi");

    }

    @Step("Kullanici adi alanina text <eMail> girilir")
    public void sendMail(String eMail) throws InterruptedException {
        Thread.sleep(1000);
        appiumDriver.findElement(By.id(eMail)).sendKeys("hsynkesmez@outlook.com");
        logger.info("E-posta girildi");
    }

    @Step("Parola alanina text <passwd> girilir")
    public void sendPass(String passwd) throws InterruptedException {
        Thread.sleep(1000);
        appiumDriver.findElement(By.id(passwd)).sendKeys("parola123");
        logger.info("Parola girildi");
    }

    @Step("Geri tiklama <backPage> yapilir")
    public void backToPage(String backPage) {
        appiumDriver.findElement(By.id(backPage)).click();
        logger.info("Geri tiklanir");
    }

    @Step("Urun bedeni <prodSize> secilir")
    public void selectSize(String prodSize) {
        appiumDriver.findElement(By.xpath(prodSize)).click();
    }

    @Step("Urun sepete <addBasket> eklenir")
    public void addToBasket(String addBasket) {
        appiumDriver.findElement(By.id(addBasket)).click();
        logger.info("Urun sepete eklenir");
    }






}
