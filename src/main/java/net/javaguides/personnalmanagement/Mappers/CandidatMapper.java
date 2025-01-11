package net.javaguides.personnalmanagement.Mappers;


import net.javaguides.personnalmanagement.Dtos.CandidatDto;

import net.javaguides.personnalmanagement.Entities.Candidat;

import java.util.stream.Collectors;

public class CandidatMapper {
    public static Candidat mapCandidatDtoToCandidat(CandidatDto candidatDto) {
        Candidat candidat = new Candidat(
                candidatDto.getId(),
                candidatDto.getFirstName(),
                candidatDto.getLastName(),
                candidatDto.getEmail(),
                candidatDto.getPhone(),
                candidatDto.getGender(),
                candidatDto.getBirthDate(),
                candidatDto.getBirthPlace(),
                candidatDto.getCity(),
                candidatDto.getCountry(),
                candidatDto.getStatutAdmission()
        );
        if (candidatDto.getDiplomes() != null) {
            candidat.setDiplomes(
                    candidatDto.getDiplomes().stream()
                            .map(DiplomeMapper::mapDiplomeDtoToDiplome)
                            .collect(Collectors.toList())
            );
        }
        if (candidatDto.getDecisionRecrutements() != null) {
            candidat.setDecisions(
                    candidatDto.getDecisionRecrutements().stream()
                            .map(DecisionRecrutementMapper::mapDRecrutementDtoToDRecrutement)
                            .collect(Collectors.toList())
            );
        }
        return candidat;
    }
    public static CandidatDto mapCandidatToCandidatDto(Candidat candidat) {
       CandidatDto candidatDto = new CandidatDto(
               candidat.getId(),
               candidat.getFirstName(),
               candidat.getFirstName(),
               candidat.getEmail(),
               candidat.getPhone(),
               candidat.getGender(),
               candidat.getBirthDate(),
               candidat.getBirthPlace(),
               candidat.getCity(),
               candidat.getCountry(),
               candidat.getStatuAdmission()
       );
        if (candidat.getDiplomes() != null) {
            candidatDto.setDiplomes(
                    candidat.getDiplomes().stream()
                            .map(DiplomeMapper::mapDiplomeToDiplomeDto)
                            .collect(Collectors.toList())
            );
        }
        if (candidat.getDecisions() != null) {
            candidatDto.setDecisionRecrutements(
                    candidat.getDecisions().stream()
                            .map(DecisionRecrutementMapper::mapDRecrutementToDRecrutementDto)
                            .collect(Collectors.toList())
            );
        }
        return candidatDto;
    }
}
