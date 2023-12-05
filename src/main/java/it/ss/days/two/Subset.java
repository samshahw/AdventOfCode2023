package it.ss.days.two;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Subset {

    private int red;
    private int green;
    private int blue;

    public Subset(String subset) {
        String[] cubes = subset.split(",");
        for (String cube : cubes) {
            Matcher matcher = Pattern.compile("\\d+").matcher(cube);
            int num;
            if (matcher.find(1)) {
                num = Integer.parseInt(matcher.group());
                if (cube.contains("red")) {
                    this.red = num;
                } else if (cube.contains("green")) {
                    this.green = num;
                } else if (cube.contains("blue")) {
                    this.blue = num;
                }
            }
        }
    }

    public Subset(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
