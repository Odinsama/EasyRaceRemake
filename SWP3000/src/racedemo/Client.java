package racedemo;


import static racedemo.ClientTester.ITER_PER_THREAD;

class Client {

	private Thread clientThread;

	Client(ClientTester caller) {
		clientThread = new Thread(() -> {
				for (int i = 1; i <= ITER_PER_THREAD; i++) {
					caller.increment(this);
				}
		});
		clientThread.start();
	}

	Thread getClientThread() {
		return clientThread;
	}

	@Override
	public String toString() {
		return clientThread.getName();
	}
}
