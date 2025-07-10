package src.main.java.ca.uqam.inf2050;
import java.util.*;
import java.time.LocalDate;

public class InscriptionImpl extends Inscription {
    private final List<Inscription> inscriptions = new ArrayList<>();

    public InscriptionImpl(Etudiant etudiant, Groupecours groupeCours, LocalDate dateInscription,
                           LocalDate dateAbandon, Number note,List<Inscription> inscriptions) {
        super(etudiant, groupeCours, dateInscription, dateAbandon, note);
        this.inscriptions.addAll(inscriptions);
    }
    void addInscription(Inscription i) {
        this.inscriptions.add(i);
    }

    public Inscription getInscription (String codePermanent) {
        for (Inscription i : inscriptions) {
            if(i.getEtudiant().getCodePermanent().equals(codePermanent)) {
                return i;
            }
        }
        return null;
    }
    List<Inscription> getInscriptionsCodeProgramme(Number codeProgramme) {
        List<Inscription> inscriptionsCodeProgramme = inscriptions;
        for (Inscription i : inscriptionsCodeProgramme) {
            if(!i.getEtudiant().getCodeProgramme().equals(codeProgramme)) {
                inscriptionsCodeProgramme.remove(i);
            }
        }
        return inscriptionsCodeProgramme;
    }

    //Fonctionnalité 2
    public List<Cours> getTousCoursSessionEnCours(Number codeProgramme) {
        List<Cours> tousCoursSessionEnCours = new ArrayList<>();
        for (Inscription i : inscriptions) {
            if(i.getEtudiant().getCodeProgramme().equals(codeProgramme) && i.getGroupeCours().getSession().getDatefin() == null) {
                tousCoursSessionEnCours.add(i.getGroupeCours().getCours());
            }
        }
        return tousCoursSessionEnCours;
    }

    //Fonctionnalité 3
    public List<Etudiant> avoirEtudiantsInscrits(Groupecours groupe, List<Inscription> inscriptions) {
        List<Etudiant> resultat = new ArrayList<>();
        for (Inscription i : inscriptions) {
            if (i.getGroupeCours().equals(groupe)) {
                resultat.add(i.getEtudiant());
            }
        }
        return resultat;
    }

    //Fonctionnalité 4
    public int compterEtudiantsInscrits(Groupecours groupe, List<Inscription> inscriptions) {
        int compteur = 0;
        for (Inscription i : inscriptions) {
            if (i.getGroupeCours().equals(groupe) && i.getDateAbandon() == null) {
                compteur++;
            }
        }
        return compteur;
    }

    //Fonctionnalité 5
    public int compterEtudiantsInscritsAuProgramme(List<Inscription> inscriptions, int codeProgramme, int anneeDebut) {
        Set<String> etudiantsUniques = new HashSet<>();

        for (Inscription inscription : inscriptions) {
            Etudiant etu = inscription.getEtudiant();
            Groupecours gc = inscription.getGroupeCours();
            Session session = gc.getSession();

            int anneeSession = session.getDatedebut().getYear();

            boolean estDansAnneeAcademique = (
                    (anneeSession == anneeDebut && session.getDatedebut().getMonthValue() >= 8) // Automne
                            || (anneeSession == anneeDebut + 1 && session.getDatedebut().getMonthValue() <= 7) // Hiver/Été
            )

            if (etu.getCodeProgramme().intValue() == codeProgramme && estDansAnneeAcademique) {
                etudiantsUniques.add(etu.getCodePermanent());
            }
        }
        return etudiantsUniques.size();
    }


    //Fonctionnalité 6
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

    //Fonctionnalité 7
    Number getProgrammePourcentageEleveSessionEnCours() {
        List<Number> codesProgramme = new ArrayList<>();
        Number programmePourcentageEleveSessionEnCours = 0;
        for (Inscription i : inscriptions) {
            for (Number cp: codesProgramme) {
                if (i.getEtudiant().getCodeProgramme().equals(cp)) {
                    break;
                }
            }
            codesProgramme.add(i.getEtudiant().getCodeProgramme());
        }

        for (Number cp: codesProgramme) {
            for (Inscription i : inscriptions) {
                if(i.getEtudiant().getCodeProgramme().equals(cp) && compterEtudiantsInscrits(i.getGroupeCours(), inscriptions)/i.getGroupeCours().maxinscriptions > programmePourcentageEleveSessionEnCours) {
                    programmePourcentageEleveSessionEnCours = compterEtudiantsInscrits(i.getGroupeCours(), inscriptions)/i.getGroupeCours().maxinscriptions > programmePourcentageEleveSessionEnCours;
                }
            }
        }
        return programmePourcentageEleveSessionEnCours;
    }
}
