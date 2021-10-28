package com.perozhak.cp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextManager {

    public static void writeToFile(String filepath, String text) {
        try (FileWriter fileWriter = new FileWriter(filepath)) {
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String filepath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                sb.append(tmp).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (sb.length() < 1) return sb.toString();
        return sb.delete(sb.length() - 2, sb.length()).toString();
    }

    public static List<String> getPenultimateWords(String text) {
        List<String> res = new ArrayList<>();
        // \S+ - 1+ non-space symbol +
        // \s+ - 1+ space symbol +
        // $ - end of text
        // | - OR
        // \\. - dot character (exactly '.') like end of sentence
        Pattern pattern = Pattern.compile("\\S+(?=\\s+\\S+$|\\s+\\S+\\.)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            res.add(matcher.group());
        }
        return res;
    }

}
