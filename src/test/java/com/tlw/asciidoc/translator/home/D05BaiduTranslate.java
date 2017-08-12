package com.tlw.asciidoc.translator.home;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by hdp on 2017/7/12.
 * 使用WebDriver
 */
public class D05BaiduTranslate {
    static Logger logger = Logger.getLogger(D05BaiduTranslate.class.getName());
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://fanyi.baidu.com/");

        //关闭广告
        WebElement closeButton = webDriver.findElement(By.className("app-guide-close"));
        closeButton.click();
        logger.info("close 广告...");

        WebElement elementSource = webDriver.findElement(By.id("baidu_translate_input"));
        elementSource.sendKeys("Hello");

//        (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return (elementSource.isEnabled());
//            }});

        Thread.sleep(3000);

        logger.info("input: " + elementSource.getText());

        WebElement elementTarget = webDriver.findElement(By.className("output-bd"));
        logger.info("output:" + elementTarget.getText());
    }
}
