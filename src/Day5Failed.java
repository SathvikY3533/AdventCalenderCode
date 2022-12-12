import java.io.File;
import java.io.IOException;
import java.util.*;

public class Day5Failed {
    public static void main(String[] args) {
        Scanner scan = null;
        ArrayList<Stack<String>> crates = new ArrayList<>();

//*******The sorted Stacks of crates are stores in arrayList************
        try {
            String line = "";
            int lineNum = 1;

            while(crates.size() < 9) {
                scan = new Scanner(new File("day5.txt"));
                Stack<String> columns = new Stack<>();
                if(scan.hasNextLine()) {
                    line = scan.nextLine();
                }
                for(int r = 0; r < line.length(); r++) {
                    if(lineNum < line.length()) {
                        if (isAlpha(line.charAt(lineNum) + "")) {
                            columns.add(0, line.charAt(lineNum) + "");
                        }
                    }

                    if(scan.hasNextLine()) {
                        line = scan.nextLine();
                    }
                }
                crates.add(columns);
                if(lineNum+4 < 34) {
                    lineNum += 4;
                }
            }
            System.out.println(crates.toString());


        } catch (IOException e) {
            System.out.println("File not Found!");
        }
//**********************************************************************

        String movesLine = "";
        int movesAmt = 0;
        int movesOg = 0;
        int movesNew = 0;
        int count = 1;
        int movesCount = 1;

        while(scan.hasNextLine()) {
            movesLine = scan.nextLine();
            count = 1;
            for(int i = 0; i < movesLine.length(); i++) {
                if(isNum(movesLine.charAt(i)+"")) {
                    if(count == 1 && i == 5) {
                        if(isNum(movesLine.charAt(i) + movesLine.charAt(i+1) + "")) {
                            movesAmt = Integer.parseInt(movesLine.charAt(i) + movesLine.charAt(i+1) + "");
                            System.out.println(movesLine.charAt(i) + movesLine.charAt(i+1));
                        } else {
                            movesAmt = Integer.parseInt(movesLine.charAt(i) + "");
                        }
                    } else if(count == 2) {
                        movesOg = Integer.parseInt(movesLine.charAt(i) + "");
                    } else if(count == 3) {
                        movesNew = Integer.parseInt(movesLine.charAt(i) + "");
                    }
                    count++;
                }
            }

            for(int i = 0; i < movesAmt; i++) {
                Stack<String> stack1 = new Stack<>(), stack2 = new Stack<>();
                if(!(movesOg-1 < 0 || movesOg-1 > crates.size() || movesNew-1 < 0 || movesNew-1 > crates.size())) {
                    stack1 = crates.get(movesOg-1);
                    stack2 = crates.get(movesNew-1);
                }

                String top = "";
                //save the top
                if (!stack1.isEmpty()) {
                    if(isAlpha(stack1.peek())) {
                        top = stack1.pop();
                        stack2.push(top);
                    }
                }
            }

            movesCount++;
        }

        System.out.println(crates.toString());


        System.out.println(movesAmt+" "+movesOg+" "+movesNew);

        System.out.println();
        System.out.println("------------------------------------------------------------");

        for(int i = 0; i < crates.size(); i++) {
            for(int i2 = 0; i2 < crates.get(i).size(); i2++) {
                System.out.print(crates.get(i).get(i2));
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------------");

        for(int i = 0; i < crates.size(); i++) {
            if(!crates.get(i).isEmpty()) {
                System.out.print(crates.get(i).peek());
            } else {
                System.out.print(" ");
            }
        }


    }

    public static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static boolean isNum(String name) {
        return name.matches("[0-9]+");
    }

}
