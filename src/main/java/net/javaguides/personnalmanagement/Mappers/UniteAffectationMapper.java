package net.javaguides.personnalmanagement.Mappers;

import net.javaguides.personnalmanagement.Dtos.AffectationDto;
import net.javaguides.personnalmanagement.Dtos.UniteAffectationDto;
import net.javaguides.personnalmanagement.Entities.Affectation;
import net.javaguides.personnalmanagement.Entities.UniteAffectation;

import java.util.stream.Collectors;

public class UniteAffectationMapper {
    public static UniteAffectation mapUniteAffectationDtoToUniteAffection(UniteAffectationDto uniteAffectationDto) {

        UniteAffectation uniteAffectation = new UniteAffectation(
                uniteAffectationDto.getId(),
                uniteAffectationDto.getUniteAffectationName(),
                uniteAffectationDto.getUniteAffectationDescription(),
                uniteAffectationDto.getUniteAffectationType()
        );
        if (uniteAffectationDto.getAffectations() != null) {
            uniteAffectation.setAffectations(
                    uniteAffectationDto.getAffectations().stream()
                            .map(AffectationMapper::mapAffectationDtoToAffection)
                            .collect(Collectors.toList())
            );
        }
        if (uniteAffectation.getPostes() != null) {
            uniteAffectation.setPostes(
                    uniteAffectationDto.getPostes().stream()
                            .map(PosteMapper::mapPosteDtoToPoste)
                            .collect(Collectors.toList())
            );
        }
        return uniteAffectation;

    }
    public static UniteAffectationDto mapUniteAffectationToUniteAffectationDto(UniteAffectation uniteAffectation) {
        UniteAffectationDto uniteAffectationDto = new UniteAffectationDto(
                uniteAffectation.getId(),
                uniteAffectation.getUniteAffectationName(),
                uniteAffectation.getUniteAffectationDescription(),
                uniteAffectation.getUniteAffectationType()
        );
        if (uniteAffectation.getAffectations() != null) {
            uniteAffectationDto.setAffectations(
                    uniteAffectation.getAffectations().stream()
                            .map(AffectationMapper::matAffectationToAffectationDto)
                            .collect(Collectors.toList())
            );
        }
        if (uniteAffectation.getPostes() != null) {
            uniteAffectationDto.setPostes(
                    uniteAffectation.getPostes().stream()
                            .map(PosteMapper::mapPosteToPosteDto)
                            .collect(Collectors.toList())
            );
        }
        return uniteAffectationDto;
    }
    }

