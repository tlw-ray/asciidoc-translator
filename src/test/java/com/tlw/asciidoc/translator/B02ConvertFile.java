package com.tlw.asciidoc.translator;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hdp on 2017/7/9.
 * 直接翻译为文件，没有能输出字符串
 */
public class B02ConvertFile {
    public static void main(String[] args){
        File file = new File("data/asciiDoc.txt");
        Map<String, Object> options = OptionsBuilder.options().safe(SafeMode.SAFE).asMap();
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        String html = asciidoctor.convertFile(file, new HashMap<String, Object>());
        System.out.println(html);
    }
}
