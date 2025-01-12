package net.javaguides.personnalmanagement.Mappers;

import net.javaguides.personnalmanagement.Dtos.CandidatDto;
import net.javaguides.personnalmanagement.Entities.Candidat;

import java.util.stream.Collectors;

public class CandidatMapper {

    public static Candidat mapCandidatDtoToCandidat(CandidatDto candidatDto) {
        if (candidatDto == null) {
            return null;
        }

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

        // Mapper les diplômes (relation One-to-Many)
        if (candidatDto.getDiplomes() != null) {
            candidat.setDiplomes(
                    candidatDto.getDiplomes().stream()
                            .map(DiplomeMapper::mapDiplomeDtoToDiplome)
                            .collect(Collectors.toList())
            );
        }

        // Mapper la décision de recrutement (relation One-to-One)
        if (candidatDto.getDecisionRecrutement() != null) {
            candidat.setDecision(
                    DecisionRecrutementMapper.mapDRecrutementDtoToDRecrutement(candidatDto.getDecisionRecrutement())
            );
        }

        return candidat;
    }

    public static CandidatDto mapCandidatToCandidatDto(Candidat candidat) {
        if (candidat == null) {
            return null;
        }

        CandidatDto candidatDto = new CandidatDto(
                candidat.getId(),
                candidat.getFirstName(),
                candidat.getLastName(), // Correction ici : utiliser getLastName()
                candidat.getEmail(),
                candidat.getPhone(),
                candidat.getGender(),
                candidat.getBirthDate(),
                candidat.getBirthPlace(),
                candidat.getCity(),
                candidat.getCountry(),
                candidat.getStatuAdmission() // Correction du nom de la méthode
        );

        // Mapper les diplômes (relation One-to-Many)
        if (candidat.getDiplomes() != null) {
            candidatDto.setDiplomes(
                    candidat.getDiplomes().stream()
                            .map(DiplomeMapper::mapDiplomeToDiplomeDto)
                            .collect(Collectors.toList())
            );
        }

        // Mapper la décision de recrutement (relation One-to-One)
        if (candidat.getDecision() != null) {
            candidatDto.setDecisionRecrutement(
                    DecisionRecrutementMapper.mapDRecrutementToDRecrutementDto(candidat.getDecision())
            );
        }

        return candidatDto;
    }
}
