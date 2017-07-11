package com.tlw.asciidoc.translator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by tlw@winning.com.cn on 2017/7/11.
 */
public class C03GoogleTrans {



    public static void main(String[] args){
        String url ="http://translate.google.cn/translate_a/single?client=t" +
        "&sl=en&tl=zh-CN&hl=zh-CN&dt=at&dt=bd&dt=ex&dt=ld&dt=md&dt=qca" +
        "&dt=rw&dt=rm&dt=ss&dt=t&ie=UTF-8&oe=UTF-8&clearbtn=1&otf=1&pc=1" +
        "&srcrom=0&ssel=0&tsel=0&kc=2&tk=%s&q=%s";

        String tk = "";
    }

    private static String getTK() throws FileNotFoundException, ScriptException {
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a Nashorn script engine
        ScriptEngine engine = factory.getEngineByName("nashorn");
        // evaluate JavaScript statement
        engine.eval(new FileReader("js/fun.js"));
        Object result = engine.eval("TL('Hello')");
        return result.toString();
    }
}
