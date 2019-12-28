package com.PiotrKlukowski.Cinema.model;

import com.PiotrKlukowski.Cinema.typeList.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "show")
public class Show {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Getter
    private String id;

    @MapsId("room_id")
    @ManyToOne
    @NotNull
    @Getter
    @Setter
    private Room room;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @NotNull
    @Getter
    @Setter
    private Movie movie;

    @Column(name = "start_time")
    @NotNull
    @Getter
    @Setter
    private ZonedDateTime startTime;

    @Column(name = "audio_language")
    @Enumerated(EnumType.STRING)
    @NotEmpty
    @Getter
    @Setter
    private Language audioLanguage;

    @Column(name = "subtitles_language")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Language subtitlesLanguage;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "show", fetch = FetchType.EAGER)
    @Getter
    private Set<Ticket> tickets;
}
