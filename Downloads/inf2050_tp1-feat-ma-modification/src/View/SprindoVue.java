package Vue;

import Model.Projet;
import Model.Sprint;
import Model.Tache;

import java.util.List;

public class SprindoVue {
    public static void afficherMenu() {
        System.out.println("====== SPRINDO - GESTION DE PROJETS AGILES ======");
        System.out.println("1. Ajouter un projet");
        System.out.println("2. Afficher la liste des projets");
        System.out.println("3. Ajouter un sprint à un projet");
        System.out.println("4. Afficher les sprints d'un projet");
        System.out.println("5. Ajouter une tâche à un sprint");
        System.out.println("6. Afficher les tâches d'un sprint");
        System.out.println("7. Assigner une tâche à un utilisateur");
        System.out.println("8. Modifier le statut d'une tâche");
        System.out.println("9. Supprimer une tâche");
        System.out.println("10. Quitter l'application");
        System.out.print("Choisissez votre option => ");
    }

    public static void afficherProjets(List<Projet> projets) {
        System.out.println("=== Liste des projets ===");
        if (projets == null || projets.isEmpty()) {
            System.out.println("(vide)");
            return;
        }
        for (Projet p : projets) {
            System.out.println("ID => " + p.getId());
            System.out.println("Nom => " + p.getNom());
            System.out.println("Description => " + p.getDescription());
            System.out.println();
        }
    }

    public static void afficherSprints(List<Sprint> sprints) {
        System.out.println("=== Sprints ===");
        if (sprints == null || sprints.isEmpty()) {
            System.out.println("(vide)");
            return;
        }
        for (Sprint s : sprints) {
            System.out.println("ID => " + s.getId());
            System.out.println("N° => " + s.getNumero());
            System.out.println("Objectif => " + s.getObjectif());
            System.out.println("Début => " + (s.getDebut() == null ? "null" : s.getDebut()));
            System.out.println("Fin => " + (s.getFin() == null ? "null" : s.getFin()));
            System.out.println();
        }
    }

    public static void afficherTaches(List<Tache> taches) {
        System.out.println("=== Tâches ===");
        if (taches == null || taches.isEmpty()) {
            System.out.println("(vide)");
            return;
        }
        for (Tache t : taches) {
            System.out.println("ID => " + t.getId());
            System.out.println("Titre => " + t.getTitre());
            System.out.println("Description => " + t.getDescription());
            System.out.println("Statut => " + t.getStatut());
            System.out.println("Assignée à => " + t.getAssigneA());
            System.out.println();
        }
    }

    public static void message(String msg) {
        System.out.println(msg);
    }
}



