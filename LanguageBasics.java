/**
 * LanguageBasics.java
 * 
 * Ce programme illustre les concepts fondamentaux de Java :
 * - Variables et types primitifs
 * - Opérateurs
 * - Structures de contrôle (if, switch, boucles)
 * - Tableaux
 * - Entrées/Sorties console (Scanner)
 * 
 * Auteur : Généré pour l'apprentissage
 * Date : 2026
 */

import java.util.Scanner;

public class LanguageBasics {
    
    public static void main(String[] args) {
        
        // ==============================================
        // 1. VARIABLES ET TYPES PRIMITIFS
        // ==============================================
        
        // Entiers
        byte petitNombre = 127;           // 8 bits, de -128 à 127
        short nombreCourt = 32000;        // 16 bits
        int nombreStandard = 100000;      // 32 bits (le plus utilisé)
        long grandNombre = 9_000_000_000L; // 64 bits, besoin du suffixe L
        
        // Décimaux
        float prix = 19.99f;               // 32 bits, suffixe f
        double precision = 99.999999;      // 64 bits (par défaut pour les décimaux)
        
        // Autres types
        char lettre = 'A';                 // Un seul caractère entre ''
        boolean estVrai = true;            // true ou false
        
        // Affichage des variables
        System.out.println("--- VARIABLES ---");
        System.out.println("byte : " + petitNombre);
        System.out.println("int : " + nombreStandard);
        System.out.println("long : " + grandNombre);
        System.out.println("float : " + prix);
        System.out.println("double : " + precision);
        System.out.println("char : " + lettre);
        System.out.println("boolean : " + estVrai);
        System.out.println();
        
        // ==============================================
        // 2. OPÉRATEURS
        // ==============================================
        
        int a = 10, b = 3;
        
        // Arithmétiques
        int somme = a + b;
        int difference = a - b;
        int produit = a * b;
        int quotient = a / b;      // Division entière = 3
        int reste = a % b;         // Modulo = 1
        
        // Comparaison (résultat boolean)
        boolean estEgal = (a == b);
        boolean estPlusGrand = (a > b);
        boolean estDifferent = (a != b);
        
        // Logiques
        boolean condition1 = (a > 5) && (b < 5);  // ET : true && true = true
        boolean condition2 = (a > 20) || (b < 5); // OU : false || true = true
        boolean condition3 = !(a == b);           // NON : !false = true
        
        // Opérateur conditionnel (ternaire)
        int max = (a > b) ? a : b;   // Si a>b alors a sinon b
        
        System.out.println("--- OPÉRATEURS ---");
        System.out.println(a + " + " + b + " = " + somme);
        System.out.println(a + " % " + b + " = " + reste);
        System.out.println(a + " > " + b + " : " + estPlusGrand);
        System.out.println("Le maximum est : " + max);
        System.out.println();
        
        // ==============================================
        // 3. STRUCTURES DE CONTRÔLE
        // ==============================================
        
        // 3.1 If-else
        System.out.println("--- IF-ELSE ---");
        int note = 85;
        
        if (note >= 90) {
            System.out.println("Excellent !");
        } else if (note >= 70) {
            System.out.println("Bien !");
        } else if (note >= 50) {
            System.out.println("Passable.");
        } else {
            System.out.println("À améliorer.");
        }
        
        // 3.2 Switch (Java 14+ avec flèches)
        System.out.println("\n--- SWITCH ---");
        char grade = 'B';
        
        switch (grade) {
            case 'A' -> System.out.println("Félicitations !");
            case 'B' -> System.out.println("Très bien !");
            case 'C' -> System.out.println("Peut mieux faire.");
            default -> System.out.println("Non évalué.");
        }
        
        // 3.3 Boucle for classique
        System.out.println("\n--- BOUCLE FOR (classique) ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Compte : " + i);
        }
        
        // 3.4 Boucle for-each (améliorée)
        System.out.println("\n--- BOUCLE FOR-EACH ---");
        String[] couleurs = {"Rouge", "Vert", "Bleu"};
        for (String couleur : couleurs) {
            System.out.println("Couleur : " + couleur);
        }
        
        // 3.5 Boucle while
        System.out.println("\n--- BOUCLE WHILE ---");
        int compteur = 1;
        while (compteur <= 3) {
            System.out.println("While : " + compteur);
            compteur++;
        }
        
        // 3.6 Boucle do-while (exécutée au moins une fois)
        System.out.println("\n--- BOUCLE DO-WHILE ---");
        int x = 5;
        do {
            System.out.println("Cette ligne s'affiche même si x >= 10");
            x++;
        } while (x < 10);
        
        // ==============================================
        // 4. TABLEAUX
        // ==============================================
        
        System.out.println("\n--- TABLEAUX ---");
        
        // Déclaration et initialisation
        int[] nombres = new int[5];           // Tableau de 5 entiers (0 par défaut)
        int[] valeurs = {10, 20, 30, 40, 50}; // Initialisation directe
        
        // Remplir le tableau
        for (int i = 0; i < nombres.length; i++) {
            nombres[i] = (i + 1) * 10;
        }
        
        // Parcourir avec for-each
        System.out.print("Valeurs : ");
        for (int val : valeurs) {
            System.out.print(val + " ");
        }
        
        // Tableau multidimensionnel (matrice)
        System.out.println("\n\nMatrice 3x3 :");
        int[][] matrice = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
        
        // ==============================================
        // 5. ENTRÉES/SORTIES CONSOLE AVEC SCANNER
        // ==============================================
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n--- ENTRÉE UTILISATEUR ---");
        System.out.print("Entrez votre nom : ");
        String nom = scanner.nextLine();
        
        System.out.print("Entrez votre âge : ");
        int age = scanner.nextInt();
        
        System.out.println("\nBonjour " + nom + ", vous avez " + age + " ans.");
        
        // Petit exercice intégré
        System.out.println("\n--- PETIT EXERCICE ---");
        System.out.print("Entrez un nombre entier : ");
        int nb = scanner.nextInt();
        
        if (nb % 2 == 0) {
            System.out.println(nb + " est pair.");
        } else {
            System.out.println(nb + " est impair.");
        }
        
        // Afficher les nombres pairs de 0 à nb
        System.out.print("Nombres pairs jusqu'à " + nb + " : ");
        for (int i = 0; i <= nb; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // Fermer le scanner pour éviter les fuites mémoire
        scanner.close();
        
        System.out.println("\n--- FIN DU PROGRAMME ---");
    }
}