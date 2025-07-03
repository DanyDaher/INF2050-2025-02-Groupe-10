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
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    public Groupecours getGroupeCours() {
        return groupecours;
    }
    public void setGroupeCours(Groupecours groupeCours) {
        this.groupecours = groupeCours;
    }
    public LocalDate getDateAbandon() {
        return dateabandon;
    }
    public void setDateAbandon(LocalDate dateAbandon) {
        this.dateabandon = dateAbandon;
    }
    public LocalDate getDateinscription() {
        return dateinscription;
    }
    public void setDateinscription(LocalDate dateinscription) {
        this.dateinscription = dateinscription;
    }
}
