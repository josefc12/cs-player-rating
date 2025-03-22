package com.josefc12;

public class Main {

    public static void main(String[] args) {

        if (args.length == 1 && (args[0].equals("--help") || args[0].equals("-h"))) {
            printHelp();
            return;
        }

        if (args.length <= 0){
            System.out.println("Please provide arguments.");
            return;
        } else if (args.length < 9) {
            System.out.println("Please provide all 9 arguments.");
            return;
        }

        final double ROUNDS_TOTAL = Integer.parseInt(args[0]);
        final double KILLS_TOTAL = Integer.parseInt(args[1]);
        final double DEATHS_TOTAL = Integer.parseInt(args[2]);
        final double ADR_TOTAL = Integer.parseInt(args[3]);

        final double K_1_AMOUNT = Integer.parseInt(args[4]);
        final double K_2_AMOUNT = Integer.parseInt(args[5]);
        final double K_3_AMOUNT = Integer.parseInt(args[6]);
        final double K_4_AMOUNT = Integer.parseInt(args[7]);
        final double K_5_AMOUNT = Integer.parseInt(args[8]);

        final double TOTAL_KILLS_FROM_K = K_1_AMOUNT + (K_2_AMOUNT*2) + (K_3_AMOUNT*3) + (K_4_AMOUNT*4) + (K_5_AMOUNT*5);

        if ( TOTAL_KILLS_FROM_K < KILLS_TOTAL ) {
            System.out.println("Round kills don't add up to total kills!");
            return;
        } else if (TOTAL_KILLS_FROM_K > KILLS_TOTAL) {
            System.out.println("Round kills add up to more than the total kills!");
            return;
        }

        final double K_RATING = K_1_AMOUNT +
                (4 * K_2_AMOUNT) +
                (9 * K_3_AMOUNT) +
                (16 * K_4_AMOUNT) +
                (25 * K_5_AMOUNT);

        final double ROUNDS_SURVIVED = ROUNDS_TOTAL - DEATHS_TOTAL;

        final double AVERAGE_RMK = K_RATING / ROUNDS_TOTAL;
        final double AVERAGE_SPR = ROUNDS_SURVIVED /ROUNDS_TOTAL;
        final double AVERAGE_KPR = KILLS_TOTAL /ROUNDS_TOTAL;

        System.out.println("K_RATING: " + K_RATING);
        System.out.println("AVERAGE_RMK: " + AVERAGE_RMK);
        System.out.println("AVERAGE_SPR: " + AVERAGE_SPR);
        System.out.println("AVERAGE_KPR: " + AVERAGE_KPR);

        final double FINAL_RATING = (AVERAGE_KPR + (0.7 * AVERAGE_SPR) + AVERAGE_RMK + (ADR_TOTAL/100)) / 2.7;

        System.out.println(FINAL_RATING);

    }

    public static void printHelp() {
        System.out.println("Usage: java -jar cs-player-rating-1.0-SNAPSHOT.jar <ROUNDS_TOTAL> <ROUNDS_SURVIVED> <KILLS_TOTAL> <DEATHS_TOTAL> <K_1_AMOUNT> <K_2_AMOUNT> <K_3_AMOUNT> <K_4_AMOUNT> <K_5_AMOUNT>");
        System.out.println();
        System.out.println("Arguments:");
        System.out.println("  <ROUNDS_TOTAL>       Total number of rounds played.");
        System.out.println("  <KILLS_TOTAL>        Total number of kills made.");
        System.out.println("  <DEATHS_TOTAL>       Total number of deaths.");
        System.out.println("  <ADR_TOTAL>          Average damage per round.");
        System.out.println("  <K_1_AMOUNT>         Number of rounds with 1 kill.");
        System.out.println("  <K_2_AMOUNT>         Number of rounds with 2 kills.");
        System.out.println("  <K_3_AMOUNT>         Number of rounds with 3 kills.");
        System.out.println("  <K_4_AMOUNT>         Number of rounds with 4 kills.");
        System.out.println("  <K_5_AMOUNT>         Number of rounds with 5 kills.");
        System.out.println();
        System.out.println("Description:");
        System.out.println("This program calculates a player's rating based on their performance in a game.");
        System.out.println("It uses various metrics such as kills, deaths, rounds survived, and the number of kills in each round.");
        System.out.println();
        System.out.println("Example:");
        System.out.println("java -jar cs-player-rating-1.0-SNAPSHOT.jar 22 7 24 15 6 6 2 0 0");
    }
}