package src.main.java.ca.uqam.inf2050;
public class Groupecours {
    public Cours cours;
    public Enseignant enseignant;
    public Session session;
    public Number maxinscriptions;
    public String local;

    public Groupecours(Cours cours, Enseignant ens, Session sessionAutomne2024, int i, String s) {
        this.cours = cours;
        this.enseignant = enseignant;
        this.session = session;
        this.maxinscriptions = maxinscriptions;
        this.local = local;
    }




    public Cours getCours() {
        return cours;
    }
    public void setCours(Cours cours) {
        this.cours = cours;
    }
    public Enseignant getEnseignant() {
        return enseignant;
    }
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
    public Session getSession() {
        return session;
    }
    public void setSession(Session session) {
        this.session = session;
    }
    public Number getMaxinscriptions() {
        return maxinscriptions;
    }
    public void setMaxinscriptions(Number maxinscriptions) {
        this.maxinscriptions = maxinscriptions;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
}