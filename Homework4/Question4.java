//Author: Cecelia Kaufmann
//  Date: 2/26/23

// Help from Daniela and Lily 
// Resource: https://www.javatpoint.com/try-catch-block

package Homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question4 {
    public static void main(String[] args) throws FileNotFoundException{
        List<String> list = new ArrayList<>(); 
        //This chunk of code will help recognize mm/-dd/-yy (for months with 31, then 30, then 28 days)
        list.add("(0[13578]|10|12)(/|-)([0-2][0-9]|[3][01])(/|-)[0-9][0-9]" + // months with 31 days
        "(0[469]|11)(/|-)([0-2][0-9]|30)(/|-)[0-9][0-9]" + // months with 30 days
        "(0[2])(/|-)([01][0-9]|2[0-8])(/|-)[0-9][0-9]"); /// February
        // This chunk recognizes mm/dd/yyyy (for months with 31, 30, and 28 days)
        list.add("(0[13578]|10|12)(/)([0-2][0-9]|[3][01])(/)[0-2][0-9][0-9][0-9]" + // 31 days
        "(0[469]|11)(/)([0-2][0-9]|30)(/)[0-2][0-9][0-9][0-9]" + // 30 days
        "(0[2])(/)([01][0-9]|2[0-8])(/)[0-2][0-9][0-9][0-9]"); // February
        // This chunk of code is to recognize by months by spelling
        list.add("(January|March|May|July|August|October|December)(/|-)([0-2][0-9]|[3][0|1])(/|-)[0-2][0-9][0-9][0-9]" + // 31 days
        "(April|June|September|November)(/|-)([0-2][0-9]|30)(/|-)[0-2][0-9][0-9][0-9]" + // 30 days
        "(February)(/|-)([01][0-9]|2[0-8])(/|-)[0-9][0-9]" // 28 days
        );
        // Day, Month (spelled), then year
        list.add("([0-2][0-9]|[3][0|1])(/|-)(January|March|May|July|August|October|December)(/|-)[0-2][0-9][0-9][0-9]" +
        "([0-2][0-9]|30)(/|-)(April|June|September|November)(/|-)[0-2][0-9][0-9][0-9]" +
        "([01][0-9]|2[0-8])(/|-)(February)(/|-)[0-9][0-9]");
        // This chunk is to recognize by days, then months
        list.add("([0-2][0-9]|[3][0|1])(/|-)(0[13578]|10|12)(/|-)[0-2][0-9][0-9][0-9]" + // 31 days
        "([0-2][0-9]|30)(/|-)(0[469]|11)(/|-)[0-2][0-9][0-9][0-9]" + // 30 days
        "([01][0-9]|2[0-8])(/|-)(0[2])(/|-)[0-2][0-9][0-9][0-9]");  // 28 days
        try{
            File exampletest = new File("testfile.txt");
            Scanner myObj = new Scanner(exampletest);
            while(myObj.hasNextLine()){
                String line = myObj.nextLine();
                for(String pattern : list){
                    Pattern patternChecker = Pattern.compile(pattern);
                    Matcher matchPatternCheck = patternChecker.matcher(line);
                    while(matchPatternCheck.find()){
                        System.out.println(matchPatternCheck.group());
                    }
                }
            }
            myObj.close();
        } catch (FileNotFoundException e){
            System.out.println("Error exists! ");
            e.printStackTrace();
        }
    }
        
}



