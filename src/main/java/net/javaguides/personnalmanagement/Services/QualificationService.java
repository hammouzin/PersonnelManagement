package net.javaguides.personnalmanagement.Services;



import net.javaguides.personnalmanagement.Dtos.QualificationDto;
import net.javaguides.personnalmanagement.Entities.Qualification;

import java.util.List;

public interface QualificationService {
    QualificationDto createQualification(QualificationDto qualification);
    QualificationDto updateQualification(long id , QualificationDto qualificationDto);
    QualificationDto deleteQualification(long id);
    QualificationDto getQualificationById(long id);
    List<QualificationDto> getAllQualifications();
}
