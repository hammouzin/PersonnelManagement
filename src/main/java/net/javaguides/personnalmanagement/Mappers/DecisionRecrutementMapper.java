package net.javaguides.personnalmanagement.Mappers;


import net.javaguides.personnalmanagement.Dtos.DecisionRecrutementDto;

import net.javaguides.personnalmanagement.Entities.DecisionRecrutement;


public class DecisionRecrutementMapper {
    public static DecisionRecrutement mapDRecrutementDtoToDRecrutement(DecisionRecrutementDto decisionRecrutementDto) {
        DecisionRecrutement decisionRecrutement = new DecisionRecrutement(
                decisionRecrutementDto.getId(),
                decisionRecrutementDto.getDecisionNumero(),
                decisionRecrutementDto.getDecisionDate(),
                decisionRecrutementDto.getDateEffetPrevisionelle(),
                decisionRecrutementDto.getStatut()
        );


        return decisionRecrutement;
    }
    public static DecisionRecrutementDto mapDRecrutementToDRecrutementDto(DecisionRecrutement decisionRecrutement) {
        DecisionRecrutementDto decisionRecrutementDto = new DecisionRecrutementDto(
                decisionRecrutement.getId(),
                decisionRecrutement.getDecisionNumero(),
                decisionRecrutement.getDecisionDate(),
                decisionRecrutement.getDateEffetPrevisionelle(),
                decisionRecrutement.getStatut()
        );


        if (decisionRecrutement.getCandidat() != null) {
            decisionRecrutementDto.setCandidatId(decisionRecrutement.getCandidat().getId());
        }
        if (decisionRecrutement.getPoste() != null) {
            decisionRecrutementDto.setPosteId(decisionRecrutement.getPoste().getId());
        }

        return decisionRecrutementDto;
    }


    public DecisionRecrutementDto toDto(DecisionRecrutement entity) {
        if (entity == null) {
            return null;
        }

        DecisionRecrutementDto dto = new DecisionRecrutementDto();
        dto.setId(entity.getId());
        dto.setPosteId(entity.getPoste() != null ? entity.getPoste().getId() : null);
        dto.setVisaStatus(entity.getVisa() != null ? entity.getVisa().name() : null);
        dto.setDecisionStatus(entity.getStatus()  != null ? entity.getStatus().name() : null);


        return dto;
    }
}
