package com.tlw.asciidoc.translator.processor;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.JavaExtensionRegistry;
import org.asciidoctor.extension.Preprocessor;
import org.asciidoctor.extension.PreprocessorReader;

import java.io.File;

/**
 * Created by hdp on 2017/7/10.
 */
public class A01ChangeAttributeValuePreprocessor extends Preprocessor {
    @Override
    public void process(Document document, PreprocessorReader preprocessorReader) {
        System.out.println(preprocessorReader.getLineNumber());
    }

    public static void main(String[] args){
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        JavaExtensionRegistry extensionRegistry = asciidoctor.javaExtensionRegistry();
        extensionRegistry.preprocessor(A01ChangeAttributeValuePreprocessor.class);
        File file = new File("asciidoc/article.txt");
        String content = asciidoctor.convertFile(file, new Options());
        System.out.println(content);
    }
}
