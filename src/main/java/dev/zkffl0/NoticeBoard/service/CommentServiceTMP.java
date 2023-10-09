package dev.zkffl0.NoticeBoard.service;

import dev.zkffl0.NoticeBoard.domain.Comment;

import java.util.Optional;

public interface CommentServiceTMP {

    public Comment save(Comment comment);
    public Optional<Comment> findById(Long id);
    public Comment update(Long id, Comment comment);
    public void delete(Long id);
}
