import java.util.Scanner;
import java.security.SecureRandom;

public class Part1 {

    static boolean gameOfOperation (String type, int ans, int int1, int int2){
        boolean result = false;
        switch(type){
            case "+":
                result = (ans == int1 + int2);
            case "-":
                result = (ans == int1 - int2);
            case "*":
                result = (ans == int1 * int2);
            case "/":
                result = (ans == int1 / int2);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        SecureRandom rand = new SecureRandom();

        int numCorrect = 0;
        double percentScore = 0;
        int difficulty;
        String realOp = "+";

        while(true) {

            System.out.println("Enter your difficulty level. (Enter a digit between 1 and 4)");
            difficulty = scan.nextInt();
            int maxRange = 0;
            int lowRange = 0;

            System.out.println("Enter the type of problem you want to solve.");
            System.out.println("Enter 1 for addition, 2 for subtraction, 3 for multiplication, 4 for division, and 5 for all five.)");
            int probType = 0;
            probType = scan.nextInt();

            if(difficulty >= 1 && difficulty <= 4) {
                switch (difficulty) {
                    case 1:
                        maxRange = 9;
                        lowRange = 0;
                        break;
                    case 2:
                        maxRange = 99;
                        lowRange = 10;
                        break;
                    case 3:
                        maxRange = 999;
                        lowRange = 100;
                        break;
                    case 4:
                        maxRange = 9999;
                        lowRange = 1000;
                        break;
                }
            }
            else{
                System.out.println("C'mon, man! Enter a difficulty level within the range!");
                System.out.println("(Enter a digit between 1 and 4)");
                difficulty = scan.nextInt();
            }


            for (int i = 0; i < 10; i++) {
                int int1 = rand.nextInt((maxRange - lowRange)) + lowRange;
                int int2 = rand.nextInt((maxRange - lowRange)) + lowRange;

                if(probType >= 1 && probType <= 5){
                    switch (probType){
                        case 1:
                            realOp = "+";
                            break;
                        case 2:
                            realOp = "-";
                            break;
                        case 3:
                            realOp = "*";
                            break;
                        case 4:
                            realOp = "/";
                            break;
                        case 5:
                            int random = rand.nextInt(3);
                            if(random == 0){
                                realOp = "+";
                            }
                            if(random == 1){
                                realOp = "-";
                            }
                            if(random == 2){
                                realOp = "*";
                            }
                            if(random == 3){
                                realOp = "/";
                            }
                            break;
                    }
                }

                System.out.println("How much is " + int1 + realOp + int2 + "?");
                int kidsAns = scan.nextInt();

                if (Part1.gameOfOperation(realOp, kidsAns, int1, int2)) {
                    numCorrect = numCorrect + 1;
                    int yesAns = rand.nextInt(3);
                    switch (yesAns) {
                        case 0:
                            System.out.println("Very good!");
                            break;
                        case 1:
                            System.out.println("Excellent!");
                            break;
                        case 2:
                            System.out.println("Nice work!");
                            break;
                        case 3:
                            System.out.println("Keep up the good work!");
                            break;
                    }
                }
                else {
                    int noAns = rand.nextInt(4);
                    switch (noAns) {
                        case 0:
                            System.out.println("No. Please try again.");
                            break;
                        case 1:
                            System.out.println("Wrong. Try once more.");
                            break;
                        case 2:
                            System.out.println("Don’t give up!");
                            break;
                        case 3:
                            System.out.println("No. Keep trying.");
                            break;
                    }
                }
            }
            percentScore = (Double.valueOf(numCorrect) / 10);
            if (percentScore >= 0.75) {
                System.out.println("Your score is: " + (percentScore * 100) + "%.");
                System.out.println("Congratulations, you are ready to go to the next level!");
            } else {
                System.out.println("Your score is: " + (percentScore * 100) + "%.");
                System.out.println("Please ask your teacher for extra help.");
            }
        }
    }
}