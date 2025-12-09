package Day01;

import java.util.ArrayList;

public class Part1{
    private int password;
    ArrayList<Turn> turns;

    public Part1(){
    }

    public void loadTurns(String filename){
        InputLoader file = new InputLoader();

        this.turns = file.getTurn(filename);
    }

    public static int turnDial(int start, int dist, String dir){
        final int min = 0;
        final int max = 100;

        if (dir.equals(Character.toString('R'))) {
            return (start + dist) % max;
        }
        else {
            if((start - dist)%max < 0){
                return (max + (start - dist) % max);
            }
            return (min + ((start - dist) % max));
            }
    }

    public int getPassword(){
        int begin = 50;
        int password = 0;

        for(Turn turn: turns){
            String dir = turn.getDir();
            int dist = turn.getDist();
            int end = turnDial(begin, dist, dir);
            if (end == 0){
                password += 1;
            }
            begin = end;
        }
        return password;
    }


public static void main(String[] args) {
    Part1 Safe = new Part1();
    Safe.loadTurns(".data/day1_input.txt");

    int password = Safe.getPassword();
    System.out.println(password);
}
}