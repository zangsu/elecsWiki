package elecs.elecswiki.user.repository.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long UserIdx;

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

    enum Part{
        Guitar, Bass, Vocal, Keyboard, Drum
    }
}
