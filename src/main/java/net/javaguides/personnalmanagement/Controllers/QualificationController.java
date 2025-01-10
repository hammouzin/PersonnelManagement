package net.javaguides.personnalmanagement.Controllers;
import net.javaguides.personnalmanagement.Dtos.QualificationDto;
import net.javaguides.personnalmanagement.Services.QualificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("qualifications")
public class QualificationController {
    private QualificationService qualificationService;
    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }
    @PostMapping
    public ResponseEntity<QualificationDto> addQualification(@RequestBody QualificationDto qualificationDto) {
        return new ResponseEntity<>(qualificationService.createQualification(qualificationDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<QualificationDto> modifyQualification( @PathVariable Long id, @RequestBody QualificationDto qualificationDto) {
        return new ResponseEntity<>(qualificationService.updateQualification(id, qualificationDto), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<QualificationDto> getQualificationById(@PathVariable Long id) {
        return new ResponseEntity<>(qualificationService.getQualificationById(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<QualificationDto>> getAllQualifications() {
        return new ResponseEntity<>(qualificationService.getAllQualifications(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQualification(@PathVariable Long id) {
        qualificationService.deleteQualification(id);
        return  ResponseEntity.ok("Qualification deleted Successfully");
    }
}
