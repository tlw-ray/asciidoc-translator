package com.tlw.asciidoc.translator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by tlw@winning.com.cn on 2017/7/11.
 */
public class C02HttpRequest {
    public static void main(String[] args) throws IOException {
        URL u = new URL("http://www.baidu.com");
        URLConnection urlConnection = u.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "";
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        inputStream.close();
    }
}
