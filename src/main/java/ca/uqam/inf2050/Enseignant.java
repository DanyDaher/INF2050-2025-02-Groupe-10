package src.main.java.ca.uqam.inf2050;
public class Enseignant {
    public String codeenseignant;
    public String nom;
    public String prenom;

    public Enseignant(String codeenseignant, String nom, String prenom) {
        this.codeenseignant = codeenseignant;
        this.nom = nom;
        this.prenom = prenom;
    }
    public String getCodeenseignant() {
        return codeenseignant;
    }
    public void setCodeenseignant(String codeenseignant) {
        this.codeenseignant = codeenseignant;
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

    public static class Fonctionnalite1 {
    }
}