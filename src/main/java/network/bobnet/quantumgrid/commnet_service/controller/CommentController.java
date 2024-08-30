package network.bobnet.quantumgrid.commnet_service.controller;

import com.github.fge.jsonpatch.JsonPatch;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import network.bobnet.quantumgrid.commnet_service.dto.CommentDto;
import network.bobnet.quantumgrid.commnet_service.dto.request.CreateCommentRequest;
import network.bobnet.quantumgrid.commnet_service.entity.Comment;
import network.bobnet.quantumgrid.commnet_service.service.CommentService;
import network.bobnet.quantumgrid.commons.dto.response.SimplePage;
import network.bobnet.quantumgrid.commons.util.DtoUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<SimplePage<CommentDto>> getAllComments(
            @Parameter(hidden = true) @SortDefault(sort = "id") @PageableDefault(size = 20) final Pageable pageable
    ) {
        return ResponseEntity.ok(
                DtoUtil.convertSimplePage(
                        commentService.findAll(pageable),
                        CommentDto.class
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable Long id) {
        return ResponseEntity.ok(
                modelMapper.map(commentService.findById(id), CommentDto.class)
        );
    }

    @PostMapping
    public ResponseEntity<Long> createComment(@RequestBody CreateCommentRequest request) {
        return ResponseEntity.ok(commentService.createComment(modelMapper.map(request, Comment.class)).getId());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CommentDto> patchComment(@PathVariable Long id, @RequestBody JsonPatch patch) {
        return ResponseEntity.ok(modelMapper.map(commentService.patch(id, patch), CommentDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{parentId}/reply")
    public ResponseEntity<Comment> replyToComment(@PathVariable Long parentId, @RequestBody Comment reply) {
        Comment createdReply = commentService.replyToComment(parentId, reply);
        return ResponseEntity.ok(createdReply);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPost(@PathVariable Long postId) {
        List<Comment> comments = commentService.getCommentsByPost(postId);
        return ResponseEntity.ok(comments);
    }
}
