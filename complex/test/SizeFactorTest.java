import org.junit.Test;
import size.SizeFactor;

import static org.junit.Assert.*;

public class SizeFactorTest {

    @Test
    public void sizeFactorTest1() {
        SizeFactor sizeFactor = new SizeFactor();
        String line;
        long expected;
        long actual;

        line = "if (color != red) {";
        expected = 2;
        try {
            actual = sizeFactor.calculateTotalCs(line);
            System.out.println(sizeFactor.getToken());
            assertEquals(expected,actual);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
}