package io.gmind.java8.nashorn;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import lombok.extern.slf4j.Slf4j;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by gmind on 14. 6. 23.
 */
@Slf4j
public class Nashorn2 {

    public static String fun(String name){
        log.debug("[JAVA] Hi there form Java : {}", name);
        return "[JAVA] greetings from java";
    }

    public static void fun2(Object object){
        log.debug("[JAVA] fun2 object.getClass() : {}", object.getClass());
    }

    public static void fun3(ScriptObjectMirror mirror){
        log.debug("[JAVA] fun3 mirror : {}, {}", mirror.getClassName(), Arrays.toString(mirror.getOwnKeys(true)));
    }

    public static void fun4(ScriptObjectMirror person) {
        log.debug("[JAVA] fun4 Full Name is : {}", person.callMember("getFullName"));
    }

    public static void main(String[] args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        Path path = Paths.get(ClassLoader.getSystemResource("scripts/nashorn2.js").toURI());
        FileReader fileReader = new FileReader(path.toFile());
        engine.eval(fileReader);
    }


}
