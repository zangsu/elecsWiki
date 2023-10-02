package elecs.elecswiki.user.service;

import elecs.elecswiki.user.repository.UserRepository;
import elecs.elecswiki.user.repository.model.UserEntity;
import elecs.elecswiki.user.web.api.UserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public long saveUser(UserRequestDTO user){
        UserEntity userEntity = UserEntity.builder()
                .userName(user.getUserName())
                .id(user.getId())
                .password(user.getPassword())
                .generation(user.getGeneration())
                .part(user.getPart())
                .build();

        userRepository.save(userEntity);

        return userEntity.getUserIdx();
    }

    public UserRequestDTO findUser(long userIdx){
        Optional<UserEntity> byId = userRepository.findById(userIdx);
        if(byId.isEmpty())
            throw new NullPointerException();
        UserEntity user = byId.get();

        return UserRequestDTO.builder()
                .userName(user.getUserName())
                .id(user.getId())
                .password(user.getPassword())
                .generation(user.getGeneration())
                .part(user.getPart())
                .build();
    }
}
