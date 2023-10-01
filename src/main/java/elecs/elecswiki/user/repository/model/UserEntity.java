package elecs.elecswiki.user.repository.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long UserIdx;

    @Column(name = "USER_NAME")
    @NotNull
    String userName;

    @Column(name = "USER_GENERATION")
    @NotNull
    int generation;

    @Column(name = "USER_ID")
    @NotNull
    String id;

    @Column(name = "USER_PASSWORD")
    @NotNull
    String password;

    @Column(name = "USER_PART")
    @Enumerated(value = EnumType.STRING)
    @NotNull
    Part part;

}
