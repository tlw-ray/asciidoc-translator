package com.tlw.asciidoc.translator.google.fail;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

/**
 * Created by tlw@winning.com.cn on 2017/7/11.
 */
public class C03GoogleTrans {

    static Logger logger = Logger.getLogger(C03GoogleTrans.class.getName());

    public static void main(String[] args) throws IOException, ScriptException {
        String content = "Hello";
        System.out.println(content.length());
        String translated = translate(content);
        System.out.println(translated);
    }

    public static String translate(String content) throws IOException, ScriptException {
        String tk = getTK(content);
        logger.info(tk);
        String urlFormat ="http://translate.google.cn/translate_a/single?client=t" +
                "&sl=en&tl=zh-CN&hl=zh-CN&dt=at&dt=bd&dt=ex&dt=ld&dt=md&dt=qca" +
                "&dt=rw&dt=rm&dt=ss&dt=t&ie=UTF-8&oe=UTF-8&clearbtn=1&otf=1&pc=1" +
                "&srcrom=0&ssel=0&tsel=0&kc=2&tk=%s&q=%s";
        String url = String.format(urlFormat, tk, content);
        String result = getURL(url);
        JSONArray jsonArray = (JSONArray)JSON.parse(result);
        JSONArray jsonArray1 = (JSONArray) jsonArray.get(0);
        JSONArray jsonArray2 = (JSONArray) jsonArray1.get(0);
        return jsonArray2.get(0).toString();
    }

    private static String getTK(String content) throws FileNotFoundException, ScriptException {
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a Nashorn script engine
        ScriptEngine engine = factory.getEngineByName("nashorn");
        // evaluate JavaScript statement
        engine.eval(new FileReader("js/fun.js"));
        Object result = engine.eval("TL('" + content + "')");
        return result.toString();
    }

    private static String getURL(String url) throws IOException {
        URL u = new URL(url);
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
        return stringBuilder.toString();
    }
}
