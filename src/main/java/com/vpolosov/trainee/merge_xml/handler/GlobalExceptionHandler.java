package com.vpolosov.trainee.merge_xml.handler;

import com.vpolosov.trainee.merge_xml.handler.dto.ErrorResponseDTO;
import com.vpolosov.trainee.merge_xml.handler.exception.IncorrectXmlFileException;
import com.vpolosov.trainee.merge_xml.handler.exception.MoreFiveHundredKbException;
import com.vpolosov.trainee.merge_xml.handler.exception.NotExactlyOneXsdFileException;
import com.vpolosov.trainee.merge_xml.handler.exception.NotExactlyTenFilesException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IncorrectXmlFileException.class, MoreFiveHundredKbException.class, NotExactlyOneXsdFileException.class,
            NotExactlyTenFilesException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleIllegalArgumentException(Exception e) {
        return new ErrorResponseDTO("Bad Request", e.getMessage());
    }

    @ExceptionHandler({IOException.class, ParserConfigurationException.class, TransformerException.class, SAXException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO handleInternalServerError(Exception e) {
        return new ErrorResponseDTO("Bad Request", e.getMessage());
    }
}
