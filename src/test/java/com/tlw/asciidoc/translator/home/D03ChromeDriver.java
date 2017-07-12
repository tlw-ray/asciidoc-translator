package com.tlw.asciidoc.translator.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by hdp on 2017/7/12.
 */
public class D03ChromeDriver {
    public static void main(String[] args){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://translate.google.com");
        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getPageSource());
        webDriver.close();
    }
}
