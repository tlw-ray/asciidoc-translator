package com.tlw.asciidoc.translator;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.ast.*;

import java.io.File;

/**
 * Created by hdp on 2017/7/10.
 */
public class B05Ast {
    public static void main(String[] args){
        File file = new File("asciidoc/article.txt");

        Asciidoctor asciidoctor = Asciidoctor.Factory.create();

        Document document = asciidoctor.loadFile(file, OptionsBuilder.options().toFile(false).asMap());
        process(document.getBlocks(), "");

    }

    public static void process(java.util.List<StructuralNode> nodeList, String prefix){
        if(nodeList != null){
            for(StructuralNode node : nodeList){
                if(node instanceof Section){
                    Section section = (Section)node;
                    System.out.println(prefix + "Section: " + section.getSectionName());
                }else if(node instanceof Block){
                    Block block = (Block)node;
                    System.out.println(prefix + "Block: " + block.getSource());
                }else{
                    System.out.println(prefix + node.getClass());
                }
                process(node.getBlocks(), prefix + "\t");
            }
        }
    }
}
