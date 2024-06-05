package totgokhung123.buoi3.services;

import totgokhung123.buoi3.entity.Lop;
import totgokhung123.buoi3.repository.ILopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LopService {

    @Autowired
    private ILopRepository lopRepository;

    public List<Lop> getAllLop() {
        return lopRepository.findAll();
    }

    public Lop getLopById(Integer id) {
        return lopRepository.findById(Long.valueOf(id)).orElse(null);
    }

    public void addLop(Lop lop) {
        lopRepository.save(lop);
    }

    public void deleteLop(Integer id) {
        lopRepository.deleteById(Long.valueOf(id));
    }

    public void updateLop(Lop lop) {
        lopRepository.save(lop);
    }
    public List<Lop> searchLopByTenLop(String tenLop) {
        return lopRepository.findBytenLopContainingIgnoreCase(tenLop);
    }
}
