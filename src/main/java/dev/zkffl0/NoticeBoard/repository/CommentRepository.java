package dev.zkffl0.NoticeBoard.repository;

import dev.zkffl0.NoticeBoard.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
