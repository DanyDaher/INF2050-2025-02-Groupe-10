package src.main.java.ca.uqam.inf2050;



import java.util.List;



public class Fonctionnalite1 {

    public static  Groupecours verifierCoursDansSession(String sigleCours, Session sessionActuelle, List<Groupecours> groupeCoursListe) {
        if (sigleCours == null || sessionActuelle == null || groupeCoursListe == null) {
            throw new IllegalArgumentException("Les arguments ne doivent pas être null !");
        }

        for (Groupecours groupe : groupeCoursListe) {
            if (groupe.cours != null && sigleCours.equals(groupe.cours.sigle)
                    && sessionActuelle.equals(groupe.session)) {
                return groupe;
            }
        }
        return null;
    }


}
