package totgokhung123.buoi3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import totgokhung123.buoi3.entity.MonHoc;
import totgokhung123.buoi3.repository.IMonHocRepository;

import java.util.List;

@Service
public class MonHocService {
    @Autowired
    private IMonHocRepository monHocRepository;
    public List<MonHoc> getAllMonHoc() {
        return monHocRepository.findAll();
    }

    public MonHoc getMonHocById(String  id) {
        return monHocRepository.findById(id).orElse(null);
    }

    public void addMonHoc(MonHoc mh) {
        monHocRepository.save(mh);
    }

    public void deleteMonHoc(String  id) {
        monHocRepository.deleteById(id);
    }

    public void updateMonHoc(MonHoc mh) {
        monHocRepository.save(mh);
    }
}
