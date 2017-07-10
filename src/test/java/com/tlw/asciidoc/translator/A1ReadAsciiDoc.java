package com.tlw.asciidoc.translator;

import org.asciidoctor.Asciidoctor;

import java.io.File;
import java.util.HashMap;

/**
 * Created by hdp on 2017/7/9.
 */
public class A1ReadAsciiDoc {
    public static void main(String[] args){
        File file = new File("asciiDoc/asciidoc.txt");
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
//        String html = asciidoctor.convertFile(file, new HashMap<String, Object>());
//        System.out.println(html);

        String html = asciidoctor.convert(
                "Writing AsciiDoc is _easy_!",
                new HashMap<String, Object>());
        System.out.println(html);
    }
}
