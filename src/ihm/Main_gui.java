package ihm;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_gui {
	private boolean clicked = true;
	private JFrame frame;
	/**
	 * @wbp.nonvisual location=69,-36
	 */
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_gui window = new Main_gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmImporter = new JMenuItem("Importer...");
		mnFichier.add(mntmImporter);
		
		JMenuItem mntmExporter = new JMenuItem("Exporter...");
		mnFichier.add(mntmExporter);
		
		JMenu mnQuitter = new JMenu("Quitter");
		menuBar.add(mnQuitter);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 151, 615);
		frame.getContentPane().add(panel);
		
		
		Icon buttonIcon = new ImageIcon("images/ICONE_AVION.jpg");
		Icon buttonIcon2 = new ImageIcon("images/ICONE_AVION_GRIS.jpg");
		JButton button = new JButton(buttonIcon);
		button.setToolTipText("Avion");
		button.setBorder(BorderFactory.createEmptyBorder());
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (clicked) {
					button.setIcon(buttonIcon2);
					clicked = false;
				} else {
					button.setIcon(buttonIcon);
					clicked = true;
				}

			}
		};	
		button.addActionListener(action);

			button.setContentAreaFilled(false);
			panel.add(button);
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
