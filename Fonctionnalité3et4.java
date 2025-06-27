
import org.junit.Test;

import static org.junit.Assert.*;

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
    @Test
    public void testInscriptionavecAssertions(){
        Etudiant E1 = new Etudiant("DIA00","Am","dou",100);
        Etudiant E2 = new Etudiant("DIA00","Am","dou",100);
        Groupecours groupecours = new Groupecours();
        assertNotSame(E1,E2); //Vérifie que ce sont deux objets différents
        assertTrue(E1 == E2);
        assertFalse(E1 != E2);
    }
}
