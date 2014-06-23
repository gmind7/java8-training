package io.gmind.java8.nashorn;

import io.gmind.java8.model.Product;
import lombok.extern.slf4j.Slf4j;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by gmind on 14. 6. 23.
 */
@Slf4j
public class Nashorn5 {

    public static void main(String[] args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        Path path = Paths.get(ClassLoader.getSystemResource("scripts/nashorn5.js").toURI());
        FileReader fileReader = new FileReader(path.toFile());
        engine.eval(fileReader);

        Invocable invocable = (Invocable) engine;

        Product product = new Product();
        product.setName("Rubber");
        product.setPrice(1.99);
        product.setStock(1037);

        Object result = invocable.invokeFunction("getValueOfGoods", product);
        log.debug("[JAVA] result: {}", result);
    }

}
