package models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {

    private long id;
    private String question;
    private int nrbReponses;
    private List<Quizz> quizzs;
    private List<Response> responses;
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    @ManyToMany(mappedBy = "questions")
    public List<Quizz> getQuizzs() {
        return quizzs;
    }

    public void setQuizzs(List<Quizz> quizzs) {
        this.quizzs = quizzs;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getNrbReponses() {
        return nrbReponses;
    }

    public void setNrbReponses(int nrbReponses) {
        this.nrbReponses = nrbReponses;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name="list_responses",
            joinColumns = @JoinColumn(name="question_id"),
            inverseJoinColumns = @JoinColumn(name ="response_id")
    )
    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
}
