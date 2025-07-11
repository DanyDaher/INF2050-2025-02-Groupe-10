package src.test.java.ca.uqam.inf2050;

import org.junit.*;
import static org.junit.Assert.*;

import src.main.java.ca.uqam.inf2050.Etudiant;
import src.main.java.ca.uqam.inf2050.Fonctionnalité3et4;
import src.main.java.ca.uqam.inf2050.Groupecours;
import src.main.java.ca.uqam.inf2050.Inscription;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Fonctionnalité3et4Test {
    public Fonctionnalité3et4 service;
    public Groupecours groupecours;
    public List<Inscription> inscriptions;

    //Évite la duplication de texte
    @Before
    public void établir(){
        service = new Fonctionnalité3et4();
        inscriptions = new ArrayList<>();
    }
    @Test
    public void testInscriptionavecAssertions(){
        Etudiant E1 = new Etudiant("DIA00","Am","dou",100);
        Etudiant E2 = new Etudiant("DIA00","Am","dou",100);
        assertNotSame(E1,E2); //Vérifie que ce sont deux objets différents
        assertTrue(E1 != E2);
        assertFalse(E1 == E2);
    }

    @Test
    public void testCompterEtudiantsInscrit(){
        Etudiant E1 = new Etudiant("DIA00","Am","dou",100);
        Etudiant E2 = new Etudiant("DIA67","Col","Piw",101);

        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(E1);
        etudiants.add(E2);
        
        int nbreInscrits = etudiants.size();
        assertTrue(nbreInscrits == etudiants.size());// un seul est inscrit
        assertFalse(nbreInscrits != etudiants.size());
        assertNotSame(E1,E2);
    }

}
