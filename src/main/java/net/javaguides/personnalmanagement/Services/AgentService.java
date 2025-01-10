package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Dtos.*;
import net.javaguides.personnalmanagement.Entities.*;
import java.util.List;

public interface AgentService {

    AgentDto createAgent(AgentDto agentDto);
    AgentDto updateAgent(Long id , AgentDto agentDto);
    AgentDto deleteAgent(Long id);
    AgentDto getAgentById(Long id);
    List<AgentDto> getAllAgents();
    /* gerer les diplomes avec les agents */
   AgentDto addDiplomeToAgent(Long agentId, Long diplomeId); // Correction de la signature
    AgentDto removeDiplomeFromAgent(Long agentId, Long diplomeId);
    AgentDto updateAgentDiplome(Long agentId, Long diplomeId, DiplomeDto diplomeDto);
    List<Diplome> getDiplomesByAgent(Long agentId);
    /* Gerer les grades d'un agent*/
    AgentDto addGradeToAgent(Long agentId, Long gradeId); // Correction de la signature
    AgentDto removeGradeFromAgent(Long agentId, Long gradeId);
    AgentDto updateAgentGrade(Long agentId, Long gradeId, GradeDto gradeDto);
    List<Grade> getGradesByAgent(Long agentId);
    /* Gerer les conges d'un agent */
    AgentDto addCongeToAgent(Long agentId, Long congeId); // Correction de la signature
    AgentDto removeCongeFromAgent(Long agentId, Long congeId);
    AgentDto updateAgentConge(Long agentId, Long congeId, CongeDto congeDto);
    List<Conge> getCongesByAgent(Long agentId);
    /* Gerer les qualifications d'un agent */
    AgentDto addQualificationToAgent(Long agentId, Long qualificationId);
    AgentDto removeQualificationFromAgent(Long agentId, Long qualificationId);
    AgentDto updateAgentQualification(Long agentId, Long qualificationId, QualificationDto qualificationDto);
    List<Qualification> getQualificationsByAgent(Long agentId);
    // gestion des postes :
    AgentDto addPosteToAgent(Long agentId, Long posteId);
    AgentDto removePosteFromAgent(Long agentId, Long posteId);
    AgentDto updateAgentPoste(Long agentId, Long posteId, PosteDto posteDto);
    List<Poste> getPostesByAgent(Long agentId);

    // gestion des affectations

    AgentDto addAffectationToAgent(Long agentId, Long affectationId);
    AgentDto removeAffectationFromAgent(Long agentId, Long affectationId);
    AgentDto updateAgentAffectation(Long agentId, Long affectationId, AffectationDto affectationDto);
    List<Affectation> getAffectationsByAgent(Long agentId);
}
