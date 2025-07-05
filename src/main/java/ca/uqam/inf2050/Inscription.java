package src.main.java.ca.uqam.inf2050;

import java.time.LocalDate;

public class Inscription {
    public Etudiant etudiant;
    public Groupecours groupecours;
    public LocalDate dateinscription;
    public LocalDate dateabandon;
    public Number note;

    public Inscription(Etudiant etudiant, Groupecours groupeCours, LocalDate dateInscription,
                       LocalDate dateAbandon, Number note) {
        this.etudiant = etudiant;
        this.groupecours = groupecours;
        this.dateinscription = dateinscription;
        this.dateabandon = dateabandon;
        this.note = note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Groupecours getGroupeCours() {
        return groupecours;
    }

    public LocalDate getDateAbandon() {
        return dateabandon;
    }
}
