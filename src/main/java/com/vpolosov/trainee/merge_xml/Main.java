package com.vpolosov.trainee.merge_xml;

import com.vpolosov.trainee.merge_xml.exception.MoreFiveHundredKbException;
import com.vpolosov.trainee.merge_xml.exception.NotExactlyOneXsdFileException;
import com.vpolosov.trainee.merge_xml.exception.NotExactlyTenFilesException;
import com.vpolosov.trainee.merge_xml.service.files.FilesParsing;
import com.vpolosov.trainee.merge_xml.service.files.MergeXmlFiles;
import com.vpolosov.trainee.merge_xml.validators.CheckFileSize;
import com.vpolosov.trainee.merge_xml.validators.FilesNumberValidator;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        FilesParsing countFiles = new FilesParsing();
        MergeXmlFiles fileMerge = new MergeXmlFiles();
        CheckFileSize checkFileSize = new CheckFileSize();
        FilesNumberValidator filesNumberValidator = new FilesNumberValidator();

        List<File> xmlFiles = countFiles.listXmlFiles("./sourceXml");
        if (filesNumberValidator.isExactlyTenXml(xmlFiles)) {
            throw new NotExactlyTenFilesException("There are not exactly 10 xml files");
        }

        List<File> xsdFiles = countFiles.listXsdFiles("./sourceXml");
        if (filesNumberValidator.isExactlyTenXml(xsdFiles)) {
            throw new NotExactlyOneXsdFileException("There are not exactly 1 xsd files");
        }

        File target = fileMerge.merge(xmlFiles, xsdFiles.get(0), "./Total.xml");

        if (checkFileSize.isMoreThanFiveKb(target)) {
            target.delete();
            throw new MoreFiveHundredKbException("There are more than 500 kb files");
        }

    }
}
