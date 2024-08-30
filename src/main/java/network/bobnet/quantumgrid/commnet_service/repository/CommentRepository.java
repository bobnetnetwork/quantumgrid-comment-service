package network.bobnet.quantumgrid.commnet_service.repository;

import network.bobnet.quantumgrid.commnet_service.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostIdAndParentIdIsNull(Long postId);  // Fetch top-level comments for a post

    List<Comment> findByParentId(Long parentId);  // Fetch child comments (replies) for a parent comment

}
