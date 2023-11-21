package dm.bigqueryconsult.repository;

import dm.bigqueryconsult.model.SaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaveRequestRepository extends JpaRepository<SaveRequest, Integer> {
    @Query("SELECT s FROM SaveRequest s WHERE s.user.idUser = :userId")
    List<SaveRequest> findAllByUserId(@Param("userId") Integer userId);
}
