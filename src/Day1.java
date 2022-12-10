import java.util.*;
import java.io.*;

public class Day1 {
    public static void main(String[] args) {
        Scanner scan = null;
        int top3Sum = 0;
        int calorieSum;
        int highestCalories = -1;
        int highestIndex = -1;
        ArrayList<Integer> calories = new ArrayList<>();
        ArrayList<Integer> topCalories = new ArrayList<>();
        try {
            scan = new Scanner(new File("day1.txt"));
            while(scan.hasNextLine()) {
                calorieSum = 0;
                String line = "ooooo";
                while(!line.isEmpty() && scan.hasNextLine()) {
                    line = scan.nextLine();
                    if(!line.isEmpty()) {
                        calorieSum += Integer.parseInt(line);
                    }
                }
                if(calorieSum != 0) {
                    calories.add(calorieSum);
                }

            }

        } catch(IOException e) {
            System.out.println("File not Found!");
        }


            for(int i = 0; i < 3; i++) {
                highestCalories = -1;
                highestIndex = -1;
                for(int x = 0; x < calories.size(); x++) {
                    if (calories.get(x) >= highestCalories) {
                        highestCalories = calories.get(x);
                        highestIndex = x;
                    }
                }
                topCalories.add(calories.get(highestIndex));
                calories.remove(highestIndex);
            }

        System.out.println(topCalories.get(0)+topCalories.get(1)+topCalories.get(2));



    }
}