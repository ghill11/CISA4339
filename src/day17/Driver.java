package day17;

public class Driver {

	public static void main(String[] args) {
		try {
			System.out.println("******** THREADED BUT TOO FAST TO SEE DETAILS OTHER THAN WRONG... ********");
			Thread ping = new Thread(new Game("ping"));
			Thread pong = new Thread(new Game("pong"));
			ping.start();
			pong.start();
			ping.join();
			pong.join();
			System.out.println();

			System.out.println("******** THREADED BUT UNSYNCHRONIZED ******** (will double up sometimes)");
			ping = new Thread(new SpeedGame("ping",1));
			pong = new Thread(new SpeedGame("pong",1));
			ping.start();
			pong.start();
			ping.join();
			pong.join();
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} // end catch
	} // end main
} // end Driver