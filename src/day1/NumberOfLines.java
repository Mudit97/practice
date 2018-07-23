package day1;

import java.io.*;

public class NumberOfLines {
    public static void main(String[] args){
        int len = args.length;
        for(int i=0; i<len; i++){
            try {
                int n = countLines(args[i]);
            } catch (IOException e) {
                System.out.println("Error processing file : " + args[i]);
            }
        }
    }

    private static int countLines(String arg) throws IOException {
        FileReader f = new FileReader(arg);
        BufferedReader bufferedReader = new BufferedReader(f);
        String line = new String();
        int count =0;
        while ((line = bufferedReader.readLine()) != null){
            count++;
        }
        return count;
    }
}
