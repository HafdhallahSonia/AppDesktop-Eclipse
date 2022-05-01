package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GestionPatient;
import dao.IGestionPatient;
import metier.Patient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class patientspage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputname;
	private JTextField telephoneinput;
	private JTextField adressinput;
	private JTextField alergieinput;
	private JTextField datenais;
	
	TableModele tm=new TableModele();
	JTable tableau=new JTable(tm);
	JScrollPane jsp=new JScrollPane(tableau);

	IGestionPatient gestion=new GestionPatient();

	public patientspage() {
		super("GestionPatient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 600);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(10, 0, 651, 319);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel nom_1 = new JLabel("Nom");
		nom_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nom_1.setBounds(59, 71, 57, 29);
		panel_2.add(nom_1);
		
		inputname = new JTextField();
		inputname.setBounds(59, 102, 120, 28);
		panel_2.add(inputname);
		inputname.setColumns(10);
		
		JLabel Telephone = new JLabel("Telephone");
		Telephone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Telephone.setBounds(59, 159, 98, 29);
		panel_2.add(Telephone);
		
		telephoneinput = new JTextField();
		telephoneinput.setBounds(59, 190, 120, 29);
		panel_2.add(telephoneinput);
		telephoneinput.setColumns(10);
		
		adressinput = new JTextField();
		adressinput.setBounds(59, 274, 116, 29);
		panel_2.add(adressinput);
		adressinput.setColumns(10);
		
		JLabel Adresse = new JLabel("Adresse");
		Adresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Adresse.setBounds(59, 245, 71, 19);
		panel_2.add(Adresse);
		
		alergieinput = new JTextField();
		alergieinput.setBounds(244, 274, 122, 29);
		panel_2.add(alergieinput);
		alergieinput.setColumns(10);
		
		JLabel Alergie = new JLabel("Alergie");
		Alergie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Alergie.setBounds(244, 239, 83, 25);
		panel_2.add(Alergie);
		
		JLabel Sexe = new JLabel("Sexe");
		Sexe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Sexe.setBounds(244, 164, 45, 19);
		panel_2.add(Sexe);
		
		datenais = new JTextField();
		datenais.setBounds(244, 101, 122, 29);
		panel_2.add(datenais);
		datenais.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		datenais.setForeground(SystemColor.textInactiveText);
		datenais.setText("aaaa/mm/jj");
		datenais.setColumns(10);
		
		JLabel Datedenaissance = new JLabel("Date de naissance");
		Datedenaissance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Datedenaissance.setBounds(244, 81, 153, 13);
		panel_2.add(Datedenaissance);
		
		JLabel ajouterlespatients = new JLabel("Gestion de patient");
		ajouterlespatients.setBounds(66, 10, 300, 43);
		panel_2.add(ajouterlespatients);
		ajouterlespatients.setForeground(new Color(25, 25, 112));
		ajouterlespatients.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 28));
		
		JPanel panel = new JPanel();
		panel.setBounds(422, 0, 300, 329);
		panel_2.add(panel);
		panel.setLayout(null);
		
		
		JButton Mprincipale = new JButton("Menue principale");
		Mprincipale.setBackground(new Color(192, 192, 192));
		Mprincipale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Mprincipale.setBounds(34, 261, 163, 32);
		panel.add(Mprincipale);
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.setBackground(new Color(192, 192, 192));
		supprimer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		supprimer.setBounds(34, 147, 163, 32);
		panel.add(supprimer);
		
		JButton modifier = new JButton("Modifier");
		modifier.setBackground(new Color(192, 192, 192));
		modifier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		modifier.setBounds(34, 92, 163, 32);
		panel.add(modifier);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.setBackground(new Color(192, 192, 192));
		ajouter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajouter.setBounds(34, 33, 163, 36);
		panel.add(ajouter);
		
		JButton rechercher = new JButton("Rechercher");
		rechercher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rechercher.setBackground(Color.LIGHT_GRAY);
		rechercher.setBounds(34, 201, 163, 32);
		panel.add(rechercher);
		
		JRadioButton bh = new JRadioButton("Homme");
		bh.setBounds(244, 194, 61, 21);
		panel_2.add(bh);
		
		JRadioButton bf = new JRadioButton("Femme");
		bf.setBounds(318, 194, 61, 21);
		panel_2.add(bf);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(bf);
	    bg.add(bh);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(".\\DenDocpics\\dentiste.jpg"));
		lblNewLabel.setBounds(654, 0, 342, 319);
		contentPane.add(lblNewLabel);
		
		jsp.setBounds(20, 325, 976, 238);
		contentPane.add(jsp);
		
		tm.chargerTable(gestion.getAllPatient());
		
		//MouseListener :color button
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
		rechercher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	rechercher.setBackground(new Color(100, 149, 237));           }

            public void mouseExited(java.awt.event.MouseEvent evt) {
            	rechercher.setBackground(Color.LIGHT_GRAY);
            }
        });
	
		//retourner au menu principale
		Mprincipale.addActionListener(x->{
			this.dispose();
			pagedacceuil pg = new pagedacceuil();
			pg.setVisible(true);
		});
		
		
		//Ajouter un patient
	   ajouter.addActionListener(x->{
		   String nom = inputname.getText();
		   String adresse = adressinput.getText();
		   String alergie = alergieinput.getText();
		   String telephone = telephoneinput.getText();
		   String date_naissance = datenais.getText();
		   String sexe="";
		   if(bh.isSelected())
			   sexe=bh.getText();
		   else if(bf.isSelected())
			   sexe=bf.getText();
		   
		   
		   if(nom.equals("")||adresse.equals("")||alergie.equals("")||sexe.equals("")||telephone.equals("")
			   ||date_naissance.equals("")) 
			   JOptionPane.showMessageDialog(this, "erreur de saisie");
		   else
		   {
			  gestion.AddPatient(new Patient(nom, adresse, alergie, sexe, telephone, date_naissance)); 
			  JOptionPane.showMessageDialog(this, "Patient ajouté");
			  tm.chargerTable(gestion.getAllPatient());
			  inputname.setText("");
			   adressinput.setText("");
			   alergieinput.setText("");
			   telephoneinput.setText("");
			   datenais.setText("");
			   bg.clearSelection();	 
		   }   
	   });
	   //recherche par nom
	   rechercher.addActionListener(x->{
			  List<Patient> liste=gestion.getPatientParNom(inputname.getText());
			  tm.chargerTable(liste);
		  });
	   //selectionner une ligne
	   tableau.addMouseListener(new EcouteurSouris());
	   //supprimer
	   supprimer.addActionListener(x->{
		   if(rownum==-1)
			   JOptionPane.showMessageDialog(this, "selectionner une ligne");
		   else{
			  int id=(int)tm.getValueAt(rownum, 0);
			  int v= JOptionPane.showConfirmDialog(this,"voulez vous supprimer ce patient","supprimer" ,
					   JOptionPane.YES_NO_OPTION);
			  if(v==0) {
			   gestion.deletePatient(id);
			   tm.chargerTable(gestion.getAllPatient());
			   rownum = -1;
			   
			   inputname.setText("");
			   adressinput.setText("");
			   alergieinput.setText("");
			   telephoneinput.setText("");
			   datenais.setText("");
			   bg.clearSelection();	 
			  }
		   }
	   });
	   //modifier 
	   modifier.addActionListener(x->{
		   if(rownum==-1)
			   JOptionPane.showMessageDialog(this, "selectionner une ligne");
		   else{
			  int v= JOptionPane.showConfirmDialog(this,"voulez vous modifier ce patient","modifier" ,
					   JOptionPane.YES_NO_OPTION);
			 
			  if(v==0) {
				  String nom = inputname.getText();
				  String adresse = adressinput.getText();
				  String alergie = alergieinput.getText();
				  String telephone = telephoneinput.getText();
				  String date_naissance = datenais.getText();
				  String sexe="";
				   if(bh.isSelected())
					   sexe=bh.getText();
				   else if(bf.isSelected())
					   sexe=bf.getText();
				   
				  int id=(int)tm.getValueAt(rownum, 0);
				  gestion.UpdatePatient(new Patient(nom, adresse, alergie, sexe, telephone, date_naissance, id)); 
					    
				  JOptionPane.showMessageDialog(this, "Patient modifié");
			      tm.chargerTable(gestion.getAllPatient());
				   rownum = -1;
				   
				   inputname.setText("");
				   adressinput.setText("");
				   alergieinput.setText("");
				   telephoneinput.setText("");
				   datenais.setText("");
				   bg.clearSelection();	
							   
				}
		   }
	   });
	   tm.chargerTable(gestion.getAllPatient());
	   
}
	
	public static void main(String[] args) {
				new patientspage();

	}
	int rownum=-1;
	class EcouteurSouris implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			rownum=tableau.getSelectedRow();
			inputname.setText((String) tm.getValueAt(rownum, 1));
			adressinput.setText((String) tm.getValueAt(rownum, 2));
		    alergieinput.setText((String) tm.getValueAt(rownum, 3));
			telephoneinput.setText((String) tm.getValueAt(rownum, 5));
			datenais.setText((String) tm.getValueAt(rownum, 6));
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
