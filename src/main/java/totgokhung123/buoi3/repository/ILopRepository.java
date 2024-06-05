package totgokhung123.buoi3.repository;

import totgokhung123.buoi3.entity.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILopRepository extends JpaRepository<Lop, Long> {
    List<Lop> findBytenLopContainingIgnoreCase(String tenLop);
}
