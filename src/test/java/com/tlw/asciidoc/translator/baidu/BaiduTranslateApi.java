package com.tlw.asciidoc.translator.baidu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jruby.ir.Tuple;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hdp on 2017/7/18.
 */
public class BaiduTranslateApi {
    public static void main(String[] args) throws IOException {
//        System.out.println(StringEscapeUtils.unescapeJava(v1("How old are you?")));
        System.out.println(StringEscapeUtils.unescapeJava(v2("The abstract, preface, appendix, bibliography, glossary and index section titles are significant ('specialsections')")));
//        System.out.println(StringEscapeUtils.unescapeJava(StringEscapeUtils.unescapeJava(v2("How old are you?"))));
    }

    public static String translate(String en) throws IOException {
        if(StringUtils.isNotBlank(en)) {
            return v2(en);
        }else{
            return "";
        }
    }

    private static String v1(String en) throws IOException {
        String url = "http://fanyi.baidu.com/transapi";
        List<Tuple> parameterList = new ArrayList();
        parameterList.add(new Tuple("from", "en"));
        parameterList.add(new Tuple("to", "zh"));
        parameterList.add(new Tuple("query", en));
        parameterList.add(new Tuple("source", "txt"));
        String json = baiduTranslate(url, parameterList);
        json = StringEscapeUtils.unescapeJson(json);
//        System.out.println(json);
        JSONObject jsonObject = (JSONObject) JSON.parse(json);
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        if (jsonArray != null) {
            JSONObject dataJsonObject = (JSONObject) jsonArray.get(0);
            String result = (String) dataJsonObject.get("dst");
            return result;
        } else {
            return "???";
        }
    }

    private static String v2(String en) throws IOException {
        String url = "http://fanyi.baidu.com/v2transapi";
        List<Tuple> parameterList = new ArrayList();
        parameterList.add(new Tuple("from", "en"));
        parameterList.add(new Tuple("to", "zh"));
        parameterList.add(new Tuple("query", en));
        parameterList.add(new Tuple("transtype", "enter"));
        parameterList.add(new Tuple("simple_means_flag", "3"));
        String json = baiduTranslate(url, parameterList);
        json = StringEscapeUtils.unescapeJson(json);
//        json = StringEscapeUtils.unescapeJson(json);
//        System.out.println(json);
//        JSONObject resultJsonObject = (JSONObject)JSON.parse(json);
//        JSONArray dataJsonArray = (JSONArray) resultJsonObject.get("data");
//        JSONObject jsonObject = (JSONObject) dataJsonArray.get(0);
//        String result = (String)jsonObject.get("dst");
//        return result;

        String from = "\"data\":[{\"dst\":\"";
        String to = "\",\"src\":\"";
        int idxFrom = json.indexOf(from);
        int idxTo = json.indexOf(to);
        if(idxFrom>0 && idxTo>0){
            return json.substring(idxFrom + from.length(), idxTo);
        }else{
            return "???";
        }
    }

    private static String baiduTranslate(String url, List<Tuple> parameterList) throws IOException {
        URL u = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection)u.openConnection();
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);

        String query = getQuery(parameterList);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(query);
        bufferedWriter.flush();
        bufferedWriter.close();

        InputStream inputStream = httpURLConnection.getInputStream();
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

    private static String getQuery(List<Tuple> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (Tuple<String, String> pair : params) {
            if (first) {
                first = false;
            }else {
                result.append("&");
            }
            result.append(URLEncoder.encode(pair.a, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.b, "UTF-8"));
        }

        return result.toString();
    }
}
