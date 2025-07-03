import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GroupecoursImpl extends Groupecours {
    private final List<Groupecours> groupecours = new ArrayList<>();
    public GroupecoursImpl(Cours cours, Enseignant enseignant, Session session, Number maxinscriptions, String local, Groupecours groupecours) {
        super(cours, enseignant, session, maxinscriptions, local);
        this.groupecours.add(groupecours);
    }
    public void addGroupecours(Groupecours g) {
        this.groupecours.add(g);
    }

    public Groupecours getGroupecours(String sigle, Number codesession, String local) {
        for (Groupecours g : groupecours) {
            if(g.getCours().getSigle().equals(sigle) &&
                    g.getSession().getCodesession().equals(codesession) &&
                    g.getLocal().equals(local)) {
                return g;
            }
        }
        return null;
    }
}
