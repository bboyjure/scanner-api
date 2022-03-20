package com.epilog.ssccapi.domain.services;

public interface ScannerService {
    Boolean isSSCC(String sscc) throws InterruptedException;
    Boolean isValid(String sscc) throws InterruptedException;
    String validateFormat(String sscc);
    String validateFormatAndCheckDigit(String sscc);
}
