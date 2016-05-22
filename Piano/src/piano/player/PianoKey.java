/**
 * Here is a program that encapsulate something of a piano key.
 *
 * @author: zhouych
 *
 * @date: 2008/11/21
 *
 * @since: JDK 1.6
 *
 * @see: DefaultChannel.java
 */
 
 package piano.player;
 
 import java.awt.Rectangle;
 
 public class PianoKey extends Rectangle {
 	
 	private static int ON = 0;
 	private static int OFF = 1;
 	
 	private int noteState = OFF;	// state of key
 	private int noteNumber;			// note number of key
 	
 	private DefaultChannel channel;
 	
 	/**
 	 * Constructor
 	 * 
 	 * @param the x coordinate of upper-left of key
 	 * @param the y coordinate of upper-left of key
 	 * @param the width of key
 	 * @param the height of key
 	 * @param the note number of key
 	 */
 	public PianoKey(int x, int y, int width, int height, int noteNumber) {
 		super(x, y, width, height);
 		this.noteNumber = noteNumber;
 	}
 	
 	public boolean isNoteOn() {
 		return noteState==ON;
 	}
 	public boolean isNoteOff() {
 		return noteState==OFF;
 	}
 	
 	public void noteOn() {
 		
 		setNoteState(ON);
 		if (Piano.DC != null) {
 			DefaultChannel dc = Piano.DC;
 			dc.channel.noteOn(noteNumber, DefaultChannel.VELOCITY);
 		}
 	}
 	
 	public void noteOff() {
 		
 		setNoteState(OFF);
 		if (Piano.DC != null) {
 			DefaultChannel dc = Piano.DC;
 			dc.channel.noteOff(noteNumber, DefaultChannel.VELOCITY);
 		}
 	}
 	
 	private void setNoteState(int state) {
 		noteState = state;
 	}
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 