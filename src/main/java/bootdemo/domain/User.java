package bootdemo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by trq on 2016/6/16.
 */
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    private String id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
