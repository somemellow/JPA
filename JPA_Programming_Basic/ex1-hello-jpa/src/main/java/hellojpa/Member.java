package hellojpa;

import javax.persistence.*;

@Entity

public class Member {
    public Member(){}
    @Id
    @GeneratedValue @Column(name="MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String Username;

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
