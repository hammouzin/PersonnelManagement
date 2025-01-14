package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Dtos.*;
import net.javaguides.personnalmanagement.Entities.*;
import java.util.List;

public interface AgentService {

    UserDto createAgent(UserDto userDto);
    UserDto updateAgent(Long id , UserDto userDto);
    UserDto deleteAgent(Long id);
    UserDto getAgentById(Long id);
    List<UserDto> getAllAgents();
    /* gerer les diplomes avec les agents */
   UserDto addDiplomeToAgent(Long agentId, Long diplomeId); // Correction de la signature
    UserDto removeDiplomeFromAgent(Long agentId, Long diplomeId);
    UserDto updateAgentDiplome(Long agentId, Long diplomeId, DiplomeDto diplomeDto);
    List<Diplome> getDiplomesByAgent(Long agentId);
    /* Gerer les grades d'un agent*/
    UserDto addGradeToAgent(Long agentId, Long gradeId); // Correction de la signature
    UserDto removeGradeFromAgent(Long agentId, Long gradeId);
    UserDto updateAgentGrade(Long agentId, Long gradeId, GradeDto gradeDto);
    List<Grade> getGradesByAgent(Long agentId);
    /* Gerer les conges d'un agent */
    UserDto addCongeToAgent(Long agentId, Long congeId); // Correction de la signature
    UserDto removeCongeFromAgent(Long agentId, Long congeId);
    UserDto updateAgentConge(Long agentId, Long congeId, CongeDto congeDto);
    List<Conge> getCongesByAgent(Long agentId);
    /* Gerer les qualifications d'un agent */
    UserDto addQualificationToAgent(Long agentId, Long qualificationId);
    UserDto removeQualificationFromAgent(Long agentId, Long qualificationId);
    UserDto updateAgentQualification(Long agentId, Long qualificationId, QualificationDto qualificationDto);
    List<Qualification> getQualificationsByAgent(Long agentId);
    // gestion des postes :
    UserDto addPosteToAgent(Long agentId, Long posteId);
    UserDto removePosteFromAgent(Long agentId, Long posteId);
    UserDto updateAgentPoste(Long agentId, Long posteId, PosteDto posteDto);
    List<Poste> getPostesByAgent(Long agentId);

    // gestion des affectations

    UserDto addAffectationToAgent(Long agentId, Long affectationId);
    UserDto removeAffectationFromAgent(Long agentId, Long affectationId);
    UserDto updateAgentAffectation(Long agentId, Long affectationId, AffectationDto affectationDto);
    List<Affectation> getAffectationsByAgent(Long agentId);
}
