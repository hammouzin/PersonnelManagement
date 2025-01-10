package net.javaguides.personnalmanagement.Mappers;

import net.javaguides.personnalmanagement.Dtos.AffectationDto;
import net.javaguides.personnalmanagement.Entities.Affectation;

public class AffectationMapper {
    public static Affectation mapAffectationDtoToAffection(AffectationDto affectationDto) {
        // DTO -> Entite (dto)
        Affectation affectation = new Affectation(
                affectationDto.getId(),
                affectationDto.getAffectationName(),
                affectationDto.getAffectationDate(),
                affectationDto.getEndAffectationDate()
        );
        return affectation;

    }
    public static AffectationDto matAffectationToAffectationDto(Affectation affectation) {

        AffectationDto affectationDto = new AffectationDto(
                affectation.getId(),
                affectation.getAffectationName(),
                affectation.getAffectationDate(),
                affectation.getEndAffectationDate()
        );
        if (affectation.getAgent() != null) {
            affectationDto.setAgentId(affectation.getAgent().getId());
        }
        if(affectation.getUniteAffectation() != null) {
            affectationDto.setUniteAffectationId(affectation.getUniteAffectation().getId());
        }

        return affectationDto;
    }
}
