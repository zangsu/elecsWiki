package elecs.elecswiki.user.web;

import elecs.elecswiki.user.repository.model.Part;
import elecs.elecswiki.user.web.api.UserRequest;
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
public class UserController {

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
    public UserRequest addUserForm() {
        return new UserRequest();
    }

    @GetMapping("/join")
    public String joinForm(Model model) {

        model.addAttribute("parts", Part.values());
        Part bass = Part.Bass;
        bass.name();
        return "user/join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserRequest request, BindingResult bindingResult, Model model) {

        return "user/userhome";
    }
}
