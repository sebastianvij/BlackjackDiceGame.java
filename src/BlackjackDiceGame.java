import java.util.*;

public class BlackjackDiceGame {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack with dice");
        System.out.println("Do you wish to play? y/n");

        //Random for at generere tilfældige tal
        Random random = new Random();
        //Scanner for at modtage input fra bruger
        Scanner scanner = new Scanner(System.in);

        //Læs brugerens input
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("y")) {
            runGame(scanner, random);
        } else if (userInput.equalsIgnoreCase("n")) {
            System.out.println("Maybe another time. Goodbye!");
        } else {
            System.out.println("Invalid input! Please type 'y' or 'n'.");
        }
    }

    public static void runGame(Scanner scanner, Random random) {
        int userTotalSum = 0;
        int machineTotalSum = 0;
        boolean keepPlaying = true;

        int userFirstRoll = random.nextInt(2, 13);
        int machineFirstRoll = random.nextInt(2, 13);
        userTotalSum += userFirstRoll;
        machineTotalSum += machineFirstRoll;
        System.out.println("You start out with: " + userTotalSum);

        //Spørg spilleren om de vil kaste terningerne igen
        while (keepPlaying) {
            System.out.println("Do you want to roll the dice again? y/n");
            String userInput = scanner.nextLine();

            //Hvis spilleren ønsker at kaste terningen igen
            if (userInput.equalsIgnoreCase("y")) {
                int userRollAgain = random.nextInt(2, 13);
                userTotalSum += userRollAgain;

                int machineRollAgain = random.nextInt(2, 13);
                machineTotalSum += machineRollAgain;

                System.out.println("You rolled a: " + userRollAgain);
                System.out.println("You now have: " + userTotalSum);

                //Hvis spilleren får blackjack eller spiller/machine buster, afsluttes spillet automatisk
                if (blackJack(userTotalSum) || bust(userTotalSum, machineTotalSum)) {
                keepPlaying = false;
                }
                //Hvis spilleren ikke ønsker at kaste terningen igen
                } else if (userInput.equalsIgnoreCase("n")) {
                    //Tjek om spilleren har vundet, tabt eller står lige med machine
                    checkScore(userTotalSum, machineTotalSum);
                    keepPlaying = false;
                } else {
                    System.out.println("Invalid input! Please type 'y' or 'n'.");
            }
        }
    }
    public static void checkScore(int userTotalSum, int machineTotalSum) {
        //Tjek om spilleren er sluttet med højere score end machine
        if (userTotalSum > machineTotalSum) {
            System.out.println("You win!");
            System.out.println("You got: "+userTotalSum);
            System.out.println("Machine got: "+machineTotalSum);
        //Tjek om machine er sluttet med højere score end spilleren
        } else if (userTotalSum < machineTotalSum) {
            System.out.println("Machine win!");
            System.out.println("You got: " +userTotalSum);
            System.out.println("Machine got: " +machineTotalSum);
        //Hvis hverken af disse udsagn er sande, bliver det en 'draw'
        } else {
            System.out.println("It's a draw!");
            System.out.println("You got: "+userTotalSum);
            System.out.println("Machine got: "+machineTotalSum);
        }
    }
    public static boolean bust(int userTotalSum, int machineTotalSum) {
        if (userTotalSum >21) {
            System.out.println("You have busted! Game over.");
            return true;
            }
        if (machineTotalSum >21) {
            System.out.println("Machine busted! You win.");
            return true;
            }
        return false;
    }
    public static boolean blackJack(int userTotalSum) {
        if (userTotalSum == 21) {
            System.out.println("Blackjack! You won.");
            return true;
        }
        return false;
    }
}