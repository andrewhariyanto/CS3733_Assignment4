package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Assert;
import org.junit.Test;

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
    public void exactly9999Test() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9999");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void lessThanN9999Test() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-10000");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void exactlyN9999Test() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-9999");
    }

    @Test(expected = MalformedNumberException.class)
    public void spaceInMiddleTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9 9");
    }

    @Test(expected = MalformedNumberException.class)
    public void spaceInMiddleWithTrailingTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9 9  ");
    }

    @Test(expected = MalformedNumberException.class)
    public void spaceInMiddleWithLeadingTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  9 9");
    }

    @Test
    public void leadingSpaceTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test
    public void trailingSpaceTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I  ");
        assertEquals(converter.toArabic(), 1);
    }

}
