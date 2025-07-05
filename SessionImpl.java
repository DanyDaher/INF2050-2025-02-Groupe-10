import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SessionImpl extends Session {
    private final List<Session> sessions = new ArrayList<>();

    public SessionImpl(Number codesession, LocalDate datedebut, LocalDate datefin, List<Session> sessions) {
        super(codesession, datedebut, datefin);
        this.sessions.addAll(sessions);
    }
    public void addSessions() {
        sessions.add(this);
    }
    public Session getSession(Number codesession) {
        for (Session s : sessions) {
            if (s.getCodesession().equals(codesession)) {
                return s;
            }
        }
        return null;
    }
}
