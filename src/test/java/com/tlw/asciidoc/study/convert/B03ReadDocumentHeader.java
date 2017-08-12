package com.tlw.asciidoc.study.convert;

import com.alibaba.fastjson.JSON;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.ast.Author;
import org.asciidoctor.ast.DocumentHeader;
import org.asciidoctor.ast.RevisionInfo;
import org.asciidoctor.ast.Title;

import java.io.File;
import java.util.Map;

/**
 * Created by hdp on 2017/7/9.
 * 所有的文档头部信息
 */
public class B03ReadDocumentHeader {
    public static void main(String[] args){
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        DocumentHeader header = asciidoctor.readDocumentHeader(new File("asciiDoc/asciidoc.txt"));

        //标题
        Title title = header.getDocumentTitle();
        System.out.println("Title: " + JSON.toJSONString(title));
        System.out.println("PageTitle: " + header.getPageTitle());

        //作者信息
        Author author = header.getAuthor();
        System.out.println("Author: " + JSON.toJSONString(author));

        //作者信息集
        System.out.println("Authors count: " + header.getAuthors().size());
        for(Author author1 : header.getAuthors()){
            System.out.println("\t" + JSON.toJSONString(author1));
        }

        //版本信息
        RevisionInfo revisionInfo = header.getRevisionInfo();
        System.out.println("Revision: " + JSON.toJSONString(revisionInfo));

        //属性
        Map<String, Object> attributes = header.getAttributes();
        System.out.println("Attributes: ");
        for(Map.Entry<String, Object> entry: attributes.entrySet()){
            System.out.println("\t" + entry);
        }
    }
}
