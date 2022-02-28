import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest {


    @Step("<wait> saniye kadar bekle")
    public void waitForSeconds(int wait) throws InterruptedException {
        Thread.sleep(wait * 1000);

    }

    @Step("id<id> li elemente tıkla")
    public void clickById(String id) {
        appiumDriver.findElement(By.id(id)).click();
        Logger.info("Uygulama acildi");

    }

    @Step("id<id> li elementi kontrol et")
    public void checkText(String id) {
        String chectText = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("ALIŞVERİŞE BAŞLA", chectText);

    }

    @Step("id<id> li elementi ara")
    public void checkText1(String id) {
        String chectText1 = appiumDriver.findElement(By.id(id)).getText();
        Logger.info("Alisveris sayfasi acildi");
    }

    @Step("id<kategori> kategoriye tıkla")
    public void clickBykategori(String kategori) {
        appiumDriver.findElement(By.id(kategori)).click();
        Logger.info("Kategoriye tiklandi");
    }

    @Step("xpath<kadin> kadın kategorisine tıkla")
    public void clickByXpathkadin(String kadin) {
        appiumDriver.findElement(By.xpath(kadin)).click();
    }

    @Step("xpath<pantolon> Pantolon kategorisine tıklandı")
    public void clickByXpathPantolon(String pantolon) {
        appiumDriver.findElement(By.xpath(pantolon)).click();
    }

    @Step("<scroll et>")
    public void scrollEt(String scroll) {
        TouchAction scrollEt = new TouchAction(appiumDriver);
        scrollEt.press(PointOption.point(530, 1500)).moveTo(PointOption.point(530, 400)).release().perform();
        logger.info("Scroll yapildi.");
    }

    @Step("Rastgele bir ürün seç")
    public void selectRandom() {
        Random random = new Random();
        List<MobileElement> rastgeleUrun = appiumDriver.findElements(By.xpath("//*[@resource-id='com.ozdilek.ozdilekteyim:id/imageView']"));
        System.out.println("rastgeleUrun" + rastgeleUrun);
        MobileElement element = rastgeleUrun.get(random.nextInt(rastgeleUrun.size()));

        element.click();

    }

    @Step("id<id> urun detay kontrolü")
    public void checkUrunDetay(String id) {
        String checkUrunDetay = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("Beden:", checkUrunDetay);
        Logger.info("Urun detay kontrol edildi");
    }

    @Step("xpath<xpath> favoriye ekle")
        public void FavoriEkle(String favXpath){
        appiumDriver.findElement(By.xpath(favXpath)).click();
        Logger.info("urun favorilere eklendi");
    }

    @Step("id<id> giris  kontrolü")
    public void checkText3(String id) {
        String chectLoginKontrol = appiumDriver.findElement(By.id(id)).getText();
        Assertions.assertEquals("Beni Hatırla", chectLoginKontrol);
    }

    @Step("<id> id'li elemente <email> email adresi girme")
    public void loginMail(String emailId,String emailText){
        appiumDriver.findElement(By.id(emailId)).sendKeys(emailText);
        Logger.info("Mail adresi girildi");
    }

    @Step("<id> 'li elemente <password> şifre girme")
    public void loginPassword(String passwordId, String passwordText){
        appiumDriver.findElement(By.id(passwordId)).sendKeys(passwordText);
        Logger.info("Sifre girildi");
    }

    @Step("id<id> geri tusuna tıkla")
    public void clickGeri(String id) {
        appiumDriver.findElement(By.id(id)).click();
    }


    @Step("<id> sepete ekleme yap")
    public  void SepeteEkle(String sepetId){
        appiumDriver.findElement(By.id(sepetId)).click();
        Logger.info("Sepete ekle tusuna basildi");
    }




}
