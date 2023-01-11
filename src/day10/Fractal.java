package day10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class Fractal extends JPanel {
	// T is type returned by doInBackground(), done(), and get()
	// V is the type used for intermediate results during publish() and process() methods
	// https://www.codementor.io/@isaib.cicourel/swingworker-in-java-du1084lyl
	private class Task extends SwingWorker<Void, List<Integer>> {
		private JPanel parent;
		private int maxLevels, x, y, angle, currentDepth;
		private final int LINE_LENGTH_STANDARD = 200;
		private final int DELAY = 25; // milliseconds
		
		public Task (JPanel parent, int maxLevels, int x, int y, int angle, int currentDepth) {
			this.parent = parent;
			this.maxLevels = maxLevels;
			this.x = x;
			this.y = y;
			this.angle = angle;
			this.currentDepth = currentDepth;
		} // end 

		@Override
		protected Void doInBackground() throws Exception {
	        if(currentDepth > maxLevels) { 
	        	return null;
	        } // end if
	        int x2 = x + (int) (Math.cos(Math.toRadians(angle)) * (LINE_LENGTH_STANDARD/currentDepth));
	        int y2 = y + (int) (Math.sin(Math.toRadians(angle)) * (LINE_LENGTH_STANDARD/currentDepth));
	        List<Integer> line = Arrays.asList(x,y,x2,y2,rng.nextInt(0xFFFFFF));
	        publish(line); // publishes intermediate object for use by .process()
	        try {
	        	Thread.sleep(DELAY); //delay
	        } catch (InterruptedException ex) { ex.printStackTrace();}
	        currentDepth++;
	        new Task(parent, maxLevels, x2, y2, angle-20, currentDepth ).execute();
	        new Task(parent, maxLevels, x2, y2, angle+20, currentDepth ).execute();
			return null;
		} // end doInBackground
		
		@Override
		protected void process(List<List<Integer>> chunk) { // the V type is nested inside a List
			synchronized (Leaf.getInstance()){
				int leafID = Leaf.getInstance().getNewLeafID();
				for (List<Integer> eachOne: chunk) {
					lines.put(leafID++, eachOne); // leafID needs to be unique for the Map, using singleton for thread-safety
				} // end for
			} // end synchronized
			parent.repaint();
		} // end process
	} // end Task
	
	private static final long serialVersionUID = 1L;
	private final int levels;
	private final int height;
	private final int width;
	private final int WINDOW_SIZE = 1000;
	Map<Integer,List<Integer>> lines = new HashMap<Integer,List<Integer>>();
	private Random rng = new Random();

	public Fractal(String inc) throws Exception {
		super();
		NumberFormat nf = NumberFormat.getIntegerInstance();
		this.levels = nf.parse(inc).intValue();
		this.height = WINDOW_SIZE;
		this.width = WINDOW_SIZE;
		initComponents();
	} // end ctor
	
	private void initComponents() {
        JFrame frame = new JFrame();
		frame.setTitle("Fractal");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setContentPane(this);
		frame.pack();
		frame.setVisible(true);
        new Task(this, levels, width/2, height-height/4, -90, 1).execute(); // -90 is straight up, 0 points to the right
	} // end initComponents
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (List<Integer> eachOne: lines.values()) {
            g.setColor(new Color(eachOne.get(4)));
            g.drawLine(eachOne.get(0), eachOne.get(1), eachOne.get(2), eachOne.get(3));        	
        } // end for
    } // end paintComponent
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    } // end getPreferredSize
} // end Fractal

class Leaf {
	private int leafID;
	private static volatile Leaf obj;
	
	private Leaf() {
		this.leafID = 1;
	} // end ctor
	
	public static Leaf getInstance() {
		if (obj == null) {
			synchronized (Leaf.class) {
				if (obj==null) {
					obj = new Leaf();
				} // end if
			} // end synchronized
		} // end if
		return obj;
	} // end getInstance
	
	public int getNewLeafID() {
		return this.leafID++;
	} // end getLeafID
} // end Leaf