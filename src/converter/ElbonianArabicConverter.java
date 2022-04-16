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
        if(number == null){
            throw new MalformedNumberException("Null string");
        }
        //Trim
        number = number.trim();
        //Check if there is space
        if(number.contains(" ")){
            throw new MalformedNumberException("Space in middle");
        }
        if(number.contains("-") && number.length() == 1){
            throw new MalformedNumberException("Invalid string");
        }
        //Check if Arabic
        try{
            int arabic = Integer.parseInt(number);
            //Check in bounds
            if(arabic > 9999 || arabic < -9999){
                throw new ValueOutOfBoundsException("Arabic value out of bounds");
            }
        }catch (NumberFormatException e){
            if("".equals(number)){
                throw new MalformedNumberException("Empty String");
            }
            //It's Elbonian
            if(number.contains("Z")){
                if(!number.matches("Z")){
                    throw new MalformedNumberException("invalid");
                }
            }else{
                if(!number.matches("-?N*M*D*C*L*X*V*I*")){
                    throw new MalformedNumberException("invalid");
                }
            }
            //For loop stuff
            int numTwoInARows = 0;
            int numThreeInARows = 0;

            //Check for two and three in a rows
            char previous = number.charAt(0);
            for(int i = 0; i < number.length(); i++){
                char current = number.charAt(i);
                if(current == 'M' || current == 'C' || current == 'X' || current == 'I'){
                    if(previous != current){
                        numTwoInARows = 0;
                    }
                    numTwoInARows++;
                    numThreeInARows = 0;
                    previous = current;
                }
                else if(current == 'N' || current == 'D' || current == 'L' || current == 'V'){
                    if(previous != current){
                        numThreeInARows = 0;
                    }
                    numThreeInARows++;
                    numTwoInARows = 0;
                    previous = current;
                    if(numThreeInARows == 3){
                        switch (current){
                            case 'N':
                                if(number.contains("M")){
                                    throw new MalformedNumberException("Three N contains M");
                                }
                                break;
                            case 'D':
                                if (number.contains("C")){
                                    throw new MalformedNumberException("Three D contains C");
                                }
                                break;
                            case 'L':
                                if(number.contains("X")) {
                                    throw new MalformedNumberException("Three L contains X");
                                }
                            case 'V':
                                if (number.contains("I")) {
                                    throw new MalformedNumberException("Three V contains I");
                                }
                            default:
                            }
                        }
                    }
                else if(current == 'Z'){
                    if(i != 0){
                        throw new MalformedNumberException("Z is not the only thing");
                    }
                }
                else {
                    if(i == 0 && number.charAt(i) == '-'){
                        //okay
                    }
                    else{
                        throw new MalformedNumberException("not a valid character");
                    }
                }
                if(numThreeInARows > 3 || numTwoInARows > 2){
                    throw new MalformedNumberException("Two and three in a rows do not conform");
                }
            }

        }


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
        if(this.number.contains("-")){
            for(int i = 1; i < this.number.length(); i++){ //go through each char in String number
                totalValue -= letterDictionary.get(this.number.charAt(i));
            }
        }
        else{
            for(int i = 0; i < this.number.length(); i++){ //go through each char in String number
                totalValue += letterDictionary.get(this.number.charAt(i));
            }
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
        int startingNum = Integer.parseInt(this.number);
        String totalString = "";
        if(startingNum < 0){
            totalString += "-";
        }

        startingNum = Math.abs(startingNum);


        if(startingNum == 0){
            return "Z";
        }

        while(startingNum > 0){
            if(startingNum - 3000 >= 0) {
                totalString += "N";
                startingNum -= 3000;
            } else if(startingNum - 1000 >= 0){
                totalString += "M";
                startingNum -= 1000;
            } else if(startingNum - 300 >= 0){
                totalString += "D";
                startingNum -= 300;
            }else if(startingNum-100 >= 0){
                totalString += "C";
                startingNum -= 100;
            }else if(startingNum - 30 >= 0){
                totalString += "L";
                startingNum -= 30;
            }else if(startingNum - 10 >= 0){
                totalString += "X";
                startingNum -= 10;
            }else if(startingNum - 3 >= 0){
                totalString += "V";
                startingNum -= 3;
            }else if(startingNum - 1 >= 0){
                totalString += "I";
                startingNum -= 1;
            }
        }

        return totalString;
    }

}
