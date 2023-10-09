package dev.zkffl0.NoticeBoard.controller;


import dev.zkffl0.NoticeBoard.domain.WritingSpace;
import dev.zkffl0.NoticeBoard.service.WritingSpaceService;
import dev.zkffl0.NoticeBoard.service.WritingSpaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class WritingSpaceController {

    @Autowired
    WritingSpaceServiceImpl writingSpaceService;

    @PostMapping("/writing_space")
    public ResponseEntity<WritingSpace> createWriting(@RequestBody WritingSpace writingSpace) {

        try {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(writingSpaceService.save(writingSpace));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/writings/{id}")
    public ResponseEntity<Optional<WritingSpace>> getWritingById(@PathVariable("id") long id) {

        try {
            return ResponseEntity.ok(writingSpaceService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @PutMapping("/writings/{id}")
    public ResponseEntity<WritingSpace> updateWriting (
            @PathVariable("id") Long id,
            @RequestBody WritingSpace writingSpace
    ) {
        try
        {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(writingSpaceService.update(id, writingSpace));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @DeleteMapping("/writings/{id}")
    public ResponseEntity<HttpStatus> deleteWriting (@PathVariable("id") long id) {

        try {
            writingSpaceService.delete(id);
            ResponseEntity.noContent();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
