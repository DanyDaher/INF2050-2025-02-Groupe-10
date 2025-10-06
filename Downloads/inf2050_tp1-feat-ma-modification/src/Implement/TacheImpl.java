package Implement;

import Model.Tache;

import java.util.*;

public class TacheImpl {
    private Map<String, Map<String, List<Tache>>> taches = new HashMap<>();

    public void ajouterTache(String projetId, String sprintId, Tache t) {
        taches
                .computeIfAbsent(projetId, k -> new HashMap<>())
                .computeIfAbsent(sprintId, k -> new ArrayList<>())
                .add(t);
    }

    public Tache getTache(String projetId, String sprintId, String tacheId) {
        List<Tache> liste = getTachesParSprint(projetId, sprintId);
        for (Tache t : liste) {
            if (t.getId().equals(tacheId)) return t;
        }
        return null;
    }

    public List<Tache> getTachesParSprint(String projetId, String sprintId) {
        return taches
                .getOrDefault(projetId, new HashMap<>())
                .getOrDefault(sprintId, new ArrayList<>());
    }

    public void assignerTache(String projetId, String sprintId, String tacheId, String utilisateur) {
        Tache t = getTache(projetId, sprintId, tacheId);
        if (t != null) t.setAssigneA(utilisateur);
    }

    public void changerStatut(String projetId, String sprintId, String tacheId, String nouveauStatut) {
        Tache t = getTache(projetId, sprintId, tacheId);
        if (t != null) t.setStatut(nouveauStatut);
    }

    public void supprimerTache(String projetId, String sprintId, String tacheId) {
        List<Tache> liste = getTachesParSprint(projetId, sprintId);
        liste.removeIf(t -> t.getId().equals(tacheId));
    }
}
