package io.gmind.java8.nashorn;

import lombok.extern.slf4j.Slf4j;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by gmind on 14. 6. 23.
 */
@Slf4j
public class Nashorn3 {

    public static void main(String[] args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        Path path = Paths.get(ClassLoader.getSystemResource("scripts/nashorn3.js").toURI());
        FileReader fileReader = new FileReader(path.toFile());
        engine.eval(fileReader);
    }

}
