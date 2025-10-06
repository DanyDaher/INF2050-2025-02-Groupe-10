package Model;

public class Utilisateur {
    private String nom;
    private String role;

    // Constructeur
    public Utilisateur(String nom, String role) {
        this.nom = nom;
        this.role = role;
    }

    // Getter pour nom
    public String getNom() {
        return nom;
    }

    // Getter pour role
    public String getRole() {
        return role;
    }

    // Setter pour nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Setter pour role
    public void setRole(String role) {
        this.role = role;
    }
}
