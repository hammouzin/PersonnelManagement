package net.javaguides.personnalmanagement.Mappers;


import net.javaguides.personnalmanagement.Dtos.DecisionRecrutementDto;

import net.javaguides.personnalmanagement.Entities.DecisionRecrutement;


public class DecisionRecrutementMapper {
    public static DecisionRecrutement mapDRecrutementDtoToDRecrutement(DecisionRecrutementDto decisionRecrutementDto) {
        DecisionRecrutement decisionRecrutement = new DecisionRecrutement(
                decisionRecrutementDto.getId(),
                decisionRecrutementDto.getDecisionNumero(),
                decisionRecrutementDto.getDecisionDate(),
                decisionRecrutementDto.getDateEffetPrevisionelle()
        );


        return decisionRecrutement;
    }
    public static DecisionRecrutementDto mapDRecrutementToDRecrutementDto(DecisionRecrutement decisionRecrutement) {
        DecisionRecrutementDto decisionRecrutementDto = new DecisionRecrutementDto(
                decisionRecrutement.getId(),
                decisionRecrutement.getDecisionNumero(),
                decisionRecrutement.getDecisionDate(),
                decisionRecrutement.getDateEffetPrevisionelle()
        );


        if (decisionRecrutement.getCandidat() != null) {
            decisionRecrutementDto.setCandidatId(decisionRecrutement.getCandidat().getId());
        }
        if (decisionRecrutement.getPoste() != null) {
            decisionRecrutementDto.setPosteId(decisionRecrutement.getPoste().getId());
        }

        return decisionRecrutementDto;
    }
}
