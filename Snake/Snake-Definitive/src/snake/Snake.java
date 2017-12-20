package snake;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

//Main class from the project that creates && runs the game
public class Snake implements ActionListener, KeyListener
{
	//Declaration and initialization of variables
	public static Snake snake;

	public JFrame jframe;

	public RenderPanel renderPanel;

	public Timer timer = new Timer(20, this);

	public ArrayList<Point> snakeParts = new ArrayList<Point>();

	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SCALE = 10;

	public int ticks = 0, direction = DOWN;

	public static int score;

	public static int tailLength;

	public int time;

	public Point head, cherry;

	public static Random random;

	public boolean over, paused;

	public Dimension dim;
	
	//Class Constructor
	public Snake() {
		
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		jframe = new JFrame("Snake");
		jframe.setVisible(true);
		jframe.setSize(805, 700);
		jframe.setResizable(false);
		jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
		jframe.add(renderPanel = new RenderPanel());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.addKeyListener(this);
		startGame();
	}
	
	public void startGame() {
		
		over = false;
		paused = false;
		time = 0;
		score = 0;
		tailLength = 1;
		ticks = 0;
		direction = DOWN;
		head = new Point(0, -1);
		random = new Random();
		snakeParts.clear();
		cherry = new Point(random.nextInt(79), random.nextInt(66));
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {	
		//function that reacts according to the players action (movement)
		renderPanel.repaint();
		ticks++;
		head = checkDirection(snakeParts, head, ticks, paused, direction);
		//checkDirection(ticks, over, paused);
		boolean valid = checkCherry(head,cherry);		
		if (valid) {
			setCherry(cherry);
		}
	}
	//public void checkDirection(int ticks, boolean over, boolean paused) {
	public Point checkDirection(ArrayList<Point> snakeParts, Point head, int ticks,boolean paused, int direction) {
		
		//checks the direction of the snake and moves it accordingly
		if (ticks % 2 == 0 && head != null && !over && !paused) {
			time++;
			snakeParts.add(new Point(head.x, head.y));			
			if (direction == UP) {
				if (head.y - 1 >= 0 && noTailAt(head.x, head.y - 1,snakeParts)) {
					head = new Point(head.x, head.y - 1);					
				} else {
					over = true;
				}
			}
			if (direction == DOWN) {
				if (head.y + 1 < 67 && noTailAt(head.x, head.y + 1,snakeParts)) {
					head = new Point(head.x, head.y + 1);					
				} else {
					over = true;
				}
			}
			if (direction == LEFT) {
				if (head.x - 1 >= 0 && noTailAt(head.x - 1, head.y,snakeParts)) {
					head = new Point(head.x - 1, head.y);
				} else {
					over = true;
				}
			}
			if (direction == RIGHT)	{
				if (head.x + 1 < 80 && noTailAt(head.x + 1, head.y,snakeParts)) {
					head = new Point(head.x + 1, head.y);
				} else {
					over = true;
				}
			}
			if (snakeParts.size() > tailLength) {
				snakeParts.remove(0);
			}			
		}
		return head;
	}
	public  static void setCherry (Point cherry) {
		
		score += 10;
		tailLength++;
		cherry.setLocation(random.nextInt(79), random.nextInt(66));
		
	}
	public static boolean checkCherry(Point head, Point cherry) {
		
		if (cherry != null)	{
			if (head.equals(cherry)) {	
				return true;
			}
		}
		return false;
	}
	public boolean noTailAt(int x, int y, ArrayList<Point> snakeParts) {
		
		for (Point point : snakeParts) {
			if (point.equals(new Point(x, y))) {
				System.out.println("The snake collided");
				return false;
			}
			System.out.println("The snake ain't colliding");
		}
		return true;
	}

	public static void main(String[] args) {
		
		snake = new Snake();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int i = e.getKeyCode();

		if ((i == KeyEvent.VK_A || i == KeyEvent.VK_LEFT) && direction != RIGHT) {
			direction = LEFT;
		}

		if ((i == KeyEvent.VK_D || i == KeyEvent.VK_RIGHT) && direction != LEFT) {
			direction = RIGHT;
		}

		if ((i == KeyEvent.VK_W || i == KeyEvent.VK_UP) && direction != DOWN) {
			direction = UP;
		}

		if ((i == KeyEvent.VK_S || i == KeyEvent.VK_DOWN) && direction != UP) {
			direction = DOWN;
		}

		if (i == KeyEvent.VK_SPACE) {
			if (over) {
				startGame();
			} else {
				paused = !paused;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

}
