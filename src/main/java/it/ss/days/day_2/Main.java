package it.ss.days.day_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int RED_CUBES = 12;
    public static final int GREEN_CUBES = 13;
    public static final int BLUE_CUBES = 14;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/day_2/input.txt"));
        List<Game> games = new ArrayList<>();
        String gameRow;

        while ((gameRow = reader.readLine()) != null) {
            games.add(new Game(gameRow));
        }
        reader.close();

        int possibleGamesSum = 0;
        int setsPowerSum = 0;
        for (Game game : games) {
            if (game.isPossible()) {
                possibleGamesSum += game.getId();
            }
            setsPowerSum += game.getPower();
        }

        System.out.printf("Sum of possible games: %d\nSum of power sets: %d\n",
                          possibleGamesSum, setsPowerSum);
    }
}
