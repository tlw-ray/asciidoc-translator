package com.tlw.asciidoc.translator.home;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by hdp on 2017/7/12.
 */
public class D05BaiduTranslate {
    static Logger logger = Logger.getLogger(D05BaiduTranslate.class.getName());
    public static void main(String[] args){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://fanyi.baidu.com/");

        //关闭广告
        WebElement closeButton = webDriver.findElement(By.className("app-guide-close"));
        closeButton.click();
        logger.info("close 广告...");

        WebElement elementSource = webDriver.findElement(By.id("baidu_translate_input"));
        elementSource.sendKeys("Hello");
        logger.info("input: " + elementSource.getText());

        WebElement elementTrans = webDriver.findElement(By.id("translate-button"));
        elementTrans.click();
        logger.info("click translate...");

        List<WebElement> elementTargets = webDriver.findElements(By.id("ordinary-span-edit"));
        for(WebElement elementTarget : elementTargets) {
            logger.info("output: " + elementTarget.getText());
        }

        webDriver.close();

    }
}
