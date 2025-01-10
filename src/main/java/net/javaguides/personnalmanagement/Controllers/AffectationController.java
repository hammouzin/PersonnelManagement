package net.javaguides.personnalmanagement.Controllers;

import net.javaguides.personnalmanagement.Services.AffectationService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import net.javaguides.personnalmanagement.Dtos.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("affectations")
public class AffectationController {

    private AffectationService affectationService;
    public AffectationController(AffectationService affectationService) {
        this.affectationService = affectationService;
    }

    @PostMapping
    public ResponseEntity<AffectationDto> addAffectation(@RequestBody AffectationDto affectationDto) {
        return new ResponseEntity<>(affectationService.createAffectation(affectationDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AffectationDto> modifyAffectation( @PathVariable Long id, @RequestBody AffectationDto affectationDto) {
         return new ResponseEntity<>(affectationService.updateAffectation(id, affectationDto), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AffectationDto> getAffectation(@PathVariable Long id) {
        return new ResponseEntity<>(affectationService.getAffectationById(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<AffectationDto>> getAllAffectations() {
        return new ResponseEntity<>(affectationService.getAllAffectations(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAffectation(@PathVariable Long id) {
                affectationService.deleteAffectation(id);
                return  ResponseEntity.ok("Affectation deleted Successfully");
    }

}
