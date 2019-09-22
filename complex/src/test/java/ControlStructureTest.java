import controlStructure.ControlStructure;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControlStructureTest {
    @Test
    public void conditionStatementTest1() {
        ControlStructure csTest = new ControlStructure();
        String line;
        long expected;
        long actual;

        line = "if (color != red) {";
        expected = 1;
//        actual = csTest.getCTC(line,1);

//        assertEquals(expected,actual);
    }

    @Test
    public void conditionStatementTest2() {
        ControlStructure csTest = new ControlStructure();
        String line;
        long expected;
        long actual;

        //senario 2
        line = "while (color != red && color != red || color == grey) {";
        expected = 6;
//        actual = csTest.getCTC(line,1);

//        assertEquals(expected,actual);
    }

    @Test
    public void conditionStatementTest3() {
        ControlStructure csTest = new ControlStructure();
        String line;
        long expected;
        long actual;

        //senario 3
        line = "case blue:";
        expected = 1;
//        actual = csTest.getCTC(line,1);

//        assertEquals(expected,actual);
    }
}
