package com.tlw.asciidoc.translator;

import org.asciidoctor.Asciidoctor;

import java.io.File;
import java.util.HashMap;

/**
 * Created by hdp on 2017/7/9.
 */
public class B01ConvertString {
    public static void main(String[] args){
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        String html = asciidoctor.convert("Writing AsciiDoc is _easy_!", new HashMap<String, Object>());
        System.out.println(html);
    }
}
