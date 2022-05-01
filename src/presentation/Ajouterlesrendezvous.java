package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dao.GestionRendez;
import dao.IGestionRendez;
import dao.SingletonConnection;
import metier.Rendez_vous;

import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class Ajouterlesrendezvous extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField talergie;
	private JTextField Tdate;
	private JComboBox<String> Tpatient ;
	private JComboBox<String> HeureBox;

	TableModeleRendez tm=new TableModeleRendez();
	JTable tableau=new JTable(tm);
	JScrollPane jsp=new JScrollPane(tableau);

	IGestionRendez gestion=new GestionRendez();
	
	private Connection connection=SingletonConnection.getConnection();
	//import nom
	public void fillComboBox(){
		try {
			PreparedStatement ps = connection.prepareStatement("select nom from patient");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Tpatient.addItem(rs.getString("nom"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Ajouterlesrendezvous() {
		super("Rendez_vous");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 0, 651, 319);
		contentPane.add(panel_2);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(112, 128, 144));
		panel.setLayout(null);
		panel.setBounds(422, 0, 300, 329);
		panel_2.add(panel);
		
		JButton Mprincipale = new JButton("Menue principale");
		Mprincipale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Mprincipale.setBackground(Color.LIGHT_GRAY);
		Mprincipale.setBounds(34, 261, 163, 32);
		panel.add(Mprincipale);
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		supprimer.setBackground(Color.LIGHT_GRAY);
		supprimer.setBounds(34, 147, 163, 32);
		panel.add(supprimer);
		
		JButton modifier = new JButton("Modifier");
		modifier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		modifier.setBackground(Color.LIGHT_GRAY);
		modifier.setBounds(34, 92, 163, 32);
		panel.add(modifier);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajouter.setBackground(Color.LIGHT_GRAY);
		ajouter.setBounds(34, 33, 163, 36);
		panel.add(ajouter);
		
		JLabel patient = new JLabel("Patient");
		patient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		patient.setBounds(47, 81, 84, 29);
		panel_2.add(patient);
		
		JLabel Telephone = new JLabel("Alergie");
		Telephone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Telephone.setBounds(49, 159, 98, 29);
		panel_2.add(Telephone);
		
		talergie = new JTextField();
		talergie.setColumns(10);
		talergie.setBounds(49, 198, 120, 29);
		panel_2.add(talergie);
		
		Tdate = new JTextField();
		Tdate.setForeground(Color.GRAY);
		Tdate.setText("aaaa/jj/aa");
		Tdate.setColumns(10);
		Tdate.setBounds(238, 198, 116, 29);
		panel_2.add(Tdate);
		
		JLabel Sexe = new JLabel("Date");
		Sexe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Sexe.setBounds(238, 164, 45, 19);
		panel_2.add(Sexe);
		
		JLabel heure = new JLabel("Heure");
		heure.setFont(new Font("Tahoma", Font.PLAIN, 20));
		heure.setBounds(238, 86, 153, 18);
		panel_2.add(heure);
		
		JLabel ajouterrendezvous = new JLabel("les rendez-vous");
		ajouterrendezvous.setForeground(new Color(25, 25, 112));
		ajouterrendezvous.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 22));
		ajouterrendezvous.setBounds(47, 10, 331, 43);
		panel_2.add(ajouterrendezvous);
		
		Tpatient = new JComboBox<>();
		Tpatient.setBounds(47, 120, 122, 29);
		panel_2.add(Tpatient);
		
	 	HeureBox = new JComboBox<>(new String[] {"11h", "11.30h", "12h", "12.30h", "13h", "13.30h", "14h", "14.30h", "15h", "15.30h", "16h", "16.30h", "17h", "17.30h"});
	 	HeureBox.setFont(new Font("Tahoma", Font.BOLD, 20));
	 	HeureBox.setBounds(232, 120, 122, 29);
		panel_2.add(HeureBox);
		
		JButton RechercherP = new JButton(" Rechercher par patient et date");
		RechercherP.setBounds(35, 263, 163, 32);
		panel_2.add(RechercherP);
		RechercherP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		RechercherP.setBackground(Color.LIGHT_GRAY);
		
		JButton RechercherD = new JButton(" Rechercher par date");
		RechercherD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		RechercherD.setBackground(Color.LIGHT_GRAY);
		RechercherD.setBounds(208, 263, 163, 32);
		panel_2.add(RechercherD);

		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(".\\DenDocpics\\dentiste (1).jpg"));
		lblNewLabel.setBounds(632, 0, 375, 319);
		contentPane.add(lblNewLabel);
		
		//table modele
		jsp.setBounds(0, 325, 1007, 238);
		contentPane.add(jsp);
		
		tm.chargerTable(gestion.getAllRendez());
		
		//changement de couleur
		Mprincipale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	Mprincipale.setBackground(new Color(100, 149, 237));           }

            public void mouseExited(java.awt.event.MouseEvent evt) {
            	Mprincipale.setBackground(Color.LIGHT_GRAY);
            }
        });
		ajouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	ajouter.setBackground(new Color(100, 149, 237));           }

            public void mouseExited(java.awt.event.MouseEvent evt) {
            	ajouter.setBackground(Color.LIGHT_GRAY);
            }
        });
		modifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	modifier.setBackground(new Color(100, 149, 237));           }

            public void mouseExited(java.awt.event.MouseEvent evt) {
            	modifier.setBackground(Color.LIGHT_GRAY);
            }
        });
		supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	supprimer.setBackground(new Color(100, 149, 237));           }

            public void mouseExited(java.awt.event.MouseEvent evt) {
            	supprimer.setBackground(Color.LIGHT_GRAY);
            }
        });
		
		//menuPrincipale
		Mprincipale.addActionListener(x->{
			this.dispose();
			pagedacceuil pg = new pagedacceuil();
			pg.setVisible(true);
		});
		//import nom patient
		fillComboBox();
		//import alergie
		Tpatient.addActionListener(x->{
			try {
				PreparedStatement ps = connection.prepareStatement("select alergie from patient where nom = ?");
				ps.setString(1, (String) Tpatient.getSelectedItem());
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					talergie.setText(rs.getString("alergie"));
				}
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		});
		//ajouter
		ajouter.addActionListener(x->{
			   String nom = (String) Tpatient.getSelectedItem();
			   String date = Tdate.getText();
			   String inputheure = (String) HeureBox.getSelectedItem();
	
			   if(nom.equals("")||date.equals("")||inputheure.equals("")) 
				   JOptionPane.showMessageDialog(this, "erreur de saisie");
			   else
			   {
				  gestion.AddRendez(new Rendez_vous(nom, date, inputheure)); 
				  JOptionPane.showMessageDialog(this, "Rendez_vous ajouté");
				  tm.chargerTable(gestion.getAllRendez());
				  Tdate.setText("");
				  talergie.setText("");
			   }   
		   });
		//selectionner une ligne
		   tableau.addMouseListener(new EcouteurSouris());
		//supprimer
		   supprimer.addActionListener(x->{
			   if(rownum==-1)
				   JOptionPane.showMessageDialog(this, "selectionner une ligne");
			   else{
				  int id=(int)tm.getValueAt(rownum, 0);
				  int v= JOptionPane.showConfirmDialog(this,"voulez vous supprimer ce rendez_vous","supprimer" ,
						   JOptionPane.YES_NO_OPTION);
				  if(v==0) {
				   gestion.deleteR(id);
				   tm.chargerTable(gestion.getAllRendez());
				   rownum = -1;
				   Tdate.setText("");
				  }
			   }
		   });
		   //recherche par date
		   RechercherD.addActionListener(x->{
			   List<Rendez_vous> liste = gestion.getRendez_vousParDate(Tdate.getText());
				  tm.chargerTable(liste);
				  Tdate.setText("");
			  });
		 //recherche par patient et date
		   RechercherP.addActionListener(x->{
			   List<Rendez_vous> liste = gestion.getRendez_vousParNom( (String) Tpatient.getSelectedItem(), Tdate.getText());
				  tm.chargerTable(liste);
				  Tdate.setText("");
			  });
		 //modifier 
		   modifier.addActionListener(x->{
			   if(rownum==-1)
				   JOptionPane.showMessageDialog(this, "selectionner une ligne");
			   else{
				  int v= JOptionPane.showConfirmDialog(this,"voulez vous modifier ce rendez-vous","modifier" ,
						   JOptionPane.YES_NO_OPTION);
				 
				  if(v==0) {
					  String nom = (String) Tpatient.getSelectedItem();
					  String date = Tdate.getText();
					  String inputheure = (String) HeureBox.getSelectedItem();
					  int id=(int)tm.getValueAt(rownum, 0);
					  
					  gestion.UpdateR(new Rendez_vous(nom, date, inputheure, id)); 
						    
					  JOptionPane.showMessageDialog(this, "rendez-vous modifié");
				      tm.chargerTable(gestion.getAllRendez());
				      rownum = -1;
				      Tdate.setText("");		   
					}
			   }
		   });

		tm.chargerTable(gestion.getAllRendez());
	}
	
	
	public static void main(String[] args) {
		new Ajouterlesrendezvous();				
	}
	int rownum=-1;
	class EcouteurSouris implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			rownum=tableau.getSelectedRow();
		    Tpatient.setSelectedItem((String) tm.getValueAt(rownum, 1));
		    Tdate.setText((String) tm.getValueAt(rownum, 2));
		    HeureBox.setSelectedItem((String) tm.getValueAt(rownum, 3));
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	}
