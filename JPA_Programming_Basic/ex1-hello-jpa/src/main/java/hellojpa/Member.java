package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MBR")
public class Member {
    public Member(){}
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String Username;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
