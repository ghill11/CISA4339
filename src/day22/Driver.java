package day22;

public class Driver {

	public static void main(String[] args) {
		System.out.println("****************************** Stack ******************************");
		Stack stack = new Stack(1); // can change to use other underlying concrete data structures
		stack.push("Jeff");
		stack.push("Brigid");
		stack.push("Mike");
		stack.push("Steven");
		stack.push("Joe");
		stack.push("Mike");
		stack.push("Overwrite!");
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()){
			sb.append(stack.pop()).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		
		System.out.println("****************************** Queue ******************************");
		Queue queue = new Queue(1); // can change to use other underlying concrete data structures
		queue.offer("Jeff");
		queue.offer("Brigid");
		queue.offer("Mike");
		queue.offer("Steven");
		queue.offer("Joe");
		queue.offer("Mike");
		queue.offer("Overwrite!");
		sb = new StringBuilder();
		while (!queue.isEmpty()){
			sb.append(queue.poll()).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
		
		System.out.println("****************************** Priority Queue ******************************");
		PriorityQueue pq = new PriorityQueue(1); // can change to use other underlying concrete data structures
		// the number at the end indicates "rank" which is used to prioritize and order the elements
		pq.offer(new Faculty("Jeff","Hill",2));
		pq.offer(new Faculty("Brigid","Appiah Otoo",3));
		pq.offer(new Faculty("Mike","Casey",3));
		pq.offer(new Faculty("Tom","Snyder",2));
		pq.offer(new Faculty("Steven","Zeltmann",3));
		pq.offer(new Faculty("Joe","Thomas",3));
		pq.offer(new Faculty("Michael","Hargis",1));
		pq.offer(new Faculty("Mike","Ellis",3));
		pq.offer(new Faculty("Stephanie","Watson",2));
		sb = new StringBuilder();
		while (!pq.isEmpty()){
			sb.append(pq.poll()).append(",");
		} // end for
		System.out.println(sb.toString().substring(0,sb.toString().length()-1));
	} // end main
} // end Driver