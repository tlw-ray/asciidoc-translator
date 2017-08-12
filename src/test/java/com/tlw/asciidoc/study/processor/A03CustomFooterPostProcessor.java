package com.tlw.asciidoc.study.processor;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.JavaExtensionRegistry;
import org.asciidoctor.extension.Postprocessor;

import java.io.File;
import java.util.Map;

/**
 * Created by hdp on 2017/7/10.
 */
public class A03CustomFooterPostProcessor extends Postprocessor {

    public static void main(String[] args){
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        File file = new File("asciidoc/article.txt");
        JavaExtensionRegistry extensionRegistry = asciidoctor.javaExtensionRegistry();
        extensionRegistry.postprocessor(A03CustomFooterPostProcessor.class);
        String content = asciidoctor.convertFile(file, new Options());
        System.out.println(content);
    }

    public A03CustomFooterPostProcessor(Map<String, Object> config) {
        super(config);
    }

    @Override
    public String process(Document document, String output) {

        System.out.println("process");
        return "Copyright Acme, Inc.";

//        String copyright  = "Copyright Acme, Inc.";
//
//        if(document.basebackend("html")) {
//            org.jsoup.nodes.Document doc = Jsoup.parse(output, "UTF-8");
//
//            Element contentElement = doc.getElementById("footer-text");
//            contentElement.append(copyright);
//
//            output = doc.html();
//
//        }
//        return output;
    }

}