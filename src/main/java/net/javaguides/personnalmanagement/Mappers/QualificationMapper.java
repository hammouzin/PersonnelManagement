package net.javaguides.personnalmanagement.Mappers;

import net.javaguides.personnalmanagement.Dtos.QualificationDto;
import net.javaguides.personnalmanagement.Entities.Qualification;

public class QualificationMapper {
    public static Qualification mapQualificationDtoToQualification(QualificationDto qualificationDto) {
        Qualification qualification = new Qualification(
                qualificationDto.getId(),
                qualificationDto.getQualificationName(),
                qualificationDto.getQualificationDescription(),
                qualificationDto.getQualificationDate(),
                qualificationDto.getQualificationType()
        );
        return qualification;

    }
    public static QualificationDto mapQualificationToQualificationDto(Qualification qualification) {
        QualificationDto qualificationDto = new QualificationDto(
                qualification.getId(),
                qualification.getQualificationName(),
                qualification.getQualificationDescription(),
                qualification.getQualificationDate(),
                qualification.getQualificationType()
        );
        if (qualification.getAgent() != null) {
            qualificationDto.setAgentId(qualification.getAgent().getId());
        }
        return qualificationDto;
    }
}
