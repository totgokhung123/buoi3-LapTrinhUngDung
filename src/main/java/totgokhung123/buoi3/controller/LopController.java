package totgokhung123.buoi3.controller;

import totgokhung123.buoi3.entity.Lop;
import totgokhung123.buoi3.services.LopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
//@RequestMapping("/lop")
public class LopController {

    @Autowired
    private LopService lopService;

    @GetMapping("/")
    public String showAllLop(Model model) {
        List<Lop> dsLop = lopService.getAllLop();
        model.addAttribute("dsLop", dsLop);
        return "lop/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("lop", new Lop());
        return "lop/add";
    }

    @PostMapping("/add")
    public String addLop(@ModelAttribute("lop") Lop lop) {
        lopService.addLop(lop);
        return "redirect:/";
    }
    @GetMapping("/edit/{maLop}")
    public String showEditForm(@PathVariable("maLop") Integer maLop, Model model) {
        Lop lop = lopService.getLopById(maLop);
        model.addAttribute("lop", lop);
        return "lop/edit";
    }

    @PostMapping("/edit/{maLop}")
    public String editLop(@ModelAttribute("lop") Lop lop, @PathVariable("maLop") Integer maLop) {
        lop.setMaLop(maLop); // Cập nhật mã lớp cho lớp được chỉnh sửa
        lopService.updateLop(lop);
        return "redirect:/";
    }

    @GetMapping("/delete/{maLop}")
    public String deleteLop(@PathVariable("maLop") Integer maLop) {
        lopService.deleteLop(maLop);
        return "redirect:/";
    }

}
