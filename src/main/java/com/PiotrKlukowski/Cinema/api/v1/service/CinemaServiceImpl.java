package com.PiotrKlukowski.Cinema.api.v1.service;

import com.PiotrKlukowski.Cinema.api.v1.response.converter.CinemaResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.response.converter.RoomResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.response.converter.TicketTypeResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.response.model.CinemaResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.RoomResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.TicketTypeResponseModel;
import com.PiotrKlukowski.Cinema.repository.CinemaRepository;
import com.PiotrKlukowski.Cinema.repository.RoomRepository;
import com.PiotrKlukowski.Cinema.typeList.TicketType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CinemaServiceImpl implements CinemaService{

    private final CinemaRepository cinemaRepository;
    private final RoomRepository roomRepository;

    public CinemaServiceImpl(
            CinemaRepository cinemaRepository,
            RoomRepository roomRepository) {
        this.cinemaRepository = cinemaRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Set<CinemaResponseModel> findAllCinemas() {
        return StreamSupport.stream(this.cinemaRepository.findAll().spliterator(), false)
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
