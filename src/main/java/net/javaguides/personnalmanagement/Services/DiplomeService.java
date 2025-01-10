package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Dtos.DiplomeDto;
import net.javaguides.personnalmanagement.Entities.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DiplomeService {
    DiplomeDto createDiplome(DiplomeDto diplome);
    DiplomeDto updateDiplome(long id , DiplomeDto diplomeDto);
    DiplomeDto deleteDiplome(long id);
    DiplomeDto getDiplomeById(long id);
    List<DiplomeDto> getAllDiplomes();

}
