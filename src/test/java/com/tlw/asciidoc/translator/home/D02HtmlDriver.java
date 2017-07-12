package com.tlw.asciidoc.translator.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by hdp on 2017/7/12.
 */
public class D02HtmlDriver {
    public static void main(String[] args){
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://www.baidu.com");
        System.out.println(driver.getPageSource());
        driver.quit();
    }
}
