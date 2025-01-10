package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Dtos.AffectationDto;
import net.javaguides.personnalmanagement.Entities.*;
import java.util.List;

public interface AffectationService {
    AffectationDto createAffectation(AffectationDto affectationDto);
    AffectationDto updateAffectation(Long id , AffectationDto affectationDto);
    AffectationDto deleteAffectation(Long id);
    AffectationDto getAffectationById(Long id);
    List<AffectationDto> getAllAffectations();
}
