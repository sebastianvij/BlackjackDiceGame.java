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
            startGame(scanner, random);
        } else if (userInput.equalsIgnoreCase("n")) {
            System.out.println("Maybe another time. Goodbye!");
        } else {
            System.out.println("Invalid input! Please type 'y' or 'n'.");
        }
    }

    public static void startGame(Scanner scanner, Random random) {
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

            if (userInput.equalsIgnoreCase("y")) {
                int userRollAgain = random.nextInt(2, 13);
                userTotalSum += userRollAgain;
                int machineRollAgain = random.nextInt(2, 13);
                machineTotalSum += machineRollAgain;
                System.out.println("You rolled a: " + userRollAgain);
                System.out.println("You now have: " + userTotalSum);

                //Tjek om spilleren har fået præcis 21 (automatisk vind)
                if (userTotalSum == 21) {
                    System.out.println("Blackjack! You have won.");
                    keepPlaying = false; }

                //Tjek om spilleren har fået over 21 (automatisk tab)
                if (userTotalSum > 21) {
                    System.out.println("You have busted! Game over.");
                    keepPlaying = false; }

                //Tjek om maskinen har fået over 21 (automatisk vind)
                if (machineTotalSum > 21) {
                    System.out.println("Machine exceeded 21! You win.");
                    keepPlaying = false; }

                //Tjek om spilleren og maskinen har fået det samme
                if (userTotalSum == machineTotalSum) {
                    System.out.println("Draw! You both got the same sum");
                    keepPlaying = false; }

            } else if (userInput.equalsIgnoreCase("n")) {
                if (userTotalSum > machineTotalSum) {
                System.out.println("You win!");
                System.out.println("You got: "+userTotalSum);
                System.out.println("Machine got: "+machineTotalSum);
            } else {
                System.out.println("Machine win!");
                System.out.println("You got: " + userTotalSum);
                System.out.println("Machine got: " + machineTotalSum);
            }
            keepPlaying = false;
            } else {
                System.out.println("Invalid input! Please type 'y' or 'n'.");
            }
        }
    }
}