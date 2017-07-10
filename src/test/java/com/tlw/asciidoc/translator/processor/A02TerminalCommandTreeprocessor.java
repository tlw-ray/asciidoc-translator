package com.tlw.asciidoc.translator.processor;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.ast.Block;
import org.asciidoctor.ast.Document;
import org.asciidoctor.ast.StructuralNode;
import org.asciidoctor.extension.JavaExtensionRegistry;
import org.asciidoctor.extension.Treeprocessor;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdp on 2017/7/10.
 */
public class A02TerminalCommandTreeprocessor extends Treeprocessor{

    public static void main(String[] args){
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        File file = new File("asciidoc/article.txt");
        JavaExtensionRegistry extensionRegistry = asciidoctor.javaExtensionRegistry();
        extensionRegistry.treeprocessor(A02TerminalCommandTreeprocessor.class);
        String content = asciidoctor.convertFile(file, new Options());
        System.out.println(content);
    }

    private Document document;

    public A02TerminalCommandTreeprocessor(Map<String, Object> config) {
        super(config);
    }

    @Override
    public Document process(Document document) {

        System.out.println("process...");
        this.document = document;

        final List<StructuralNode> blocks = this.document.blocks();

        for (int i = 0; i < blocks.size(); i++) {
            final StructuralNode currentBlock = blocks.get(i);
            if(currentBlock instanceof Block) {
                Block block = (Block)currentBlock;
                List<String> lines = block.lines();
                if (lines.size() > 0 && lines.get(0).startsWith("$")) {
                    blocks.set(i, convertToTerminalListing(block));
                }
            }
        }

        return this.document;
    }

    public Block convertToTerminalListing(Block block) {

        Map<String, Object> attributes = block.getAttributes();
        attributes.put("role", "terminal");
        StringBuilder resultLines = new StringBuilder();

        List<String> lines = block.lines();

        for (String line : lines) {
            if (line.startsWith("$")) {
                resultLines.append("<span class=\"command\">")
                        .append(line.substring(2, line.length()))
                        .append("</command");
            }
            else {
                resultLines.append(line);
            }
        }

        return createBlock(this.document, "listing", Arrays.asList(resultLines.toString()), attributes, new HashMap<Object, Object>());
    }
}
