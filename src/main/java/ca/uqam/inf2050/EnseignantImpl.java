package src.main.java.ca.uqam.inf2050;
import java.util.ArrayList;
import java.util.List;

public class EnseignantImpl extends Enseignant {
    private final List<Enseignant> enseignants = new ArrayList<>();

    public EnseignantImpl(String codeenseignant, String nom, String prenom, List<Enseignant> enseignants) {
        super(codeenseignant, nom, prenom);
        this.enseignants.addAll(enseignants);
    }
    public void addEnseignant(Enseignant e) {
        enseignants.add(e);
    }
    public Enseignant getEnseignants(String codeenseignant) {
        for (Enseignant e : enseignants) {
            if (e.getCodeenseignant().equals(codeenseignant)) {
                return e;
            }
        }
        return null;
    }
}
