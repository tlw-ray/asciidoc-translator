package com.tlw.asciidoc.translator.processor;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.DocinfoProcessor;
import org.asciidoctor.extension.JavaExtensionRegistry;

import java.io.File;
import java.util.Map;

/**
 * Created by hdp on 2017/7/10.
 */
public class A04MetaRobotsDocinfoProcessor extends DocinfoProcessor {

    public static void main(String[] args){
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        File file = new File("asciidoc/article.txt");
        JavaExtensionRegistry extensionRegistry = asciidoctor.javaExtensionRegistry();
        extensionRegistry.docinfoProcessor(A04MetaRobotsDocinfoProcessor.class);
        String content = asciidoctor.convertFile(file, OptionsBuilder.options().safe(SafeMode.SAFE).headerFooter(true).toFile(false).get());
        System.out.println(content);
    }

    public A04MetaRobotsDocinfoProcessor() {
        super();
    }

    public A04MetaRobotsDocinfoProcessor(Map<String, Object> config) {
        super(config);
    }

    @Override
    public String process(Document document) {
        System.out.println("process...");
        return "<meta name=\"robots\" content=\"index,follow\">";
    }
}
