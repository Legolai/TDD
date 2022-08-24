import dk.cphbusiness.Greeter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingTest {

    @BeforeEach
    void setUp() {
        
    }

    @AfterEach
    void tearDown() {
        
    }

    @Test
    void greetNameTest() {
        System.out.println("Testing greet with a given name");
        Greeter greeter = new Greeter();
        String actual = greeter.greet("Bob");
        String expected = "Hello, Bob.";

        assertEquals(expected, actual);

        actual = greeter.greet("Jens");
        expected = "Hello, Jens.";

        assertEquals(expected, actual);
    }

    @Test
    void greetNullTest() {
        System.out.println("Testing greet with null arg");
        Greeter greeter = new Greeter();
        String actual = greeter.greet(null);
        String expected = "Hello, my friend.";

        assertEquals(expected, actual);
    }

    @Test
    void greetShoutingTest() {
        System.out.println("Testing greet with capped name");
        Greeter greeter = new Greeter();
        String actual = greeter.greet("JERRY");
        String expected = "HELLO JERRY!";

        assertEquals(expected, actual);
    }

    @Test
    void greetMultipleTest() {
        System.out.println("Testing greet with multiple names");
        Greeter greeter = new Greeter();
        String actual = greeter.greet("Jill", "Jane");
        String expected = "Hello, Jill and Jane.";

        assertEquals(expected, actual);
    }

    @Test
    void greetMultipleCommaSepTest() {
        System.out.println("Testing greet with multiple names with Oxford comma");
        Greeter greeter = new Greeter();
        String actual = greeter.greet("Amy", "Brian", "Charlotte");
        String expected = "Hello, Amy, Brian and Charlotte.";

        assertEquals(expected, actual);
    }

    @Test
    void greetMultipleShoutTest() {
        System.out.println("Testing greet with multiple names and shout");
        Greeter greeter = new Greeter();
        String actual = greeter.greet("Amy", "BRIAN", "Charlotte");
        String expected = "Hello, Amy and Charlotte. AND HELLO BRIAN!";

        assertEquals(expected, actual);
    }

    @Test
    void greetMultipleSplitCommaTest() {
        System.out.println("Testing greet with multiple names split comma");
        Greeter greeter = new Greeter();
        String actual = greeter.greet("Bob", "Charlie, Dianne");
        String expected = "Hello, Bob, Charlie and Dianne.";

        assertEquals(expected, actual);
    }
}
