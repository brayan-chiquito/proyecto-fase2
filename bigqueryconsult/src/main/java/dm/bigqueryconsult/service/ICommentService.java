package dm.bigqueryconsult.service;

import dm.bigqueryconsult.model.Comment;

import java.util.List;

public interface ICommentService {
    public List<Comment> findAllBySaveRequestId(Integer saveRequestId);
    public Comment save(Comment comment);
}
