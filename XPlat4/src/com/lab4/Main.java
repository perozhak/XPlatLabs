package com.lab4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.ParseException;


public class Main {

    public static final boolean PRINT_FILE = true;
    public static final boolean LOG_DATA = false;
    public static DateRange dateRange = new DateRange();

    public static void main(String[] args) throws ParseException {

        String filepath = "src/04_lab_data.txt";
        String resultFilepath = "src/04_lab_result.txt";

        Pair<String,String> data = readFile(filepath);

        String oldData = data.getFirst();
        String newData = data.getSecond();

        if (PRINT_FILE){
            System.out.println("OLD DATA: ");
            System.out.println(oldData);
        }
        System.out.println("NEW DATA: ");
        System.out.println(newData);

        writeDataToFile( resultFilepath, newData);

        System.out.println("DATE RANGE: ");
        System.out.println(dateRange.getRange());
    }

    private static Pair<String, String> readFile(String path) {

        StringBuilder oldBuf = new StringBuilder();
        StringBuilder newBuf = new StringBuilder();

        try (Scanner sc = new Scanner(new FileInputStream(path))) {
            while (sc.hasNext()) {
                String str = sc.nextLine();
                String[] arr = str.split(" ");
                for (int i = 0; i < arr.length; i++) {
                    newBuf.append(tryToParseWord(arr[i]) + " ");
                }
                newBuf.append(System.lineSeparator());
                oldBuf.append(str);
                oldBuf.append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("-------------");
            System.out.println(e);
        }

        return new Pair<String, String>(oldBuf.toString(), newBuf.toString());

    }

    private static void writeDataToFile(String path, String data) {

        Path filePath = Path.of(path);

        try
        {
            // Delete file if exists and create new
            Files.deleteIfExists(filePath);
            Files.createFile(filePath);

            //Write content to file
            Files.writeString(filePath, data, StandardOpenOption.APPEND);

            //Verify file content
            String content = Files.readString(filePath);

            System.out.println("CHECK DATA:");
            System.out.println(content);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static Pair<Boolean,String> isDate(String date) throws ParseException{

        String[] patterns = {"dd.MM.y", "dd/MM/y", "y/MM/dd", "y.MM.dd"};

        for(String pattern: patterns){
            DateValidator validator = new DateValidatorUsingDateFormat(pattern);
            if(validator.isValid(date)) return new Pair<Boolean, String>(true, pattern);
        }

        return new Pair<Boolean, String>(false, "");
    }

    private static String tryToParseWord(String word) {
            try {
                Pair<Boolean,String> isDateResult = isDate(word);
                Boolean isValidDate = isDateResult.getFirst();
                String pattern = isDateResult.getSecond();
                if (LOG_DATA) System.out.println("Date "+ word + " isValid - " + isValidDate);
                if(isValidDate) {
                    if (LOG_DATA) System.out.println(pattern);
                    LocalDate date = LocalDate.parse(word, DateTimeFormatter.ofPattern(pattern));
                    LocalDate nextDay = date.plusDays(1);
                    String weekDay2 = nextDay.getDayOfWeek().toString();
                    String parsedDate = nextDay
                            .format(DateTimeFormatter.ofPattern(pattern))
                            .toString() + "(" + weekDay2 + ")";
                    if (LOG_DATA) System.out.println(parsedDate);

                    if (dateRange.IsEmpty()) {
                        dateRange.setNotEmpty();
                        dateRange.setMinDate(date);
                        dateRange.setMaxDate(date);
                    } else {
                        if (date.isAfter(dateRange.getMaxDate())) dateRange.setMaxDate(date);
                        if (date.isBefore(dateRange.getMinDate())) dateRange.setMinDate(date);
                    }

                    return parsedDate;
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return word;
            }
            return word;
    }
}

