package src.main.java.ca.uqam.inf2050;
public class Etudiant {
    public String codepermanent;
    public String nom;
    public String prenom;
    public Number codeprogramme;

    public Etudiant(String codepermanent, String nom, String prenom, Number codeprogramme){
        this.codepermanent=codepermanent;
        this.nom=nom;
        this.prenom=prenom;
        this.codeprogramme=codeprogramme;
    }

    public String getCodePermanent() {
        return codepermanent;
    }
    public void setCodePermanent(String codepermanent) {
        this.codepermanent = codepermanent;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Number getCodeProgramme() {
        return codeprogramme;
    }
    public void setCodeProgramme(Number codeprogramme) {
        this.codeprogramme = codeprogramme;
    }
}