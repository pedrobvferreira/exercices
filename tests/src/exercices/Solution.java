package exercices;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

class Result {

    /*
     * Complete the 'processNumber' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING input as parameter.
     */

    public static String processNumber(String input) throws Exception {
    	int number = Integer.parseInt(input);
    	
        if(number>5000) {
        	throw new Exception();
        } else {
        	
        	input = reverseNumber(number);
        }
		return input;
    }
    
    public static String reverseNumber(int number) {
    	int reversedNumber=0, remainder;
    	
    	while(number != 0)
        {
            remainder = number%10;
            reversedNumber = reversedNumber*10 + remainder;
            number = number/10;
        }
    	System.out.println(number);
    	
    	return String.valueOf(number);
    }

}

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String input = bufferedReader.readLine();

        String result = "";
        try {
             result = Result.processNumber(input);            
        } catch(Exception e) {
           result = "ERROR";
        }
        
        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}