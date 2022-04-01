package ru.ssb.hw5.mapper;

import org.springframework.stereotype.Component;
import ru.ssb.hw5.dto.PremiereDto;
import ru.ssb.hw5.entity.PremiereEntity;

@Component
public class PremiereTransformer {

    public PremiereEntity toPremiere(PremiereDto premiereDto) {

        PremiereEntity premiereEntity = new PremiereEntity();
        premiereEntity.setId(premiereDto.getId());
        premiereEntity.setName(premiereDto.getName());
        premiereEntity.setDescription(premiereDto.getDescription());
        premiereEntity.setAgeCategory(premiereDto.getAgeCategory());
        premiereEntity.setNumberOfSeats(premiereDto.getNumberOfSeats());

        return premiereEntity;

    }


    public PremiereDto toPremiereDto(PremiereEntity premiereEntity) {

        PremiereDto premiereDto = new PremiereDto();
        premiereDto.setId(premiereEntity.getId());
        premiereDto.setName(premiereEntity.getName());
        premiereDto.setDescription(premiereEntity.getDescription());
        premiereDto.setAgeCategory(premiereEntity.getAgeCategory());
        premiereDto.setNumberOfSeats(premiereEntity.getNumberOfSeats());

        return premiereDto;
    }

}