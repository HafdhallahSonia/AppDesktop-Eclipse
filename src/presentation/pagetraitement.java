package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dao.GestionTraitement;
import dao.IGestionTraitement;
import dao.SingletonConnection;
import metier.Traitement;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JComboBox;

public class pagetraitement extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel contentPane = new JPanel();
	JLabel lblNewLabel = new JLabel("New label");
	JLabel nom = new JLabel("Nom");
	JLabel lblTraitement = new JLabel("Traitement");
	JLabel lblDose = new JLabel("Dose");
	JLabel lblMedicament = new JLabel("Medicament");
	JLabel lblPrix = new JLabel("Prix");
	JComboBox<String> Tpatient = new JComboBox<>();
	JComboBox<String> traitementBox = new JComboBox<>();
	JTextField Tprix = new JTextField();
	JTextField Tdose = new JTextField();
	JTextField tmedicament = new JTextField();
	JButton ajouter = new JButton("Ajouter");
	JButton modifier = new JButton("Modifier");
	JButton supprimer = new JButton("Supprimer");
	JButton Mprincipale = new JButton("Menue principale");
	JButton rechercher = new JButton("Rechercher");
	//table modele
	TableModeleTraintement tm=new TableModeleTraintement();
	JTable tableau=new JTable(tm);
	JScrollPane jsp=new JScrollPane(tableau);
    //gestion
	IGestionTraitement gestion=new GestionTraitement();
	
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

	public pagetraitement() {
		super("Traitement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 601);
		
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel.setBounds(572, -15, 435, 335);
		lblNewLabel.setIcon(new ImageIcon(".\\DenDocpics\\thumbnail-votre-enfant-chez-le-dentiste.jpg"));
		contentPane.add(lblNewLabel);
		
		lblTraitement.setBounds(20, 10, 130, 43);
		lblTraitement.setForeground(new Color(25, 25, 112));
		lblTraitement.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 22));
		contentPane.add(lblTraitement);
		
		nom.setBounds(20, 70, 57, 29);
		nom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(nom);
		
		lblPrix.setBounds(20, 167, 57, 29);
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblPrix);

		Tprix.setBounds(20, 206, 120, 28);
		Tprix.setColumns(10);
		contentPane.add(Tprix);
		
		lblDose.setBounds(190, 70, 57, 29);
		lblDose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblDose);
		
		Tdose.setBounds(190, 106, 120, 28);
		Tdose.setColumns(10);
		contentPane.add(Tdose);
		
		lblMedicament.setBounds(190, 167, 120, 29);
		lblMedicament.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblMedicament);
		
		tmedicament.setBounds(190, 206, 120, 28);
		tmedicament.setColumns(10);
		contentPane.add(tmedicament);
		
		Tpatient.setBounds(20, 109, 120, 28);
		contentPane.add(Tpatient);
		
		JPanel panel = new JPanel();
		panel.setBounds(339, -9, 300, 329);
		panel.setLayout(null);
		panel.setForeground(new Color(112, 128, 144));
		contentPane.add(panel);
		
		Mprincipale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Mprincipale.setBackground(Color.LIGHT_GRAY);
		Mprincipale.setBounds(34, 261, 163, 32);
		panel.add(Mprincipale);
		
		supprimer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		supprimer.setBackground(Color.LIGHT_GRAY);
		supprimer.setBounds(34, 147, 163, 32);
		panel.add(supprimer);
		
		modifier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		modifier.setBackground(Color.LIGHT_GRAY);
		modifier.setBounds(34, 92, 163, 32);
		panel.add(modifier);
		
		ajouter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajouter.setBackground(Color.LIGHT_GRAY);
		ajouter.setBounds(34, 33, 163, 36);
		panel.add(ajouter);
		
		rechercher.setBounds(34, 202, 163, 32);
		panel.add(rechercher);
		rechercher.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rechercher.setBackground(Color.LIGHT_GRAY);
		
		
		//table modele
		jsp.setBounds(0, 325, 1007, 238);
		contentPane.add(jsp);
		
		traitementBox = new JComboBox<String>(new String[] {"Mal Del", "Nettoyage des dentes", "Blanchiment des dentes"});
		traitementBox.setBounds(170, 17, 140, 28);
		contentPane.add(traitementBox);
		
		tm.chargerTable(gestion.getAllTraitement());
		
		//cangement de couleur
		rechercher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	rechercher.setBackground(new Color(100, 149, 237));           }

            public void mouseExited(java.awt.event.MouseEvent evt) {
            	rechercher.setBackground(Color.LIGHT_GRAY);
            }
        });
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
		//menu principale
		Mprincipale.addActionListener(x->{
			this.dispose();
			pagedacceuil pg = new pagedacceuil();
			pg.setVisible(true);
		});
		//import nom patient
			fillComboBox();
		//ajouter
			ajouter.addActionListener(x->{
			   String nom = (String) Tpatient.getSelectedItem();
			   String trait = (String) traitementBox.getSelectedItem();
			   String med = tmedicament.getText();
			   String dose = Tdose.getText();
			   String prix = Tprix.getText();
			   
			   if(med.equals("")||dose.equals("")||prix.equals("")) 
				   JOptionPane.showMessageDialog(this, "erreur de saisie");
			   else
			   {
				  gestion.AddTraitement(new Traitement(nom, med, trait, dose, prix)); 
				  JOptionPane.showMessageDialog(this, "Traitement ajouté");
				  tm.chargerTable(gestion.getAllTraitement());
				  tmedicament.setText("");
				  Tdose.setText("");
				  Tprix.setText("");
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
				  int v= JOptionPane.showConfirmDialog(this,"voulez vous supprimer ce Traitement","supprimer" ,
						   JOptionPane.YES_NO_OPTION);
				  if(v==0) {
				   gestion.deleteTraitement(id);
				   tm.chargerTable(gestion.getAllTraitement());
				   rownum = -1;
				  }
			   }
		   });
		 //recherche par patient
		   rechercher.addActionListener(x->{
			   List<Traitement> liste = gestion.getTraitementParNom( (String) Tpatient.getSelectedItem());
				  tm.chargerTable(liste);
			});
		 //modifier 
		   modifier.addActionListener(x->{
			   if(rownum==-1)
				   JOptionPane.showMessageDialog(this, "selectionner une ligne");
			   else{
				  int v= JOptionPane.showConfirmDialog(this,"voulez vous modifier ce traitement","modifier" ,
						   JOptionPane.YES_NO_OPTION);
				 
				  if(v==0) {
					  String nom = (String) Tpatient.getSelectedItem();
					   String trait = (String) traitementBox.getSelectedItem();
					   String med = tmedicament.getText();
					   String dose = Tdose.getText();
					   String prix = Tprix.getText();
					  int id=(int)tm.getValueAt(rownum, 0);
					  
					  gestion.UpdateTraitment(new Traitement(nom, med, trait, dose, prix, id)); 
						    
					  JOptionPane.showMessageDialog(this, "traitement modifié");
				      tm.chargerTable(gestion.getAllTraitement());
				      rownum = -1;
				      tmedicament.setText("");
					  Tdose.setText("");
					  Tprix.setText("");		   
					}
			   }
		   });
		
		
		tm.chargerTable(gestion.getAllTraitement());
	}
	

	public static void main(String[] args) {
		new pagetraitement();
	}
	int rownum=-1;
	class EcouteurSouris implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			rownum=tableau.getSelectedRow();
			Tpatient.setSelectedItem((String) tm.getValueAt(rownum, 1));
			traitementBox.setSelectedItem((String) tm.getValueAt(rownum, 2));
			tmedicament.setText((String) tm.getValueAt(rownum, 3));
			Tdose.setText((String) tm.getValueAt(rownum, 4));
			Tprix.setText((String) tm.getValueAt(rownum, 5));
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
