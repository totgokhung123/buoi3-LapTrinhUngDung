package totgokhung123.buoi3.repository;

import totgokhung123.buoi3.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISinhVienRepository extends JpaRepository<SinhVien, Long>{
    List<SinhVien> findByhoTenContainingIgnoreCase(String hoTen);
}