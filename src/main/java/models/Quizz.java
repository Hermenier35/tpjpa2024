package models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Quizz {
    private long id;
    private String name;
    private String theme;
    private List<Question> questions;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name="list_questions",
            joinColumns = @JoinColumn(name="quizz_id"),
            inverseJoinColumns = @JoinColumn(name ="question_id")
    )
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
