package day17;

public class CoordinatedSynchronizedSpeedGame implements Runnable {
	private final String word;
	private Ball obj;
	
	public CoordinatedSynchronizedSpeedGame(String word, Ball obj) {
		this.word = word;
		this.obj = obj;
	} // end ctor
	
	@Override
	public void run() {
		synchronized(obj) {
			try {
				for (int i=0;i<5;i++) {
					while (!obj.getValue().equalsIgnoreCase(this.word)) {
						obj.wait(); // don't need the delay anymore using this mechanic 
					} // end while
					System.out.print(" " + word);
					obj.setValue(obj.getValue().equalsIgnoreCase("ping")? "pong" : "ping");
					obj.notifyAll();
				} // end for
			} catch (Exception e) {
				e.printStackTrace();
			} // end catch
		} //end synchronized
	} // end run
} // end CoordinatedSynchronizedSpeedGame