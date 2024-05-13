package com.vpolosov.trainee.merge_xml.validators;

import com.vpolosov.trainee.merge_xml.aspect.Loggable;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class FilesNumberValidator {
    private static final int XML_FILES_NUBMER = 10;
    private static final int XSD_FILES_NUBMER = 1;

    @Loggable
    public boolean isExactlyTenXml(List<File> files) {
        return files.size() == XML_FILES_NUBMER;
    }

    @Loggable
    public boolean isExactlyOneXsd(List<File> files) {
        return files.size() == XSD_FILES_NUBMER;
    }
}
