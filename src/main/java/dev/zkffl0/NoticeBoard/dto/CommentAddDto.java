package dev.zkffl0.NoticeBoard.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentAddDto {
    private String content;
    private Long writingSpaceId;
}
