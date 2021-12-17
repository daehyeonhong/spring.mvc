package hello.spring.mvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @GetMapping(value = "/response-view-v1")
    public ModelAndView responseViewV1() {
        return new ModelAndView("/response/hello")
                .addObject("data", "Hello, World!");
    }

    @GetMapping(value = "/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "Hello, World!");
        return "/response/hello";
    }

    @GetMapping(value = "/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "Hello, World!");
    }

}
