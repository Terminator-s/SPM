import controlStructure.ControlStructure;
import file.ComplexityFactors;
import file.Stacks;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ControlStructureTest {
    Stacks stack = new Stacks();

    public ControlStructureTest() {
        stack.push("{");
        stack.push("{");
    }

    @BeforeClass
    public static void start() {
        System.out.println("Control Structure test Started");
    }

    @AfterClass
    public static void end() {
        System.out.println("Control Structure test Ended");
    }

    @Test
    public void conditionStatementTest1() {
        ControlStructure csTest = new ControlStructure();
        String line;
        long expected;
        long actual;

        line = "if (color != red) {";
        expected = 1;
        actual = csTest.getCTC(line,1,stack);

        assertEquals(expected,actual);

        System.out.println("senario 1 sucessfull");
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
        actual = csTest.getCTC(line,1,stack);
        assertEquals(expected,actual);
        System.out.println("senario 2 sucessfull");
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
        actual = csTest.getCTC(line,1,stack);
        assertEquals(expected,actual);
        System.out.println("senario 3 sucessfull");
    }
}
