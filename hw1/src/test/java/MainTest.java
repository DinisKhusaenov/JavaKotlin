import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InvalidPropertiesFormatException;

import static org.junit.Assert.*;

public class MainTest {
    private String[] arguments;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        new Main();
        this.arguments = new String[]{"20", "*", "3"};
        System.setOut(new PrintStream(output));
    }

    @Test
    public void mainTest() throws InvalidPropertiesFormatException {
        Main.main(arguments);
        Assert.assertEquals("60", output.toString().trim());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    private String[] correctArguments;
    private String[] wrongArguments;


    @Before
    public void prepareThreeArgumentsAndParser(){
        new Main();
        correctArguments = new String[]{"1", "+", "3"};
        wrongArguments = new String[]{"l", ")", "3", "6"};
    }


    @Test
    public void parseIntSuccessfully() throws InvalidPropertiesFormatException {
        var val1 = Main.parseIntOrError(correctArguments[0]);
        var val2 = Main.parseIntOrError(correctArguments[2]);
        Assert.assertEquals(Integer.parseInt(correctArguments[0]),val1);
        Assert.assertEquals(Integer.parseInt(correctArguments[2]),val2);
    }

    @Test
    public void parseIntWithError(){
        Assert.assertThrows(InvalidPropertiesFormatException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                Main.parseIntOrError(wrongArguments[0]);
            }
        });
    }

    @Test
    public void parseOperatorPlus() throws InvalidPropertiesFormatException {
        var operator = Main.parseOperatorOrError("+");
        Assert.assertEquals("+",operator);
    }

    @Test
    public void parseOperatorMinus() throws InvalidPropertiesFormatException {
        var operator = Main.parseOperatorOrError("-");
        Assert.assertEquals("-",operator);
    }

    @Test
    public void parseOperatorMultiply() throws InvalidPropertiesFormatException {
        var operator = Main.parseOperatorOrError("*");
        Assert.assertEquals("*",operator);
    }

    @Test
    public void parseOperatorDivide() throws InvalidPropertiesFormatException {
        var operator = Main.parseOperatorOrError("/");
        Assert.assertEquals("/",operator);
    }

    @Test
    public void parseOperatorWithError(){
        Assert.assertThrows(InvalidPropertiesFormatException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                Main.parseOperatorOrError(wrongArguments[1]);
            }
        });
    }

    @Test
    public void countOfArgsWithError(){
        Assert.assertEquals(false, Main.countOfArgumentsChecker(wrongArguments));
    }

    @Test
    public void countOfArgsCorrect(){
        Assert.assertEquals(true, Main.countOfArgumentsChecker(correctArguments));
    }

}