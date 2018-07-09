package de.unihd.prog2.threads;

public class Postbox {
	private String message;
	
	public void sendMessage(String message) {
		this.message = message;
	}
	
	public String receiveMessage() {
		String copy = null;
		copy = message;
		message = null;
		return copy;
	}

	public static void main(String[] args) {
		Postbox pb = new Postbox();
		Thread readerThread = new Thread(() -> {
			for (int i = 0; i < 500; i++) {
				System.out.println(pb.receiveMessage());
			}
		});

		Thread writerThread = new Thread(() -> {
			for (int i = 0; i < 500; i++) {
				String message = "Message " + Integer.toString(i + 1);
				pb.sendMessage(message);
			}
		});
		
		writerThread.start();
		readerThread.start();
		
		try {
			writerThread.join();
			readerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
