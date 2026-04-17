/**
 * VariableScopeDemo.java
 * 
 * Ce programme illustre les différents types de portée (scope) en Java :
 * - Portée de classe (class scope)
 * - Portée de méthode (method scope)
 * - Portée de boucle (loop scope)
 * - Portée d'accolades (bracket scope)
 * - Variable shadowing (masquage)
 * 
 * Auteur : Généré pour l'apprentissage
 * Date : 2026
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VariableScopeDemo {
    
    // ==============================================
    // 1. PORTÉE DE CLASSE (CLASS SCOPE)
    // ==============================================
    // Ces variables existent dans TOUTE la classe
    private String nomClasse = "VariableScopeDemo";
    private int compteurGlobal = 0;
    private static final String VERSION = "1.0";
    
    // Une variable de classe peut être utilisée dans n'importe quelle méthode
    private String messageBienvenue = "Bienvenue dans la démo des portées !";
    
    public void afficherMessageBienvenue() {
        // Accès à une variable de classe
        System.out.println(messageBienvenue);
        System.out.println("Version : " + VERSION);
    }
    
    // ==============================================
    // 2. PORTÉE DE MÉTHODE (METHOD SCOPE)
    // ==============================================
    public void exemplePorteeMethode() {
        System.out.println("\n--- 2. PORTÉE DE MÉTHODE ---");
        
        // Variable locale à cette méthode
        String variableLocale = "Je n'existe que dans cette méthode";
        int nombreLocal = 42;
        
        System.out.println(variableLocale);
        System.out.println("Nombre local : " + nombreLocal);
        
        // On peut utiliser les variables de classe ici
        compteurGlobal++;
        System.out.println("Compteur global (incrémenté) : " + compteurGlobal);
        
        // À la fin de la méthode, variableLocale et nombreLocal disparaissent
    }
    
    public void uneAutreMethode() {
        System.out.println("\n--- Test d'accès ---");
        
        // Cette méthode ne peut PAS voir variableLocale ni nombreLocal
        // car ils étaient dans exemplePorteeMethode()
        
        // Par contre, elle peut voir les variables de classe
        System.out.println("Accès à nomClasse depuis autre méthode : " + nomClasse);
        System.out.println("Compteur global actuel : " + compteurGlobal);
        
        // ERREUR de compilation si on décommente :
        // System.out.println(variableLocale); // Ne compile pas !
    }
    
    // ==============================================
    // 3. PORTÉE DE BOUCLE (LOOP SCOPE)
    // ==============================================
    public void exemplePorteeBoucle() {
        System.out.println("\n--- 3. PORTÉE DE BOUCLE ---");
        
        // Variable avec portée de méthode
        String resultat = "";
        
        // La variable 'i' a une portée de BOUCLE (uniquement dans le for)
        for (int i = 0; i < 5; i++) {
            resultat = resultat + i + " ";
            System.out.println("Dans la boucle, i = " + i);
        }
        
        System.out.println("Résultat : " + resultat);
        
        // ERREUR de compilation si on essaie d'utiliser i ici :
        // System.out.println("i vaut : " + i); // Ne compile pas !
        
        // Exemple avec for-each
        List<String> noms = Arrays.asList("Alice", "Bob", "Charlie");
        
        // 'nom' a une portée de boucle
        for (String nom : noms) {
            System.out.println("Nom dans la boucle : " + nom);
        }
        
        // ERREUR : 'nom' n'existe pas ici
        // System.out.println("Dernier nom : " + nom);
        
        // Exemple avec while
        int compteur = 0; // Variable de méthode
        while (compteur < 3) {
            int temp = compteur * 10; // Variable de BOUCLE (déclarée DANS le bloc)
            System.out.println("temp = " + temp);
            compteur++;
            // temp existe jusqu'à la fin de cette itération
        }
        // ERREUR : temp n'existe pas ici
        // System.out.println(temp);
    }
    
    // ==============================================
    // 4. PORTÉE D'ACCOLADES (BRACKET SCOPE)
    // ==============================================
    public void exemplePorteeAccolades() {
        System.out.println("\n--- 4. PORTÉE D'ACCOLADES ---");
        
        int x = 10;
        System.out.println("Début : x = " + x);
        
        // Bloc interne (délimité par {})
        {
            int y = 20;
            System.out.println("Dans le bloc : x = " + x + ", y = " + y);
            
            // On peut modifier x (qui est de portée supérieure)
            x = x + y;
            System.out.println("Après modification : x = " + x);
            
            // y n'existe qu'ici
        }
        
        // y n'est PLUS accessible ici
        System.out.println("Fin : x = " + x);
        // System.out.println(y); // ERREUR de compilation !
        
        // Bloc conditionnel
        if (true) {
            String messageBloc = "Message dans le if";
            System.out.println(messageBloc);
            // messageBloc existe seulement dans ce bloc
        }
        // messageBloc n'existe plus ici
    }
    
    // ==============================================
    // 5. VARIABLE SHADOWING (MASQUAGE)
    // ==============================================
    
    // Variable de classe (sera masquée)
    private String titre = "Titre de la classe";
    private int valeur = 100;
    
    public void exempleShadowing() {
        System.out.println("\n--- 5. VARIABLE SHADOWING (MASQUAGE) ---");
        
        // Affiche la variable de classe
        System.out.println("1. Variable de classe : " + titre);
        
        // Déclaration d'une variable locale avec le MÊME NOM
        String titre = "Titre local (masque la variable de classe)";
        
        // Affiche la variable locale (shadowing)
        System.out.println("2. Variable locale (masquante) : " + titre);
        
        // Pour accéder à la variable de classe masquée, on utilise 'this'
        System.out.println("3. Variable de classe (via this) : " + this.titre);
        
        // Autre exemple avec un entier
        System.out.println("\n--- Exemple avec entier ---");
        System.out.println("Valeur de classe : " + valeur);
        
        int valeur = 200; // Shadowing
        System.out.println("Valeur locale : " + valeur);
        System.out.println("Valeur de classe (this) : " + this.valeur);
        
        // Ce n'est PAS une bonne pratique !
        System.out.println("\n⚠️ Le shadowing est déconseillé car il rend le code ambigu.");
        System.out.println("Préférez des noms différents ou utilisez 'this' explicitement.");
    }
    
    // ==============================================
    // 6. EXEMPLE COMPLET AVEC PLUSIEURS PORTÉES
    // ==============================================
    
    private List<String> historique = new ArrayList<>(); // Portée classe
    
    public void exempleComplet() {
        System.out.println("\n--- 6. EXEMPLE COMPLET (portées imbriquées) ---");
        
        String operation = "Addition"; // Portée méthode
        
        for (int i = 1; i <= 3; i++) { // i : portée boucle
            int resultat = i * 10;      // resultat : portée bloc de la boucle
            
            {
                // Bloc interne supplémentaire
                String details = "Itération " + i + " donne " + resultat;
                System.out.println(details);
                
                // On peut accéder à toutes les portées supérieures
                historique.add(details); // variable de classe
                operation = operation + " " + i; // variable de méthode
            }
            
            // details n'existe plus ici
            // Mais resultat existe encore (dans le bloc de la boucle)
            System.out.println("  resultat vaut toujours : " + resultat);
        }
        
        // i et resultat n'existent plus ici
        System.out.println("\nOpération finale : " + operation);
        System.out.println("Historique : " + historique);
    }
    
    // ==============================================
    // MÉTHODE MAIN (POINT D'ENTRÉE)
    // ==============================================
    public static void main(String[] args) {
        System.out.println("=== DÉMONSTRATION DES PORTÉES DE VARIABLES EN JAVA ===\n");
        
        // Création d'une instance de la classe
        VariableScopeDemo demo = new VariableScopeDemo();
        
        // Appel des différentes méthodes de démonstration
        demo.afficherMessageBienvenue();
        
        demo.exemplePorteeMethode();
        demo.uneAutreMethode();
        
        demo.exemplePorteeBoucle();
        demo.exemplePorteeAccolades();
        
        demo.exempleShadowing();
        demo.exempleComplet();
        
        // Affichage d'un résumé
        System.out.println("\n=== RÉSUMÉ DES PORTÉES ===");
        System.out.println("📦 CLASSE : accessible partout dans la classe");
        System.out.println("🔧 MÉTHODE : accessible seulement dans la méthode");
        System.out.println("🔄 BOUCLE : accessible seulement dans la boucle");
        System.out.println("{} BLOC : accessible seulement dans le bloc d'accolades");
        System.out.println("⚠️ SHADOWING : une variable locale peut masquer une variable de classe");
        System.out.println("\n✅ Fin de la démonstration !");
    }
}