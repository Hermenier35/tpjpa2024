package models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Response {

    private long id;
    private String response;
    private boolean isGood;
    private List<Question> questions;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public boolean isGood() {
        return isGood;
    }

    @ManyToMany(mappedBy = "responses")
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
