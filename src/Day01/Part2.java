package Day01;

import java.util.ArrayList;

public class Part2{
    private int password;
    ArrayList<Turn> turns;

    public Part2(){
    }

    public void loadTurns(String filename){
        InputLoader file = new InputLoader();

        this.turns = file.getTurn(filename);
    }


    public int findZero(int start, int dist, String dir)
    {
        int max = 100;
        if (dir.equals(Character.toString('R'))) {
            return Math.floorDiv((start + dist), max);
        }
        else{
            int min = 0;
            if((Part1.turnDial(start, dist, dir) == min)){
                return -Math.floorDiv((start - dist), max) ;
                }
                return -Math.floorDiv((start - dist), max);
            }
        }


    public int getPassword(){
        int begin = 50;
        int password = 0;

        ArrayList<Integer> results = new ArrayList<Integer>();

        for(Turn turn: turns){
            String dir = turn.getDir();
            int dist = turn.getDist();
            int end = Part1.turnDial(begin,dist, dir);
            int zeros = findZero(begin, dist, dir);
            begin = end;

            password += zeros;

        }
        return password;
    }


    public static void main(String[] args) {
        Part2 Safe = new Part2();

        Safe.loadTurns(".data/day1_input.txt");

        int password = Safe.getPassword();
        System.out.println(password);
    }
}