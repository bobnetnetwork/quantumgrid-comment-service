package network.bobnet.quantumgrid.commnet_service.service;

import com.github.fge.jsonpatch.JsonPatch;
import network.bobnet.quantumgrid.commnet_service.entity.Comment;
import network.bobnet.quantumgrid.commnet_service.repository.CommentRepository;
import network.bobnet.quantumgrid.commons.dto.response.SimplePage;
import network.bobnet.quantumgrid.commons.service.AbstractService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends AbstractService<Comment> {

    public CommentService(CommentRepository commentRepository) {
        super(Comment.class, commentRepository);
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
}
