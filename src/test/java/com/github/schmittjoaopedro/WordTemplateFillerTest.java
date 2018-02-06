package com.github.schmittjoaopedro;

import org.docx4j.Docx4J;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordTemplateFillerTest {

    @Test
    public void testSimpleDocument() throws Exception {

        Path resourceDirectory = Paths.get("src","test","resources");
        Path xmlDataPath = Paths.get(resourceDirectory.toString(), "FormDataSample.xml");
        Path wordTemplatePath = Paths.get(resourceDirectory.toString(), "FormTemplateSample.docx");
        Path wordOutputPath = Paths.get(resourceDirectory.toString(), "WordOutputPath.docx");

        if(Files.exists(wordOutputPath))
            Files.delete(wordOutputPath);
        WordTemplateFiller wordTemplateFiller = new WordTemplateFiller();
        wordTemplateFiller.generateWord(wordTemplatePath.toString(), xmlDataPath.toString(), wordOutputPath.toString());

        String fileData = Docx4J.load(new File(wordOutputPath.toString())).getMainDocumentPart().getContent().get(1).toString();
        Assert.assertEquals("Name: Homer Simpson", fileData);
        Files.delete(wordOutputPath);
        Assert.assertFalse(Files.exists(wordOutputPath));

    }

}
