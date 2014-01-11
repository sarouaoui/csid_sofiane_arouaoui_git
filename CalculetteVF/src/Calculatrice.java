import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Calculatrice extends JFrame {

	private float pourcentage;
	private double chiffre = 0;  // Variable contenant les operandes
	private String operateur;  // Variable contenant les opearateurs
	private boolean calculEffectuer = false; 
	private String memoire = ""; // Variable contenant un chiffre memoriser par l'utilisateur via la calculatrice
	private boolean operateurAppuer = false; // Boolean à vrai si un operateur a été saisi
	
	private JPanel conteneur = new JPanel(new BorderLayout()); // Creation du conteneur qui detient l'écran + clavier
	private JPanel cadre_bouton = new JPanel(new GridLayout(0, 4)); // le JPanel ayant les boutonss est divisé en 4 colonnes
	
	
	// Creation de chaque bouton de la calculette
	private JButton bouton1 = new JButton("1"); 
	private JButton bouton2 = new JButton("2"); 
	private JButton bouton3 = new JButton("3"); 
	private JButton bouton4 = new JButton("4"); 
	private JButton bouton5 = new JButton("5"); 
	private JButton bouton6 = new JButton("6"); 
	private JButton bouton7 = new JButton("7"); 
	private JButton bouton8 = new JButton("8"); 
	private JButton bouton9 = new JButton("9"); 
	private JButton bouton0 = new JButton("0"); 
	private JButton boutonPoint = new JButton("."); 
	private JButton boutonClear = new JButton("c"); // Bouton clear effaçant l'écran
	private JButton boutonPourc = new JButton("%");
	private JButton boutonEfface = new JButton("<="); 
	private JButton boutonPlus = new JButton("+"); 
	private JButton boutonMoin = new JButton("-"); 
	private JButton boutonMult = new JButton("x"); 
	private JButton boutonDiv = new JButton("÷");
	private JButton boutonEgale = new JButton("=");
	private JButton boutonMemoire = new JButton("M"); // initialise le bouton memoire
	private JButton boutonMemoirePlus = new JButton("M+"); // Appel le contenu mis en mémoire
	private JButton boutonMemoireMoin = new JButton("M-"); // Efface la mémoire de la calculatrice
	

	// separateurs pour mettre des espaces vide sur le clavier
	private JLabel separateur0 = new JLabel(); 
	private JLabel separateur1 = new JLabel(); 
	
	
	private JLabel ecran; 
	
	public Calculatrice(){  
		
		//cadre_bouton.add();
		this.setSize(240, 230);
		this.setLocationRelativeTo(null); // mettre au centre la fenêtre par defaut
		this.setResizable(false); // fige la taille de la fenêtre 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.show();
		
		this.add(conteneur);
		this.conteneur.add(cadre_bouton, BorderLayout.SOUTH);  
	
		ecran = new JLabel(); 
		ecran.setPreferredSize(new Dimension(290, 40));
		ecran.setBorder(BorderFactory.createLineBorder(Color.black));
		Font police = new Font("Arial", Font.BOLD, 25);
		ecran.setFont(police);
		
		ecran.setHorizontalAlignment(JLabel.RIGHT); // mettre les chiffres à droite de l'écran
		this.conteneur.add(ecran, BorderLayout.NORTH); // ajoute et met en haut l'ecran, dans la calculatrice
		
				

		
		ajouterBouton();
		ajoutActionListener();
		

	} 
	
	
	// methode permettant d'ajouter les boutons au JPanel contenant les touches
	private void ajouterBouton(){
	
		
		cadre_bouton.add(separateur0); 
		cadre_bouton.add(boutonMemoire);
		cadre_bouton.add(boutonMemoirePlus);
		cadre_bouton.add(boutonMemoireMoin);
		cadre_bouton.add(separateur1); 
		cadre_bouton.add(boutonPourc); 
		cadre_bouton.add(boutonClear);
		cadre_bouton.add(boutonEfface);
		cadre_bouton.add(bouton7);
		cadre_bouton.add(bouton8); 
		cadre_bouton.add(bouton9);
		cadre_bouton.add(boutonDiv);
		cadre_bouton.add(bouton4);
		cadre_bouton.add(bouton5);
		cadre_bouton.add(bouton6); 
		cadre_bouton.add(boutonMult);
		cadre_bouton.add(bouton1);
		cadre_bouton.add(bouton2);
		cadre_bouton.add(bouton3);
		cadre_bouton.add(boutonMoin);
		cadre_bouton.add(boutonPoint);
		cadre_bouton.add(bouton0);
		cadre_bouton.add(boutonEgale);
		cadre_bouton.add(boutonPlus); 
		
		
		
		
		
	}
	
	private void ajoutActionListener() {
		
		boutonMemoire.addActionListener(new EcouteurBoutonMemoire()); 
		boutonMemoirePlus.addActionListener(new EcouteurBoutonMemoirePlus()); 
		boutonMemoireMoin.addActionListener(new EcouteurBoutonMemoireMoin()); 
		boutonEgale.addActionListener(new EcouteurBoutonEgale()); 
		boutonDiv.addActionListener(new EcouteurBoutonOperationDiv()); 
		boutonMult.addActionListener(new EcouteurBoutonOperationMult());
		boutonPlus.addActionListener(new EcouteurBoutonOperationPlus()); 
		boutonMoin.addActionListener(new EcouteurBoutonOperationMoin());
		bouton0.addActionListener(new EcouteurBouton0());
		bouton1.addActionListener(new EcouteurBouton1());
		bouton2.addActionListener(new EcouteurBouton2());
		bouton3.addActionListener(new EcouteurBouton3());
		bouton4.addActionListener(new EcouteurBouton4());
		bouton5.addActionListener(new EcouteurBouton5());
		bouton6.addActionListener(new EcouteurBouton6());
		bouton7.addActionListener(new EcouteurBouton7());
		bouton8.addActionListener(new EcouteurBouton8());
		bouton9.addActionListener(new EcouteurBouton9());
		boutonPoint.addActionListener(new EcouteurBoutonPoint());
		boutonClear.addActionListener(new EcouteurBoutonClear());
		boutonPourc.addActionListener(new EcouteurBoutonPourc());
		boutonEfface.addActionListener(new EcouteurBoutonEfface());
		
		
		
		
	}
	
	
	private class EcouteurBoutonMemoire implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if (!ecran.getText().equals("") && memoire.equals("")) {
				
				memoire = ecran.getText(); 	
				
			}
		
			
		}
	}
	
	private class EcouteurBoutonMemoirePlus implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			nouveauCalcul();
			ecran.setText(memoire); 	
			
			
		}
	}
	
	private class EcouteurBoutonMemoireMoin implements ActionListener {
		public void actionPerformed(ActionEvent event) {

		
			memoire = "";
			
		}
	}

		

	private class EcouteurBouton0 implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			nouveauCalcul();
			//ecran.setText(ecran.getText()+"0"); 
			
			if (operateurAppuer) {
				
				operateurAppuer = false;
				ecran.setText("0");
				
			}else {
				
				ecran.setText(ecran.getText()+"0"); 

				
			}
			
		}
	}
	
	private class EcouteurBouton1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			nouveauCalcul();
			//ecran.setText(ecran.getText() + "1"); 
			
			if (operateurAppuer) {
				
				operateurAppuer = false;
				ecran.setText("1");
				
			}else {
				
				ecran.setText(ecran.getText()+"1"); 

				
			}
			
		}
	}


	private class EcouteurBouton2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			
			nouveauCalcul();
			//ecran.setText(ecran.getText() + "2");
			
			if (operateurAppuer) {
				
				operateurAppuer = false;
				ecran.setText("2");
				
			}else {
				
				ecran.setText(ecran.getText()+"2"); 

				
			}
		
		}
	}
	
	
	private class EcouteurBouton3 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			nouveauCalcul();
			//ecran.setText(ecran.getText() + "3");
			
			if (operateurAppuer) {
				
				operateurAppuer = false;
				ecran.setText("3");
				
			}else {
				
				ecran.setText(ecran.getText()+"3"); 

				
			}
			
		}
	}
	
	
	private class EcouteurBouton4 implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			nouveauCalcul();	
			//ecran.setText(ecran.getText() + "4");
			if (operateurAppuer) {
				
				operateurAppuer = false;
				ecran.setText("4");
				
			}else {
				
				ecran.setText(ecran.getText()+"4"); 

				
			}
		}
	}
	
	private class EcouteurBouton5 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			nouveauCalcul();
			//ecran.setText(ecran.getText() + "5");
			
			if (operateurAppuer) {
				
				operateurAppuer = false;
				ecran.setText("5");
				
			}else {
				
				ecran.setText(ecran.getText()+"5"); 

				
			}
			
		}
	}
	
	
	
	private class EcouteurBouton6 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			nouveauCalcul();
			//ecran.setText(ecran.getText() + "6");
			
			if (operateurAppuer) {
				
				operateurAppuer = false;
				ecran.setText("6");
				
			}else {
				
				ecran.setText(ecran.getText()+"6"); 

				
			}
			
		}
	}
	
	private class EcouteurBouton7 implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			nouveauCalcul();	 
			//ecran.setText(ecran.getText() + "7");
		
			if (operateurAppuer) {
				
				operateurAppuer = false;
				ecran.setText("7");
				
			}else {
				
				ecran.setText(ecran.getText()+"7"); 

				
			}
		}
	}
	
	
	private class EcouteurBouton8 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			nouveauCalcul(); 
			//ecran.setText(ecran.getText() + "8");
			
			if (operateurAppuer) {
				
				operateurAppuer = false;
				ecran.setText("8");
				
			}else {
				
				ecran.setText(ecran.getText()+"8"); 

				
			}
		
		}
	}
	
	
	
	private class EcouteurBouton9 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			nouveauCalcul(); 
			//ecran.setText(ecran.getText() + "9");
			if (operateurAppuer) {
				
				operateurAppuer = false;
				ecran.setText("9");
				
			}else {
				
				ecran.setText(ecran.getText()+"9"); 

				
			}
		}	
			 
	}
	
	private class EcouteurBoutonPoint implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			boolean presence = false; //S'il y a la présence d'un point dans le nombre
			
			
			
			// On parcourt les caractére présent à l'écran
			for (int a = 0; a < ecran.getText().length(); a++) {
				
				// Si il y'a deja un point à l'ecran 
				if (ecran.getText().charAt(a) == '.'){
					
					presence = true;
					
				}
				
				
				
				
			}
			if (!presence) { //S'il n'y a pas de point
				if (ecran.getText().equals("")){ //Si l'écran est vide
					ecran.setText("0.");
				} else { 
					ecran.setText(ecran.getText()+".");
				}
				
			}	
		}
	}
	
	private class EcouteurBoutonClear implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			
			ecran.setText("");
		}
	}
	
	private class EcouteurBoutonPourc implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			// On test si ecran n'est pas vide alors on applique le %
			if (!ecran.getText().equals("")){
				
				String s = ecran.getText(); 	
				pourcentage = (Float.parseFloat(s)/100); // On convrti le txt à l'ecran en float puis on divise par 100
				ecran.setText(Float.toString(pourcentage));
				
			}
				
		
			
		}
	}
	
	private class EcouteurBoutonOperationPlus implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			if (!ecran.getText().equals("") ) {
				chiffre += Double.parseDouble(ecran.getText()) ;
 				operateur = "+";
 				//ecran.setText("");
 				operateurAppuer = true;
			}
			
		}

	}
	
	
	private class EcouteurBoutonOperationDiv implements ActionListener {
		public void actionPerformed(ActionEvent event) {
					
			if (!ecran.getText().equals("")) {
				chiffre = Double.parseDouble(ecran.getText()) ; 
 				operateur = "÷"; 
 				//ecran.setText(""); 
 				operateurAppuer = true;
			}
		}

	}
	
	private class EcouteurBoutonOperationMoin implements ActionListener {
		public void actionPerformed(ActionEvent event) {
					
			if (!ecran.getText().equals("")) {
				chiffre = Double.parseDouble(ecran.getText()) ;
 				operateur = "-";
 				//ecran.setText(""); 
 				operateurAppuer = true;
			}
			
			
		}

	}

	private class EcouteurBoutonOperationMult implements ActionListener {
		public void actionPerformed(ActionEvent event) {
					
			
			if (!ecran.getText().equals("")) {
				chiffre = Double.parseDouble(ecran.getText()) ; 
 				operateur = "*";
 				//ecran.setText("");  
 				operateurAppuer = true;
			}
			
		}

	}
	
	private class EcouteurBoutonEfface implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String tmp = ecran.getText();  
			if(!tmp.equals("")) // Si ecran est pas vide 
				ecran.setText(tmp.substring(0, tmp.length()-1)); // alors je prends tous les caractères sauf le dernier
			
			
		}
	}
	
	
	
	private class EcouteurBoutonEgale implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			
			//Gestion de l'operation lors de la pression sur le bouton égale
			if (!ecran.getText().equals("")) { 
			
				switch (operateur) { 
				
					case "-": 
						chiffre -= Double.parseDouble(ecran.getText()) ;
						
						break;
					case "+":
						chiffre += Double.parseDouble(ecran.getText()) ;
						
						break;
					
					case "*":
						chiffre *= Double.parseDouble(ecran.getText()) ;
						
						
						break;
						
				
				
					case "÷":
						chiffre /= Double.parseDouble(ecran.getText()) ;
						
					
						break;
						
					default:	
				} 
				
				
	
				calculEffectuer = true;  // on met a true calculeffectuer lorqu'on a fai un calcule
				ecran.setText(Double.toString(chiffre)); // on affiche le resultat
				operateur = ""; // operateur a vide apres un calcul


			}
			
		}	

	}
	
	 // reinitialiser l'ecran lorsque le calcul a été effectuer
	private void nouveauCalcul(){
		
		
		if (calculEffectuer){
			
			chiffre =0; 
			ecran.setText("");
			calculEffectuer = false; 
			
		}
		
	}

}
