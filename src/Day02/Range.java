package Day02;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Range {
    long min;
    long max;
    ArrayList<Long> allIDs;
    Long invalid;
    Long invalidComplete;

    public Range(long min, long max){
        this.min = min;
        this.max = max;
    }

    public void getIDs(){
         allIDs = LongStream.rangeClosed(min, max)
                 .boxed()
                 .collect(Collectors.toCollection(ArrayList::new));
    }
    //2121221212
    public void findInvalID(){

        Function<String, Long> checkEach =
                id ->  {
                    if((id.length()%2) != 0){
                        return Long.valueOf(0);
                    }
                    else{
                        int idLen = id.length();
                        int middle = idLen/2;

                        String firstSub = id.substring(0,middle);
                        String secondSub = id.substring(middle,idLen);

                        if(firstSub.equals(secondSub)){
                            return Long.parseLong(id);
                        }
                        else{
                            return Long. valueOf(0);
                        }
                    }
                };



        this.invalid = allIDs.stream()
                .map(String::valueOf)
                .map(checkEach)
                .mapToLong(Long::longValue)
                .sum();

    }

    public static boolean isPrime(int n) {
        // Check from 2 to sqrt(n)
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public static ArrayList<Integer> getDivisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<>();


        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {

                // If divisors are equal, add only once
                if (n / i == i) {
                    divisors.add(i);
                }
                // Otherwise add both
                else {
                    divisors.add(i);
                    divisors.add(n / i);
                }
            }
        }
        return divisors;
    }

    public void findAllInvalid()
    {
        // part 2
        //if length of string is a prime number it can only have single digit repetitions
        //if length is even it can either have two repetitions or length/2 repetitions
        //if odd then it can only have single digit repetitions and length/factors

        Function<String, Long> checkEach =
                id ->  {
                    int idLen = id.length();


            // check for even first since 2 is prime
                    if((idLen%2) == 0) {
                        int middle = idLen / 2;

                        String firstSub = id.substring(0, middle);
                        String secondSub = id.substring(middle, idLen);

                        if (firstSub.equals(secondSub)) {
                            return Long.parseLong(id);
                        } else {
                            return Long.valueOf(0);
                        }
                    }
                    else if(getDivisors(idLen).size() > 2){
                        return Long.valueOf(0);
                    }
                    else{


                    }
                };
    }

    public Long getInvalid()
    {
        return invalid;
    }
}
