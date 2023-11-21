package dm.bigqueryconsult.controller;

import dm.bigqueryconsult.model.Comment;
import dm.bigqueryconsult.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@CrossOrigin(origins = "http://localhost:9000")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    private CommentService commentService;
    @GetMapping("/comment")
    public List<Comment> findAllBySaveRequestId(Integer saveRequestId){
        logger.info("findAllBySaveRequestId() method called");
        return this.commentService.findAllBySaveRequestId(saveRequestId);
    }
    @PostMapping("/comment")
    public Comment save(@RequestBody Comment comment){
        logger.info("save() method called");
        return this.commentService.save(comment);
    }
}
