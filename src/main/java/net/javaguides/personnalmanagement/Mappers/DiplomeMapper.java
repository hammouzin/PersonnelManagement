package net.javaguides.personnalmanagement.Mappers;

import net.javaguides.personnalmanagement.Dtos.DiplomeDto;
import net.javaguides.personnalmanagement.Dtos.AgentDto; // Assurez-vous d'avoir importé AgentDto
import net.javaguides.personnalmanagement.Entities.Diplome;

public class DiplomeMapper {
    public static Diplome mapDiplomeDtoToDiplome(DiplomeDto diplomeDto) {
        Diplome diplome = new Diplome(
                diplomeDto.getId(),
                diplomeDto.getNomDiplome(),
                diplomeDto.getDateObtention(),
                diplomeDto.getEtablissement()
        );

       // Vous devez mapper l'agent de DiplomeDto vers l'Agent de Diplome
       /* if (diplomeDto.getAgentId() != null) {
            diplome.setAgent(AgentMapper.mapAgentDtoToAgent(diplomeDto.getAgentId()))); // Si vous avez un AgentMapper
        }*/

        return diplome;
    }

    public static DiplomeDto mapDiplomeToDiplomeDto(Diplome diplome) {
        DiplomeDto diplomeDto = new DiplomeDto(
                diplome.getId(),
                diplome.getNomDiplome(),
                diplome.getDateObtention(),
                diplome.getEtablissement()
        );


        // Vous devez mapper l'agent de Diplome vers DiplomeDto
        if (diplome.getAgent() != null) {
            diplomeDto.setAgentId(diplome.getAgent().getId());
        }
        if (diplome.getCandidat() != null) {
            diplomeDto.setCandidateId(diplome.getCandidat().getId());
        }

        return diplomeDto;
    }
}
