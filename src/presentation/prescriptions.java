package presentation;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dao.GestionPrescription;
import dao.IGestionPrescription;
import dao.SingletonConnection;
import metier.Prescription;

import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;

public class prescriptions extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Talergie;
	private JTextField Tmed;
	private JTextField Tdose;
	private JTextField Tprix;
	JButton Mprincipale = new JButton("Menue principale");
	JButton ajouter = new JButton("Ajouter");
	JLabel lblPrescriptions = new JLabel("Prescriptions");
	JLabel Traitement = new JLabel("Traitement");
	JLabel patient = new JLabel("Patient");
	JLabel algerie = new JLabel("Alergie");
	JLabel lblMedicament = new JLabel("Medicament");
	
	JComboBox<String> Tpatient = new JComboBox<>();
	JComboBox<String> traitementBox = new JComboBox<>();
	
	//table modele
	    TableModelePrescriptions tm=new TableModelePrescriptions();
		JTable tableau=new JTable(tm);
		JScrollPane jsp=new JScrollPane(tableau);
	    //gestion
		IGestionPrescription gestion=(IGestionPrescription) new GestionPrescription();
		
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

	public prescriptions() {
		super("prescriptions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1019, 602);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(".\\DenDocpics\\teeth-whitening-vancouver-teeth-whitening.jpg"));
		lblNewLabel.setBounds(670, -24, 459, 349);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(112, 128, 144));
		panel.setBounds(441, -11, 300, 329);
		contentPane.add(panel);
		
		Mprincipale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Mprincipale.setBackground(Color.LIGHT_GRAY);
		Mprincipale.setBounds(34, 261, 163, 32);
		panel.add(Mprincipale);
		
		ajouter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ajouter.setBackground(Color.LIGHT_GRAY);
		ajouter.setBounds(34, 33, 163, 36);
		panel.add(ajouter);
		
		JButton rechercher = new JButton("Rechercher");
		rechercher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rechercher.setBackground(Color.LIGHT_GRAY);
		rechercher.setBounds(34, 94, 163, 36);
		panel.add(rechercher);
		
		lblPrescriptions.setForeground(new Color(25, 25, 112));
		lblPrescriptions.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 22));
		lblPrescriptions.setBounds(125, 10, 170, 43);
		contentPane.add(lblPrescriptions);
		
		patient.setFont(new Font("Tahoma", Font.PLAIN, 20));
		patient.setBounds(21, 62, 84, 29);
		contentPane.add(patient);
		
		Traitement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Traitement.setBounds(228, 67, 153, 18);
		contentPane.add(Traitement);
		
		algerie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		algerie.setBounds(21, 144, 98, 29);
		contentPane.add(algerie);
		
		Talergie = new JTextField();
		Talergie.setColumns(10);
		Talergie.setBounds(21, 183, 120, 29);
		contentPane.add(Talergie);
			
		lblMedicament.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMedicament.setBounds(228, 144, 120, 29);
		contentPane.add(lblMedicament);
		
		Tmed = new JTextField();
		Tmed.setColumns(10);
		Tmed.setBounds(228, 184, 120, 28);
		contentPane.add(Tmed);
		
		JLabel lblDose = new JLabel("Dose");
		lblDose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDose.setBounds(21, 222, 120, 29);
		contentPane.add(lblDose);
		
		Tdose = new JTextField();
		Tdose.setColumns(10);
		Tdose.setBounds(23, 261, 120, 28);
		contentPane.add(Tdose);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrix.setBounds(228, 222, 120, 29);
		contentPane.add(lblPrix);
		
		Tprix = new JTextField();
		Tprix.setColumns(10);
		Tprix.setBounds(228, 261, 120, 28);
		contentPane.add(Tprix);
		
		Tpatient.setBounds(21, 93, 120, 29);
		contentPane.add(Tpatient);
		
		traitementBox = new JComboBox<String>(new String[] {"Mal Del", "Nettoyage des dentes", "Blanchiment des dentes"});
		traitementBox.setBounds(228, 95, 120, 29);
		contentPane.add(traitementBox);
		
		//table modele
		jsp.setBounds(0, 325, 1007, 238);
		contentPane.add(jsp);
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
		//menu principale
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
					Talergie.setText(rs.getString("alergie"));
				}
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		});
		//import traitemnt
		traitementBox.addActionListener(x->{
			try {
				PreparedStatement ps = connection.prepareStatement("select * from traitement where traitement = ?");
				ps.setString(1, (String) traitementBox.getSelectedItem());
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Tmed.setText(rs.getString("medicament"));
					Tdose.setText(rs.getString("dose"));
					Tprix.setText(rs.getString("prix"));
				}
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		});
		//ajouter
		ajouter.addActionListener(x->{
			   String nom = (String) Tpatient.getSelectedItem();
			   String trait = (String) traitementBox.getSelectedItem();
			   String alg = Talergie.getText();
			   String med = Tmed.getText();
			   String dose = Tdose.getText();
			   String prix = Tprix.getText();
			   
			   if(alg.equals("")||med.equals("")||dose.equals("")||prix.equals("")) 
				   JOptionPane.showMessageDialog(this, "erreur de saisie");
			   else
			   {
				  gestion.AddPrescription(new Prescription(nom,alg,trait, med, dose, prix)); 
				  JOptionPane.showMessageDialog(this, "Traitement ajouté");
				  tm.chargerTable(gestion.getAllPrescription());
				  Tmed.setText("");
				  Tdose.setText("");
				  Tprix.setText("");
			   }   
		   });
		//recherche par patient
	   rechercher.addActionListener(x->{
		   List<Prescription> liste = gestion.getPrescriptionParNom( (String) Tpatient.getSelectedItem());
			  tm.chargerTable(liste);
		});
	 //selectionner une ligne
	   tableau.addMouseListener(new EcouteurSouris());
		
		tm.chargerTable(gestion.getAllPrescription());
	}
	
	public static void main(String[] args) {
		new prescriptions();
	}
	int rownum=-1;
	class EcouteurSouris implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			rownum=tableau.getSelectedRow();
			Tpatient.setSelectedItem((String) tm.getValueAt(rownum, 1));
			traitementBox.setSelectedItem((String) tm.getValueAt(rownum, 2));
			Tmed.setText((String) tm.getValueAt(rownum, 3));
			Tdose.setText((String) tm.getValueAt(rownum, 4));
			Tprix.setText((String) tm.getValueAt(rownum, 5));
			Talergie.setText((String) tm.getValueAt(rownum, 6));
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
