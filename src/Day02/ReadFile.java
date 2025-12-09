package Day02;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadFile {
    String filePath;
    ArrayList<String> data;

    public ReadFile(String filePath ){
        this.filePath = filePath;
    }


    public void getLine() {
        File line = new File(filePath);
        String data = new String();

        try (Scanner myReader = new Scanner(line)) {
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            data = "An error occurred." ;
        }
        String[] singleRange = data.split(",");
        this.data = new ArrayList<String>(Arrays.asList(singleRange));

    }
    public ArrayList<Range> getRange()
     {

     Function<String, Range> createRange =
     range ->  {
     String[] parts = range.split("-");

     long min = Long.parseLong(parts[0].trim());
     long max = Long.parseLong(parts[1].trim());
     Range rObj = new Range(min,max);
     rObj.getIDs();
     rObj.findInvalID();
        return rObj;
   };

     ArrayList<Range> allRanges;

     allRanges = data.stream()
             .map(createRange)
             .collect(Collectors.toCollection(ArrayList::new));

     return allRanges;
     }

    public static void main(String[] args) {
        ReadFile myObj = new ReadFile(".data/day02_input.txt");
        myObj.getLine();
        ArrayList<Range> test = myObj.getRange();

        System.out.println(test.get(0).invalid);
        System.out.println(test.get(0).allIDs);
    }
}
