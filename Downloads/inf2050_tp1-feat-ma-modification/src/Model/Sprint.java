package Model;

import java.time.LocalDate;

public class Sprint {
    private String id;
    private int numero;
    private String objectif;
    private LocalDate debut;
    private LocalDate fin;

    public Sprint(String id, int numero, String objectif, LocalDate debut, LocalDate fin) {
        this.id = id;
        this.numero = numero;
        this.objectif = objectif;
        this.debut = debut;
        this.fin = fin;
    }



    public String getId() { return id; }
    public int getNumero() { return numero; }
    public String getObjectif() { return objectif; }
    public LocalDate getDebut() { return debut; }
    public LocalDate getFin() { return fin; }

    public void setId(String id) { this.id = id; }
    public void setNumero(int numero) { this.numero = numero; }
    public void setObjectif(String objectif) { this.objectif = objectif; }
    public void setDebut(LocalDate debut) { this.debut = debut; }
    public void setFin(LocalDate fin) { this.fin = fin; }
}
