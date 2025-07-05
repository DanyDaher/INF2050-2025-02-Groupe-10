import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class InscriptionImpl extends Inscription{
    private final List<Inscription> inscriptions = new ArrayList<>();

    public InscriptionImpl(Etudiant etudiant, Groupecours groupeCours, LocalDate dateInscription,
                           LocalDate dateAbandon, Number note,List<Inscription> inscriptions) {
        super(etudiant, groupeCours, dateInscription, dateAbandon, note);
        this.inscriptions.addAll(inscriptions);
    }
    void addInscription(Inscription i) {
        this.inscriptions.add(i);
    }
    public Inscription getInscription (String codePermanent) {
        for (Inscription i : inscriptions) {
            if(i.getEtudiant().getCodePermanent().equals(codePermanent)) {
                return i;
            }
        }
        return null;
    }
    List<Inscription> getInscriptionsCodeProgramme(Number codeProgramme) {
        List<Inscription> inscriptionsCodeProgramme = inscriptions;
        for (Inscription i : inscriptionsCodeProgramme) {
            if(!i.getEtudiant().getCodeProgramme().equals(codeProgramme)) {
                inscriptionsCodeProgramme.remove(i);
            }
        }
        return inscriptionsCodeProgramme;
    }
}
