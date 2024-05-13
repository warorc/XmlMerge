package com.vpolosov.trainee.merge_xml.validators;

import java.io.File;

public class CheckFileSize {

    public boolean isMoreThanFiveKb(File file) {
        return file.length() > (long) 500 * 1024;
    }
}
