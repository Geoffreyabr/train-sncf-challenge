package Entity;

public class Agent {
    private Long id;
    private String nom;
    private String prenom;
    private String numMatricule;
    private String specialite;

    public Agent(Long id) {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumMatricule() {
        return numMatricule;
    }

    public void setNumMatricule(String numMatricule) {
        this.numMatricule = numMatricule;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
