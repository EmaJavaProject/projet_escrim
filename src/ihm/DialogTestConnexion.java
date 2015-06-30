package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import escrim.utils.ConnexionEscrim;

import java.awt.Color;

import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class DialogTestConnexion extends JDialog {

	private final JPanel panelConnexion = new JPanel();
	private JTextField textUrl;
	private JTextField textLogin;
	private final JLabel labelErreurUrl = new JLabel("L'url fourni est invalide");
	private final JLabel labelErreurConnexion = new JLabel("Connexion impossible, informations invalides");
	private JPasswordField textPassword;

	public DialogTestConnexion() {
		setModal(true);
		setTitle("Connexion \u00E0 la base de donn\u00E9es");
		setBounds(100, 100, 556, 256);
		
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout());
		panelConnexion.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelConnexion, BorderLayout.CENTER);
		panelConnexion.setLayout(new GridLayout(2, 0, 0, 0));
		{
			JPanel panelChoixDatabase = new JPanel();
			panelConnexion.add(panelChoixDatabase);
			panelChoixDatabase.setLayout(null);
			
			JLabel labelTexteUrl = new JLabel("Url de la base de donn\u00E9es :");
			labelTexteUrl.setBounds(22, 11, 159, 23);
			panelChoixDatabase.add(labelTexteUrl);
			
			ConnexionEscrim connexion = ConnexionEscrim.getInstance();
			textUrl = new JTextField();
			textUrl.setBounds(191, 13, 138, 20);
			textUrl.setText(connexion.getInformationConnexion());
			panelChoixDatabase.add(textUrl);
			textUrl.setColumns(10);
			
			labelErreurUrl.setForeground(Color.RED);
			labelErreurUrl.setBounds(175, 36, 170, 23);
			labelErreurUrl.setVisible(false);
			panelChoixDatabase.add(labelErreurUrl);
			
			JLabel labelEnregistrement = new JLabel("Enregistrement r\u00E9ussi");
			labelEnregistrement.setForeground(new Color(50, 205, 50));
			labelEnregistrement.setBounds(175, 37, 144, 20);
			labelEnregistrement.setVisible(false);
			panelChoixDatabase.add(labelEnregistrement);
			
			JButton boutonEnregistrer = new JButton("Enregistrer");
			boutonEnregistrer.setBounds(343, 12, 119, 23);
			boutonEnregistrer.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent evt) {
					  String url;
					  boolean result;
					  
					  ConnexionEscrim connexion = ConnexionEscrim.getInstance();
					  url = textUrl.getText();
					  labelEnregistrement.setVisible(false);
					  labelErreurUrl.setVisible(false);
					  if(!(url.isEmpty()))
					  {
						  result = connexion.setInformationConnexion(url);
						  if(result == true) labelEnregistrement.setVisible(true); 
						  else labelErreurUrl.setVisible(true);
					  }
					  else labelErreurUrl.setVisible(true);
				     }
					});
			panelChoixDatabase.add(boutonEnregistrer);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(new Color(192, 192, 192));
			separator.setBounds(73, 70, 400, 10);
			panelChoixDatabase.add(separator);
			
		}
		{
			JPanel panelInformationConnexion = new JPanel();
			panelConnexion.add(panelInformationConnexion);
			panelInformationConnexion.setLayout(null);
			
			JLabel labelLogin = new JLabel("Login :");
			labelLogin.setBounds(127, 14, 46, 14);
			panelInformationConnexion.add(labelLogin);
			
			JLabel labelPasword = new JLabel("Password :");
			labelPasword.setBounds(127, 45, 65, 14);
			panelInformationConnexion.add(labelPasword);
			
			textLogin = new JTextField();
			textLogin.setBounds(192, 11, 137, 20);
			panelInformationConnexion.add(textLogin);
			textLogin.setColumns(10);
			
			textPassword = new JPasswordField();
			textPassword.setBounds(192, 42, 137, 20);
			panelInformationConnexion.add(textPassword);
		}
		{
			JPanel panelValidation = new JPanel();
			panelValidation.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(panelValidation, BorderLayout.SOUTH);
			{
				labelErreurConnexion.setForeground(new Color(255, 0, 0));
				labelErreurConnexion.setVisible(false);
				panelValidation.add(labelErreurConnexion);
				
				JButton boutonConnexion = new JButton("Connexion");
				boutonConnexion.addActionListener(new ActionListener() {
					  public void actionPerformed(ActionEvent evt) {
						    String login;
						    String password;
						    boolean result;
						    
						    ConnexionEscrim connexion = ConnexionEscrim.getInstance();
						    
						    login = textLogin.getText();
						    password = new String(textPassword.getPassword());
						    
						    if(!login.isEmpty() && !password.isEmpty())
						    {
						    	result = connexion.testInformationConnexion(login, password);
						    	if(result == true) dispose();
						    	else labelErreurConnexion.setVisible(true);
						    }
						    else labelErreurConnexion.setVisible(true);
						  }
						});
				
				panelValidation.add(boutonConnexion);
				getRootPane().setDefaultButton(boutonConnexion);
			}
			{
				JButton boutonAnnuler = new JButton("Annuler");
				boutonAnnuler.addActionListener(new ActionListener() {
					  public void actionPerformed(ActionEvent evt) {
						  System.exit(0);
						  }
						});
				panelValidation.add(boutonAnnuler);
			}
		}
		

	}
}
