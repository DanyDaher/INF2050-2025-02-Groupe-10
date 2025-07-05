package src.main.java.ca.uqam.inf2050;

public class Etudiant {
    public String codepermanent;
    public String nom;
    public String prenom;
    public Number codeprogramme;

    public Etudiant(String codepermanent,String nom, String prenom, Number codeprogramme){
        this.codepermanent=codepermanent;
        this.nom=nom;
        this.prenom=prenom;
        this.codeprogramme=codeprogramme;
    }
}