package ua.axiom.taskSB.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "UUSER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private static long lastPrimKey = 0;
    public enum Role {CREATOR, ADMIN, USER, GUEST}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    @Enumerated
    private Role role;

    public User(String username, String password, Role role) {
        this.id = ++lastPrimKey;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
