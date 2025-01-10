package net.javaguides.personnalmanagement.Mappers;

import net.javaguides.personnalmanagement.Dtos.GradeDto;

import net.javaguides.personnalmanagement.Entities.Grade;

public class GradeMapper {
    public static Grade mapGradeDtoToGrade(GradeDto gradeDto) {
        Grade grade = new Grade(
                gradeDto.getId(),
                gradeDto.getLibelleGrade(),
                gradeDto.getDateObtention(),
                gradeDto.getDateFinValidite()
        );
        return grade;
    }

    public static GradeDto mapGradeToGradeDto(Grade grade) {
        GradeDto gradeDto = new GradeDto(
                grade.getId(),
                grade.getLibelleGrade(),
                grade.getDateObtention(),
                grade.getDateFinValidite()
        );
        if (grade.getAgent() != null) {
            gradeDto.setAgentId(grade.getAgent().getId());
        }
        return gradeDto;
    }
}
