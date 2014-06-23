package io.gmind.java8.nashorn;

import io.gmind.java8.model.Person;
import lombok.extern.slf4j.Slf4j;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by gmind on 14. 6. 23.
 */
@Slf4j
public class Nashorn1 {

    public static void main(String[] args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        Path path = Paths.get(ClassLoader.getSystemResource("scripts/nashorn1.js").toURI());
        FileReader fileReader = new FileReader(path.toFile());
        engine.eval(fileReader);

        Invocable invocable = (Invocable) engine;
        Object result = invocable.invokeFunction("fun1", "Peter Parker");
        log.debug("result : {}", result);
        log.debug("result.getClass() : {}", result.getClass());

        invocable.invokeFunction("fun2", new Date());
        invocable.invokeFunction("fun2", LocalDateTime.now());
        invocable.invokeFunction("fun2", new Person());
    }



}


