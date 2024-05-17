package com.vpolosov.trainee.merge_xml.handler.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IncorrectXmlFileException extends RuntimeException {

    public IncorrectXmlFileException(String message) {
        super(message);
    }
}
