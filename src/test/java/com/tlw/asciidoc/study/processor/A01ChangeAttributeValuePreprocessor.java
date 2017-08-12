package com.tlw.asciidoc.study.processor;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.JavaExtensionRegistry;
import org.asciidoctor.extension.Preprocessor;
import org.asciidoctor.extension.PreprocessorReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by hdp on 2017/7/10.
 */
public class A01ChangeAttributeValuePreprocessor extends Preprocessor {

    @Override
    public void process(Document document, PreprocessorReader preprocessorReader) {
        System.out.println(preprocessorReader.getLineNumber());
    }

    public static void main(String[] args) throws IOException {
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        JavaExtensionRegistry extensionRegistry = asciidoctor.javaExtensionRegistry();
        extensionRegistry.preprocessor(A01ChangeAttributeValuePreprocessor.class);
        File file = new File("asciidoc/article.txt");
        byte[] bytes = Files.readAllBytes(file.toPath());
        String content = new String(bytes);
        String html = asciidoctor.render(content, new Options());
        System.out.println(html);
    }
}
