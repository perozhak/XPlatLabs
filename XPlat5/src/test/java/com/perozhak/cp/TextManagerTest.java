package com.perozhak.cp;

import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TextManagerTest {

    private static final String FILEPATH = "src/main/resources/file.txt";

    private static final String TEXT = "It is an established fact. That a reader " + System.lineSeparator() +
            "will be distracted by. The readable content of. A page when looking. " + System.lineSeparator() +
            "The point of using it is that. It has a normal distribution " + System.lineSeparator() +
            "of letters, making it look like readable English.";

    // backup
    private static final InputStream SYSTEM_IN =  System.in;

    private static final InputStream NEW_INPUT_STREAM = new ByteArrayInputStream(TEXT.getBytes(StandardCharsets.UTF_8));

    // "clear" file before each test
    @Before
    public void prepFile() {
        TextManager.writeToFile(FILEPATH, "");
    }

    // mock input
    @BeforeClass
    public static void setSystemIn() {
        System.setIn(NEW_INPUT_STREAM);
    }

    @Test
    public void readWriteTest() {
        TextManager.writeToFile(FILEPATH, TEXT);
        Assert.assertEquals(TEXT, TextManager.readFromFile(FILEPATH));
    }

    // test writing user input
    @Test
    public void inputWriteTest() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append(System.lineSeparator());
        }

        TextManager.writeToFile(FILEPATH, sb.delete(sb.length() - 1, sb.length()).toString());
        Assert.assertEquals(TEXT, TextManager.readFromFile(FILEPATH));
    }

    // test finding second last words
    @Test
    public void secondLastWordsTest() {
        TextManager.writeToFile(FILEPATH, TEXT);
        Assert.assertEquals("[established, distracted, content, when, is, readable]",
                TextManager.getPenultimateWords(TextManager.readFromFile(FILEPATH)).toString());
    }

    // set built in input back
    @AfterClass
    public static void resetSystemIn() {
        System.setIn(SYSTEM_IN);
    }

}
