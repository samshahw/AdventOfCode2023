package it.ss.days.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/day_one/input.txt"));
        List<Integer> numbersList = new ArrayList<>();
        Pattern pattern;
        Matcher matcher;
        String lineRaw;

        while ((lineRaw = reader.readLine()) != null) {
            pattern = Pattern.compile("(\\d|one|two|three|four|five|six|seven|eight|nine)");
            matcher = pattern.matcher(lineRaw);
            StringBuilder builder = new StringBuilder();
            if (matcher.find()) {
                do {
                    builder.append(matcher.group());
                } while (matcher.find(matcher.start() + 1));
                String line = builder.toString();
                String[][] numbersToDigits = {{"one", "1"},
                                              {"two", "2"},
                                              {"three", "3"},
                                              {"four", "4"},
                                              {"five", "5"},
                                              {"six", "6"},
                                              {"seven", "7"},
                                              {"eight", "8"},
                                              {"nine", "9"}};
                for (String[] numberToDigit : numbersToDigits) {
                    line = line.replaceAll(numberToDigit[0], numberToDigit[1]);
                }
                int number = Integer.parseInt("" + line.charAt(0) + line.charAt(line.length() - 1));
                numbersList.add(number);
            }
        }

        int res = 0;
        for (int num : numbersList) {
            res += num;
        }

        System.out.println("Final result is " + res);
    }
}
