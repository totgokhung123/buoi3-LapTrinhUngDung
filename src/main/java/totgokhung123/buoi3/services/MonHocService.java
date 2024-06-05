package totgokhung123.buoi3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import totgokhung123.buoi3.entity.MonHoc;
import totgokhung123.buoi3.repository.IMonHocRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MonHocService {
    @Autowired
    private IMonHocRepository monHocRepository;
    public List<MonHoc> getAllMonHoc() {
        return monHocRepository.findAll();
    }

    public MonHoc getMonHocById(Long  id) {
        return monHocRepository.findById(id).orElse(null);
    }

    public void addMonHoc(MonHoc mh) {
        monHocRepository.save(mh);
    }

    public void deleteMonHoc(Long  id) {
        monHocRepository.deleteById(id);
    }

    public void updateMonHoc(MonHoc mh) {
        monHocRepository.save(mh);
    }
    public List<MonHoc> searchMonHocByTenMon(String tenMonHoc) {
        return monHocRepository.findBytenMonHocContainingIgnoreCase(tenMonHoc);
    }
}
