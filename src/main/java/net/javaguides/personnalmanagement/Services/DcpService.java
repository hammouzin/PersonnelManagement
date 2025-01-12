package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Dtos.PosteDto;
import net.javaguides.personnalmanagement.Entities.DecisionRecrutement;

public interface DcpService {

/*    Dcp validerPoste(Long decisionId) ;

      DcpDto createDcp(DcpDto dcpDto);
*/
   boolean verifierExistencePoste(Long posteId);
    PosteDto getPosteDetails(Long posteId);
     void verifierEtMettreAJourStatut(Long decisionId) ;
}
