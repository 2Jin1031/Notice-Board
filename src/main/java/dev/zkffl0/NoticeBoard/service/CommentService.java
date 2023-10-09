package dev.zkffl0.NoticeBoard.service;

import dev.zkffl0.NoticeBoard.domain.Comment;
import dev.zkffl0.NoticeBoard.domain.WritingSpace;
import dev.zkffl0.NoticeBoard.dto.CommentAddDto;
import dev.zkffl0.NoticeBoard.repository.CommentRepository;
import dev.zkffl0.NoticeBoard.repository.WritingSpaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService{

    private final CommentRepository commentRepository;
    private final WritingSpaceRepository writingSpaceRepository;

    @Transactional
    public Long save(CommentAddDto infoDto) {
        Long writingSpaceId = infoDto.getWritingSpaceId();
        Optional<WritingSpace> optionalWritingSpace = writingSpaceRepository.findById(writingSpaceId);
        if(optionalWritingSpace.isEmpty()) {
            throw new RuntimeException("해당 정보는 존재하지 않습니다.");
        }

        Comment comment = Comment.builder()
                .content(infoDto.getContent())
                .writingSpace(optionalWritingSpace.get())
                .build();

        try {
            commentRepository.save(
                    comment
            );
            return comment.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Comment save(Comment comment) {
        return null;
    }

    public Optional<Comment> findById(Long id) {

        try {
            Optional<Comment> commentData = commentRepository.findById(id);
            if (commentData.isPresent()) {
                return commentData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Comment update(Long id, Comment comment) {

        try {
            Optional<Comment> commentData = commentRepository.findById(id);
            if (commentData.isPresent()) {
                Comment _comment = commentData.get();
                _comment.setContent(comment.getContent());
                commentRepository.save(_comment);
                return _comment;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(Long id) {

        try {
            commentRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

