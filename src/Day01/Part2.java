package Day01;

import java.util.ArrayList;

public class Part2{
    private int password;
    ArrayList<Turn> turns;
    private final int min = 0;
    private final int max = 100;

    public Part2(){
    }

    public void loadTurns(String filename){
        InputLoader file = new InputLoader();

        this.turns = file.getTurn(filename);
    }

    public int turnDial(int start, int dist, String dir){

        if (dir.equals(Character.toString('R'))) {
            return (start + dist) % max;
        }
        else {
            if((start - dist)%max < 0){
                return (max + (start -dist)%max);
            }
            return (min + ((start - dist)%max));
        }
    }

    public int findZero(int start, int dist, String dir)
    {
        if (dir.equals(Character.toString('R'))) {
            return Math.floorDiv((start + dist), max);
        }
        else{
            if((turnDial(start, dist, dir) == min)){
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
            int end = turnDial(begin,dist, dir);
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