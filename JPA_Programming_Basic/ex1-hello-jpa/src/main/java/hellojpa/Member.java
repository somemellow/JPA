package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Member {
    public Member(){}
    @Id
    @GeneratedValue @Column(name="MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String Username;
//    @Column(name= "TEMA_ID")
//    private Long teamId;
    @ManyToOne @JoinColumn(name="TEAM_ID")
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

}
