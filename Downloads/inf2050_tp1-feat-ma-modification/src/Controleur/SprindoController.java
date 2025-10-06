package Controleur;

import Implement.ProjetImpl;
import Implement.SprintImpl;
import Implement.TacheImpl;
import Implement.UtilisateurImpl;
import Model.Projet;
import Model.Sprint;
import Model.Tache;
import Model.Utilisateur;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class SprindoController {
                                                                                    /**Hadj chaabane Malek**/
    // Instanciation des gestionnaires (DAO) pour la gestion en mémoire
    private final ProjetImpl projetImpl = new ProjetImpl();
    private final SprintImpl sprintImpl = new SprintImpl();
    private final TacheImpl tacheImpl = new TacheImpl();
    private final UtilisateurImpl utilisateurImpl = new UtilisateurImpl();

    /** =================== Gestion des projets =================== **/

    // Ajouter un projet dans la liste
    public void ajoutProjet(Projet p) {
        projetImpl.ajoutProjet(p);
    }

    // Récupérer un projet par son ID
    public Projet avoirProjet(String id) {
        return projetImpl.avoirProjet(id);
    }

    // Récupérer la liste de tous les projets
    public List<Projet> getProjets() {
        return projetImpl.getProjets();
    }

    /** =================== Gestion des sprints =================== **/

    // Ajouter un sprint à un projet (identifié par projetId)
    public void ajouterSprint(String projetId, Sprint s) {
        sprintImpl.ajouterSprint(projetId, s);
    }

    // Récupérer un sprint spécifique d’un projet
    public Sprint getSprint(String projetId, String sprintId) {
        return sprintImpl.getSprint(projetId, sprintId);
    }

    // Récupérer la liste des sprints d’un projet
    public List<Sprint> getSprintsParProjet(String projetId) {
        return sprintImpl.getSprintsParProjet(projetId);
    }

    /** =================== Gestion des tâches =================== **/

    // Ajouter une tâche à un sprint d’un projet
    public void ajouterTache(String projetId, String sprintId, Tache t) {
        tacheImpl.ajouterTache(projetId, sprintId, t);
    }

    // Récupérer une tâche spécifique d’un sprint
    public Tache getTache(String projetId, String sprintId, String tacheId) {
        return tacheImpl.getTache(projetId, sprintId, tacheId);
    }

    // Récupérer toutes les tâches d’un sprint
    public List<Tache> getTachesParSprint(String projetId, String sprintId) {
        return tacheImpl.getTachesParSprint(projetId, sprintId);
    }

    // Assigner une tâche à un utilisateur
    public void assignerTache(String projetId, String sprintId, String tacheId, String utilisateur) {
        tacheImpl.assignerTache(projetId, sprintId, tacheId, utilisateur);
    }

    // Modifier le statut d’une tâche
    public void changerStatut(String projetId, String sprintId, String tacheId, String nouveauStatut) {
        tacheImpl.changerStatut(projetId, sprintId, tacheId, nouveauStatut);
    }

    // Supprimer une tâche
    public void supprimerTache(String projetId, String sprintId, String tacheId) {
        tacheImpl.supprimerTache(projetId, sprintId, tacheId);
    }
                                                                                       /**Hadj chaabane Malek**/
    /** =================== Gestion des utilisateurs =================== **/

    // Ajouter un utilisateur
    public void ajouterUtilisateur(Utilisateur u) {
        utilisateurImpl.ajouterUtilisateur(u);
    }

    // Récupérer un utilisateur par son nom
    public Utilisateur getUtilisateur(String nom) {
        return utilisateurImpl.getUtilisateur(nom);
    }

    // Récupérer la liste de tous les utilisateurs
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurImpl.getUtilisateurs();
    }
                                                                                  /**Hadj chaabane Malek**/
    /** =================== Gestion des dates =================== **/

    // Convertir une chaîne en LocalDate
    public LocalDate parseDate(String s) {
        if (s == null || s.trim().isEmpty()) return null; // si vide, renvoie null
        try {
            return LocalDate.parse(s);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}

