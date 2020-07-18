package ga.mr838wind.checkNovel.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CheckController {

    @Autowired
    CheckService checkService;

    @GetMapping("/")
    public String main() {
        return "redirect:/page";
    }

    @GetMapping("/page")
    public String page() {
        return "page";
    }

    @GetMapping("/ajax/check")
    @ResponseBody
    public Map<String,Object> check() throws Exception {
        Map<String,Object> result = new HashMap<>();

        List<NovelVO> novelVOS = checkService.checkAll();
        result.put("result", novelVOS);

        return result;
    }


}
