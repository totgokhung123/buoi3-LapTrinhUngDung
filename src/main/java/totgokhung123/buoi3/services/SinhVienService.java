package totgokhung123.buoi3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import totgokhung123.buoi3.entity.Lop;
import totgokhung123.buoi3.entity.SinhVien;
import totgokhung123.buoi3.repository.ISinhVienRepository;

import java.util.List;

@Service
public class SinhVienService {
    @Autowired
    private ISinhVienRepository sinhVienRepository;
    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }

    public SinhVien getSinhVienById(String id) {
//        return sinhVienRepository.findById(Long.valueOf(id)).orElse(null);
        try {
            Long sinhVienId = Long.parseLong(id);
            return sinhVienRepository.findById(sinhVienId).orElse(null);
        } catch (NumberFormatException e) {
            // Trong trường hợp chuỗi id không phải là một số hợp lệ
            return null;
        }
    }

    public void addSinhVien(SinhVien sv) {
        sinhVienRepository.save(sv);
    }

    public void deleteSinhVien(String  id) {
        sinhVienRepository.deleteById(Long.valueOf(id));
    }

    public void updateSinhVien(SinhVien sv) {
        sinhVienRepository.save(sv);
    }
}
