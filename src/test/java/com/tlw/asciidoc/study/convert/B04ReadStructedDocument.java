package com.tlw.asciidoc.study.convert;

import com.alibaba.fastjson.JSON;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.ast.ContentPart;
import org.asciidoctor.ast.DocumentHeader;
import org.asciidoctor.ast.StructuredDocument;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hdp on 2017/7/9.
 * 文档的内容结构信息
 */
public class B04ReadStructedDocument {
    public static void main(String[] args){
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
//        File file = new File("asciidoc/article.txt");
        File file = new File("asciidoc/book.txt");
//        File file = new File("asciidoc/book-multi.txt");


        StructuredDocument structuredDocument = asciidoctor.readDocumentStructure(file, new HashMap());

        //Header
        DocumentHeader documentHeader = structuredDocument.getHeader();
        System.out.println("DocumentHeader:");
        System.out.println("\t" + JSON.toJSONString(documentHeader));

        //Parts
        System.out.println("ContentParts: ");
        for (ContentPart part : structuredDocument.getParts()){
            parsePart(part, "\t");
        }
    }

    public static void parsePart(ContentPart part, String prefix){
        if(part != null) {
            System.out.println(prefix + JSON.toJSONString(part));
            List<ContentPart> partList = part.getParts();
            if (partList != null) {
                for (ContentPart subPart : partList) {
                    parsePart(subPart, prefix + "\t");
                }
            }
        }
    }
}
