package com.tlw.asciidoc.study.convert;

import org.asciidoctor.Asciidoctor;

import java.util.HashMap;

/**
 * Created by hdp on 2017/7/9.
 * 转换一个字符串从asciidoc到html
 * 字符串转换使用render
 * 文件转换使用convert
 */
public class A1ReadAsciiDoc {
    public static void main(String[] args){
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        String html = asciidoctor.render(
                "Writing AsciiDoc is _easy_!",
                new HashMap<String, Object>());
        System.out.println(html);

    }
}
