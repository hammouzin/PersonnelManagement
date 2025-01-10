package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Dtos.GradeDto;
import net.javaguides.personnalmanagement.Entities.*;

import java.util.List;

public interface GradeService {
    GradeDto createGrade(GradeDto grade);
    GradeDto updateGrade(long id , GradeDto gradeDto);
    GradeDto deleteGrade(long id);
    GradeDto getGradeById(long id);
    List<GradeDto> getAllGrades();
}
