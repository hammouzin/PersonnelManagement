package net.javaguides.personnalmanagement.Mappers;

import net.javaguides.personnalmanagement.Dtos.UserDto;
import net.javaguides.personnalmanagement.Entities.Agent;
import net.javaguides.personnalmanagement.Entities.User;

import java.util.stream.Collectors;

public class AgentMapper {

    public static User mapAgentDtoToAgent(UserDto userDto) {


        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getAddress(),
                userDto.getEmail(),
                userDto.getPhone(),
                userDto.getGender(),
                userDto.getBirthDate(),
                userDto.getBirthPlace(),
                userDto.getCity(),
                userDto.getCountry(),
                userDto.getJoinDate(),
                userDto.getSalary()
        );

        if (userDto.getDiplomes() != null) {
            user.setDiplomes(
                    userDto.getDiplomes().stream()
                            .map(DiplomeMapper::mapDiplomeDtoToDiplome)
                            .collect(Collectors.toList())
            );
        }
        if (userDto.getGrades() != null) {
            user.setGrades(
                    userDto.getGrades().stream()
                            .map(GradeMapper::mapGradeDtoToGrade)
                            .collect(Collectors.toList())
            );
        }
        if (userDto.getConges() != null) {
            user.setConges(
                    userDto.getConges().stream()
                            .map(CongeMapper::mapCongeDtoToConge)
                            .collect(Collectors.toList())
            );
        }
        if (userDto.getQualifications() != null) {
            user.setQualifications(
                    userDto.getQualifications().stream()
                            .map(QualificationMapper::mapQualificationDtoToQualification)
                            .collect(Collectors.toList())
            );
        }
        if (userDto.getPostes() != null) {
            user.setPostes(
                    userDto.getPostes().stream()
                            .map(PosteMapper::mapPosteDtoToPoste)
                            .collect(Collectors.toList())
            );
        }
        if (userDto.getAffectations() != null) {
            user.setAffectations(
                    userDto.getAffectations().stream()
                            .map(AffectationMapper::mapAffectationDtoToAffection)
                            .collect(Collectors.toList())
            );
        }
        return user;
    }

    public static UserDto mapAgentToAgentDTO(User user) {
        UserDto agentDTO = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getAddress(),
                user.getEmail(),
                user.getPhone(),
                user.getGender(),
                user.getBirthDate(),
                user.getBirthPlace(),
                user.getCity(),
                user.getCountry(),
                user.getJoinDate(),
                user.getSalary()
        );

        if (user.getDiplomes() != null) {
            agentDTO.setDiplomes(
                    user.getDiplomes().stream()
                            .map(DiplomeMapper::mapDiplomeToDiplomeDto)
                            .collect(Collectors.toList())
            );
        }
        if (user.getGrades() != null) {
            agentDTO.setGrades(
                    user.getGrades().stream()
                            .map(GradeMapper::mapGradeToGradeDto)
                            .collect(Collectors.toList())
            );
        }
        if (user.getConges() != null) {
            agentDTO.setConges(
                    user.getConges().stream()
                            .map(CongeMapper::mapCongeToCongeDto)
                            .collect(Collectors.toList())
            );
        }
        if (user.getQualifications() != null) {
            agentDTO.setQualifications(
                    user.getQualifications().stream()
                            .map(QualificationMapper::mapQualificationToQualificationDto)
                            .collect(Collectors.toList())
            );
        }
        if (user.getPostes() != null) {
            agentDTO.setPostes(
                    user.getPostes().stream()
                            .map(PosteMapper::mapPosteToPosteDto)
                            .collect(Collectors.toList())
            );
        }
        if (user.getAffectations() != null) {
            agentDTO.setAffectations(
                    user.getAffectations().stream()
                            .map(AffectationMapper::matAffectationToAffectationDto)
                            .collect(Collectors.toList())
            );
        }
        return agentDTO;
    }
}
