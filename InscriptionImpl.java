package target;

public class InscriptionImpl extends Inscription{
    private final List<Inscription> inscriptions = new ArrayList<>();

    public InscriptionImpl(List<Inscription> inscriptions) {
        super();
        this.inscriptions = inscriptions;
    }
    void addInscription(Inscription i);
    public Inscription getInscription (String codePermanent);
    List<Inscription> getInscriptionsCodeProgramme(Number codeProgramme);
}
