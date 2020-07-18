package ga.mr838wind.checkNovel.check;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckController {


    @GetMapping("/page")
    public String page() {
        return "page";
    }

    @GetMapping("/ajax/check")
    public String check() {
        return "";
    }


}
