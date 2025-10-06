

import Controleur.SprindoController;
import Model.*;
import Vue.SprindoVue;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SprindoController controller = new SprindoController();
        int choix = -1;

        while (choix != 10) {
            SprindoVue.afficherMenu();
            String input = scan.nextLine().trim();
            try {
                choix = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un chiffre valide.");
                continue;
            }

            switch (choix) {
                case 1: // Ajouter projet
                    System.out.print("ID: ");
                    String id = scan.nextLine().trim();
                    if (controller.avoirProjet(id) != null) {
                        System.out.println("ID déjà existant.");
                        break;
                    }
                    System.out.print("Nom: ");
                    String nom = scan.nextLine().trim();
                    System.out.print("Description: ");
                    String desc = scan.nextLine().trim();
                    Projet p = new Projet(id, nom, desc);
                    controller.ajoutProjet(p);
                    System.out.println("Projet ajouté.");
                    break;

                case 2: // Afficher projets
                    List<Projet> projets = controller.getProjets();
                    SprindoVue.afficherProjets(projets);
                    break;

                case 3: // Ajouter sprint
                    System.out.print("ID projet: ");
                    String pId = scan.nextLine().trim();
                    if (controller.avoirProjet(pId) == null) {
                        System.out.println("Projet introuvable.");
                        break;
                    }
                    System.out.print("ID sprint: ");
                    String sId = scan.nextLine().trim();
                    System.out.print("Numéro: ");
                    int numero = Integer.parseInt(scan.nextLine().trim());
                    System.out.print("Objectif: ");
                    String objectif = scan.nextLine().trim();
                    System.out.print("Début (YYYY-MM-DD): ");
                    LocalDate debut = controller.parseDate(scan.nextLine().trim());
                    System.out.print("Fin (YYYY-MM-DD): ");
                    LocalDate fin = controller.parseDate(scan.nextLine().trim());
                    Sprint s = new Sprint(sId, numero, objectif, debut, fin);
                    controller.ajouterSprint(pId, s);
                    System.out.println("Sprint ajouté.");
                    break;

                case 4: // Afficher sprints
                    System.out.print("ID projet: ");
                    String projId = scan.nextLine().trim();
                    List<Sprint> sprints = controller.getSprintsParProjet(projId);
                    SprindoVue.afficherSprints(sprints);
                    break;
                case 5: // Ajouter tâche
                    System.out.print("ID projet: ");
                    String pID = scan.nextLine().trim();
                    System.out.print("ID sprint: ");
                    String sID = scan.nextLine().trim();

                    if (controller.avoirProjet(pID) == null || controller.getSprint(pID, sID) == null) {
                        System.out.println("Projet ou sprint introuvable.");
                        break;
                    }

                    System.out.print("ID tâche: ");
                    String tId = scan.nextLine().trim();

                    System.out.print("Titre: ");
                    String tTitre = scan.nextLine().trim();

                    System.out.print("Description: ");
                    String tDesc = scan.nextLine().trim();

                    System.out.print("Statut (ex: A FAIRE): ");
                    String tStatut = scan.nextLine().trim();

                    if (tStatut.isEmpty()) tStatut = "A FAIRE";

                    System.out.print("Assignée à (nom utilisateur): ");
                    String assign = scan.nextLine().trim();

                    Tache tache = new Tache(tId, tTitre, tDesc, tStatut, assign);
                    controller.ajouterTache(pID, sID, tache);
                    System.out.println("Tâche ajoutée.");
                    break;


                case 6: // Afficher tâches
                    System.out.print("ID projet: ");
                    String pIdT = scan.nextLine().trim();
                    System.out.print("ID sprint: ");
                    String sIdT = scan.nextLine().trim();
                    List<Tache> taches = controller.getTachesParSprint(pIdT, sIdT);
                    SprindoVue.afficherTaches(taches);
                    break;
                case 7: // Assigner tâche
                    System.out.print("ID projet: ");
                    String pAssign = scan.nextLine().trim();
                    System.out.print("ID sprint: ");
                    String sAssign = scan.nextLine().trim();
                    System.out.print("ID tâche: ");
                    String tAssign = scan.nextLine().trim();
                    System.out.print("Nom utilisateur: ");
                    String userNom = scan.nextLine().trim();

                    // Créer l'utilisateur si non existant
                    if (controller.getUtilisateur(userNom) == null) {
                        Utilisateur u = new Utilisateur(userNom, "DEVELOPPEUR");
                        controller.ajouterUtilisateur(u);
                    }

                    controller.assignerTache(pAssign, sAssign, tAssign, userNom);
                    System.out.println("Tâche assignée à " + userNom);
                    break;

                case 8: // Modifier le statut de la tâche
                    System.out.print("ID projet: ");
                    String pStatut = scan.nextLine().trim();
                    System.out.print("ID sprint: ");
                    String sStatut = scan.nextLine().trim();
                    System.out.print("ID tâche: ");
                    tStatut = scan.nextLine().trim();
                    System.out.print("Nouveau statut: ");
                    String nouveauStatut = scan.nextLine().trim();
                    controller.changerStatut(pStatut, sStatut, tStatut, nouveauStatut);
                    System.out.println("Statut modifié si la tâche existait.");
                    break;

                case 9: // Supprimer une tâche
                    System.out.print("ID projet: ");
                    String pDel = scan.nextLine().trim();
                    System.out.print("ID sprint: ");
                    String sDel = scan.nextLine().trim();
                    System.out.print("ID tâche: ");
                    String tDel = scan.nextLine().trim();
                    controller.supprimerTache(pDel, sDel, tDel);
                    System.out.println("Tâche supprimée si elle existait.");
                    break;

                case 10:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
            System.out.println();
        }
        scan.close();
    }
}



