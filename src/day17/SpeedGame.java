package day17;

public class SpeedGame implements Runnable {
	
	private final String word;
	private final int delay;
	
	public SpeedGame(String word, int delay) {
		this.word = word;
		this.delay = delay;
	} // end ctor
	
	@Override
	public void run() {
		for (int i=0;i<5;i++) {
			System.out.print(" " + word);
			try {
				Thread.sleep(250 * this.delay);		
			} catch (Exception e) {
				e.printStackTrace();
			} // end catch
		} // end for
	} // end run
} // end SpeedGame
