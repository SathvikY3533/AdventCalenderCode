import java.io.File;
import java.io.IOException;
import java.util.*;

public class Day6 {
    public static void main(String[] args) {
        Scanner scan = null;

        try {
            scan = new Scanner(new File("day6.txt"));
            String line = scan.nextLine();
            String word = "";
            int index = 0;
            boolean check = false;

            for(int i = 0; i < line.length()-14; i++) {
                word = line.charAt(i)+""+line.charAt(i+1)+line.charAt(i+2)+line.charAt(i+3)+line.charAt(i+4)+line.charAt(i+5)+line.charAt(i+6)+line.charAt(i+7)+line.charAt(i+8)+line.charAt(i+9)+line.charAt(i+10)+line.charAt(i+11)+line.charAt(i+12)+line.charAt(i+13)+"";

                for(int x = 0; x < word.length(); x++) {
                    if(word.substring(x+1, word.length()).indexOf(word.charAt(x)+"") == -1) {
                        check = true;
                    } else {
                        check = false;
                        break;
                    }
                }

                if(check) {
                    index = i+14;
                    break;
                }

            }

            System.out.println(word+": "+(index));



        } catch(IOException e) {
            System.out.println("404 - file not found!");
        }
    }
}
