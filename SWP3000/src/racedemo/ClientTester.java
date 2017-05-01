package racedemo;


import java.awt.Color;
import java.util.ArrayList;




public class ClientTester {

	private static final int COUNT_OF_THREADS = 150;
	static final int ITER_PER_THREAD = 10;
	private static final int SLEEP = 0;

	private int i = 0;
	private Color[] colors = new Color[ITER_PER_THREAD * COUNT_OF_THREADS];

	public ClientTester() {
		ArrayList<Thread> clientThreads = new ArrayList<>();
		for (int j = 0; j < COUNT_OF_THREADS; j++) {
			Client client = new Client(this);
			clientThreads.add(client.getClientThread());
		}
		for (Thread ct: clientThreads) {
			try {
				ct.join();
			} catch (Exception ignored) {}
		}		
		new ProofPane(colors);
	}
	
	 synchronized
	void increment(Object o) {
		colors[i] = Color.GREEN;
				try {
					Thread.sleep(SLEEP);
				} catch (Exception ignored) {}
		System.out.println(i +" "+o);
		i++;
	}
	 
}
