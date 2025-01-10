package net.javaguides.personnalmanagement.Mappers;

import net.javaguides.personnalmanagement.Dtos.AgentDto;
import net.javaguides.personnalmanagement.Entities.Agent;
import net.javaguides.personnalmanagement.Dtos.DiplomeDto;
import net.javaguides.personnalmanagement.Entities.Diplome;

import java.util.stream.Collectors;

public class AgentMapper {

    public static Agent mapAgentDtoToAgent(AgentDto agentDto) {
        Agent agent = new Agent(
                agentDto.getId(),
                agentDto.getFirstName(),
                agentDto.getLastName(),
                agentDto.getAddress(),
                agentDto.getEmail(),
                agentDto.getPhone(),
                agentDto.getGender(),
                agentDto.getBirthDate(),
                agentDto.getBirthPlace(),
                agentDto.getCity(),
                agentDto.getCountry(),
                agentDto.getJoinDate(),
                agentDto.getSalary()
        );

        if (agentDto.getDiplomes() != null) {
            agent.setDiplomes(
                    agentDto.getDiplomes().stream()
                            .map(DiplomeMapper::mapDiplomeDtoToDiplome)
                            .collect(Collectors.toList())
            );
        }
        if (agentDto.getGrades() != null) {
            agent.setGrades(
                    agentDto.getGrades().stream()
                            .map(GradeMapper::mapGradeDtoToGrade)
                            .collect(Collectors.toList())
            );
        }
        if (agentDto.getConges() != null) {
            agent.setConges(
                    agentDto.getConges().stream()
                            .map(CongeMapper::mapCongeDtoToConge)
                            .collect(Collectors.toList())
            );
        }
        if (agentDto.getQualifications() != null) {
            agent.setQualifications(
                    agentDto.getQualifications().stream()
                            .map(QualificationMapper::mapQualificationDtoToQualification)
                            .collect(Collectors.toList())
            );
        }
        if (agentDto.getPostes() != null) {
            agent.setPostes(
                    agentDto.getPostes().stream()
                            .map(PosteMapper::mapPosteDtoToPoste)
                            .collect(Collectors.toList())
            );
        }
        if (agentDto.getAffectations() != null) {
            agent.setAffectations(
                    agentDto.getAffectations().stream()
                            .map(AffectationMapper::mapAffectationDtoToAffection)
                            .collect(Collectors.toList())
            );
        }
        return agent;
    }

    public static AgentDto mapAgentToAgentDTO(Agent agent) {
        AgentDto agentDTO = new AgentDto(
                agent.getId(),
                agent.getFirstName(),
                agent.getLastName(),
                agent.getAddress(),
                agent.getEmail(),
                agent.getPhone(),
                agent.getGender(),
                agent.getBirthDate(),
                agent.getBirthPlace(),
                agent.getCity(),
                agent.getCountry(),
                agent.getJoinDate(),
                agent.getSalary()
        );

        if (agent.getDiplomes() != null) {
            agentDTO.setDiplomes(
                    agent.getDiplomes().stream()
                            .map(DiplomeMapper::mapDiplomeToDiplomeDto)
                            .collect(Collectors.toList())
            );
        }
        if (agent.getGrades() != null) {
            agentDTO.setGrades(
                    agent.getGrades().stream()
                            .map(GradeMapper::mapGradeToGradeDto)
                            .collect(Collectors.toList())
            );
        }
        if (agent.getConges() != null) {
            agentDTO.setConges(
                    agent.getConges().stream()
                            .map(CongeMapper::mapCongeToCongeDto)
                            .collect(Collectors.toList())
            );
        }
        if (agent.getQualifications() != null) {
            agentDTO.setQualifications(
                    agent.getQualifications().stream()
                            .map(QualificationMapper::mapQualificationToQualificationDto)
                            .collect(Collectors.toList())
            );
        }
        if (agent.getPostes() != null) {
            agentDTO.setPostes(
                    agent.getPostes().stream()
                            .map(PosteMapper::mapPosteToPosteDto)
                            .collect(Collectors.toList())
            );
        }
        if (agent.getAffectations() != null) {
            agentDTO.setAffectations(
                    agent.getAffectations().stream()
                            .map(AffectationMapper::matAffectationToAffectationDto)
                            .collect(Collectors.toList())
            );
        }
        return agentDTO;
    }
}
