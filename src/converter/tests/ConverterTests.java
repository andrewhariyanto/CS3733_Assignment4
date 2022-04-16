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

    @Test
    public void exactly9999ArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9999");
        assertEquals(converter.toElbonian(), "NNNDDDLLLVVV");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void lessThanN9999ArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-10000");
    }

    @Test
    public void exactlyN9999ArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("-9999");
        assertEquals(converter.toElbonian(), "-NNNDDDLLLVVV");
    }

    @Test(expected = MalformedNumberException.class)
    public void spaceInMiddleArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9 9");
    }
    @Test(expected = MalformedNumberException.class)
    public void spaceInMiddleElbonianTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M M");
    }
    @Test(expected = MalformedNumberException.class)
    public void spacesInMiddleArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9  9");
    }
    @Test(expected = MalformedNumberException.class)
    public void spacesInMiddleElbonianTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M  M");
    }

    @Test(expected = MalformedNumberException.class)
    public void spaceInMiddleArabicWithTrailingTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9 9  ");
    }
    @Test(expected = MalformedNumberException.class)
    public void spaceInMiddleElbonianWithTrailingTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M M  ");
    }
    @Test(expected = MalformedNumberException.class)
    public void spacesInMiddleArabicWithTrailingTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9  9  ");
    }
    @Test(expected = MalformedNumberException.class)
    public void spacesInMiddleElbonianWithTrailingTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M  M  ");
    }

    @Test(expected = MalformedNumberException.class)
    public void spaceInMiddleArabicWithLeadingTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  9 9");
    }
    @Test(expected = MalformedNumberException.class)
    public void spaceInMiddleElbonianWithLeadingTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  M M");
    }
    @Test(expected = MalformedNumberException.class)
    public void spacesInMiddleArabicWithLeadingTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  9  9");
    }
    @Test(expected = MalformedNumberException.class)
    public void spacesInMiddleElbonianWithLeadingTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  M  M");
    }

    @Test
    public void leadingSpaceArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  1");
        assertEquals(converter.toElbonian(), "I");
    }
    @Test
    public void leadingSpaceElbonianTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  I");
        assertEquals(converter.toArabic(), 1);
    }
    @Test
    public void trailingSpaceArabicTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1  ");
        assertEquals(converter.toElbonian(), "I");
    }
    @Test
    public void trailingSpaceElbonianTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I  ");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void threeInARowNFailTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NNNM");
    }
    @Test(expected = MalformedNumberException.class)
    public void threeInARowDFailTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NMDDDC");
    }
    @Test(expected = MalformedNumberException.class)
    public void threeInARowLFailTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NMDDCLLLX");
    }
    @Test(expected = MalformedNumberException.class)
    public void threeInARowVFailTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NMDDCLLXVVVI");
    }

    @Test(expected = MalformedNumberException.class)
    public void fourInARowNFailTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NNNNNDDCC");
    }
    @Test(expected = MalformedNumberException.class)
    public void fourInARowDFailTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NNNDDDDCC");
    }
    @Test(expected = MalformedNumberException.class)
    public void fourInARowLFailTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NNNDDCCCC");
    }
    @Test(expected = MalformedNumberException.class)
    public void fourInARowVFailTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NNDDCCVVVV");
    }

    @Test
    public void threeInARowNSuccessTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NNND");
        assertEquals(converter.toArabic(), 9300);
    }
    @Test
    public void threeInARowDSuccessTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NNNDDD");
        assertEquals(converter.toArabic(), 9900);
    }
    @Test
    public void threeInARowLSuccessTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NNNDDDLLL");
        assertEquals(converter.toArabic(), 9990);
    }
    @Test
    public void threeInARowVSuccessTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NNNDDDLLLVVV");
        assertEquals(converter.toArabic(), 9999);
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
