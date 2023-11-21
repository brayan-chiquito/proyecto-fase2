package dm.bigqueryconsult.service;

import dm.bigqueryconsult.model.Comment;
import dm.bigqueryconsult.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public List<Comment> findAllBySaveRequestId(Integer saveRequestId) {
        return this.commentRepository.findAllBySaveRequestId(saveRequestId);
    }

    @Override
    public Comment save(Comment comment) {
        return this.commentRepository.save(comment);
    }
}
