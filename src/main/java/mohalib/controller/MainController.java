package mohalib.controller;

import mohalib.service.MainService;
import mohalib.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Calendar;

/**
 * Created by pendragon on 16-12-16.
 */

@Controller
@RequestMapping("/")
public class MainController {

    private MainService mainService;

    @Autowired
    public MainController(MainService mainService){
        this.mainService = mainService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(Model model, HttpSession httpSession,
            @RequestParam (value = "username") String username,
            @RequestParam (value = "password") String password){

        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)){
            model.addAttribute("error", "请检查用户名或密码");
            return "login";
        }


        if (!mainService.isAuthorizedUser(username)){
            model.addAttribute("error", "不好意思，我怀疑你是国民党");
            return "login";
        }


        httpSession.setAttribute("username", username);
        httpSession.setAttribute("password", password);
        httpSession.setMaxInactiveInterval(60 * 10); // 10 mins session timeout

        model.addAttribute("username", username);
        model.addAttribute("password", password);
        if (username.equals("2016302580205")){
            int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            String info;
            if (hour > 6 && hour < 10){
                info = "早上好";
            } else if (hour < 14){
                info = "中午好";
            } else if (hour < 17){
                info = "下午好";
            } else {
                info = "晚上好";
            }
            model.addAttribute("info", "宝贝女儿, " + info);
        }
        return "home";
    }
}
