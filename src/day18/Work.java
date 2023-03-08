package day18;

public class Work implements Runnable {
	
	private final char payload;
	
	public Work(char inc) {
		this.payload = inc;
	} // end ctor
	
	@Override
	public void run() {
		try {
			Thread.sleep(new java.util.Random().nextInt(5000)+1); // simulate actual work taking time to execute
			System.out.println(Thread.currentThread().getName() + ": " + this.payload);
		} catch (Exception e) {
			e.printStackTrace();
		} // end catch
	} // end run
} // end Work