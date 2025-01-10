package net.javaguides.personnalmanagement.Controllers;

import net.javaguides.personnalmanagement.Services.GradeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import net.javaguides.personnalmanagement.Dtos.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;

@RestController
@RequestMapping("grades")
public class GradeController {
    private GradeService gradeService;
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }
    @PostMapping
    public ResponseEntity<GradeDto> addGrade(@RequestBody GradeDto gradeDto) {
        return new ResponseEntity<>(gradeService.createGrade(gradeDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<GradeDto> modifyGrade( @PathVariable Long id, @RequestBody GradeDto gradeDto) {
        return new ResponseEntity<>(gradeService.updateGrade(id, gradeDto), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GradeDto> getGrade(@PathVariable Long id) {
        return new ResponseEntity<>(gradeService.getGradeById(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<GradeDto>> getAllGrades() {
        return new ResponseEntity<>(gradeService.getAllGrades(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
        return  ResponseEntity.ok("Grade deleted Successfully");
    }

}
