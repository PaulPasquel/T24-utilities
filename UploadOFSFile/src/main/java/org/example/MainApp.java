package org.example;

import org.apache.camel.spring.Main;

public class MainApp {
    public static void main(final String[] args) throws Exception {

        Main main = new Main();
        main.configure().withXmlRoutes("camel-context.xml");
        main.enableTrace();
        main.run();
    }
}