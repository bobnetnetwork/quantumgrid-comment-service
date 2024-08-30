package network.bobnet.quantumgrid.commnet_service.dto;

import lombok.*;
import network.bobnet.quantumgrid.commnet_service.enums.CommentStatusEnum;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link network.bobnet.quantumgrid.commnet_service.entity.Comment}
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 2128192761042994099L;

    private Long id;
    private Long postId;
    private Long authorId;
    private CommentStatusEnum status;
    private String content;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}
