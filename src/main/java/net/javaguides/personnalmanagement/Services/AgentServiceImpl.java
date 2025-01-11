package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Dtos.*;
import net.javaguides.personnalmanagement.Entities.*;
import net.javaguides.personnalmanagement.Mappers.AgentMapper;
import net.javaguides.personnalmanagement.Mappers.DiplomeMapper;
import net.javaguides.personnalmanagement.Repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentServiceImpl implements AgentService {
    private final GradeRepository gradeRepository;
    private final CongeRepository congeRepository;
    private final QualificationRepository qualificationRepository;
    private final PosteRepository posteRepository;
    private final AffectationRepository affectationRepository;
    private AgentRepository agentRepository;
    private DiplomeRepository diplomeRepository;

    // Constructor to inject dependencies
    public AgentServiceImpl(AgentRepository agentRepository, DiplomeRepository diplomeRepository, GradeRepository gradeRepository, CongeRepository congeRepository, QualificationRepository qualificationRepository, PosteRepository posteRepository, AffectationRepository affectationRepository) {
        this.agentRepository = agentRepository;
        this.diplomeRepository = diplomeRepository;
        this.gradeRepository = gradeRepository;
        this.congeRepository = congeRepository;
        this.qualificationRepository = qualificationRepository;
        this.posteRepository = posteRepository;
        this.affectationRepository = affectationRepository;
    }

    @Override
    public AgentDto createAgent(AgentDto agentDto) {
        Agent agent = AgentMapper.mapAgentDtoToAgent(agentDto);
        Agent savedAgent = agentRepository.save(agent);
        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public AgentDto updateAgent(Long id, AgentDto agentDto) {
        if (!agentRepository.existsById(id)) {
            throw new RuntimeException("Agent not found with id: " + id);
        }
        Agent agent = AgentMapper.mapAgentDtoToAgent(agentDto);
        agent.setId(id);
        Agent savedAgent = agentRepository.save(agent);
        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public AgentDto deleteAgent(Long id) {
        Agent agent = agentRepository.findById(id).orElse(null);
        if (agent != null) {
            agentRepository.delete(agent);
        }
        return agent != null ? AgentMapper.mapAgentToAgentDTO(agent) : null;
    }

    @Override
    public AgentDto getAgentById(Long id) {
        Agent agent = agentRepository.findById(id).orElseThrow(() -> new RuntimeException("Agent non trouvé"));
        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public List<AgentDto> getAllAgents() {
        List<Agent> agentList = agentRepository.findAll();
        return agentList.stream().map(agent -> AgentMapper.mapAgentToAgentDTO(agent)).collect(Collectors.toList());
    }

    // gestion des diplomes
    @Override
  public AgentDto addDiplomeToAgent(Long agentId, Long diplomeId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Diplome diplome = diplomeRepository.findById(diplomeId)
                .orElseThrow(() -> new RuntimeException("Diplome not found with id: " + diplomeId));

        diplome.setAgent(agent); // Associer le diplôme à l'agent
        agent.getDiplomes().add(diplome); // Ajouter à la liste des diplômes

        diplomeRepository.save(diplome); // Sauvegarder le diplôme
        Agent savedAgent = agentRepository.save(agent); // Sauvegarder l'agent avec la mise à jour

        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public AgentDto removeDiplomeFromAgent(Long agentId, Long diplomeId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Diplome diplome = diplomeRepository.findById(diplomeId)
                .orElseThrow(() -> new RuntimeException("Diplome not found with id: " + diplomeId));

        if (agent.getDiplomes().contains(diplome)) {
            agent.getDiplomes().remove(diplome);
            diplome.setAgent(null); // Remove the link from the diplome

            diplomeRepository.save(diplome); // Update the diplome in the database
            agentRepository.save(agent); // Save the updated agent
        }

        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public AgentDto updateAgentDiplome(Long agentId, Long diplomeId, DiplomeDto diplomeDto) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Diplome diplome = agent.getDiplomes().stream()
                .filter(d -> d.getId().equals(diplomeId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Diplome not found with id: " + diplomeId));

        // Update diplome fields
        diplome.setNomDiplome(diplomeDto.getNomDiplome());
        diplome.setDateObtention(diplomeDto.getDateObtention());
        diplome.setEtablissement(diplomeDto.getEtablissement());

        diplomeRepository.save(diplome); // Save the updated diplome
        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public List<Diplome> getDiplomesByAgent(Long agentId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        return agent.getDiplomes();
    }
// gestion des grades

    @Override
    public AgentDto addGradeToAgent(Long agentId, Long gradeId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Grade grade = gradeRepository.findById(gradeId)
                .orElseThrow(() -> new RuntimeException("Grade not found with id: " + gradeId));

        grade.setAgent(agent);
        agent.getGrades().add(grade);

        gradeRepository.save(grade);
        Agent savedAgent = agentRepository.save(agent);

        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public AgentDto removeGradeFromAgent(Long agentId, Long gradeId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Grade grade = gradeRepository.findById(gradeId)
                .orElseThrow(() -> new RuntimeException("Grade not found with id: " + gradeId));

        if (agent.getGrades().contains(grade)) {
            agent.getGrades().remove(grade);
            /*grade.setAgent(null);

            gradeRepository.save(grade);*/
            agentRepository.save(agent);
        }

        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public AgentDto updateAgentGrade(Long agentId, Long gradeId, GradeDto gradeDto) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Grade grade = agent.getGrades().stream()
                .filter(d -> d.getId().equals(gradeId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Grade not found with id: " + gradeId));


        grade.setLibelleGrade(gradeDto.getLibelleGrade());
        grade.setDateObtention(gradeDto.getDateObtention());
        grade.setDateFinValidite(gradeDto.getDateFinValidite());

        gradeRepository.save(grade); // Save the updated diploma
        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public List<Grade> getGradesByAgent(Long agentId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        return agent.getGrades();
    }

    // gestion des conges

    @Override
    public AgentDto addCongeToAgent(Long agentId, Long congeId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Conge conge = congeRepository.findById(congeId)
                .orElseThrow(() -> new RuntimeException("Conge not found with id: " + congeId));

        conge.setAgent(agent);
        agent.getConges().add(conge);

        congeRepository.save(conge);
        Agent savedAgent = agentRepository.save(agent);

        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public AgentDto removeCongeFromAgent(Long agentId, Long congeId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Conge conge = congeRepository.findById(congeId)
                .orElseThrow(() -> new RuntimeException("Conge not found with id: " + congeId));

        if (agent.getConges().contains(conge)) {
            agent.getConges().remove(conge);
            conge.setAgent(null);

            congeRepository.save(conge);
            agentRepository.save(agent);
        }

        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public AgentDto updateAgentConge(Long agentId, Long congeId, CongeDto congeDto) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Conge conge = agent.getConges().stream()
                .filter(d -> d.getId().equals(congeId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Conge not found with id: " + congeId));


        conge.setCongeType(congeDto.getCongeType());
        conge.setCongeDateDebut(congeDto.getCongeDateDebut());
        conge.setCongeDateFin(congeDto.getCongeDateFin());
        conge.setCongeDescription(congeDto.getCongeDescription());
        conge.setCongeNbJours(congeDto.getCongeNbJours());
        conge.setCongeStatus(congeDto.getCongeStatus());

        congeRepository.save(conge);
        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public List<Conge> getCongesByAgent(Long agentId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(()
                        -> new RuntimeException("Agent not found with id: " + agentId));
        return agent.getConges();

    }

    // gestion des qualifications

    @Override
    public AgentDto addQualificationToAgent(Long agentId, Long qualificationId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Qualification qualification = qualificationRepository.findById(qualificationId)
                .orElseThrow(() -> new RuntimeException("Qualification not found with id: " + qualificationId));

        qualification.setAgent(agent);
        agent.getQualifications().add(qualification);

        qualificationRepository.save(qualification);
        Agent savedAgent = agentRepository.save(agent);

        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public AgentDto removeQualificationFromAgent(Long agentId, Long qualificationId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Qualification qualification = qualificationRepository.findById(qualificationId)
                .orElseThrow(() -> new RuntimeException("Qualification not found with id: " + qualificationId));

        if (agent.getQualifications().contains(qualification)) {
            agent.getQualifications().remove(qualification);
            qualification.setAgent(null);

            qualificationRepository.save(qualification);
            agentRepository.save(agent);
        }

        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public AgentDto updateAgentQualification(Long agentId, Long qualificationId, QualificationDto qualificationDto) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Qualification qualification = agent.getQualifications().stream()
                .filter(d -> d.getId().equals(qualificationId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Qualification not found with id: " + qualificationDto));


        qualification.setQualificationName(qualificationDto.getQualificationName());
        qualification.setQualificationDescription(qualificationDto.getQualificationDescription());
        qualification.setQualificationDate(qualificationDto.getQualificationDate());
        qualification.setQualificationType(qualificationDto.getQualificationType());

        qualificationRepository.save(qualification);
        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public List<Qualification> getQualificationsByAgent(Long agentId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(()
                        -> new RuntimeException("Agent not found with id: " + agentId));
        return agent.getQualifications();
    }

    // gestion des postes :

    @Override
    public AgentDto addPosteToAgent(Long agentId, Long posteId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new RuntimeException("Poste not found with id: " + posteId));

        poste.setAgent(agent);
        agent.getPostes().add(poste);

        posteRepository.save(poste);
        Agent savedAgent = agentRepository.save(agent);

        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public AgentDto removePosteFromAgent(Long agentId, Long posteId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new RuntimeException("Poste not found with id: " + posteId));

        if (agent.getPostes().contains(poste)) {
            agent.getPostes().remove(poste);
            poste.setAgent(null);

            posteRepository.save(poste);
            agentRepository.save(agent);
        }

        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public AgentDto updateAgentPoste(Long agentId, Long posteId, PosteDto posteDto) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Poste poste = agent.getPostes().stream()
                .filter(d -> d.getId().equals(posteId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Poste not found with id: " + posteId));


        poste.setPosteName(poste.getPosteName());
        poste.setPosteDescription(poste.getPosteDescription());
        poste.setPosteSalary(poste.getPosteSalary());



        posteRepository.save(poste);
        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public List<Poste> getPostesByAgent(Long agentId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(()
                        -> new RuntimeException("Agent not found with id: " + agentId));
        return agent.getPostes();
    }

    @Override
    public AgentDto addAffectationToAgent(Long agentId, Long affectationId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Affectation affectation = affectationRepository.findById(affectationId)
                .orElseThrow(() -> new RuntimeException("Affectation not found with id: " + affectationId));

        affectation.setAgent(agent);
        agent.getAffectations().add(affectation);

        affectationRepository.save(affectation);
        Agent savedAgent = agentRepository.save(agent);

        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public AgentDto removeAffectationFromAgent(Long agentId, Long affectationId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Affectation affectation = affectationRepository.findById(affectationId)
                .orElseThrow(() -> new RuntimeException("Affectation not found with id: " + affectationId));

        if (agent.getAffectations().contains(affectation)) {
            agent.getAffectations().remove(affectation);
            affectation.setAgent(null);

            affectationRepository.save(affectation);
            agentRepository.save(agent);
        }

        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public AgentDto updateAgentAffectation(Long agentId, Long affectationId, AffectationDto affectationDto) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Affectation affectation = agent.getAffectations().stream()
                .filter(d -> d.getId().equals(affectationId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Affectation not found with id: " + affectationId));


        affectation.setAffectationName(affectation.getAffectationName());
        affectation.setAffectationDate(affectation.getAffectationDate());
        affectation.setEndAffectationDate(affectation.getEndAffectationDate());



        affectationRepository.save(affectation);
        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public List<Affectation> getAffectationsByAgent(Long agentId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(()
                        -> new RuntimeException("Agent not found with id: " + agentId));
        return agent.getAffectations();
    }


}
