/**
 * Here is a program to create a default channel.
 *
 * @author: zhouych
 *
 * @date: 2008/11/21
 *
 * @since: JDK 1.6
 *
 * @see: 
 */
 
 package piano.player;
 
 import javax.sound.midi.MidiChannel;
 
 public class DefaultChannel {
 	
 	public static final int VELOCITY = 64;		// the speed with which the key was depressed
 	public static final int PRESSURE = 64;		// value for the specified key, from 0 to 127
 	public static final int BEND = 8192;		// the amount of pitch change, as a nonnegative 14-bit value (8192 = no bend)
 	public static final int REVERB = 64;
 	
 	public static final boolean isSolo = false;
 	public static final boolean isMono = false;
 	public static final boolean isMute = false;
 	//public static final boolean isSustain = false;
 	//public static final boolean isOmni = false;
 	
 	public MidiChannel channel = null;			// the MIDI channel
 	public int noteNumber;						// the MIDI note number, from 0 to 127 (60 = Middle C)
 	
 	public DefaultChannel(MidiChannel channel, int noteNumber) {
 		
 		this.channel = channel;
 		this.noteNumber = noteNumber;
 	}
 }