package dev.zkffl0.NoticeBoard.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
@Entity
@Data
@Table(name = "writing_spaces")
public class WritingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "writing_title")
    private String title;

    @Column(name = "writing_content")
    private String content;

    public WritingSpace() {
    }

    public WritingSpace(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
