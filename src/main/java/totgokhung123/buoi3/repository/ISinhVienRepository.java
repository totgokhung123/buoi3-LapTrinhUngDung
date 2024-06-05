package totgokhung123.buoi3.repository;

import totgokhung123.buoi3.entity.SinhVien;
import org.springframework.data. jpa.repository. JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISinhVienRepository extends JpaRepository<SinhVien, Long> {
}