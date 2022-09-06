package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Member {
    @Id
    @GeneratedValue @Column(name="MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String Username;

    @ManyToOne
    @JoinColumn(name="TEAM_ID", insertable = false, updatable = false)
    private Team team;
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<MemberProduct>() ;
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
