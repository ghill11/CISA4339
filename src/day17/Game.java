package day17;

public class Game implements Runnable {
	
	private final String word;
	
	public Game(String word) {
		this.word = word;
	} // end ctor
	
	@Override
	public void run() {
		for (int i=0;i<5;i++) {
			System.out.print(" " + word);			
		} // end for
	} // end run
} // end Game