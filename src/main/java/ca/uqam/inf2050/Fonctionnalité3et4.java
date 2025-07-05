package src.main.java.ca.uqam.inf2050;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fonctionnalité3et4 {
    public List<Etudiant> avoirEtudiantsInscrits(Groupecours groupe, List<Inscription> inscriptions) {
        List<Etudiant> resultat = new ArrayList<>();
        for (Inscription i : inscriptions) {
            if (i.getGroupeCours().equals(groupe)) {
                resultat.add(i.getEtudiant());
            }
        }
        return resultat;
    }

    public int compterEtudiantsInscrits(Groupecours groupe, List<Inscription> inscriptions) {
        int compteur = 0;
        for (Inscription i : inscriptions) {
            if (i.getGroupeCours().equals(groupe) && i.getDateAbandon() == null) {
                compteur++;
            }
        }
        return compteur;
    }



}
