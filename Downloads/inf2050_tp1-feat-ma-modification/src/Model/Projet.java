package Model;

public class Projet {
    private String id;
    private String nom;
    private String description;

    // Constructeur
    public Projet(String id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    // Les getters
    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
