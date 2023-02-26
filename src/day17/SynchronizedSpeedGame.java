package day17;

public class SynchronizedSpeedGame implements Runnable {			
		private final String word;
		private final Object obj;
		
		public SynchronizedSpeedGame(String word, Object obj) {
			this.word = word;
			this.obj = obj;
		} // end ctor
		
		@Override
		public void run() {
			synchronized(obj) {
				try {
					for (int i=0;i<5;i++) {
						System.out.print(" " + word);
						obj.notifyAll();
						obj.wait(10); // use wait(10) so last cycle of last thread doesn't hang indefinitely
					} // end for
				} catch (Exception e) {
					e.printStackTrace();
				} // end catch
			} //end synchronized
		} // end run
} // end SynchronizedSpeedGame