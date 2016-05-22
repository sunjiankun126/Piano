/**
 * Here is a program to create a virtual piano
 *
 * @author: zhouych
 *
 * @date: 2008/11/20
 * 
 * @since: JDK 1.6
 *
 * @see: PianoPanel.java DefaultChannel.java
 */
 
 package piano.player;
 
 import java.io.IOException;
 import java.net.URL;
 import java.awt.Toolkit;
 import java.awt.Dimension;
 import java.awt.event.WindowEvent;
 import java.awt.event.WindowAdapter;
 import javax.swing.JPanel;
 import javax.swing.JFrame;
 import javax.swing.ImageIcon;
 import javax.sound.midi.Instrument;
 import javax.sound.midi.MidiChannel;
 import javax.sound.midi.MidiSystem;
 import javax.sound.midi.Sequence;
 import javax.sound.midi.Sequencer;
 import javax.sound.midi.Soundbank;
 import javax.sound.midi.Synthesizer;
 import javax.sound.midi.MidiUnavailableException;
 import javax.sound.midi.InvalidMidiDataException;
 
 public class Piano extends JPanel {
 	
 	private static final int WIDTH = 800;
 	private static final int HEIGHT = 200;
 	
 	private Sequence sequence = null;
 	private Sequencer sequencer = null;
 	private Synthesizer synthesizer = null;
 	
 	private DefaultChannel[] channels;
 	public static DefaultChannel DC = null;		// to be used by class PianoKey
 	
 	private static ClassLoader loader;
 	private static PianoPanel pPanel;
 	
 	public Piano() {
 		setLayout(null);
 		setPreferredSize(new Dimension(WIDTH, HEIGHT));
 		initComponent();
 		initResource();
 	}
 	
 	private void initComponent() {
 		
 		loader = this.getClass().getClassLoader();
 		pPanel = new PianoPanel();
 		pPanel.setBounds((WIDTH - pPanel.KEYWIDTH * pPanel.WHITEKEYS) / 2, 50, pPanel.KEYWIDTH * pPanel.WHITEKEYS, pPanel.KEYHEIGHT);
 		this.add(pPanel);
 	}
 	/**
 	 * Initialize resource
 	 */
 	private void initResource() {
 		
 		try {
 			if (synthesizer == null) {
 				synthesizer = MidiSystem.getSynthesizer();
 				if (synthesizer == null) {
 					return ;
 				}
 			}
 			// Open device
 			synthesizer.open();
 			sequence = new Sequence(Sequence.PPQ, 10);
 			sequencer = MidiSystem.getSequencer();
 		} catch(MidiUnavailableException e1) {
 			// Offen happen
 		} catch(InvalidMidiDataException e2) {
 			//
 		}
 		
 		Soundbank sb = synthesizer.getDefaultSoundbank();
 		if (sb != null) {
 			Instrument[] instruments = sb.getInstruments();
 			// Get first instrument (Piano)
 			synthesizer.loadInstrument(instruments[0]);
 		}
 		MidiChannel[] midiChannels = synthesizer.getChannels();
 		if (midiChannels != null) {
 			channels = new DefaultChannel[midiChannels.length];
 			for (int i=0; i<channels.length; i++) {
 				channels[i] = new DefaultChannel(midiChannels[i], i);
 			}
 			// Get first channel
 			DC = channels[0];
 		}
 		
 	}
 	
 	public static void main(String[] args) {
 		
 		Piano piano = new Piano();
        JFrame jf = new JFrame();

        URL iconURL = loader.getResource("piano/pic/icon.png");
        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);
            jf.setIconImage(icon.getImage());
        }

        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { 
            	System.exit(0); 
            }
        });
        jf.getContentPane().add(piano);
        jf.setResizable(false);
        jf.setSize(WIDTH, HEIGHT);
        jf.setTitle("VirtualPiano");
        jf.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 		Dimension frameSize = jf.getSize();
 		jf.setLocation(
 			(screenSize.width - frameSize.width) / 2,
 			(screenSize.height - frameSize.height) / 2
 			);
        jf.setVisible(true);       
    }
 }