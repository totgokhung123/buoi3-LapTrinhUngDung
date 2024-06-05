package totgokhung123.buoi3.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import totgokhung123.buoi3.entity.SinhVien;
import totgokhung123.buoi3.services.LopService;
import totgokhung123.buoi3.services.MonHocService;
import totgokhung123.buoi3.services.SinhVienService;
import java.io.IOException;
import java.util.List;

@Controller
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;
    @Autowired
    private LopService lopService;
    @Autowired
    private MonHocService monHocService;
    @GetMapping("/Sinhvien/")
    public String showAllSinhVien(Model model) {
        List<SinhVien> dsSinhvien = sinhVienService.getAllSinhVien();
        model.addAttribute("dssv", dsSinhvien);
        return "sinhvien/list";
    }

    @GetMapping("/Sinhvien/add")
    public String showAddForm(Model model) {
        model.addAttribute("Sinhvien", new SinhVien());
        model.addAttribute("lop", lopService.getAllLop());
        model.addAttribute("monHocs", monHocService.getAllMonHoc());
        return "sinhvien/add";
    }
    @PostMapping("/Sinhvien/add")
    public String addSinhvien(@Valid SinhVien sinhVien, BindingResult result) {
        if (result.hasErrors()) {
            return "sinhvien/add";
        }
        sinhVienService.addSinhVien(sinhVien);
        return "redirect:/Sinhvien/";
    }
    @GetMapping("/sinhvien/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        SinhVien sinhvien = sinhVienService.getSinhVienById(id);
//                .orElseThrow(() -> new IllegalArgumentException("Invalid sinhvien Id:" + id));
        model.addAttribute("sinhvien", sinhvien);
        model.addAttribute("lop", lopService.getAllLop());
        return "sinhvien/edit";
    }

    @PostMapping("/sinhvien/edit/{id}")
    public String editSinhVien(@PathVariable("id") Long id, @Valid SinhVien sinhvien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "sinhvien/edit";
        }
        sinhVienService.updateSinhVien(sinhvien);
        model.addAttribute("sinhvien", sinhVienService.getAllSinhVien());
        return "redirect:/Sinhvien/";
    }

    @GetMapping("/sinhvien/delete/{id}")
    public String deleteSinhVien(@PathVariable("id") Long id, Model model) {
        SinhVien sinhvien= sinhVienService.getSinhVienById(id);
        sinhVienService.deleteSinhVien(id);
        model.addAttribute("sinhvien", sinhVienService.getAllSinhVien());
        return "redirect:/Sinhvien/";
    }
}
