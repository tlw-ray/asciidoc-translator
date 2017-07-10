package com.tlw.asciidoc.translator;

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
 */
public class B04EachContentPart {
    public static void main(String[] args){
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        File file = new File("asciidoc/article.txt");

        StructuredDocument structuredDocument = asciidoctor.readDocumentStructure(file, new HashMap());

        //Header
        DocumentHeader documentHeader = structuredDocument.getHeader();
        System.out.println(JSON.toJSONString(documentHeader));

        //Parts
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
