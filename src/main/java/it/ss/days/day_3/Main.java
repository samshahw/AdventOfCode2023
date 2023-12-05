package it.ss.days.day_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final List<String> lines = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/day_3/input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        List<Integer> validNumbers = new ArrayList<>();

        String fileLine;
        int k = 0;
        while ((fileLine = reader.readLine()) != null) {
            lines.add(k, fileLine);
            k++;
        }
        reader.close();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher;
        for (int i = 0; i < lines.size(); i++) {
            matcher = pattern.matcher(lines.get(i));
            while (matcher.find()) {
                if (isNumberValid(matcher.group(), i, matcher.start())) {
                    validNumbers.add(Integer.valueOf(matcher.group()));
                }
            }
        }

        int res = validNumbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Valid numbers: " + validNumbers);
        System.out.println("Final result is " + res);
    }

    private static boolean isNumberValid(String number, int lineIndex, int matchIndex) {
        String prevLine = lineIndex > 0 ? lines.get(lineIndex - 1) : null;
        String currLine = lines.get(lineIndex);
        String nextLine = lineIndex < lines.size() - 1 ? lines.get(lineIndex + 1) : null;

        int currIndex;
        for (int i = 0; i < number.length(); i++) {
            currIndex = matchIndex + i;
            if (hasAdjacentSymbolOnLine(currLine, currIndex)) return true;
            if (prevLine != null) {
                if (hasAdjacentSymbolOnLine(prevLine, currIndex)) return true;
            }
            if (nextLine != null) {
                if (hasAdjacentSymbolOnLine(nextLine, currIndex)) return true;
            }
        }

        return false;
    }

    private static boolean hasAdjacentSymbolOnLine(String line, int index) {
        Pattern pattern = Pattern.compile("[^\\d.]");
        Matcher matcher;
        if (index > 0) {
            matcher = pattern.matcher(String.valueOf(line.charAt(index - 1)));
            if (matcher.find()) return true;
        }
        if (index < line.length() - 1) {
            matcher = pattern.matcher(String.valueOf(line.charAt(index + 1)));
            if (matcher.find()) return true;
        }
        matcher = pattern.matcher(String.valueOf(line.charAt(index)));
        if (matcher.find()) return true;
        return false;
    }
}
