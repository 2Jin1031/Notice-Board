package dev.zkffl0.NoticeBoard.service;

import dev.zkffl0.NoticeBoard.domain.WritingSpace;
import dev.zkffl0.NoticeBoard.repository.WritingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WritingSpaceServiceImpl implements WritingSpaceService {
    @Autowired
    private WritingSpaceRepository writingSpaceRepository;

    @Override
    public WritingSpace save(WritingSpace writingSpace) {

        try {
            return writingSpaceRepository.save(
                    new WritingSpace(
                            writingSpace.getTitle(),
                            writingSpace.getContent()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<WritingSpace> findById(Long id) {

        try {
            Optional<WritingSpace> writingSpaceData = writingSpaceRepository.findById(id);
            if (writingSpaceData.isPresent()) {
                return writingSpaceData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public WritingSpace update(Long id, WritingSpace writingSpace) {

        try {
            Optional<WritingSpace> writingSpaceData = writingSpaceRepository.findById(id);
            if (writingSpaceData.isPresent()) {
                WritingSpace _writingSpace = writingSpaceData.get();
                _writingSpace.setTitle(writingSpace.getTitle());
                _writingSpace.setContent(writingSpace.getContent());
                writingSpaceRepository.save(_writingSpace);
                return _writingSpace;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try {
            writingSpaceRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
