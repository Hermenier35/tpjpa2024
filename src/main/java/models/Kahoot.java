package models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Kahoot {
    private long id;
    private Date start_time;
    private Date end_time;
    private Quizz quizz;
    private List<User> players;
    private int timer;
    private int pin;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "kahoot_id")
    public Quizz getQuizz() {
        return quizz;
    }

    public void setQuizz(Quizz quizz) {
        this.quizz = quizz;
    }

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "kahoot_id")
    public List<User> getPlayers() {
        return players;
    }

    public void setPlayers(List<User> players) {
        this.players = players;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
