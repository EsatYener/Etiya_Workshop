package org.etiya;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumFuncs {
    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver= new ChromeDriver();

        // Web sayfasına gitme
        webDriver.navigate().to("https://www.saucedemo.com/v1/");

        // Sayfa başlığını alma
        String title= webDriver.getTitle();
        System.out.println("Sayfa başlığı: " + title);

        // Kullanıcı adı alanına metin gönderme
        WebElement usernameInput = webDriver.findElement(By.id("user-name"));
        usernameInput.sendKeys("esatyener");
        System.out.println("Kullanıcı adı alanı: " + usernameInput);

        // Şifre alanına metin gönderme
        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys("esat@YENER");
        System.out.println("Şifre alanı: " + passwordInput);
        Thread.sleep(1000);


        // Giriş yap butonuna tıklama
        WebElement loginBtn=webDriver.findElement(By.id("login-button"));
        loginBtn.click();
        Thread.sleep(1000);
        // Sayfadaki tüm inputların sayısını alma
        List<WebElement> inputs=webDriver.findElements(By.cssSelector("input"));
        System.out.println("Toplam input sayısı:"+inputs.size());

        // Tüm inputların değerlerini alma
        for(WebElement input:inputs){
            System.out.println("input text i: "+ input.getAttribute("value"));
        }

        // Hata metnini alma
        WebElement errorText=webDriver.findElement(By.tagName("h3"));
        String errorText1=errorText.getText();
        System.out.println("Hata metni: "+errorText1);

        // Şifre alanının etkin olup olmadığını kontrol etme
        Boolean isEnabled=passwordInput.isEnabled();
        System.out.println("Şifre alanı etkin mi: "+isEnabled);

        // Logo görüntüleniyor mu kontrol etme
        WebElement logo=webDriver.findElement(By.className("login_logo"));
        Boolean isDisplayed=logo.isDisplayed();
        System.out.println("Logo gözüküyor mu: "+isDisplayed);
        Thread.sleep(1000);
        // WebDriver'ı kapatma
        webDriver.quit();
    }
}
