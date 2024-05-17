package com.vpolosov.trainee.merge_xml.validators;

import com.vpolosov.trainee.merge_xml.aspect.Loggable;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class CheckFileSize {

    private static final long FILE_SIZE_LIMIT = 500L*1024;

    @Loggable
    public boolean isMoreThanFiveKb(File file) {
        return file.length() > FILE_SIZE_LIMIT;
    }
}
