package network.bobnet.quantumgrid.commnet_service.repository;

import network.bobnet.quantumgrid.commnet_service.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
