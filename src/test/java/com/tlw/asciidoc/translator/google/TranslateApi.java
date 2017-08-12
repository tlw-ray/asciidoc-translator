package com.tlw.asciidoc.translator.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class TranslateApi {
    public static void main(String[] args) throws IOException {
        translate("Use curl to make a v2 request, passing it the access token you printed, and the filename of the JSON request you set up in step 1");
    }
    private static void translate(String content) throws IOException {
        String contentEncoded = URLEncoder.encode(content, "UTF-8");
        URL url = new URL("https://translation.googleapis.com/language/translate/v2?q=" + contentEncoded + "&target=zh&key=AIzaSyB6_GFTCZ0Fn7xaEpLmpVWHRRRzx2axM8E");
        try(InputStream inputStream = url.openStream()){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }
    }
}
