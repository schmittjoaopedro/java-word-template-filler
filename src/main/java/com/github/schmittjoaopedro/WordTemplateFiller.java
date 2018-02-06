package com.github.schmittjoaopedro;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

public class WordTemplateFiller {

    private static final Logger logger = Logger.getLogger(WordTemplateFiller.class.getName());

    public void generateWord(String wordTemplatePath, String xmlDataPath, String wordOutputPath) throws Docx4JException, FileNotFoundException {
        WordprocessingMLPackage wordMLPackage = Docx4J.load(new File(wordTemplatePath));
        FileInputStream xmlStream = new FileInputStream(new File(xmlDataPath));
        Docx4J.bind(wordMLPackage, xmlStream, Docx4J.FLAG_BIND_INSERT_XML | Docx4J.FLAG_BIND_BIND_XML | Docx4J.FLAG_BIND_REMOVE_SDT);
        Docx4J.save(wordMLPackage, new File(wordOutputPath), Docx4J.FLAG_NONE);
        logger.info("Saved: " + wordOutputPath);
    }

}
