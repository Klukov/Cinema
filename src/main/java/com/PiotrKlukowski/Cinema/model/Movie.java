package com.PiotrKlukowski.Cinema.model;

import com.PiotrKlukowski.Cinema.typeList.MovieStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
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

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    @Column(name = "picture")
    @Getter
    @Setter
    private byte[] picture;
}
