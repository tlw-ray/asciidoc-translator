package com.tlw.asciidoc.translator.baidu;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.ast.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by hdp on 2017/7/10.
 */
public class TranslateArticle {
    public static void main(String[] args) throws IOException {
        File file = new File("asciidoc/article.txt");

        Asciidoctor asciidoctor = Asciidoctor.Factory.create();

        Document document = asciidoctor.loadFile(file, OptionsBuilder.options().toFile(false).asMap());
        process(document.getBlocks(), "");

    }

    public static void process(java.util.List<StructuralNode> nodeList, String prefix) throws IOException {
        if(nodeList != null){
            for(StructuralNode node : nodeList){
                if(node instanceof Section){
                    Section section = (Section)node;
                    String sectionNameEn = section.getSectionName().replaceAll("[\\r\\n]+", " ");
                    System.out.println(prefix + "Section_en: " + sectionNameEn);
                    String sectionNameZh = BaiduTranslateApi.translate(sectionNameEn);
                    System.out.println(prefix + "Section_zh: " + sectionNameZh);
                }else if(node instanceof Block){
                    Block block = (Block)node;
                    String blockEn = block.getSource().replaceAll("[\\r\\n]+", " ");
                    System.out.println(prefix + "Block_en: " + blockEn);
                    String blockZh = BaiduTranslateApi.translate(blockEn);
                    System.out.println(prefix + "Block_zh: " + blockZh);
                }else{
                    System.out.println(prefix + node.getClass());
                }
                process(node.getBlocks(), prefix + "\t");
            }
        }
    }
}
