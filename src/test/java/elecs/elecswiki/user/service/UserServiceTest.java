package elecs.elecswiki.user.service;

import elecs.elecswiki.user.repository.model.Part;
import elecs.elecswiki.user.web.api.UserRequestDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    @Transactional
    public void saveUser() throws Exception {
        //given
        UserRequestDTO userRequestDTO = new UserRequestDTO("userName", "userId", "password", 42, Part.Bass);

        //when
        long savedIdx = userService.saveUser(userRequestDTO);
        UserRequestDTO findUserDTO = userService.findUser(savedIdx);

        //then
        assertThat(userRequestDTO.getUserName()).isEqualTo(findUserDTO.getUserName());
        assertThat(userRequestDTO.getId()).isEqualTo(findUserDTO.getId());
        assertThat(userRequestDTO.getPassword()).isEqualTo(findUserDTO.getPassword());
        assertThat(userRequestDTO.getGeneration()).isEqualTo(findUserDTO.getGeneration());
        assertThat(userRequestDTO.getPart()).isEqualTo(findUserDTO.getPart());
    }
}