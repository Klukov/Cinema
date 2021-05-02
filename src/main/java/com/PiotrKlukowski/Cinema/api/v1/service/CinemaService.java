package com.PiotrKlukowski.Cinema.api.v1.service;

import com.PiotrKlukowski.Cinema.api.v1.converter.CinemaResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.converter.RoomResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.converter.TicketTypeResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.response.CinemaResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.RoomResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.TicketTypeResponseModel;
import com.PiotrKlukowski.Cinema.repository.CinemaRepository;
import com.PiotrKlukowski.Cinema.repository.RoomRepository;
import com.PiotrKlukowski.Cinema.typeList.TicketType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CinemaService implements AllCinemasQuery, AllRoomsInCinemaQuery, TicketTypesQuery {

    private final CinemaRepository cinemaRepository;
    private final RoomRepository roomRepository;

    @Override
    public Set<CinemaResponseModel> findAllCinemas() {
        return this.cinemaRepository.findAll().stream()
                .map(CinemaResponseConverter::convert)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<TicketTypeResponseModel> getAllTicketTypes() {
        return Arrays.stream(TicketType.values())
                .map(TicketTypeResponseConverter::convert)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<RoomResponseModel> findAllRoomsInCinema(Integer cinemaId) {
        return roomRepository.findAllByCinema_Id(cinemaId).stream()
                .map(RoomResponseConverter::convert)
                .collect(Collectors.toSet());
    }
}
