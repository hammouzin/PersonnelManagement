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
    private AgentRepository agentRepository;
    private final GradeRepository gradeRepository;
    private final CongeRepository congeRepository;
    private final QualificationRepository qualificationRepository;
    private final PosteRepository posteRepository;
    private final AffectationRepository affectationRepository;
    private DiplomeRepository diplomeRepository;
    private UserRepository userRepository;


    public AgentServiceImpl(AgentRepository agentRepository ,  GradeRepository gradeRepository, CongeRepository congeRepository, QualificationRepository qualificationRepository, PosteRepository posteRepository, AffectationRepository affectationRepository) {
        this.agentRepository = agentRepository;
        this.gradeRepository = gradeRepository;
        this.congeRepository = congeRepository;
        this.qualificationRepository = qualificationRepository;
        this.posteRepository = posteRepository;
        this.affectationRepository = affectationRepository;
    }


    @Override
    public UserDto createAgent(UserDto userDto) {
        User agent = AgentMapper.mapAgentDtoToAgent(userDto);
        User savedAgent = userRepository.save(agent);
        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public UserDto updateAgent(Long id, UserDto agentDto) {
        if (!agentRepository.existsById(id)) {
            throw new RuntimeException("Agent not found with id: " + id);
        }
        User agent = AgentMapper.mapAgentDtoToAgent(agentDto);
        agent.setId(id);
        User savedAgent = userRepository.save(agent);
        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public UserDto deleteAgent(Long id) {
        User agent = userRepository.findById(id).orElse(null);
        if (agent != null) {
            userRepository.delete(agent);
        }
        return agent != null ? AgentMapper.mapAgentToAgentDTO(agent) : null;
    }

    @Override
    public UserDto getAgentById(Long id) {
        User agent = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Agent non trouvé"));
        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public List<UserDto> getAllAgents() {
        List<User> agentList = userRepository.findAll();
        return agentList.stream().map(agent -> AgentMapper.mapAgentToAgentDTO(agent)).collect(Collectors.toList());
    }

    // gestion des diplomes
    @Override
  public UserDto addDiplomeToAgent(Long agentId, Long diplomeId) {
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Diplome diplome = diplomeRepository.findById(diplomeId)
                .orElseThrow(() -> new RuntimeException("Diplome not found with id: " + diplomeId));

        diplome.setAgent(agent); // Associer le diplôme à l'agent
        agent.getDiplomes().add(diplome); // Ajouter à la liste des diplômes

        diplomeRepository.save(diplome); // Sauvegarder le diplôme
        User savedAgent = userRepository.save(agent); // Sauvegarder l'agent avec la mise à jour

        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public UserDto removeDiplomeFromAgent(Long agentId, Long diplomeId) {
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Diplome diplome = diplomeRepository.findById(diplomeId)
                .orElseThrow(() -> new RuntimeException("Diplome not found with id: " + diplomeId));

        if (agent.getDiplomes().contains(diplome)) {
            agent.getDiplomes().remove(diplome);
            diplome.setAgent(null); // Remove the link from the diplome

            diplomeRepository.save(diplome); // Update the diplome in the database
            userRepository.save(agent); // Save the updated agent
        }

        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public UserDto updateAgentDiplome(Long agentId, Long diplomeId, DiplomeDto diplomeDto) {
        User agent = userRepository.findById(agentId)
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
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        return agent.getDiplomes();
    }
// gestion des grades

    @Override
    public UserDto addGradeToAgent(Long agentId, Long gradeId) {
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Grade grade = gradeRepository.findById(gradeId)
                .orElseThrow(() -> new RuntimeException("Grade not found with id: " + gradeId));

        grade.setAgent(agent);
        agent.getGrades().add(grade);

        gradeRepository.save(grade);
        User savedAgent = userRepository.save(agent);

        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public UserDto removeGradeFromAgent(Long agentId, Long gradeId) {
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Grade grade = gradeRepository.findById(gradeId)
                .orElseThrow(() -> new RuntimeException("Grade not found with id: " + gradeId));

        if (agent.getGrades().contains(grade)) {
            agent.getGrades().remove(grade);
            /*grade.setAgent(null);

            gradeRepository.save(grade);*/
            userRepository.save(agent);
        }

        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public UserDto updateAgentGrade(Long agentId, Long gradeId, GradeDto gradeDto) {
        User agent = userRepository.findById(agentId)
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
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        return agent.getGrades();
    }

    // gestion des conges

    @Override
    public UserDto addCongeToAgent(Long agentId, Long congeId) {
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Conge conge = congeRepository.findById(congeId)
                .orElseThrow(() -> new RuntimeException("Conge not found with id: " + congeId));

        conge.setAgent(agent);
        agent.getConges().add(conge);

        congeRepository.save(conge);
        User savedAgent = userRepository.save(agent);

        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public UserDto removeCongeFromAgent(Long agentId, Long congeId) {
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Conge conge = congeRepository.findById(congeId)
                .orElseThrow(() -> new RuntimeException("Conge not found with id: " + congeId));

        if (agent.getConges().contains(conge)) {
            agent.getConges().remove(conge);
            conge.setAgent(null);

            congeRepository.save(conge);
            userRepository.save(agent);
        }

        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public UserDto updateAgentConge(Long agentId, Long congeId, CongeDto congeDto) {
        User agent = userRepository.findById(agentId)
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
        User agent = userRepository.findById(agentId)
                .orElseThrow(()
                        -> new RuntimeException("Agent not found with id: " + agentId));
        return agent.getConges();

    }

    // gestion des qualifications

    @Override
    public UserDto addQualificationToAgent(Long agentId, Long qualificationId) {
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Qualification qualification = qualificationRepository.findById(qualificationId)
                .orElseThrow(() -> new RuntimeException("Qualification not found with id: " + qualificationId));

        qualification.setAgent(agent);
        agent.getQualifications().add(qualification);

        qualificationRepository.save(qualification);
        User savedAgent = userRepository.save(agent);

        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public UserDto removeQualificationFromAgent(Long agentId, Long qualificationId) {
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Qualification qualification = qualificationRepository.findById(qualificationId)
                .orElseThrow(() -> new RuntimeException("Qualification not found with id: " + qualificationId));

        if (agent.getQualifications().contains(qualification)) {
            agent.getQualifications().remove(qualification);
            qualification.setAgent(null);

            qualificationRepository.save(qualification);
            userRepository.save(agent);
        }

        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public UserDto updateAgentQualification(Long agentId, Long qualificationId, QualificationDto qualificationDto) {
        User agent = userRepository.findById(agentId)
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
        User agent = userRepository.findById(agentId)
                .orElseThrow(()
                        -> new RuntimeException("Agent not found with id: " + agentId));
        return agent.getQualifications();
    }

    // gestion des postes :

    @Override
    public UserDto addPosteToAgent(Long agentId, Long posteId) {
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new RuntimeException("Poste not found with id: " + posteId));

        poste.setAgent(agent);
        agent.getPostes().add(poste);

        posteRepository.save(poste);
        User savedAgent = userRepository.save(agent);

        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public UserDto removePosteFromAgent(Long agentId, Long posteId) {
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new RuntimeException("Poste not found with id: " + posteId));

        if (agent.getPostes().contains(poste)) {
            agent.getPostes().remove(poste);
            poste.setAgent(null);

            posteRepository.save(poste);
            userRepository.save(agent);
        }

        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public UserDto updateAgentPoste(Long agentId, Long posteId, PosteDto posteDto) {
        User agent = userRepository.findById(agentId)
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
        User agent = userRepository.findById(agentId)
                .orElseThrow(()
                        -> new RuntimeException("Agent not found with id: " + agentId));
        return agent.getPostes();
    }

    @Override
    public UserDto addAffectationToAgent(Long agentId, Long affectationId) {
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Affectation affectation = affectationRepository.findById(affectationId)
                .orElseThrow(() -> new RuntimeException("Affectation not found with id: " + affectationId));

        affectation.setAgent(agent);
        agent.getAffectations().add(affectation);

        affectationRepository.save(affectation);
        User savedAgent = userRepository.save(agent);

        return AgentMapper.mapAgentToAgentDTO(savedAgent);
    }

    @Override
    public UserDto removeAffectationFromAgent(Long agentId, Long affectationId) {
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + agentId));

        Affectation affectation = affectationRepository.findById(affectationId)
                .orElseThrow(() -> new RuntimeException("Affectation not found with id: " + affectationId));

        if (agent.getAffectations().contains(affectation)) {
            agent.getAffectations().remove(affectation);
            affectation.setAgent(null);

            affectationRepository.save(affectation);
            userRepository.save(agent);
        }

        return AgentMapper.mapAgentToAgentDTO(agent);
    }

    @Override
    public UserDto updateAgentAffectation(Long agentId, Long affectationId, AffectationDto affectationDto) {
        User agent = userRepository.findById(agentId)
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
        User agent = userRepository.findById(agentId)
                .orElseThrow(()
                        -> new RuntimeException("Agent not found with id: " + agentId));
        return agent.getAffectations();
    }


}
