package net.javaguides.personnalmanagement.Mappers;

import net.javaguides.personnalmanagement.Dtos.CongeDto;
import net.javaguides.personnalmanagement.Entities.Conge;


public class CongeMapper {
    public static Conge mapCongeDtoToConge(CongeDto congeDto) {
        Conge conge = new Conge(
                congeDto.getId(),
                congeDto.getCongeType(),
                congeDto.getCongeDateDebut(),
                congeDto.getCongeDateFin(),
                congeDto.getCongeDescription(),
                congeDto.getCongeNbJours(),
                congeDto.getCongeStatus()
        );
        return conge;
    }
    public static CongeDto mapCongeToCongeDto(Conge conge) {
        CongeDto congeDto = new CongeDto(
                conge.getId(),
                conge.getCongeType(),
                conge.getCongeDateDebut(),
                conge.getCongeDateFin(),
                conge.getCongeDescription(),
                conge.getCongeNbJours(),
                conge.getCongeStatus()
        );
        if (conge.getAgent() != null) {
            congeDto.setAgentId(conge.getAgent().getId());
        }
        return congeDto;
    }
}
