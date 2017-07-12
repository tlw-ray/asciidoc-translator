package com.tlw.asciidoc.translator;

import java.io.*;
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
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        while((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        inputStream.close();
    }
}
