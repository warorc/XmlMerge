package com.vpolosov.trainee.merge_xml.validators;

import com.vpolosov.trainee.merge_xml.aspect.Loggable;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class CheckFileSize {

    @Loggable
    public boolean isMoreThanFiveKb(File file) {
        return file.length() > (long) 500 * 1024;
    }
}
