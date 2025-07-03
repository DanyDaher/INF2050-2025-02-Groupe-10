import org.junit.*;
import static org.junit.Assert.*;

public class Cours {
    public String sigle;
    public String titre;
    public String description;
    public Number nbcredits;

    public Cours(String sigle, String titre, String description, Number nbcredits) {
        this.sigle = sigle;
        this.titre = titre;
        this.description = description;
        this.nbcredits = nbcredits;
    }
    public String getSigle() {
        return sigle;
    }
    public void setSigle(String sigle) {
        this.sigle = sigle;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Number getNbcredits() {
        return nbcredits;
    }
    public void setNbcredits(Number nbcredits) {
        this.nbcredits = nbcredits;
    }
}