package day22;

import java.util.Random;

public class QueuedGeneratorAndServer {

	private class Generator implements Runnable {
		Random rng = new Random();
		String[] fillNames = new String[] {"Grace","Jim","Jeff","Tali","Steve","Ada","Sam","Jennifer","Anne","Mike"};
		Queue queue;

		public Generator(Queue queue) {
			this.queue = queue;
		} // end ctor
		
		@Override
		public void run() {
			for (String name: fillNames) {
				queue.offer(name);
				System.out.println(name + " has arrived and is waiting in line.");
				try {
					Thread.sleep(rng.nextInt(1000,2500));
				} catch (Exception e) {
					e.printStackTrace();
				} // end catch
			} // end for
		} // end run
	} // end Generator
	
	private class Server implements Runnable {
		Random rng = new Random();
		private Queue queue;
		
		public Server(Queue queue) {
			this.queue = queue;
		} // end ctor
		
		@Override
		public void run() {
			while(true) {
				String name = "queue is empty!";
				if (!queue.isEmpty()) {
					name = queue.poll();
				} // end if
				System.out.println("Now serving customer: " + name);
				try {
					Thread.sleep(rng.nextInt(1000,5000));
				} catch (Exception e) {
					e.printStackTrace();
				} // end catch				
			} // end while
		} // end run
	} // end Server
	
	public static void main(String[] args) {
		Queue queue = new Queue(1);
		Thread generator = new Thread(new QueuedGeneratorAndServer().new Generator(queue));
		Thread server = new Thread(new QueuedGeneratorAndServer().new Server(queue));
		generator.start();
		server.start();
	} // end main
} // end QueuedGeneratorAndServer