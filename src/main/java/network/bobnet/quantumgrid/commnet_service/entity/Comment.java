package network.bobnet.quantumgrid.commnet_service.entity;

import jakarta.persistence.*;
import lombok.*;
import network.bobnet.quantumgrid.commnet_service.enums.CommentStatusEnum;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments", schema = "commentservice")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @ToString.Include
    private Long id;

    @Column(name = "post_id", nullable = false)
    @ToString.Include
    private Long postId;

    @Column(name = "author_id", nullable = false)
    @ToString.Include
    private Long authorId;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    @ToString.Include
    private CommentStatusEnum status;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private Long updatedBy;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
