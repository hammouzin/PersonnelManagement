package net.javaguides.personnalmanagement.Services;


import net.javaguides.personnalmanagement.Dtos.CongeDto;
import net.javaguides.personnalmanagement.Entities.Conge;

import java.util.List;

public interface CongeService {
    CongeDto createConge(CongeDto conge);
    CongeDto updateConge(long id , CongeDto congeDto);
    CongeDto deleteConge(long id);
    CongeDto getCongeById(long id);
    List<CongeDto> getAllConges();
}
