package src.main.java.ca.uqam.inf2050;
import java.time.LocalDate;

public class Session {
    public Number codesession;
    public LocalDate datedebut;
    public LocalDate datefin;

    public Session(Number codesession, LocalDate datedebut, LocalDate datefin) {
        this.codesession = codesession;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }
    public Number getCodesession() {
        return codesession;
    }
    public void setCodesession(Number codesession) {
        this.codesession = codesession;
    }
    public LocalDate getDatedebut() {
        return datedebut;
    }
    public void setDatedebut(LocalDate datedebut) {
        this.datedebut = datedebut;
    }
    public LocalDate getDatefin() {
        return datefin;
    }
    public void setDatefin(LocalDate datefin) {
        this.datefin = datefin;
    }
}