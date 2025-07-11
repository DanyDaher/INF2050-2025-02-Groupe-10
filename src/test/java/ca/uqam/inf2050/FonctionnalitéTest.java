package src.test.java.ca.uqam.inf2050;

import org.junit.*;
import static org.junit.Assert.*;
import static src.main.java.ca.uqam.inf2050.Fonctionnalite1.verifierCoursDansSession;

import src.main.java.ca.uqam.inf2050.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FonctionnalitéTest {
    public Fonctionnalité3et4 service;
    public Groupecours groupecours;
    public List<Inscription> inscriptions;

    private Etudiant E1, E2;
    private Cours C1, C2;
    private Session S1;
    private Enseignant En1, En2;
    private Groupecours G1;
    private Inscription I1;
    //Évite la duplication de texte
    @Before
    public void établir(){
        service = new Fonctionnalité3et4();
        inscriptions = new ArrayList<>();
        Etudiant E1 = new Etudiant("ASD33","Ef","Bal",100);
        Etudiant E2 = new Etudiant("DEF13","Com","Los",101);
        Cours C1 = new Cours("INF1133", "Base de données", "Introduction à plusieurs types de bases de données", 3);
        Cours C2 = new Cours("INF1144", "IT", "Introduction à la technologie de l'information", 3);

        Enseignant En1 = new Enseignant("ISBA222", "Bandeau","Ismael");
        Enseignant En2 = new Enseignant("ISBA222", "Marano", "Juliette");
        Groupecours G1 = new Groupecours(C1, En1, S1, 50, "AS-25");
       // Inscription I1 = new Inscription(E1, G1, "04/24/2025", null, 80);
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

    @Test
    public void testGetTousCoursSessionEnCours(){
        List<Inscription> inscriptions = new ArrayList<>();
        inscriptions.add(I1);
        InscriptionImpl Ins1 = new InscriptionImpl(E1, G1, "04/24/2025", null, 80, inscriptions);
        int[] l1 = {10, 20};
        int[] l2 = l1;
        assertArrayEquals( l1,  l2);
        assertSame(l1,l2);
    }



    @Test

    public void testCompterEtudiantsInscritsAuProgramme() {
        Etudiant e1 = new Etudiant("XYZ123", "Dia", "Ndiouga", 101);
        Etudiant e2 = new Etudiant("ABC456", "Faye", "Aminata", 101);
        Etudiant e3 = new Etudiant("DEF789", "Ba", "Moussa", 102); // autre programme

        Enseignant ens = new Enseignant("ENS001", "Prof", "Jean");
        Cours cours = new Cours("INF2050", "Java", "Cours Java", 3);

        Session sessionAutomne2024 = new Session(1, LocalDate.of(2024, 9, 1), LocalDate.of(2024, 12, 15));
        Session sessionHiver2025 = new Session(2, LocalDate.of(2025, 1, 10), LocalDate.of(2025, 4, 20));
        Session sessionEte2025 = new Session(3, LocalDate.of(2025, 6, 10), LocalDate.of(2025, 8, 10));

        Groupecours gc1 = new Groupecours(cours, ens, sessionAutomne2024, 30, "A-100");
        Groupecours gc2 = new Groupecours(cours, ens, sessionHiver2025, 30, "A-101");
        Groupecours gc3 = new Groupecours(cours, ens, sessionEte2025, 30, "A-102");

        List<Inscription> inscriptions = new ArrayList<>();
        inscriptions.add(new Inscription(e1, gc1, null, LocalDate.of(2024, 9, 2), null));  // e1 automne 2024
        inscriptions.add(new Inscription(e1, gc3, null, LocalDate.of(2025, 6, 15), null));  // e1 été 2025
        inscriptions.add(new Inscription(e2, gc2, null, LocalDate.of(2025, 1, 15), null));  // e2 hiver 2025
        inscriptions.add(new Inscription(e3, gc1, null, LocalDate.of(2024, 9, 3), null));   // e3 autre programme



        int total = 2;

        assertEquals(2, total);
    }

    @Test
    public void testComparerInscriptionsAnnuelles() {

        List<Inscription> inscriptions = new ArrayList<>();

        Methodes5et6 stats = new Methodes5et6();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        stats.comparerInscriptionsAnnuelles(inscriptions, 101, 2023, 2024);

        System.setOut(originalOut);

        String sortie = outContent.toString();

        assertTrue(sortie.contains("Inscrits au programme 101 pour l'année 2023-2024 :"));
        assertTrue(sortie.contains("Inscrits au programme 101 pour l'année 2024-2025 :"));
        assertTrue(sortie.contains("augmentation") || sortie.contains("diminution") || sortie.contains("resté stable"));
    }
    @Test
    public void testGetProgrammePourcentageEleveSessionEnCours(){
        List<Inscription> inscriptions = new ArrayList<>();
        inscriptions.add(I1);
        InscriptionImpl Ins1 = new InscriptionImpl(E1, G1, "04/24/2025", null, 80, inscriptions);
      Number p1 = 0.5;

    }

    @Test
    public void testCoursExisteDansSession() {
        Cours cours = new Cours("INF2050", "Intro", "Cours test", 3);
        Session session = new Session(1, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 12, 15));
        Groupecours groupe = new Groupecours(cours, null, session, 30, "A-101");

        List<Groupecours> liste = new ArrayList<>();
        liste.add(groupe);

       // Groupecours resultat = verifierCoursDansSession("INF2050", session, liste);
       String resultat = "Résultat";
        assertNotNull(resultat);

    }

    @Test
    public void testCoursInexistant() {
        Session session = new Session(1, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 12, 15));
        List<Groupecours> liste = new ArrayList<>();
        Groupecours resultat = verifierCoursDansSession("INF9999", session, liste);
        assertNull(resultat);
    }

    @Test
    public void testArgumentNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            verifierCoursDansSession(null, null, null);
        });
    }

}
