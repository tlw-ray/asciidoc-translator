package com.tlw.asciidoc.translator.google.fail;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by tlw@winning.com.cn on 2017/7/11.
 */
public class C01RunJavascript {
    public static void main(String[] args) throws FileNotFoundException, ScriptException {
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a Nashorn script engine
        ScriptEngine engine = factory.getEngineByName("nashorn");
        // evaluate JavaScript statement
        engine.eval(new FileReader("js/fun.js"));
        Object reuslt = engine.eval("TL('Hello')");
        System.out.println(reuslt);
    }
}
