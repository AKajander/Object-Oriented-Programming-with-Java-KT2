import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import java.awt.Button;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Label;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.InputEvent;
import javax.swing.JRadioButtonMenuItem;

public class TextEditorGui extends JFrame {

	private JPanel contentPane;
	AbstractButton editorPane = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEditorGui frame = new TextEditorGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TextEditorGui() {
		setTitle("Text Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser optionWindow = new JFileChooser();
				optionWindow.showOpenDialog(null);
				String row = "";
				String newFile = optionWindow.getSelectedFile().getAbsolutePath();
				
				try {
					
					File file = new File(newFile);
					Scanner reader = new Scanner(file);
					while (reader.hasNextLine()) {
						row += reader.nextLine()+"\n";
						System.out.println(row);
					}
				}
				
				catch (FileNotFoundException p) {
					System.out.println("File not found");
				}
				
				editorPane.setText(row);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mntmNewMenuItem.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFile.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser optionWindow = new JFileChooser();
				optionWindow.showSaveDialog(null);
				
				String newFile = optionWindow.getSelectedFile().getAbsolutePath();
				
				System.out.println("You are about to save a file: "+newFile);
				
				try {
					PrintWriter writer = new PrintWriter(newFile);
					String content = editorPane.getText();
					
					writer.println(content);
					
					writer.flush();
					writer.close();
				} catch (Exception e1) {
					System.out.println("Error occured while saving the file");
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(TextEditorGui.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Search");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content = editorPane.getText();
				content = content.toLowerCase();
				
				String search = "word";
				int index = content.indexOf(search);
				System.out.println("Index: "+index);
			}
		});
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mntmNewMenuItem_3.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		mnFile.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Quit");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mntmNewMenuItem_4.setIcon(new ImageIcon(TextEditorGui.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mnFile.add(mntmNewMenuItem_4);
		
		JMenu mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Font gallery");
		mntmNewMenuItem_5.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/javafx/scene/web/skin/FontColor_16x16_JFX.png")));
		mntmNewMenuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mnTools.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Image gallery");
		mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		mntmNewMenuItem_6.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/javafx/webkit/prism/resources/missingImage.png")));
		mnTools.add(mntmNewMenuItem_6);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Instructions");
		mntmNewMenuItem_7.setIcon(new ImageIcon(TextEditorGui.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		mntmNewMenuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnHelp.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("About");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Here is information about text editor");
			}
		});
		mntmNewMenuItem_8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmNewMenuItem_8.setIcon(new ImageIcon(TextEditorGui.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		mnHelp.add(mntmNewMenuItem_8);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setActionCommand("New button");
		btnNewButton.setIcon(new ImageIcon(TextEditorGui.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Copy-Black.png")));
		toolBar.add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Cut-Black.png")));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Paste-Black.png")));
		toolBar.add(btnNewButton_5);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Bold-Black.png")));
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Italic-Black.png")));
		toolBar.add(btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Underline-Black.png")));
		toolBar.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Bullets-Black.png")));
		toolBar.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Text-Color-Yellow.png")));
		toolBar.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		toolBar.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("");
		btnNewButton_10.setIcon(new ImageIcon(TextEditorGui.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		toolBar.add(btnNewButton_10);
		
		JEditorPane editorPane = new JEditorPane();
		contentPane.add(editorPane, BorderLayout.CENTER);
	}

}
