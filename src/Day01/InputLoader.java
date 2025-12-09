package Day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InputLoader {

    private final int DIR = 0,
                      DIST =1;

    public InputLoader(){}

    public ArrayList<Turn> getTurn(String filename)
    {
        Function<String, Turn> createTurn =
                turn -> {
                   String[] parts = turn.split("(?<=\\D)(?=\\d)");

                   String dir = parts[DIR].trim();
                   int dist = Integer.parseInt(parts[DIST].trim());

                   return new Turn(dir, dist);
                };

        ArrayList<Turn> turns;
        try
        {
        turns = Files.lines(Paths.get(filename))
                .map(createTurn)
                .collect(Collectors.toCollection(ArrayList::new));
        }
        catch(IOException e) {
            System.out.println("Unable to open " + filename);
            turns = new ArrayList<>();
        }
        return turns;
    }

    }
