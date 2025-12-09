package Day02;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Part1 {
    ArrayList<Range> idRanges;

    public Part1(){
        ReadFile myObj = new ReadFile(".data/day02_input.txt");
        myObj.getLine();
        this.idRanges = myObj.getRange();
    }

    public Long getAllInvalid()
    {

        return idRanges.stream()
                .map(Range::getInvalid)
                .mapToLong(Long::longValue)
                .sum();
    }

    public static void main(String[] args){
        Instant start = Instant.now();

        Part1 part1 = new Part1();

        System.out.println(part1.getAllInvalid());
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
    }
}
