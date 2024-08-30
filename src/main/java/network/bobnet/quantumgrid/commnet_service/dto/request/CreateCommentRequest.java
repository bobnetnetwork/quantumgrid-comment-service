package network.bobnet.quantumgrid.commnet_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import network.bobnet.quantumgrid.commnet_service.enums.CommentStatusEnum;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateCommentRequest {

    private Long postId;
    private Long authorId;
    private CommentStatusEnum status;
    private String content;

}
