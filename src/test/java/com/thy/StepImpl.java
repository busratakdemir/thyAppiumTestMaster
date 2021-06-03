package com.thy;



import com.thy.model.SelectorInfo;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;

import io.appium.java_client.MobileElement;

import org.junit.Assert;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepImpl extends HookImpl {

    private Logger logger = LoggerFactory.getLogger(getClass());



    public MobileElement findElementByKey(String key) {

        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        By by = selectorInfo.getBy();
        MobileElement element;
        try {
            logger.info("findElement method called:  finding " + key);
            element = (MobileElement) appiumFluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception ex) {
            Assert.fail(key + " sayfada görüntülenemedi!!!");
            throw ex;
        }
        return element;
    }


    public void clickButton(String key){
        WebElement element=findElementByKey(key);
        element.click();

    }

    public void sendKey(String key, String value)
    {
        WebElement element=findElementByKey(key);
        element.sendKeys(value);
    }

    public static void wait (int sure){

        try {
            Thread.sleep(sure*1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }



    @Step("Gauge rapora <text> mesajını yaz ve ekran görüntüsü al")
    public void takeScreenShot(String text) {
        Gauge.captureScreenshot();
        Gauge.writeMessage(text);
        logger.info("gauge raporuna bu adımda " + text + " mesajı eklendi");
    }



    @Step("<key> Butonuna tıkla")
    public void ButtonClick(String key) {
        clickButton(key);
    }

    @Step("<key> textine yazdır <text>")
    public void textSendKeys(String key, String text) {
        sendKey(key,text);


    }
    @Step("<key> saniye bekle")
    public void bekle(int key) throws InterruptedException {
        Thread.sleep(key*1000);
    }


    @Step("Sayfada <key> alanı var mı ? Yoksa <mesaj>")
    public void getButtonControl(String key, String msg)
    {
        Assert.assertTrue(msg,findElementByKey(key).isDisplayed());
    }


}


