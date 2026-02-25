package CS4135.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Demo Application");
        model.addAttribute("description", "Spring Boot MVC Architecture");
        return "index";
    }

    @RestController
    public static class ApiController {
        
        @GetMapping("/api/hello")
        public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
            return "Hello, " + name + "!";
        }

        @GetMapping("/api/status")
        public String status() {
            return "{\"status\": \"running\", \"version\": \"1.0\", \"framework\": \"Spring Boot 4.0.3\"}";
        }
    }
}
