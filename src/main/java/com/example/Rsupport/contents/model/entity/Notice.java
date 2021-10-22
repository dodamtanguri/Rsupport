package com.example.Rsupport.contents.model.entity;

import com.example.Rsupport.commons.enmuns.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id")
    private Author author;

    private int hitCount;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Column(nullable = false, columnDefinition = "enum('Y','N')")
    @Enumerated(EnumType.STRING)
    private Status status = Status.N;

    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;


}
