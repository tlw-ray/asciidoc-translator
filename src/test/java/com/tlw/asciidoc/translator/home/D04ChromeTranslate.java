package com.tlw.asciidoc.translator.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by hdp on 2017/7/12.
 */
public class D04ChromeTranslate {
    public static void main(String[] args){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://translate.google.com");
        WebElement elementSource = webDriver.findElement(By.id("source"));
        elementSource.sendKeys("Hello");
        WebElement elementTrans = webDriver.findElement(By.id("gt-submit"));
        elementTrans.click();
        WebElement elementTarget = webDriver.findElement(By.id("result-box"));
        System.out.println(elementTarget.getText());
        webDriver.close();
    }
}
