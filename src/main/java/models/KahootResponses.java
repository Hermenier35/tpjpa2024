package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class KahootResponses {
    private long id;
    private long id_kahoot;
    private int time;
    private Response response;
    private int Score;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_kahoot() {
        return id_kahoot;
    }

    public void setId_kahoot(long id_kahoot) {
        this.id_kahoot = id_kahoot;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @OneToOne
    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
