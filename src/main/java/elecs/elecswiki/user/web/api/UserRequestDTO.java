package elecs.elecswiki.user.web.api;

import elecs.elecswiki.user.repository.model.Part;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserRequestDTO {

    static UserRequestDTO emptyDTO = new UserRequestDTO(null, null, null, 0, null);
    //long UserIdx;
    private final String userName;
    private final String id;
    private final String password;
    private final int generation;
    private final Part part;

    public static UserRequestDTO getEmptyDTO(){
        return emptyDTO;
    }

}
