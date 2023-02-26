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

			System.out.println("******** THREADED AND SYNCHRONIZED ******** (won't double up, but will sometimes be backwards)");
			Ball ball = new Ball();
			ping = new Thread(new SynchronizedSpeedGame("ping",ball));
			pong = new Thread(new SynchronizedSpeedGame("pong",ball));
			ping.start();
			pong.start();
			ping.join();
			pong.join();
			System.out.println();
			
			System.out.println("******** COORDINATED, THREADED, AND SYNCHRONIZED ******** (will always work as intended)");
			Ball ball2 = new Ball("ping");
			ping = new Thread(new CoordinatedSynchronizedSpeedGame("ping",ball2));
			pong = new Thread(new CoordinatedSynchronizedSpeedGame("pong",ball2));
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