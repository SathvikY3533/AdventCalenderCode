import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        //part1();
        part2();
    }

    public static void part1() {
        Scanner scan = null;
        int prioritySum = 0;
        char priorityLetter = ' ';
        try {
            scan = new Scanner(new File("day3.txt"));
            while (scan.hasNextLine()) {
                String firstHalf = "";
                String secondHalf = "";
                String ogLine = scan.nextLine();
                for (int i = 0; i < ogLine.length() / 2; i++) {
                    firstHalf += "" + ogLine.charAt(i);
                }
                for (int i = ogLine.length() / 2; i < ogLine.length(); i++) {
                    secondHalf += "" + ogLine.charAt(i);
                }


                for (int f = 0; f < firstHalf.length(); f++) {
                    if (secondHalf.indexOf(firstHalf.charAt(f) + "") != -1) {
                        priorityLetter = firstHalf.charAt(f);
                    }
                }

                if (isAlpha(priorityLetter)) {
                    prioritySum += priorityLetter - 64 + 26;
                } else {
                    prioritySum += priorityLetter - 96;
                }

            }
            System.out.println(prioritySum);

        } catch (IOException e) {
            System.out.println("File not Found!");
        }
    }

    public static void part2() {
        Scanner scan = null;
        int prioritySum = 0;
        try {
            scan = new Scanner(new File("day3.txt"));
            while(scan.hasNextLine()) {
                char priorityLetter = ' ';
                String firstLine = "";
                String secondLine = "";
                String thirdLine = "";

                firstLine = scan.nextLine();
                if(scan.hasNextLine()) {
                    secondLine = scan.nextLine();
                    if(scan.hasNextLine()) {
                        thirdLine = scan.nextLine();
                    }
                }


                for (int f = 0; f < firstLine.length(); f++) {
                    if (secondLine.indexOf(firstLine.charAt(f) + "") != -1 && thirdLine.indexOf(firstLine.charAt(f)+"") != -1) {
                        priorityLetter = firstLine.charAt(f);
                    }
                }

                if(isAlpha(priorityLetter)) {
                    prioritySum += priorityLetter-64+26;
                } else if(!(priorityLetter+"").equals(" ")) {
                    prioritySum += priorityLetter-96;
                }

            }
            System.out.println(prioritySum);

        } catch(IOException e) {
            System.out.println("File not Found!");
        }
    }

    public static boolean isAlpha(char name) {
        return (name+"").matches("[A-Z]+");
    }
}
