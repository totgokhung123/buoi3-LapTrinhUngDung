package totgokhung123.buoi3.repository;

import totgokhung123.buoi3.entity.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ILopRepository extends JpaRepository<Lop, Long> {
}
