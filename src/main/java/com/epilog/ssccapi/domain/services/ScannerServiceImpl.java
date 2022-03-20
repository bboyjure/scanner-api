package com.epilog.ssccapi.domain.services;

import com.epilog.ssccapi.domain.validators.CheckDigit;
import com.epilog.ssccapi.domain.validators.ScannerInternals;
import org.springframework.stereotype.Service;

@Service
public class ScannerServiceImpl implements ScannerService{
    /**
     * Determines if a string is a valid SSCC without verifying its check digit.
     */
    @Override
    public Boolean isSSCC(String sscc){
        return ScannerInternals.isDigits(sscc);
    }

    /**
     * Validates that a string is a SSCC with a correct check digit.
     */
    @Override
    public Boolean isValid(String sscc) {
        return isSSCC(sscc) && CheckDigit.isValid(sscc);
    }

    /**
     * Checks if a string is a correctly formatted SSCC without verifying its check digit.
     *
     * @throws NullPointerException     if the input string is null
     * @throws IllegalArgumentException if the input string is not a sequence of exactly 18 digits
     */
    @Override
    public String validateFormat(String sscc) throws NullPointerException, IllegalArgumentException {
        return ScannerInternals.validateFormat("SSCC", sscc);
    }


    /**
     * Checks if a string is a SSCC with correct check digit.
     *
     * @throws NullPointerException     if the input string is null
     * @throws IllegalArgumentException if the input string is not a sequence of exactly 18 digits or if the check digit is not correct
     */
    @Override
    public String validateFormatAndCheckDigit(String sscc) throws NullPointerException, IllegalArgumentException {
        return CheckDigit.validate(validateFormat(sscc));
    }
}
