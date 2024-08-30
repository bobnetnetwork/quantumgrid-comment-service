package network.bobnet.quantumgrid.commnet_service.service;

import com.github.fge.jsonpatch.JsonPatch;
import network.bobnet.quantumgrid.commnet_service.entity.Comment;
import network.bobnet.quantumgrid.commnet_service.repository.CommentRepository;
import network.bobnet.quantumgrid.commons.dto.response.SimplePage;
import network.bobnet.quantumgrid.commons.exceptions.NotFoundException;
import network.bobnet.quantumgrid.commons.service.AbstractService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService extends AbstractService<Comment> {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        super(Comment.class, commentRepository);
        this.commentRepository = commentRepository;
    }

    public SimplePage<Comment> findAll(final Pageable pageable) {
        return getPageableEntityList(pageable);
    }

    public Comment findById(final Long id) {
        return findEntityById(id);
    }

    public Comment createComment(Comment comment) {
        return createEntityToRepository(comment);
    }

    public void deleteComment(Long id) {
        deleteEntityById(id);
    }

    public Comment patch(Long id, JsonPatch patch) {
        return patchEntity(id, patch);
    }

    public Comment replyToComment(Long parentId, Comment reply) {
        Optional<Comment> parentComment = commentRepository.findById(parentId);
        if (parentComment.isPresent()) {
            reply.setParentId(parentComment.get().getId());
            return createEntityToRepository(reply);
        } else {
            throw new NotFoundException("Parent comment not found");
        }
    }

    public List<Comment> getCommentsByPost(Long postId) {
        List<Comment> topLevelComments = commentRepository.findByPostIdAndParentIdIsNull(postId);
        List<Comment> result = new ArrayList<>();
        for (Comment comment : topLevelComments) {
            result.add(comment);
            result.addAll(getReplies(comment.getId()));
        }
        return result;
    }

    private List<Comment> getReplies(Long parentId) {
        List<Comment> replies = commentRepository.findByParentId(parentId);
        List<Comment> result = new ArrayList<>(replies);
        for (Comment comment : replies) {
            result.addAll(getReplies(comment.getId()));
        }
        return result;
    }
}
