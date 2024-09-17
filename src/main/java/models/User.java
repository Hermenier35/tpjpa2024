package models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    private long id;
    private String nom;
    private String prenom;

    private String pseudo;
    private String type;
    private List<Quizz> created_quizzs;
    private List<KahootResponses> responses_kahoot;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    public List<Quizz> getCreated_quizzs() {
        return created_quizzs;
    }

    public void setCreated_quizzs(List<Quizz> created_quizzs) {
        this.created_quizzs = created_quizzs;
    }

    @OneToMany()
    @JoinColumn(name = "user_id")
    public List<KahootResponses> getResponses_kahoot() {
        return responses_kahoot;
    }

    public void setResponses_kahoot(List<KahootResponses> responses_kahoot) {
        this.responses_kahoot = responses_kahoot;
    }
}
