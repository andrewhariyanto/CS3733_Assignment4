package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Assert;
import org.junit.Test;

import java.security.interfaces.ECKey;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

    // TODO Add more test cases
    @Test(expected = ValueOutOfBoundsException.class)
    public void greaterThan9999Test() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("10000");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void exactly9999ArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9999");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void lessThanN9999ArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-10000");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void exactlyN9999ArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-9999");
    }

    @Test(expected = MalformedNumberException.class)
    public void spaceInMiddleArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9 9");
    }

    @Test(expected = MalformedNumberException.class)
    public void spaceInMiddleArabicWithTrailingTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9 9  ");
    }

    @Test(expected = MalformedNumberException.class)
    public void spaceInMiddleArabicWithLeadingTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  9 9");
    }

    @Test
    public void leadingSpaceArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void trailingSpaceArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1  ");
        assertEquals(converter.toElbonian(), "I");
    }





    //toArabic Tests
    @Test
    public void zeroElbonianTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("Z");
        assertEquals(converter.toArabic(), 0);
    }
    @Test
    public void  negativeNumberElbonianTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-MMCCII");
        assertEquals(converter.toArabic(), -2202);
    }
    @Test
    public void positiveNumberElbonianTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMCCII");
        assertEquals(converter.toArabic(), 2202);
    }


    //toElbonian tests
    @Test
    public void zeroArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("0");
        assertEquals(converter.toElbonian(), "Z");
    }
    @Test
    public void negativeArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-2202");
        assertEquals(converter.toElbonian(), "-MMCCII");
    }
    @Test
    public void positiveArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("2202");
        assertEquals(converter.toElbonian(), "MMCCII");
    }

}
