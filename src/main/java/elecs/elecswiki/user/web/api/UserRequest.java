package elecs.elecswiki.user.web.api;

import com.sun.istack.NotNull;
import elecs.elecswiki.user.repository.model.Part;
import lombok.Data;

import javax.persistence.*;

@Data
public class UserRequest {

    long UserIdx;
    String userName;
    String id;
    String password;
    int generation;
    Part part;
}
