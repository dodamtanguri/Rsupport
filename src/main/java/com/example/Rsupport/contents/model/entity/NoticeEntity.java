package com.example.Rsupport.contents.model.entity;

import com.example.Rsupport.commons.enmuns.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Setter
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    private String author;

    private int hitCount;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(nullable = false, columnDefinition = "enum('Y','N')")
    @Enumerated(EnumType.STRING)
    private Status status = Status.N;

    @Builder
    public NoticeEntity(String title, String content, String author, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
