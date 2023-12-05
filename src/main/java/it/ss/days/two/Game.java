package it.ss.days.two;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static it.ss.days.two.Main.*;

public class Game {

    private int id;
    private final List<Subset> subsetList = new ArrayList<>();

    public Game(String row) {
        Matcher matcher = Pattern.compile("\\d+").matcher(row);
        if (matcher.find(1)) {
            this.id = Integer.parseInt(matcher.group());
        }
        String[] subsets = row.replaceAll("Game \\d+:", "").split(";");
        for (String subset : subsets) {
            this.subsetList.add(new Subset(subset));
        }
    }

    public int getId() {
        return id;
    }

    private Subset getGCD() {
        int gcdRed = 0;
        int gcdGreen = 0;
        int gcdBlue = 0;
        for (Subset subset : this.subsetList) {
            if (subset.getRed() > gcdRed) {
                gcdRed = subset.getRed();
            }
            if (subset.getGreen() > gcdGreen) {
                gcdGreen = subset.getGreen();
            }
            if (subset.getBlue() > gcdBlue) {
                gcdBlue = subset.getBlue();
            }
        }
        return new Subset(gcdRed, gcdGreen, gcdBlue);
    }

    public int getPower() {
        Subset subset = getGCD();
        return subset.getRed() * subset.getGreen() * subset.getBlue();
    }

    public boolean isPossible() {
        for (Subset subset : this.subsetList) {
            if (subset.getRed() > RED_CUBES ||
                subset.getGreen() > GREEN_CUBES ||
                subset.getBlue() > BLUE_CUBES) {
                return false;
            }
        }
        return true;
    }
}
