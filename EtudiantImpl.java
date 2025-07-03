import java.util.List;
import java.util.ArrayList;

public class EtudiantImpl extends Etudiant {
    private final List<Etudiant> etudiants = new ArrayList<>();

    public EtudiantImpl(String codepermanent,String nom, String prenom, Number codeprogramme, List<Etudiant> etudiants) {
        super(codepermanent, nom, prenom, codeprogramme);
        this.etudiants.addAll(etudiants);
    }

    void addEtudiant(Etudiant e) {
        etudiants.add(e);
    }

    public Etudiant getEtudiant(String codePermanent) {
        for (Etudiant et : etudiants) {
            if(et.getCodePermanent().equals(codePermanent)) {
                return et;
            }
        }
        return null;
    }

    List<Etudiant> getEtudiantsCodeProgramme(Number codeProgramme) {
        List<Etudiant> etudiantsCodeProgramme = etudiants;
        for (Etudiant et : etudiantsCodeProgramme) {
            if(!et.getCodeProgramme().equals(codeProgramme)) {
                etudiantsCodeProgramme.remove(et);
            }
        }
        return etudiantsCodeProgramme;
    }
}
