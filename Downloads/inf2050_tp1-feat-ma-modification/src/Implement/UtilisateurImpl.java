package Implement;

import Model.Utilisateur;

import java.util.*;

public class UtilisateurImpl {
    private List<Utilisateur> utilisateurs = new ArrayList<>();

    public void ajouterUtilisateur(Utilisateur u) {
        utilisateurs.add(u);
    }

    public Utilisateur getUtilisateur(String nom) {
        for (Utilisateur u : utilisateurs) {
            if (u.getNom().equals(nom)) {
                return u;
            }
        }
        return null;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }
}
