package fr.nexus.erp;

public class Main {

    public static void main(String[] args) {

        boolean accesAutorise = SystemBoot.verifierAcces(7);

        if (!accesAutorise) {
            System.out.println("Arrêt du programme.");
            return;
        }

        SystemBoot.afficherEtapes();

        DataEngine.runPipeline();
    }
}