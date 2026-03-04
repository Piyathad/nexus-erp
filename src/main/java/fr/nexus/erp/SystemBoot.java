package fr.nexus.erp;

public class SystemBoot {

    public static boolean verifierAcces(int niveau) {
        if (niveau >= 5) {
            System.out.println("Accès autorisé. Niveau : " + niveau);
            return true;
        } else {
            System.out.println("Accès refusé. Niveau insuffisant : " + niveau);
            return false;
        }
    }

    public static void afficherEtapes() {
        String[] etapes = {"Initialisation", "Connexion DB", "Nettoyage", "Export"};

        System.out.println("============================================");
        System.out.println("ÉTAPES DU PROGRAMME :");
        for (String etape : etapes) {
            System.out.println("  → " + etape);
        }
        System.out.println("============================================");
    }
}