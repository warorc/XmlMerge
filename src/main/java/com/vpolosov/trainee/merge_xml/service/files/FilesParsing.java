package com.vpolosov.trainee.merge_xml.service.files;

import com.vpolosov.trainee.merge_xml.aspect.Loggable;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Component
public class FilesParsing {

    private static final String XML_EXTENSION = ".xml";
    private static final String XSD_EXTENSION = ".xsd";

    @Loggable
    public List<File> listXmlFiles(String directory) {
        File directoryFile = new File(directory);
        return Arrays.stream(directoryFile.listFiles())
                .filter(file -> file.getName().endsWith(XML_EXTENSION))
                .sorted(Comparator.comparing(File::lastModified))
                .toList();
    }

    @Loggable
    public List<File> listXsdFiles(String directory) {
        File directoryFile = new File(directory);
        return Arrays.stream(directoryFile.listFiles())
                .filter(x -> x.getName().endsWith(XSD_EXTENSION))
                .toList();
    }
}
