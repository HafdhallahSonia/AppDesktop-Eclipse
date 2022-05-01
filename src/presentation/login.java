package presentation;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import dao.SingletonConnection;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JPanel contentPane = new JPanel();
	private JTextField inputnomutilisteur;
	private JPasswordField inputpassword;
	JButton annuler = new JButton("Annuler");
	JButton seconnecter = new JButton("Se connecter");
	JLabel nomutilisateur = new JLabel("Nom d'utilisateur");
	JLabel motdepasse_1 = new JLabel("Mot de passe");
	
	private Connection connection=SingletonConnection.getConnection();

	@SuppressWarnings("deprecation")
	public login() {
		super("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1,2, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 204));
		contentPane.add(panel);
		panel.setLayout(null);
		
		annuler.setForeground(new Color(255, 255, 255));
		annuler.setBackground(new Color(100, 149, 237));
		annuler.setBounds(324, 287, 124, 54);
		panel.add(annuler);
		
		seconnecter.setForeground(new Color(255, 255, 255));
		seconnecter.setBackground(new Color(100, 149, 237));
		seconnecter.setBounds(474, 287, 118, 54);
		panel.add(seconnecter);
		
		inputnomutilisteur = new JTextField();
		inputnomutilisteur.setBounds(324, 78, 268, 45);
		panel.add(inputnomutilisteur);
		inputnomutilisteur.setColumns(10);
		
		
		nomutilisateur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomutilisateur.setForeground(new Color(0, 0, 139));
		nomutilisateur.setBounds(75, 80, 160, 32);
		panel.add(nomutilisateur);
		
		inputpassword = new JPasswordField();
		inputpassword.setBounds(324, 166, 268, 45);
		panel.add(inputpassword);
		inputpassword.setColumns(10);
		
		motdepasse_1.setForeground(new Color(0, 0, 139));
		motdepasse_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		motdepasse_1.setBounds(75, 168, 118, 32);
		panel.add(motdepasse_1);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 37));
		lblNewLabel_1.setBounds(284, 10, 98, 45);
		panel.add(lblNewLabel_1);
		
		JLabel image = new JLabel();
		image.setBounds(0, 0, 685, 375);
		panel.add(image);
		image.setIcon(new ImageIcon(".\\DenDocpics\\login.jpg"));
		
		seconnecter.addActionListener(e->{		
			
			String nom = inputnomutilisteur.getText();
			String password = inputpassword.getText();

			  if(nom.equals("")||password.equals("")) {
				  JOptionPane.showMessageDialog(this,"Erreur de saisie");
			   }
			  else { 
				 try {
					PreparedStatement ps = connection.prepareStatement("select * from admin where nom_user=? And password=? ");
					ps.setString(1,nom);
					ps.setString(2,password);
					ResultSet rs=ps.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Bienvenu Admin");
						this.dispose();
						pagedacceuil pg = new pagedacceuil();
						pg.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "identifiant ou mot de passe incorrecte");
					}
				
				  }catch(SQLException e3){
					  e3.printStackTrace();
				  }
			  }
		});
		annuler.addActionListener(x->{
			inputnomutilisteur.setText("");
			inputpassword.setText("");  
		  });  
		
		seconnecter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	seconnecter.setForeground(Color.BLACK);           }

            public void mouseExited(java.awt.event.MouseEvent evt) {
            	seconnecter.setForeground(new Color(255, 255, 255));
            }
        });
		
		annuler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	annuler.setForeground(Color.BLACK);           }

            public void mouseExited(java.awt.event.MouseEvent evt) {
            	annuler.setForeground(new Color(255, 255, 255));
            }
        });
		    
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
