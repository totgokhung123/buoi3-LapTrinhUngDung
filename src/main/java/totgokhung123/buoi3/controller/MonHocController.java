package totgokhung123.buoi3.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import totgokhung123.buoi3.entity.MonHoc;
import totgokhung123.buoi3.services.MonHocService;
import totgokhung123.buoi3.services.SinhVienService;

import java.util.List;

public class MonHocController {
    @Autowired
    private MonHocService monHocService;
    @GetMapping("/Monhoc/")
    public String showAllMonhoc(Model model) {
        List<MonHoc> dsSinhvien = monHocService.getAllMonHoc();
        model.addAttribute("dsmh", dsSinhvien);
        return "monhoc/list";
    }

    @GetMapping("/Monhoc/add")
    public String showAddForm(Model model) {
        model.addAttribute("monhoc", new MonHoc());
        return "monhoc/add";
    }
    @PostMapping("/Monhoc/add")
    public String addSinhvien(@Valid MonHoc sinhVien, BindingResult result) {
        if (result.hasErrors()) {
            return "monhoc/add";
        }
        monHocService.addMonHoc(sinhVien);
        return "redirect:/Sinhvien/";
    }
    @GetMapping("/Monhoc/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        MonHoc sinhvien = monHocService.getMonHocById(id);
//                .orElseThrow(() -> new IllegalArgumentException("Invalid sinhvien Id:" + id));
        model.addAttribute("monhoc", sinhvien);
        return "monhoc/edit";
    }

    @PostMapping("/Monhoc/edit/{id}")
    public String editSinhVien(@PathVariable("id") Long id, @Valid MonHoc sinhvien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "monhoc/edit";
        }
        monHocService.updateMonHoc(sinhvien);
        model.addAttribute("monhoc", monHocService.getAllMonHoc());
        return "redirect:/Monhoc/";
    }

    @GetMapping("/Monhoc/delete/{id}")
    public String deleteSinhVien(@PathVariable("id") Long id, Model model) {
        MonHoc sinhvien= monHocService.getMonHocById(id);
        monHocService.deleteMonHoc(id);
        model.addAttribute("monhoc", monHocService.getAllMonHoc());
        return "redirect:/Monhoc/";
    }
}
