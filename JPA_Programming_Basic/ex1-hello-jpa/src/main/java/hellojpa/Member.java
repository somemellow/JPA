package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator( name = "member_seq_generator", sequenceName = "member_seq")
public class Member {
    public Member(){}
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;
    @Column(name = "name", nullable = false)
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
