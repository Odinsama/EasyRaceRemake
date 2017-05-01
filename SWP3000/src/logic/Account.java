package logic;

import java.util.ArrayList;

public class Account {
	 
	private int balance = 0;
	private static final int USERS = 10;
	private static final int ONE_BUDGET = 11;
	private static final int TOTAL_INCOME = 100;
	private IncomeFeed incomeFeed;


	public Account() {
		ArrayList<Thread> expenseThreads = new ArrayList<>();
		incomeFeed = new IncomeFeed(this, TOTAL_INCOME);
		for (int i = 0; i< USERS; i++) {
			ExpenseFeed expense = new ExpenseFeed(this, ONE_BUDGET);
			expenseThreads.add(expense.getExpenseThread());
		}
		try {
			for (Thread t: expenseThreads) {
				t.join();
			}
		} catch (Exception ignored) {}

		System.out.println("Felles kasse = " + balance);
	}
	
	synchronized void spend(ExpenseFeed expense, int expenses) {
		while (balance - expenses < 0) {
            if (!incomeFeed.getIncomeThread().isAlive()){
                break;
            }
		    try {
			System.out.println(expense.getExpenseThread().getName() + " venter med " + expenses);
			wait();			
			} catch (Exception ignored) {}
		}		
		balance -= expenses;
		System.out.println(expense.getExpenseThread().getName()+" brukte " + expenses);
	}
	
	synchronized void earn(int income) {
		balance += income;
		System.out.println("Dustekassen = " + balance);
		notifyAll();
	}	

}
