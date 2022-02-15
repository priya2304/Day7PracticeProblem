public class GamblingSituationProblem {
    /*
    Use case 1
    */
    public static final int INITIAL_BET_STAKE = 100;
    public static final int BET_AMT = 1;

    /*
    Use Case 2
    */
    public void gamblingSituationProblemUC2() {
        double random_num = Math.random();
        int remg_amt = INITIAL_BET_STAKE;
        if (random_num > 0.5) {
            remg_amt += BET_AMT;
            System.out.println("The Gambler wins the bet and he has $"
                    + remg_amt + " with him after one bet.");
        } else if (random_num <= 0.5) {
            remg_amt -= BET_AMT;
            System.out.println("The Gambler loses the bet and he has $"
                    + remg_amt + " with him after one bet.");
        }
    }

    /*
    Use case 3
    */
    public void gamblingSituationProblemUC3(int margin_perct) {
        double uppr_margin = INITIAL_BET_STAKE + margin_perct * INITIAL_BET_STAKE / 100;
        double lowr_margin = INITIAL_BET_STAKE - margin_perct * INITIAL_BET_STAKE / 100;
        double avail_amt = INITIAL_BET_STAKE;
        while ((avail_amt < uppr_margin) && (avail_amt > lowr_margin)) {
            double random_num = Math.random();
            if (random_num > 0.5) {
                avail_amt += BET_AMT;
            } else if (random_num <= 0.5) {
                avail_amt -= BET_AMT;
            }
        }
        System.out.println("The gambler resigns for the day after he has $"
                + avail_amt + " with him.");
    }

    /*
    Use case 4
    */
    public void gamblingSituationProblemUC4() {
        // Assume 100 bets played every day
        int NO_OF_BETS = 100;
        //margin = 50%
        double uppr_margin = 0.5 * INITIAL_BET_STAKE;
        double lowr_margin = -0.5 * INITIAL_BET_STAKE;
        double tot_amt_won_lost = 0;

        // Game played for 20 days
        for (int i = 0; i < 20; i++) {
            double daily_amt_won_lost = 0;
            int bets_played = 0;

            // Everyday game stops at 50% margin
            while ((daily_amt_won_lost < uppr_margin) && (daily_amt_won_lost > lowr_margin)
                    && (bets_played < NO_OF_BETS)) {
                double random_num = Math.random();
                bets_played++;

                if (random_num > 0.5) {
                    daily_amt_won_lost += BET_AMT;
                } else if (random_num <= 0.5) {
                    daily_amt_won_lost -= BET_AMT;
                }
            }
            tot_amt_won_lost += daily_amt_won_lost;
        }

        // Print total amount won or last in 20 days
        if (tot_amt_won_lost > 0) {
            System.out.println("The total amount won in 20 days = " + tot_amt_won_lost);
        } else if (tot_amt_won_lost == 0) {
            System.out.println("There is no net gain in last 20 days");
        } else if (tot_amt_won_lost < 0) {
            System.out.println("The total amount lost in last 20 days = " + Math.abs(tot_amt_won_lost));
        }
    }

    /*
    Use case 5
    */
    public void gamblingSituationProblemUC5() {
        // Assume 100 bets played every day
        int NO_OF_BETS = 100;
        //margin = 50%
        double uppr_margin = 0.5 * INITIAL_BET_STAKE;
        double lowr_margin = -0.5 * INITIAL_BET_STAKE;
        double tot_amt_won_lost = 0;
        // Game played for a month
        for (int i = 1; i < 31; i++) {
            double daily_amt_won_lost = 0;
            int bets_played = 0;

            // Everyday game stops at 50% margin or before 100 bets, whichever comes earlier
            while ((daily_amt_won_lost < uppr_margin) && (daily_amt_won_lost > lowr_margin)
                    && (bets_played < NO_OF_BETS)) {
                double random_num = Math.random();
                bets_played++;
                //check whether he wins or loses the bet
                if (random_num > 0.5) {
                    daily_amt_won_lost += BET_AMT;
                } else if (random_num <= 0.5) {
                    daily_amt_won_lost -= BET_AMT;
                }
            }

            // Print total amount won or last on this day
            if (daily_amt_won_lost > 0) {
                System.out.println("The amount won on day " + i + " = $" + daily_amt_won_lost);
            } else if (daily_amt_won_lost == 0) {
                System.out.println("There is no net gain or loss on day " + i);
            } else if (daily_amt_won_lost < 0) {
                System.out.println("The amount lost on day " + i + " = $" + Math.abs(daily_amt_won_lost));
            }
        }
    }

    /*
    Use case 6: Luckiest and unluckiest day
    */
    public void gamblingSituationProblemUC6() {
        // Assume 100 bets played every day
        int NO_OF_BETS = 100;
        //margin = 50%
        double uppr_margin = 0.5 * INITIAL_BET_STAKE;
        double lowr_margin = -0.5 * INITIAL_BET_STAKE;
        int luck_day = 0;
        double luck_day_amt = 0;
        int unluck_day = 0;
        double unluck_day_amt = 0;
        // Game played for a month
        for (int i = 1; i < 31; i++) {
            double daily_amt_won_lost = 0;
            int bets_played = 0;

            // Everyday game stops at 50% margin or before 100 bets, whichever comes earlier
            while ((daily_amt_won_lost < uppr_margin) && (daily_amt_won_lost > lowr_margin)
                    && (bets_played < NO_OF_BETS)) {
                double random_num = Math.random();
                bets_played++;
                //check whether he wins or loses the bet
                if (random_num > 0.5) {
                    daily_amt_won_lost += BET_AMT;
                } else if (random_num <= 0.5) {
                    daily_amt_won_lost -= BET_AMT;
                }
            }
            // Compare for the lucky and unlucky day
            if (luck_day_amt < daily_amt_won_lost) {
                luck_day_amt = daily_amt_won_lost;
                luck_day = i;
            }
            if (unluck_day_amt > daily_amt_won_lost) {
                unluck_day_amt = daily_amt_won_lost;
                unluck_day = i;
            }
        }
        // Print luckiest and unluckiest days and the amounts won or last on that day
        System.out.println("The luckiest day for gambler is " + luck_day +
                "th day, on which he won $" + luck_day_amt);
        System.out.println(" And the unluckiest day for gambler is " + unluck_day +
                "th day, on which he lost $" + Math.abs(unluck_day_amt));
    }

    /*
    Use case 7 : if wins should he play or not
    */
    public void gamblingSituationProblemUC7() {
        // Assume 100 bets played every day
        int NO_OF_BETS = 100;
        //margin = 50%
        double uppr_margin = 0.5 * INITIAL_BET_STAKE;
        double lowr_margin = -0.5 * INITIAL_BET_STAKE;
        double tot_amt_won_lost = 0;

        // Game played for 30 days
        for (int i = 1; i < 31; i++) {
            double daily_amt_won_lost = 0;
            int bets_played = 0;

            // Everyday game stops at 50% margin or if number of bets exceed 100
            while ((daily_amt_won_lost < uppr_margin) && (daily_amt_won_lost > lowr_margin)
                    && (bets_played < NO_OF_BETS)) {
                double random_num = Math.random();
                bets_played++;

                if (random_num > 0.5) {
                    daily_amt_won_lost += BET_AMT;
                } else if (random_num <= 0.5) {
                    daily_amt_won_lost -= BET_AMT;
                }
            }
            // total amount won or lost in a month
            tot_amt_won_lost += daily_amt_won_lost;
        }

        // If he has won in last month
        if (tot_amt_won_lost > 0) {
            // Whether he should play or not
            double random_num1 = Math.random();

            // He should play further
            if (random_num1 > 0.5) {
                System.out.println("The gambler has won $" + tot_amt_won_lost +
                        " last month and he should play in this month too");
            }
            // He should not play further
            else if (random_num1 <= 0.5) {
                System.out.println("The gambler has won $" + tot_amt_won_lost +
                        " last month and he should stop gambling now.");
            }
        }
        // If he has lost in last month
        else if (tot_amt_won_lost <= 0) {
            System.out.println("The gambler has lost in last month $"
                    + Math.abs(tot_amt_won_lost) +
                    " and to avoid further losses he should stop playing now.");
        }
    }

    // Main method
    public static void main(String[] args) {
        GamblingSituationProblem gsp = new GamblingSituationProblem();
        gsp.gamblingSituationProblemUC7();
    }
}
