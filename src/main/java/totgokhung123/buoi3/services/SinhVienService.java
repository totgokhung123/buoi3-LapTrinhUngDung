package totgokhung123.buoi3.services;

import totgokhung123.buoi3.entity.SinhVien;
import totgokhung123.buoi3.repository.ISinhVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SinhVienService {
    @Autowired
    private ISinhVienRepository sinhVienRepository;

    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }

    public SinhVien getSinhVienById(Long id) {
        return sinhVienRepository.findById(id).orElse(null);
    }

    public void addSinhVien(SinhVien sinhVien) {
        sinhVienRepository.save(sinhVien);
    }

    public void deleteSinhVien(Long id) {
        sinhVienRepository.deleteById(id);
    }

    public void updateSinhVien(SinhVien sinhVien) {
        sinhVienRepository.save(sinhVien);
    }
}