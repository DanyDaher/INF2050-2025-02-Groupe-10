package Implement;
import Model.Projet;

import java.util.*;
public class ProjetImpl {
    public List<Projet> projets = new ArrayList<>();

    //Méthode pour ajouter un projet
    public void ajoutProjet(Projet pj ) {
        projets.add(pj);
    }

    //Méthode pour récupérer un projet par ID
    public Projet avoirProjet(String id) {
        for (Projet pj : projets) {
            if (pj.getId().equals(id)){
                return pj;
            }
        }
        //Si rien trouvé
        return null;
    }
    //Méthode pour lister tous les projets
    public List<Projet> getProjets(){
        return projets;
    }
}
