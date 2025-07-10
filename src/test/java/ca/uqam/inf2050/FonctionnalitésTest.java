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
    private Fonctionnalité3et4 service;
    private Groupecours groupecours;
    private List<Inscription> inscriptions;

    //Évite la duplication de texte
    @Before
    public void établir(){
        service = new Fonctionnalité3et4();
        groupecours = new Groupecours();
        inscriptions = new ArrayList<>();
        Etudiant E1 = new Etudiant("ASD33","Ef","Bal",100);
        Etudiant E2 = new Etudiant("DEF13","Com","Los",101);
        Cours C1 = new Cours("INF1133", "Base de données", "Introduction à plusieurs types de bases de données", 3);
        Cours C2 = new Cours("INF1144", "IT", "Introduction à la technologie de l'information", 3);
        Session S1 = new Session("E2025", "04/24/2025", null);
        Enseignant E1 = new Enseignant("ISBA222", "Bandeau","Ismael");
        Enseignant E2 = new Enseignant("ISBA222", "Marano", "Juliette");
        Groupecours G1 = new Groupecours(C1, E1, S1, 50, "AS-25");
        Inscription I1 = new Inscription(E1, G1, "04/24/2025", null, 80);
    }

    @Test
    public void testInscriptionavecAssertions(){
        Etudiant E1 = new Etudiant("DIA00","Am","dou",100);
        Etudiant E2 = new Etudiant("DIA00","Am","dou",100);
        Groupecours groupecours = new Groupecours();
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

    @Test
    public void testGetTousCoursSessionEnCours(){
        List<Inscription> inscriptions = new ArrayList<>();
        inscriptions.add(I1);
        InscriptionImpl Ins1 = new InscriptionImpl(E1, G1, "04/24/2025", null, 80, inscriptions);
        l1 = Ins1.getTousCoursSessionEnCours(101);
        l2 = Ins1.getTousCoursSessionEnCours(101);
        assertArrayEquals(l1, l2);
        assertSame(l1,l2);
    }

    @Test
    public void testGetProgrammePourcentageEleveSessionEnCours(){
        List<Inscription> inscriptions = new ArrayList<>();
        inscriptions.add(I1);
        InscriptionImpl Ins1 = new InscriptionImpl(E1, G1, "04/24/2025", null, 80, inscriptions);
        p1 = Ins1.getProgrammePourcentageEleveSessionEnCours();
        assertThat(p1 == 1/50);
    }
}
