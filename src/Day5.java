import java.io.File;
import java.io.IOException;
import java.util.*;

public class Day5 {
    public static void main(String[] args) {
        Scanner scan = null;
        ArrayList<Stack<String>> crates = new ArrayList<>();
        try {
            scan = new Scanner(new File("day5.txt"));


        } catch (IOException e) {
            System.out.println("File not Found!");
        }
    }
}
