package com.github.schmittjoaopedro;

import org.docx4j.openpackaging.exceptions.Docx4JException;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        try {
            if(args.length >= 3) {
                String wordTemplatePath = args[0];
                String xmlDataPath = args[1];
                String wordOutputPath = args[2];
                logger.info("Template file: " + wordTemplatePath);
                logger.info("XML file: " + xmlDataPath);
                logger.info("Output file: " + wordOutputPath);
                WordTemplateFiller wordTemplateFiller = new WordTemplateFiller();
                wordTemplateFiller.generateWord(wordTemplatePath, xmlDataPath, wordOutputPath);
            } else {
                logger.info("Use the following arguments: wordTemplatePath xmlDataPath wordOutputPath");
            }
        } catch (Docx4JException | FileNotFoundException ex) {
            logger.log(Level.SEVERE, "Error on generate document!", ex);
        }

    }

}
