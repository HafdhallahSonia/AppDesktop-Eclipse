package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class pagedacceuil extends JFrame {
	
	JLabel dendoc = new JLabel("DENDOC");
	JLabel welcome = new JLabel("BIENVENUE !");
	JButton Rendezvous = new JButton("Rendez-vous");
	JButton deconnecter = new JButton("Déconnecter");
	JButton Prescriptions = new JButton("Prescriptions");
	JButton Traitement = new JButton("Traitement");
	JButton Patients = new JButton("Patients");

	public pagedacceuil() {
		super("Menu principale");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1016, 574);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Rendezvous.setForeground(new Color(25, 25, 112));
		Rendezvous.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 24));
		Rendezvous.setBackground(SystemColor.inactiveCaption);
		
		dendoc.setForeground(new Color(0, 0, 128));
		dendoc.setFont(new Font("Poppins Black", Font.PLAIN, 86));
		dendoc.setBounds(543, 294, 394, 131);
		panel.add(dendoc);
		
		JLabel to = new JLabel("Sur");
		to.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 60));
		to.setForeground(new Color(0, 0, 139));
		to.setBounds(687, 207, 116, 77);
		panel.add(to);
		
		welcome.setFont(new Font("Poppins SemiBold", Font.PLAIN, 74));
		welcome.setForeground(new Color(25, 25, 112));
		welcome.setBounds(517, 61, 457, 125);
		panel.add(welcome);
		
		deconnecter.setForeground(new Color(25, 25, 112));
		deconnecter.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 15));
		deconnecter.setBackground(SystemColor.activeCaption);
		deconnecter.setBounds(92, 475, 234, 52);
		panel.add(deconnecter);
		
		Prescriptions.setForeground(new Color(25, 25, 112));
		Prescriptions.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 24));
		Prescriptions.setBackground(SystemColor.inactiveCaption);
		Prescriptions.setBounds(92, 368, 234, 60);
		panel.add(Prescriptions);
		
		Traitement.setForeground(new Color(25, 25, 112));
		Traitement.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 25));
		Traitement.setBackground(SystemColor.inactiveCaption);
		Traitement.setBounds(92, 261, 234, 60);
		panel.add(Traitement);
		Rendezvous.setBounds(92, 154, 234, 60);
		panel.add(Rendezvous);
		
		Patients.setForeground(new Color(0, 0, 128));
		Patients.setFont(new Font("Poppins ExtraBold", Font.PLAIN, 30));
		Patients.setBackground(SystemColor.inactiveCaption);
		Patients.setBounds(92, 47, 234, 60);
		panel.add(Patients);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(135, 206, 250), 2));
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(45, 10, 332, 543);
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, -333, 1680, 1333);
		lblNewLabel.setIcon(new ImageIcon(".\\DenDocpics\\curetage-dentiste.jpg"));
		panel.add(lblNewLabel);
		
		deconnecter.addActionListener(x->{
			this.dispose();
			login pg = new login();
			pg.setVisible(true);
		});
		deconnecter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	deconnecter.setForeground(Color.BLACK);           }

            public void mouseExited(java.awt.event.MouseEvent evt) {
            	deconnecter.setForeground(new Color(25, 25, 112));
            }
        });
		
		Patients.addActionListener(x->{
			this.dispose();
			patientspage pg = new patientspage();
			pg.setVisible(true);
		});
		Patients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	Patients.setForeground(new Color(255, 255, 255));           }

            public void mouseExited(java.awt.event.MouseEvent evt) {
            	Patients.setForeground(new Color(25, 25, 112));
            }
        });
		
		Rendezvous.addActionListener(x->{
			this.dispose();
			Ajouterlesrendezvous pg = new Ajouterlesrendezvous();
			pg.setVisible(true);
		});
		Rendezvous.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	Rendezvous.setForeground(new Color(255, 255, 255));           }

            public void mouseExited(java.awt.event.MouseEvent evt) {
            	Rendezvous.setForeground(new Color(25, 25, 112));
            }
        });
		
		Traitement.addActionListener(x->{
			this.dispose();
			pagetraitement pg = new pagetraitement();
			pg.setVisible(true);
		});
		Traitement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	Traitement.setForeground(new Color(255, 255, 255));           }

            public void mouseExited(java.awt.event.MouseEvent evt) {
            	Traitement.setForeground(new Color(25, 25, 112));
            }
        });
		
		Prescriptions.addActionListener(x->{
			this.dispose();
			prescriptions pg = new prescriptions();
			pg.setVisible(true);
		});
		Prescriptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	Prescriptions.setForeground(new Color(255, 255, 255));           }

            public void mouseExited(java.awt.event.MouseEvent evt) {
            	Prescriptions.setForeground(new Color(25, 25, 112));
            }
        });
		
		
		
	}
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pagedacceuil frame = new pagedacceuil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
