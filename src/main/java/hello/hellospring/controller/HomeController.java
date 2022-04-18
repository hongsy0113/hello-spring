package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 도메이능로 처음 드러ㅗㄴ 겨우
    @GetMapping("/")
    public String home() {
        return "home";
        // home.html
    }
}
