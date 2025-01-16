package sncf.challenge.sncf.challenge.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Agent {
    @Id
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "agent_train",
            joinColumns = @JoinColumn(name = "agent_id"),
            inverseJoinColumns = @JoinColumn(name = "train_id")
    )
    private List<Train> trains;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public List<Train> getTrains() {
        return trains;
    }
}
