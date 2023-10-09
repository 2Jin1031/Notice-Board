package dev.zkffl0.NoticeBoard.repository;

import dev.zkffl0.NoticeBoard.domain.WritingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WritingSpaceRepository extends JpaRepository<WritingSpace, Long> {
}
