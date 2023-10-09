package dev.zkffl0.NoticeBoard.controller;


import dev.zkffl0.NoticeBoard.domain.Comment;
import dev.zkffl0.NoticeBoard.dto.CommentAddDto;
import dev.zkffl0.NoticeBoard.service.CommentService;
import dev.zkffl0.NoticeBoard.service.CommentServiceTMP;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment")
    public ResponseEntity<Comment> createComment(@RequestBody CommentAddDto infoDto) {

        try {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(commentService.save(infoDto));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Optional<Comment>> getCommentById(@PathVariable("id") long id) {

        try {
            return ResponseEntity.ok(commentService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment (
            @PathVariable("id") Long id,
            @RequestBody Comment comment
    ) {
        try
        {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(commentService.update(id, comment));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<HttpStatus> deleteComment (@PathVariable("id") long id) {

        try {
            commentService.delete(id);
            ResponseEntity.noContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
