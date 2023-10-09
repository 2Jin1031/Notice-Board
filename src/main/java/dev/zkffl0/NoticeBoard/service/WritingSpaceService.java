package dev.zkffl0.NoticeBoard.service;

import dev.zkffl0.NoticeBoard.domain.WritingSpace;
import java.util.Optional;
public interface WritingSpaceService {

    public WritingSpace save(WritingSpace writingSpace);
    public Optional<WritingSpace> findById(Long id);
    public WritingSpace update(Long id, WritingSpace writingSpace);

    public void delete(Long id);
}
