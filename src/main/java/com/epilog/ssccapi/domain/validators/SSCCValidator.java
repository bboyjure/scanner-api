package com.epilog.ssccapi.domain.validators;

public class SSCCValidator
{
  public static final int SSCC_OK = 0;


  public static int validateSSCC(String sscc)
  {
     return SSCC_OK;
  }

   /*
    Funkcija calculateSSCCCheckDigit izracuna check digit za osnovo SSCC kode.
    Param: String ssccBase, 17 mestna osnova za SSCC
     */
   public static int calculateCheckDigit(String ssccBase)
   {
      int oddDigitSum = 0;
      int evenDigitSum = 0;

      boolean evenPosition = false;

      for (char sDigit : ssccBase.toCharArray())
      {
         int i = Character.getNumericValue(sDigit);

         if (i < 0)
         {
            throw new IllegalArgumentException("invalid character while calculating SSCC, i=" + sDigit);
         }

         if (evenPosition)
         {
            evenDigitSum += i;
         }
         else
         {
            oddDigitSum += i;
         }

         evenPosition = !evenPosition;
      }
      int totalSum = oddDigitSum * 3 + evenDigitSum;
      int mod10Rem = totalSum % 10;

      return mod10Rem == 0 ? mod10Rem : 10 - mod10Rem;
   }
}
