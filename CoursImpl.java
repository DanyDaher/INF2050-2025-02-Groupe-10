import java.util.ArrayList;
import java.util.List;

public class CoursImpl extends Cours {
    private final List<Cours> cours = new ArrayList<>();

    public CoursImpl(String sigle, String titre, String description, Number nbcredits, List<Cours> cours) {
        super(sigle, titre, description, nbcredits);
        this.cours.addAll(cours);
    }

    void addCours(Cours c) {
        cours.add(c);
    }

    public Cours getCours (String sigle) {
        for (Cours c : cours) {
            if(c.getSigle().equals(sigle)) {
                return c;
            }
        }
        return null;
    }
}
