package totgokhung123.buoi3.repository;

import totgokhung123.buoi3.entity.MonHoc;
import org.springframework.data. jpa.repository. JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMonHocRepository extends JpaRepository<MonHoc, Long> {
}