package logic;

import java.util.Random;

import static java.lang.Thread.sleep;

class ExpenseFeed {


	private int singleBudget;
	private Thread expenseThread;

	ExpenseFeed(Account account, int singularBudget) {
        Random random = new Random();
        singleBudget = singularBudget;
		expenseThread = new Thread(() -> {
			while (singleBudget > 0) {
				try {
					sleep(random.nextInt(1000)); // utgift oftere enn hvert sekund
				} catch (Exception ignored) {}
				int expense = Math.max(1, random.nextInt(singleBudget));
				singleBudget -= expense;
				account.spend(this, expense);
			}
        });
		expenseThread.start();
	}

	Thread getExpenseThread() {
		return expenseThread;
	}
}
