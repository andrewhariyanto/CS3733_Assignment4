package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {
    private final int n = 3000;
    private final int m = 1000;
    private final int d = 300;
    private final int c = 100;
    private final int l = 30;
    private final int x = 10;
    private final int v = 3;
    private final int i = 1;
    private final int z = 0;
    private Map<Character, Integer> letterDictionary = new HashMap<Character, Integer>();
    private final Character[] possibleChars = {'N', 'M', 'D', 'C', 'L', 'X', 'V', 'I', 'Z'};

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic integer that cannot be represented
     * in the Elbonian number system.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system or any other error in Arabic number input.
	 * Leading and trailing spaces should not throw an error.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {
        letterDictionary.put('N', n);
        letterDictionary.put('M', m);
        letterDictionary.put('D', d);
        letterDictionary.put('C', c);
        letterDictionary.put('L', l);
        letterDictionary.put('X', x);
        letterDictionary.put('V', v);
        letterDictionary.put('I', i);
        letterDictionary.put('Z', z);
        // TODO check to see if the number is valid, then set it equal to the string

        //check if capital
        this.number = number;
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        // TODO Fill in the method's body
        int totalValue = 0;
        for(int i = 0; i < this.number.length(); i++){ //go through each char in String number
            totalValue += letterDictionary.get(this.number.charAt(i));
        }
        return totalValue;
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        // TODO Fill in the method's body
        return "I";
    }

}
