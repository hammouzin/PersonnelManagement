package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Dtos.GradeDto;
import net.javaguides.personnalmanagement.Entities.Grade;
import net.javaguides.personnalmanagement.Mappers.GradeMapper;
import net.javaguides.personnalmanagement.Repositories.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradeServiceImpl implements GradeService {
    private GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public GradeDto createGrade(GradeDto gradeDto) {
        Grade grade = GradeMapper.mapGradeDtoToGrade(gradeDto);
        Grade savedGrade = gradeRepository.save(grade);
        return GradeMapper.mapGradeToGradeDto(savedGrade);
    }


    @Override
    public GradeDto updateGrade(long id, GradeDto gradeDto) {
        if (!gradeRepository.existsById(id)) {
            throw new RuntimeException("Grade not found with id: " + id);
        }
        Grade grade = GradeMapper.mapGradeDtoToGrade(gradeDto);
        grade.setId(id);
        Grade savedGrade = gradeRepository.save(grade);
        return GradeMapper.mapGradeToGradeDto(savedGrade);
    }

    @Override
    public GradeDto deleteGrade(long id) {
        Grade grade = gradeRepository.findById(id).orElse(null);
        gradeRepository.delete(grade);
        return GradeMapper.mapGradeToGradeDto(grade);
    }

    @Override
    public GradeDto getGradeById(long id) {
        Grade grade = gradeRepository.findById(id).orElseThrow(() -> new RuntimeException("Grade non trouvé"));
        return GradeMapper.mapGradeToGradeDto(grade);
    }

    @Override
    public List<GradeDto> getAllGrades() {
        List<Grade> gradeList = gradeRepository.findAll();
        return gradeList.stream().map((grade -> GradeMapper.mapGradeToGradeDto(grade))).collect(Collectors.toList());
    }

}
