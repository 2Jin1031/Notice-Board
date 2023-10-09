package dev.zkffl0.NoticeBoard.domain;

import lombok.*;

import javax.persistence.*;
@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "comment_content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "writing_id")
    private WritingSpace writingSpace;

    public Comment() {

    }



//    public Comment(String content, WritingSpace writingSpace) {
//        this.content = content;
//        this.writingSpace = writingSpace;
//    }

//    public Comment(String content) {
//        this.content = content;
//    }
//
//    public Comment(String content, WritingSpace writingSpace) {
//        this.content = content;
//        this.writingSpace = writingSpace;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public WritingSpace getWritingSpace() {
//        return writingSpace;
//    }
//
//    public void setWritingSpace(WritingSpace writingSpace) {
//        this.writingSpace = writingSpace;
//    }
}
