package com.epilog.ssccapi.adapters.controllers;

import com.epilog.ssccapi.domain.services.MyWriter;
import com.epilog.ssccapi.domain.validators.SSCCValidator;
import com.epilog.ssccapi.domain.services.ScannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/code/")
public class ScannerController {

    @Autowired
    ScannerService scannerService;

    @Autowired
    MyWriter myFileWriter;

    @ResponseBody
    @GetMapping(path = "/{ai}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity validateAI(@PathVariable(required = true) String ai) {
        ResponseDto responseDto = new ResponseDto();
        try
        {
//            Thread.sleep(sleep);
            responseDto.setIsSSCC(scannerService.isSSCC(ai));
            responseDto.setIsValid(scannerService.isValid(ai));
            responseDto.setValidateFormat(scannerService.validateFormat(ai));
            responseDto.setValidateFormatAndCheckDigit(scannerService.validateFormatAndCheckDigit(ai));
            responseDto.setCheckDigit(SSCCValidator.calculateCheckDigit(ai));
            myFileWriter.writeToFile(ai);
            return new ResponseEntity(responseDto, HttpStatus.OK);
        }
        catch(Exception exception)
        {
            responseDto.setErrorMsg(exception.getMessage());
            return new ResponseEntity(responseDto, HttpStatus.NOT_FOUND);
        }
    }

}
