package com.tlw.asciidoc.translator;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.ast.Author;
import org.asciidoctor.ast.DocumentHeader;
import org.asciidoctor.ast.RevisionInfo;

import java.io.File;

/**
 * Created by hdp on 2017/7/9.
 */
public class B03ReadDocumentTree {
    public static void main(String[] args){
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        DocumentHeader header = asciidoctor.readDocumentHeader(new File("asciiDoc/asciidoc.txt"));

        System.out.println(header.getDocumentTitle().getMain());

        Author author = header.getAuthor();
        System.out.println(author.getEmail());
        System.out.println(author.getFullName());

        RevisionInfo revisionInfo = header.getRevisionInfo();

        System.out.println(revisionInfo.getDate());
        System.out.println(revisionInfo.getNumber());
        System.out.println(revisionInfo.getRemark());
    }
}
