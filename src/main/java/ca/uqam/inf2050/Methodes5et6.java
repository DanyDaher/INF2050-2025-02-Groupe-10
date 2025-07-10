import java.util.*;
import java.time.LocalDate;
public class Methodes5et6 {
    public int compterEtudiantsInscritsAuProgramme(List<Inscription> inscriptions, int codeProgramme, int anneeDebut) {
        Set<String> etudiantsUniques = new HashSet<>();

        for (Inscription inscription : inscriptions) {
            Etudiant etu = inscription.getEtudiant();
            GroupeCours gc = inscription.getGroupecours();
            Session session = gc.getSession();

            int anneeSession = session.getDatedebut().getYear();

            boolean estDansAnneeAcademique = (
                    (anneeSession == anneeDebut && session.getDatedebut().getMonthValue() >= 8) // Automne
                            || (anneeSession == anneeDebut + 1 && session.getDatedebut().getMonthValue() <= 7) // Hiver/Été
            );

            if (etu.getCodeprogramme().intValue() == codeProgramme && estDansAnneeAcademique) {
                etudiantsUniques.add(etu.getCodepermanent());
            }
        }

        return etudiantsUniques.size();
    }


    // Nouvelle méthode : Comparer deux années consécutives (par exemple 2023-2024 et 2024-2025) en termes du nombre d'inscriptions à un programme
    public void comparerInscriptionsAnnuelles(List<Inscription> inscriptions, int codeProgramme, int anneeDebut1, int anneeDebut2) {
        int totalAnnee1 = compterEtudiantsInscritsAuProgramme(inscriptions, codeProgramme, anneeDebut1);
        int totalAnnee2 = compterEtudiantsInscritsAuProgramme(inscriptions, codeProgramme, anneeDebut2);

        System.out.println("Inscrits au programme " + codeProgramme + " pour l'année " + anneeDebut1 + "-" + (anneeDebut1 + 1) + " : " + totalAnnee1);
        System.out.println("Inscrits au programme " + codeProgramme + " pour l'année " + anneeDebut2 + "-" + (anneeDebut2 + 1) + " : " + totalAnnee2);

        if (totalAnnee2 > totalAnnee1) {
            System.out.println("Il y a eu une augmentation de " + (totalAnnee2 - totalAnnee1) + " inscriptions.");
        } else if (totalAnnee2 < totalAnnee1) {
            System.out.println("Il y a eu une diminution de " + (totalAnnee1 - totalAnnee2) + " inscriptions.");
        } else {
            System.out.println("Le nombre d'inscriptions est resté stable.");
        }
    }


}
