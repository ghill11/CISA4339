package day18;

public class CoordinatedSynchronizedSpeedGame implements Runnable {
	private final String word;
	private final int myTurn;
	private Ball obj;
	
	public CoordinatedSynchronizedSpeedGame(String word, int myTurn, Ball obj) {
		this.word = word;
		this.myTurn = myTurn;
		this.obj = obj;
	} // end ctor
	
	@Override
	public void run() {
		synchronized(obj) {
			try {
				for (int i=0;i<5;i++) {
					while (!(obj.getValue() == this.myTurn)) {
						obj.wait(); // don't need the delay anymore using this mechanic 
					} // end while
					System.out.print(" " + word);
					obj.setValue(obj.getValue() == 1 ? 2 : 1);
					obj.notifyAll();
				} // end for
			} catch (Exception e) {
				e.printStackTrace();
			} // end catch
		} //end synchronized
	} // end run
} // end CoordinatedSynchronizedSpeedGame