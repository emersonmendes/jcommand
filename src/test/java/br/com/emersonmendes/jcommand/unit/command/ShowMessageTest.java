package br.com.emersonmendes.jcommand.unit.command;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.emersonmendes.jcommand.Executor;

public class ShowMessageTest {

    private final PrintStream stdout = System.out;

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testShowingMessageWithManyArgs() {
        Executor.exec("sm", "Emerson", " ", "Mendes");
        assertEquals("Emerson Mendes\n", output.toString());
    }

    @Test
    public void testShowingEmojiMessage() {
        Executor.exec("sm", "😱");
        assertEquals("😱\n", output.toString());
    }

    @Test
    public void testThrowingNotFoundCommandError() {
        String cmd = "thatIsANotFoundCommand";
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("command not found ¯\\_(ツ)_/¯");
        Executor.exec(cmd);
    }

    @Before
    public void setUp() throws UnsupportedEncodingException {
        System.setOut(new PrintStream(output, true, "UTF-8"));
    }

    @After
    public void cleanUp() {
        System.setOut(stdout);
    }

}