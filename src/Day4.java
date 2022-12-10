import java.io.File;
import java.io.IOException;
import java.util.*;

public class Day4 {

    public static void main(String[] args) {
        Scanner scan = null;
        int overlapCompleteCount = 0;
        int overlapAtAllCount = 0;
        try {
            scan = new Scanner(new File("day4.txt"));
            while (scan.hasNextLine()) {
                int num1 = 0;
                int num2 = 0;
                int num3 = 0;
                int num4 = 0;
                String firstLine = scan.nextLine();

                String[] commaSplit1 = firstLine.split(",");

                num1 = Integer.parseInt(commaSplit1[0].split("-")[0]);
                num2 = Integer.parseInt(commaSplit1[0].split("-")[1]);
                num3 = Integer.parseInt(commaSplit1[1].split("-")[0]);
                num4 = Integer.parseInt(commaSplit1[1].split("-")[1]);

                if((num2 <= num4 && num1 >= num3) || (num4 <= num2 && num3 >= num1)) {
                    overlapCompleteCount++;
                }

                if((num3 >= num1 && num3 <= num2) || (num3 <= num1 && num4 >= num1)) {
                    overlapAtAllCount++;
                }


            }
            System.out.println(overlapCompleteCount);
            System.out.println(overlapAtAllCount);

        } catch (IOException e) {
            System.out.println("File not Found!");
        }
    }
}
