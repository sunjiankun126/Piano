/**
 * Here is a frame of a piano, it includes 42 white keys and 30 black keys.
 *
 * @author: zhouych
 *
 * @date: 2008/11/21
 *
 * @since: JDK 1.6
 *
 * @see: PianoKey.java 
 */
 
 package piano.player;
 
 import java.util.Vector;
 import java.awt.Color;
 import java.awt.Dimension;
 import java.awt.Graphics;
 import java.awt.Graphics2D;
 import java.awt.BorderLayout;
 import java.awt.event.KeyEvent;
 import java.awt.event.KeyListener;
 import java.awt.event.MouseEvent;
 import java.awt.event.MouseListener;
 import java.awt.event.MouseMotionAdapter;
 import javax.swing.JPanel;
 
 public class PianoPanel extends JPanel implements MouseListener, KeyListener {
 	
 	public final int KEYWIDTH = 18;
 	public final int KEYHEIGHT = 100;
 	public final int WHITEKEYS = 42;
 	private final int BLACKKEYS = 30;
 	
 	Vector<PianoKey> keys;	
 	Vector<PianoKey> blackKeys;
 	Vector<PianoKey> whiteKeys;
 	
 	private PianoKey prevKey;
 	
 	public PianoPanel() {
 		
 		setLayout(new BorderLayout());
 		setPreferredSize(new Dimension(KEYWIDTH*WHITEKEYS, KEYHEIGHT));
 		initResource();
 		setFocusable(true);
 	}
 	
 	/**
 	 * Initialize resources
 	 */
 	private void initResource() {
 		
 		keys = new Vector<PianoKey>();
 		blackKeys = new Vector<PianoKey>();
 		whiteKeys = new Vector<PianoKey>();
 		
 		int transpose = 24;
 		int[] whiteNumber = {0, 2, 4, 5, 7, 9, 11};
 		int[] blackNumber = {1, 3, 6, 8, 10};
 		
 		//int[] whiteNumber = {0, 2, 4, 6, 8, 10, 12};
 		//int[] blackNumber = {1, 3, 5, 7, 9};
 		
 		// Add white keys
 		for (int i=0, x=0; i<6; i++) {
 			for (int j=0; j<7; x+=KEYWIDTH, j++) {
 				int keyNoteNumber = 12 * i + whiteNumber[j] + transpose;
 				whiteKeys.add(new PianoKey(x, 0, KEYWIDTH, KEYHEIGHT, keyNoteNumber));
 			}
 		}
 		// Add black keys
 		// NOTE: width of black key is 2/3 of white key
 		//       height of black key is 1/2 of white key
 		for (int i=0, x=KEYWIDTH*2/3; i<6; x+=KEYWIDTH*2, i++) {
 			int keyNoteNumber = 12 * i + transpose;
 			blackKeys.add(new PianoKey(x, 0, KEYWIDTH*2/3, KEYHEIGHT/2, keyNoteNumber+blackNumber[0]));
 			blackKeys.add(new PianoKey((x+=KEYWIDTH), 0, KEYWIDTH*2/3, KEYHEIGHT/2, keyNoteNumber+blackNumber[1]));
 			x += KEYWIDTH * 2;
 			blackKeys.add(new PianoKey(x, 0, KEYWIDTH*2/3, KEYHEIGHT/2, keyNoteNumber+blackNumber[2]));
 			blackKeys.add(new PianoKey((x+=KEYWIDTH), 0, KEYWIDTH*2/3, KEYHEIGHT/2, keyNoteNumber+blackNumber[3]));
 			blackKeys.add(new PianoKey((x+=KEYWIDTH), 0, KEYWIDTH*2/3, KEYHEIGHT/2, keyNoteNumber+blackNumber[4]));
 		}
 		
 		// Add all keys
 		// NOTE: Here we must add black keys first,
 		//       because when we travel the keys,
 		//       black keys are in higher priority.
 		keys.addAll(blackKeys);
 		keys.addAll(whiteKeys);
 				
 		// Add mouse over listener
 		addMouseMotionListener(new MouseMotionAdapter() {
 			public void mouseMoved(MouseEvent e) {
 				/*
 				PianoKey key = getPressedKey(e.getX(), e.getY());
 				if (prevKey!=null && prevKey!=key) {
 					prevKey.noteOff();
 				}
 				if (key!=null && prevKey!=key) {
 					key.noteOn();
 				}
 				prevKey = key;
 				repaint();
 				*/
 			}
 		});
 		
 		addKeyListener(this);
 		addMouseListener(this);	
 	}
 	
 	/**
 	 * @override
 	 */
 	public void keyPressed(KeyEvent e) {
 		int keyCode = e.getKeyCode();
 		switch (keyCode) {
 			case KeyEvent.VK_A:
 				prevKey = (PianoKey)keys.get(45);
 				break;
 			case KeyEvent.VK_B:
 				prevKey = (PianoKey)keys.get(46);
 				break;
 			case KeyEvent.VK_C:
 				prevKey = (PianoKey)keys.get(47);
 				break;
 			case KeyEvent.VK_D:
 				prevKey = (PianoKey)keys.get(48);
 				break;
 			case KeyEvent.VK_E:
 				prevKey = (PianoKey)keys.get(49);
 				break;
 			case KeyEvent.VK_F:
 				prevKey = (PianoKey)keys.get(50);
 				break;
 			case KeyEvent.VK_G:
 				prevKey = (PianoKey)keys.get(51);
 				break;
 			case KeyEvent.VK_F1:
 				prevKey = (PianoKey)keys.get(52);
 				break;
 			case KeyEvent.VK_F2:
 				prevKey = (PianoKey)keys.get(53);
 				break;
 			case KeyEvent.VK_F3:
 				prevKey = (PianoKey)keys.get(54);
 				break;
 			case KeyEvent.VK_F4:
 				prevKey = (PianoKey)keys.get(55);
 				break;
 			case KeyEvent.VK_F5:
 				prevKey = (PianoKey)keys.get(56);
 				break;
 			case KeyEvent.VK_F6:
 				prevKey = (PianoKey)keys.get(57);
 				break;
 			case KeyEvent.VK_F7:
 				prevKey = (PianoKey)keys.get(58);
 				break;
 			case KeyEvent.VK_0:
 				prevKey = (PianoKey)keys.get(59);
 				break;
 			case KeyEvent.VK_1:
 				prevKey = (PianoKey)keys.get(60);
 				break;
 			case KeyEvent.VK_2:
 				prevKey = (PianoKey)keys.get(61);
 				break;
 			case KeyEvent.VK_3:
 				prevKey = (PianoKey)keys.get(62);
 				break;
 			case KeyEvent.VK_4:
 				prevKey = (PianoKey)keys.get(63);
 				break;
 			case KeyEvent.VK_5:
 				prevKey = (PianoKey)keys.get(64);
 				break;
 			case KeyEvent.VK_6:
 				prevKey = (PianoKey)keys.get(65);
 				break;
 			case KeyEvent.VK_7:
 				prevKey = (PianoKey)keys.get(66);
 				break;
 			default:
 				prevKey = null;
 		}
 		if (prevKey != null) {
 			prevKey.noteOn();
 			repaint();
 		}
 	}
 	public void keyReleased(KeyEvent e) {
 		int keyCode = e.getKeyCode();
 		switch (keyCode) {
 			case KeyEvent.VK_A:
 				prevKey = (PianoKey)keys.get(45);
 				break;
 			case KeyEvent.VK_B:
 				prevKey = (PianoKey)keys.get(46);
 				break;
 			case KeyEvent.VK_C:
 				prevKey = (PianoKey)keys.get(47);
 				break;
 			case KeyEvent.VK_D:
 				prevKey = (PianoKey)keys.get(48);
 				break;
 			case KeyEvent.VK_E:
 				prevKey = (PianoKey)keys.get(49);
 				break;
 			case KeyEvent.VK_F:
 				prevKey = (PianoKey)keys.get(50);
 				break;
 			case KeyEvent.VK_G:
 				prevKey = (PianoKey)keys.get(51);
 				break;
 			case KeyEvent.VK_F1:
 				prevKey = (PianoKey)keys.get(52);
 				break;
 			case KeyEvent.VK_F2:
 				prevKey = (PianoKey)keys.get(53);
 				break;
 			case KeyEvent.VK_F3:
 				prevKey = (PianoKey)keys.get(54);
 				break;
 			case KeyEvent.VK_F4:
 				prevKey = (PianoKey)keys.get(55);
 				break;
 			case KeyEvent.VK_F5:
 				prevKey = (PianoKey)keys.get(56);
 				break;
 			case KeyEvent.VK_F6:
 				prevKey = (PianoKey)keys.get(57);
 				break;
 			case KeyEvent.VK_F7:
 				prevKey = (PianoKey)keys.get(58);
 				break;
 			case KeyEvent.VK_0:
 				prevKey = (PianoKey)keys.get(59);
 				break;
 			case KeyEvent.VK_1:
 				prevKey = (PianoKey)keys.get(60);
 				break;
 			case KeyEvent.VK_2:
 				prevKey = (PianoKey)keys.get(61);
 				break;
 			case KeyEvent.VK_3:
 				prevKey = (PianoKey)keys.get(62);
 				break;
 			case KeyEvent.VK_4:
 				prevKey = (PianoKey)keys.get(63);
 				break;
 			case KeyEvent.VK_5:
 				prevKey = (PianoKey)keys.get(64);
 				break;
 			case KeyEvent.VK_6:
 				prevKey = (PianoKey)keys.get(65);
 				break;
 			case KeyEvent.VK_7:
 				prevKey = (PianoKey)keys.get(66);
 				break;
 		}
 		if (prevKey != null) {
 			prevKey.noteOff();
 			repaint();
 		}
 	}
	public void keyTyped(KeyEvent e) {}
 	
 	
 	/**
 	 * @override
 	 */
 	public void mousePressed(MouseEvent e) {
 		prevKey = getPressedKey(e.getX(), e.getY());
 		if (prevKey != null) {
 			prevKey.noteOn();
 			repaint();
 		}
 	}
 	public void mouseReleased(MouseEvent e) {
 		if (prevKey == null) {
 			return ;
 		}
 		prevKey.noteOff();
 		repaint();
 	}
 	public void mouseExited(MouseEvent e) {
 		if (prevKey != null) {
 			prevKey.noteOff();
 			prevKey = null;
 			repaint();
 		}
 	}
 	public void mouseEntered(MouseEvent e) {}
 	public void mouseClicked(MouseEvent e) {}
 	
 	/**
 	 * Get the key which was pressed.
 	 *
 	 * @param the point of mouse click
 	 */
 	private PianoKey getPressedKey(int x, int y) {
 		
 		for (int i=0; i<keys.size(); i++) {
 			if (((PianoKey)keys.get(i)).contains(x, y)) {
 				return (PianoKey)keys.get(i);
 			}
 		}
 		// NOTE: Must be return something here
 		return null;
 	}
 	
 	/**
 	 * @override
 	 */
 	public void paint(Graphics g) {
 		
 		Graphics2D g2 = (Graphics2D)g;
 		// Clean screen
 		g2.setColor(Color.WHITE);
 		g2.fillRect(0, 0, getWidth(), getHeight());
 		
 		// Draw white keys
 		for (int i=0; i<whiteKeys.size(); i++) {
 			PianoKey key = (PianoKey)whiteKeys.get(i);
 			if (key.isNoteOn()) {
 				// Key was pressed, change color
 				g2.setColor(Color.LIGHT_GRAY);
 				g2.fill(key);
 			}
 			g2.setColor(Color.BLACK);
 			g2.draw(key);
 		}
 		// Draw black keys
 		for (int i=0; i<blackKeys.size(); i++) {
 			PianoKey key = (PianoKey)blackKeys.get(i);
 			if (key.isNoteOn()) {
 				// Key was pressed, change color
 				g2.setColor(Color.LIGHT_GRAY);
 				g2.fill(key);
 				g2.setColor(Color.BLACK);
 				g2.draw(key);
 			} else {
 				g2.setColor(Color.BLACK);
 				g2.fill(key);
 			}
 		}
 	} 	
 }