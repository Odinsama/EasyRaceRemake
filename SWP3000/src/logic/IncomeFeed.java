package logic;

import static java.lang.Thread.sleep;


class IncomeFeed {

    private final int AVERAGE_INCOME = 10;
    private int totalBudget;
    private Thread incomeThread;

	IncomeFeed(Account account, int totalIncome) {
		totalBudget = totalIncome;
		incomeThread = new Thread(() -> {
            while (totalBudget >0) {
                try {
                    sleep(1000); // fast inntekt hvert sekund
                } catch (InterruptedException ignored) {}
                totalBudget -= AVERAGE_INCOME;
                account.earn(AVERAGE_INCOME);
            }
        });
		incomeThread.start();
	}

    Thread getIncomeThread() {
        return incomeThread;
    }
}
