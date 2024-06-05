package totgokhung123.buoi3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import totgokhung123.buoi3.entity.SinhVien;
import totgokhung123.buoi3.services.LopService;
import totgokhung123.buoi3.services.MonHocService;
import totgokhung123.buoi3.services.SinhVienService;

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
    public String addSinhvien(@ModelAttribute("Sinhvien") SinhVien sinhVien) {
        sinhVienService.addSinhVien(sinhVien);
        return "redirect:/Sinhvien/";
    }
    @GetMapping("/Sinhvien/edit/{mssv}")
    public String showEditForm(@PathVariable("mssv") String  mssv, Model model) {
        SinhVien sv = sinhVienService.getSinhVienById(mssv);
        model.addAttribute("sinhvien", sv);
        model.addAttribute("lop", lopService.getAllLop());
        model.addAttribute("monHocs", monHocService.getAllMonHoc());
        return "sinhvien/edit";
    }
    @PostMapping("/Sinhvien/edit/{mssv}")
    public String editSinhvien(@ModelAttribute("sinhvien") SinhVien sv, @PathVariable("mssv") String mssv) {
        sv.setMssv(mssv); // Cập nhật mã số sinh viên cho sinh viên được chỉnh sửa
        sinhVienService.updateSinhVien(sv);
        return "redirect:/Sinhvien/";
    }

    @GetMapping("/Sinhvien/delete/{mssv}")
    public String deleteSinhvien(@PathVariable("mssv") String  mssv) {
        sinhVienService.deleteSinhVien(mssv);
        return "redirect:/Sinhvien/";
    }
}
