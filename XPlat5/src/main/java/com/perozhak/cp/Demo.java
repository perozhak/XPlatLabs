package com.perozhak.cp;

public class Demo {

    private static final String FILEPATH = "src/main/resources/file.txt";

    private static final String TEXT = "It is an established fact. That a reader " + System.lineSeparator() +
            "will be distracted by. The readable content of. A page when looking. " + System.lineSeparator() +
            "The point of using it is that. It has a normal distribution " + System.lineSeparator() +
            "of letters, making it look like readable English.";

    public static void main(String[] args) {
        TextManager.writeToFile(FILEPATH, TEXT);
        String text = TextManager.readFromFile(FILEPATH);

        System.out.println("Given text:" + System.lineSeparator() + text);
        System.out.println(System.lineSeparator() +
                "Second last words: " +
                TextManager.getPenultimateWords(text));
    }

}
