package Model;

public class Tache {
    private String id;
    private String titre;
    private String description;
    private String statut;
    private String assigneA;

    public Tache(String id, String titre, String description, String statut, String assigneA) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.statut = statut;
        this.assigneA = assigneA;
    }

    public String getId() { return id; }
    public String getTitre() { return titre; }
    public String getDescription() { return description; }
    public String getStatut() { return statut; }
    public String getAssigneA() { return assigneA; }

    public void setId(String id) { this.id = id; }
    public void setTitre(String titre) { this.titre = titre; }
    public void setDescription(String description) { this.description = description; }
    public void setStatut(String statut) { this.statut = statut; }
    public void setAssigneA(String assigneA) { this.assigneA = assigneA; }
}
