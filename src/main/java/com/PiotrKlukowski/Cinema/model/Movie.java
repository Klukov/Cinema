package com.PiotrKlukowski.Cinema.model;

import com.PiotrKlukowski.Cinema.typeList.MovieStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Column(name = "title")
    @NotEmpty
    @NotNull
    @Getter
    @Setter
    private String title;

    @Column(name = "description")
    @NotEmpty
    @NotNull
    @Getter
    @Setter
    private String description;

    @Column(name = "length_minutes")
    @NotNull
    @Getter
    @Setter
    private Integer lengthMinutes;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @NotNull
    @Getter
    @Setter
    private MovieStatus status;

    @Column(name = "picture")
    @Getter
    @Setter
    private byte[] picture;
}
