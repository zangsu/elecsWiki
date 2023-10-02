package elecs.elecswiki.user.web;

import elecs.elecswiki.user.repository.model.Part;
import elecs.elecswiki.user.service.UserService;
import elecs.elecswiki.user.web.api.UserRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    final UserService userService;

    static HashMap<String, String> links;

    static {
        links = new HashMap<>();
        links.put("join", "/user/join");
        links.put("home", "/user/home");
    }

    @ModelAttribute(name = "links")
    public HashMap<String, String> addLink() {
        return links;
    }

    @ModelAttribute(name = "userForm")
    public UserRequestDTO addUserForm() {
        return UserRequestDTO.getEmptyDTO();
    }

    @GetMapping("/join")
    public String joinForm(Model model) {

        model.addAttribute("parts", Part.values());
        Part bass = Part.Bass;
        bass.name();
        return "user/join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserRequestDTO request, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "user/join";
        }
        long savedIdx = userService.saveUser(request);
        return "user/userhome";
    }
}
