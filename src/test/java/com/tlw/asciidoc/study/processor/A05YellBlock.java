package com.tlw.asciidoc.study.processor;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.extension.BlockProcessor;
import org.asciidoctor.extension.JavaExtensionRegistry;
import org.asciidoctor.extension.Name;
import org.asciidoctor.extension.Reader;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdp on 2017/7/10.
 */
@Name("Yell")
public class A05YellBlock extends BlockProcessor {

    public static void main(String[] args){
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        File file = new File("asciidoc/article.txt");
        JavaExtensionRegistry extensionRegistry = asciidoctor.javaExtensionRegistry();
        extensionRegistry.block(A05YellBlock.class);
        String content = asciidoctor.convertFile(file, OptionsBuilder.options().safe(SafeMode.SAFE).headerFooter(true).toFile(false).get());
//        System.out.println(content);
    }

    public A05YellBlock(String name, Map<String, Object> config) {
        super(name, config);
    }

    @Override
    public Object process(StructuralNode parent, Reader reader, Map<String, Object> attributes) {
        System.out.println("process...");
        List<String> lines = reader.readLines();
        String upperLines = null;
        for (String line : lines) {
            if (upperLines == null) {
                upperLines = line.toUpperCase();
            }
            else {
                upperLines = upperLines + "\n" + line.toUpperCase();
            }
        }

        return createBlock(parent, "paragraph", Arrays.asList(upperLines), attributes, new HashMap<Object, Object>());
    }

}