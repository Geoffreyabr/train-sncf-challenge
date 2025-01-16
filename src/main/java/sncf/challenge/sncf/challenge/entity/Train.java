package sncf.challenge.sncf.challenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Train {
    @Id
    private Long id;

    @ManyToMany(mappedBy = "trains")
    private List<Agent> agents;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public List<Agent> getAgents() {
        return agents;
    }
}
