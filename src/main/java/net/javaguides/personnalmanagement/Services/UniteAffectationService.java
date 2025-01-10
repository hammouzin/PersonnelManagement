package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Dtos.AffectationDto;
import net.javaguides.personnalmanagement.Dtos.AgentDto;
import net.javaguides.personnalmanagement.Dtos.PosteDto;
import net.javaguides.personnalmanagement.Dtos.UniteAffectationDto;
import net.javaguides.personnalmanagement.Entities.Affectation;
import net.javaguides.personnalmanagement.Entities.Poste;

import java.util.List;

public interface UniteAffectationService {
    UniteAffectationDto createUniteAffectation(UniteAffectationDto uniteAffectationDto);
    UniteAffectationDto updateUniteAffectation(Long id , UniteAffectationDto uniteAffectationDto);
    UniteAffectationDto deleteUniteAffectation(Long id);
    UniteAffectationDto getUniteAffectationById(Long id);
    List<UniteAffectationDto> getAllUniteAffectations();

    //Gestion des Unites d'affectation avec les affectations
    UniteAffectationDto addAffectationToUniteAffectation(Long uniteAffectationId, Long affectationId);
    UniteAffectationDto removeAffectationFromUniteAffectation(Long uniteAffectationId, Long affectationId);
    UniteAffectationDto updateUniteAffectationAffectation(Long uniteAffectationId, Long affectationId, AffectationDto affectationDto);
    List<Affectation> getAffectationsByUniteAffectation(Long uniteAffectationId);

    // Gestion des postes

    UniteAffectationDto addPosteToUniteAffectation(Long uniteAffectationId, Long posteId);
    UniteAffectationDto removePosteFromUniteAffectation(Long uniteAffectationId, Long posteId);
    UniteAffectationDto updateUniteAffectationPoste(Long uniteAffectationId, Long posteId, PosteDto posteDto);
    List<Poste> getPostesByUniteAffectation(Long uniteAffectationId);



}
