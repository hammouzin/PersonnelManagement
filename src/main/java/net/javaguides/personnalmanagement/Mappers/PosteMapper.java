package net.javaguides.personnalmanagement.Mappers;

import net.javaguides.personnalmanagement.Dtos.PosteDto;
import net.javaguides.personnalmanagement.Entities.Poste;

public class PosteMapper {
    public static Poste mapPosteDtoToPoste(PosteDto posteDto) {
        Poste poste = new Poste(
                posteDto.getId(),
                posteDto.getPosteName(),
                posteDto.getPosteDescription(),
                posteDto.getPosteSalary()
        );
        return poste;
    }
    public static PosteDto mapPosteToPosteDto(Poste poste) {
        PosteDto posteDto = new PosteDto(
                poste.getId(),
                poste.getPosteName(),
                poste.getPosteDescription(),
                poste.getPosteSalary()
        );
        if (poste.getAgent() != null) {
            posteDto.setAgentId(poste.getAgent().getId());
        }
        if (poste.getUniteAffectation() != null) {
            posteDto.setUniteAffectationId(poste.getUniteAffectation().getId());
        }
        return posteDto;
    }
}
