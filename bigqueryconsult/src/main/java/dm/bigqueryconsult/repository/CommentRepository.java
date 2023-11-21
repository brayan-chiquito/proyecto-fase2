package dm.bigqueryconsult.repository;

import dm.bigqueryconsult.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("SELECT c FROM Comment c WHERE c.saveRequest.id = :saveRequestId")
    List<Comment> findAllBySaveRequestId(@Param("saveRequestId") Integer saveRequestId);
}
