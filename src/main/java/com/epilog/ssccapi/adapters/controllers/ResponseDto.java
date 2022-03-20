package com.epilog.ssccapi.adapters.controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    private Boolean isSSCC;
    private Boolean isValid;
    private Integer  checkDigit;
    private String  validateFormat;
    private String  validateFormatAndCheckDigit;
    private String errorMsg;
}
