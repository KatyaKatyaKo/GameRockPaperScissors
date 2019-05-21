import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	// Affiche Figures joueur & AI
	public final static String[] figuresnames = { "Pierre", "Feuille", "Ciseaux" };
	// Affiche gagnant
	public final static String[] gagnantstring = { "Match nul", "Vous avez GAGNE", "Vous avez PERDU" };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.setProperty("file.encoding", "UTF-8");
		int nbtours = -99;
		Random rand = new Random();

		// ****************************************************************************************************************************************************
		// VARIABLES
		// Etat du pot de mise avant le jeu: montant;
		// Nombre de tours (nbtours va ausi servir de table.length): int
		// nbtours=Terminal.lireInt();
		// Défition de nombre de variables "mise","figurenames",
		// "figurejoueur","figureAI","gagnant","potdemisefintour"};
		// La mise du joueur tableau[i][0];
		// String figuresnames [] = {"Pierre","Feuille","Ciseaux"}; //key
		// Figure de joueur tableau[i][1]; //value
		// String figuresnamejoueur [] ={"Pierre","Feuille","Ciseaux"}; //key
		// Figure de Spireted tableau[i][2]; //value
		// String figuresnameAI [] ={"Pierre","Feuille","Ciseaux"}; //key
		// Gagnant tableau[i][3]; //value
		// **********************************************************************************************************************************************************
		// DEROULEMENT DU PROGRAMME
		// BLOCK 0.0 BIENVENUE CHEZ AI
		// BLOCK 0.1 DECLARATION DES VARIABLES
		// BLOCK 1.1 ETAT DU POT DE MISE AVANT LE JEU + DEBUT DU JEU
		// BLOCK 1.2 MISE JOUEUR
		// BLOCK 1.3 FIGURE JOUEUR
		// BLOCK 1.4 REPONSE AI
		// BLOCK 1.5 CALCUL DU GAGNANT
		// BLOCK 1.6 CALCUL DE L'ETAT DE POT DE MISE A LA FIN DU ROUND
		// BLOCK 2 AFFICHAGE DES RESULTATS A LA FIN
		// **********************************************************************************************************************************************************

		// BLOCK 0.0: BIENVENUE CHEZ AI
		System.out.println("Bonjour et bienvenue dans le jeu \"Pierre-Feuille-Ciseaux!\""
				+ "\nVous allez jouer contre (^-^)AI !\n");

		// BLOCK 0.1: DECLARATION DES VARIABLES

		// Nombre de lignes = Nombre de tours à jouer
		System.out.println("Combien de tours vous voulez jouer?");
		nbtours = OnlyPositiveInts(saisie());
		System.out.println("C'est parti pour " + nbtours + " tour(s)!\n");

		// Déclaration de tableau
		int[][] tableau = new int[nbtours][6]; // "potdemisedebuttour", "mise",
												// "figurejoueur","figureAI","gagnant","potdemisefintour"

		String figuresnameAI[] = new String[nbtours];
		String figuresnamejoueur[] = new String[nbtours];

		// Affiche gagnant
		String gagnant[] = new String[nbtours];

		// PROGRAMME
		// ecrire dans un tableau
		// BLOCK 1.1: ETAT DU POT DE MISE AVANT LE JEU + DEBUT DU JEU [j0]
		System.out.println("Quel montant total avez-vous apporté pour miser?");
		int montant = OnlyPositiveInts(saisie());

		System.out.println("Parfait, vous avez " + montant + "€.\n");
		System.out.println(
				"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~C'EST PARTI!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		int montantrestant = montant;
		int compteur = 0;
		for (int i = 0; i <= nbtours - 1; i++) { // compteur de lignes = tours

			System.out.println("======TOUR " + (i + 1) + "======");

			// BLOCK 1.2: MISE JOUEUR [j1]
			System.out.println("Faites votre " + (i + 1) + "e(re) mise!");
			System.out.println("Elle doit être inférieure ou égale à " + montantrestant + "€.");
			for (;;) {
				tableau[i][0] = OnlyPositiveInts(saisie());
				if (tableau[i][0] <= montantrestant) {
					break;
				} else {
					System.out.println("La mise doit être inférieure ou égale à " + montantrestant
							+ "€. Essayez encore une fois!");
				}
			}
			System.out.println("Parfait! Vous avez misé " + tableau[i][0] + "€!\n");

			// BLOCK 1.3: FIGURE JOUEUR [j2]
			System.out.println("Quel est votre choix: \n'p': Pierre \n'f' Feuille ou \n'c': Ciseaux?\n");

			for (;;) { // Possibilité saisie1
				System.out.println("Saisissez votre choix:");
				String result = sc.nextLine();

				if (result.equals("")) {
					System.out.println("Chaine vide. Veillez recommencer");
					continue;
				}
				char resultChar = Character.toLowerCase(result.charAt(0));

				switch (resultChar) {
				case 'p':
					figuresnamejoueur[i] = figuresnames[0];
					tableau[i][1] = 0;
					System.out.println("Vous avez choisi \"Pierre\"\n");
					break;
				case 'f':
					System.out.println("Vous avez choisi \"Feuille\"\n");
					figuresnamejoueur[i] = figuresnames[1];
					tableau[i][1] = 1;
					break;
				case 'c':
					System.out.println("Vous avez choisi \"Ciseaux\"\n");
					figuresnamejoueur[i] = figuresnames[2];
					tableau[i][1] = 2;
					break;
				default:
					System.out.println("Veillez resaisir. Ce n'est pas un choix valide");
					continue;
				}
				break;
			}

			// BLOCK 1.4: FIGURE AI [j3] //Possibilité saisie 2
			System.out.println("(^-^)AI, quel est votre choix? \n1: Pierre \n2: Feuille ou \n3: Ciseaux?");
			tableau[i][2] = rand.nextInt(3);

			if (tableau[i][2] == 0) {
				System.out.println("AI a choisi \"Pierre\"\n");
				figuresnameAI[i] = figuresnames[0];
			}
			if (tableau[i][2] == 1) {
				System.out.println("AI a choisi \"Feuille\"\n");
				figuresnameAI[i] = figuresnames[1];
			}
			if (tableau[i][2] == 2) {
				System.out.println("AI a choisi \"Ciseaux\"\n");
				figuresnameAI[i] = figuresnames[2];
			}

			// BLOCK 1.5: GAGNANT [j4] //Gagnant: 1 = null; 2 = vous, 3 = IA;
			// match null
			if (tableau[i][1] == tableau[i][2]) {
				System.out.println("GAGNANT: Match nul!\n");
				tableau[i][3] = 0;
				gagnant[i] = gagnantstring[0];
			}

			// ***************************************//
			// * REGLES DU JEU: CHOIX DE GAGNANT *//
			// ***************************************//
			// * |Feulle| -- Pierre *//
			// * |Pierre| -- Ciseaux *//
			// * |Ciseaux| -- Feuille *//
			// ***************************************//

			else if ((/* cas1 */(tableau[i][1] == 1) && (tableau[i][2] == 0))
					|| (/* cas2 */(tableau[i][1] == 0) && (tableau[i][2] == 2))
					|| (/* cas2 */(tableau[i][1] == 2) && (tableau[i][2] == 1))) {
				System.out.println("GAGNANT: Vous avez GAGNE!\n");
				tableau[i][3] = 1;
				gagnant[i] = gagnantstring[1];
			} else {
				System.out.println("GAGNANT: Vous avez PERDU!\n");
				tableau[i][3] = 2;
				gagnant[i] = gagnantstring[2];
			}

			// BLOCK 1.6: CALCUL DE L'ETAT DE POT DE MISE A LA FIN DU TOUR [j5]
			if (tableau[i][3] == 1) { // si joueur gagne
				montantrestant = montantrestant + tableau[i][0];
			} else if (tableau[i][3] == 2) {// si AI gagne
				montantrestant = montantrestant - tableau[i][0];
			}

			if (montantrestant == 0)
				break;

			compteur++;
		}

		// BLOCK 2: AFFICHAGE DES RESULTATS
		System.out.println(
				"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\t\t\t\tDESOLE, IL NE VOUS RESTE PLUS D'ARGENT OU LE NOMBRE DE TOUR EST JOUE!\n\t\t\t\t\t\t     Merci pour votre jeu!\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		for (int i = 0; i <= compteur - 1; i++) {
			System.out.println(
					// tour N
					"\t\t\t\t\t\tPOUR LE TOUR N" + (i + 1) + " LE RESULTAT EST:\n" +
					// pot de mise au debut
							"Vous aviez: " + montantrestant + "€ *" +
							// la mise
							" Vous avez misé: " + tableau[i][0] + "€ *" +
							// la figure joueur
							" Vous avez choisi: " + "\"" + figuresnamejoueur[i] + "\" *" +
							// la réponse de AI
							" AI a choisi: " + "\"" + figuresnameAI[i] + "\" *" +
							// gagnant du tour
							" " + gagnant[i] + " *");
			montantrestant -= tableau[i][0];
		}
		System.out.println("\t\t\t\t\t\tA la fin du jeu il vous reste " + montantrestant + "€");
		sc.close();
	}

	// FONCTIONS
	// Fonction 1 : Saisie
	public static int saisie() {
		Scanner sc = new Scanner(System.in); // Il ne faut pas le fermer sinon NoSUchLementException quand on appelle la fonction 2e fois 							
		int x = -99;
		for (;;) {
			try {
				x = sc.nextInt();
				if (x == 0) {
					System.out.println("Le nombre doit être supérieur à \"0\". Veillez resaisir:");
					continue;
				}
			} catch (InputMismatchException ime) {
				System.out.println("La saisie doit être numérique. Veillez resaisir:");
				sc.nextLine();
				continue;
			}
			return x;
		}

	}

	// Fonction 2: TransformerLeNegEnPositive
	public static int OnlyPositiveInts(int i) {
		if (i < 0) {
			int sign = -1;
			i = i * sign;
		}
		return (i);
	}

}
