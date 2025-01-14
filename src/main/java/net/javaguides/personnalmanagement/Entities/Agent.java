package net.javaguides.personnalmanagement.Entities;

import jakarta.persistence.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Entity
@Table(name = "agents")
public class Agent  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId ;

    private String username ;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user ;

    public Agent(Long agentId, String username, User user) {
        this.agentId = agentId;
        this.username = username;
        this.user = user;
    }

    public Agent() {}

    public Long getAgentId() {
        return agentId;
    }

    public void setId(Long id) {
        this.agentId = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
