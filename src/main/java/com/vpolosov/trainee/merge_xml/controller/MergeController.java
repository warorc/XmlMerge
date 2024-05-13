package com.vpolosov.trainee.merge_xml.controller;

import com.vpolosov.trainee.merge_xml.handler.exception.MoreFiveHundredKbException;
import com.vpolosov.trainee.merge_xml.handler.exception.NotExactlyOneXsdFileException;
import com.vpolosov.trainee.merge_xml.handler.exception.NotExactlyTenFilesException;
import com.vpolosov.trainee.merge_xml.service.files.FilesParsing;
import com.vpolosov.trainee.merge_xml.service.files.MergeXmlFiles;
import com.vpolosov.trainee.merge_xml.validators.CheckFileSize;
import com.vpolosov.trainee.merge_xml.validators.FilesNumberValidator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/xml")
@AllArgsConstructor
public class MergeController {

    private FilesParsing countFiles;
    private MergeXmlFiles fileMerge;
    private CheckFileSize checkFileSize;
    private FilesNumberValidator filesNumberValidator;

    @GetMapping
    public void patchXml() throws IOException, ParserConfigurationException, TransformerException, SAXException {
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
