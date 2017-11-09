package mohalib.controller;

import mohalib.domain.ReserveForm;
import mohalib.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by pendragon on 16-12-16.
 */

@Controller
@RequestMapping("/floor")
public class FloorController {

    private MainService mainService;

    @Autowired
    public FloorController(MainService mainService){
        this.mainService = mainService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showSeats(@PathVariable String id, Model model){
        switch (Integer.parseInt(id)){
            case 1:
                model.addAttribute("floor", "Floor 1");
                model.addAttribute("roomList", mainService.getRoomsByFloor(1));
                break;
            case 2:
                model.addAttribute("floor", "Floor 2");
                model.addAttribute("roomList", mainService.getRoomsByFloor(2));
                break;
            case 3:
                model.addAttribute("floor", "Floor 3");
                model.addAttribute("roomList", mainService.getRoomsByFloor(3));
                break;
            case 4:
                model.addAttribute("floor", "Floor 4");
                model.addAttribute("roomList", mainService.getRoomsByFloor(4));
                break;
        }
        return "floor";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String chooseSeats(
            Model model,
            @ModelAttribute("form") ReserveForm reserveForm,
            HttpSession httpSession){

        reserveForm.setUsername((String) httpSession.getAttribute("username"));
        reserveForm.setPassword((String) httpSession.getAttribute("password"));

        System.out.println(reserveForm);
        if (mainService.doReserve(reserveForm))
            model.addAttribute("status", "Congratulations, Your request has been scheduled.");
        else
            model.addAttribute("status", "Some error occurred, please contact me.");
        return "mohaResult";
    }
}
