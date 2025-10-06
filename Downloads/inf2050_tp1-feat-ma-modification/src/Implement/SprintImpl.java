package Implement;

import Model.Sprint;

import java.util.*;

public class SprintImpl {
    private Map<String, List<Sprint>> sprintsParProjet = new HashMap<>();

    /**
     *
     * @param projetId voici l'identifiant du projet
     * @param s       ça c'est le sprint à ajouter
     */
    public void ajouterSprint(String projetId, Sprint s) {
       List<Sprint> liste = sprintsParProjet.computeIfAbsent(projetId, x -> new ArrayList<>());

        for (Sprint sprint : liste){

            //Içi on veut ajouter un message d'erreur pour eviter les doublons dans les ID
            if (sprint != null && sprint.getId() != null && sprint.getId().equals(s.getId())) {

                System.out.println("Il y'a un problème , un sprint avec le même ID existe déjà dans ce projet !!");
                return;
            }
        }
        //Rentrons le sprint
        liste.add(s);
        System.out.println("Un sprint a été ajouté au projet " + projetId + " : " + s.getObjectif());
    }

    /**
     *
     * @param projetId
     * @param sprintId
     * @return
     * Récupérons un sprint d'un projet
     */
    public Sprint getSprint(String projetId, String sprintId) {
        List<Sprint> sprints = sprintsParProjet.getOrDefault(projetId, new ArrayList<>());
        for (Sprint sp : sprints) {
            if (sp.getId().equals(sprintId)) {
                return sp;
            }
        }
        //Rien trouvé
        return null;
    }

    public List<Sprint> getSprintsParProjet(String projetId) {
        return sprintsParProjet.getOrDefault(projetId, new ArrayList<>());
    }
}

