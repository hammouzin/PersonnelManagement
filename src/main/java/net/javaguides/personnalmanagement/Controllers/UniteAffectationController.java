package net.javaguides.personnalmanagement.Controllers;


import net.javaguides.personnalmanagement.Dtos.AffectationDto;
import net.javaguides.personnalmanagement.Dtos.AgentDto;
import net.javaguides.personnalmanagement.Dtos.PosteDto;
import net.javaguides.personnalmanagement.Dtos.UniteAffectationDto;
import net.javaguides.personnalmanagement.Entities.Affectation;
import net.javaguides.personnalmanagement.Entities.Poste;
import net.javaguides.personnalmanagement.Services.UniteAffectationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("uniteAffectations")
public class UniteAffectationController {
    private UniteAffectationService uniteAffectationService;

    public UniteAffectationController(UniteAffectationService uniteAffectationService) {
        this.uniteAffectationService = uniteAffectationService;
    }
    @PostMapping
    public ResponseEntity<UniteAffectationDto> addUniteAffectation(@RequestBody UniteAffectationDto uniteAffectationDto) {
        return new ResponseEntity<>(uniteAffectationService.createUniteAffectation(uniteAffectationDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UniteAffectationDto> modifyUniteAffectation( @PathVariable Long id, @RequestBody UniteAffectationDto uniteAffectationDto) {
        return new ResponseEntity<>(uniteAffectationService.updateUniteAffectation(id, uniteAffectationDto), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UniteAffectationDto> getUniteAffectation(@PathVariable Long id) {
        return new ResponseEntity<>(uniteAffectationService.getUniteAffectationById(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<UniteAffectationDto>> getAllUniteAffectations() {
        return new ResponseEntity<>(uniteAffectationService.getAllUniteAffectations(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUniteAffectation(@PathVariable Long id) {
        uniteAffectationService.deleteUniteAffectation(id);
        return  ResponseEntity.ok("Unite d' Affectation deleted Successfully");
    }
    // gerer les Affectations et UnitesD'affectation
    @PostMapping("/{uniteAffectationId}/affectations/{affectationId}")
    public ResponseEntity<UniteAffectationDto> addAffectation(@PathVariable Long uniteAffectationId, @PathVariable Long affectationId) {
        Affectation affectation = new Affectation();
        affectation.setId(affectationId);
        return new ResponseEntity<>(uniteAffectationService.addAffectationToUniteAffectation(uniteAffectationId, affectationId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{uniteAffectationId}/affectations/{affectationId}")
    public ResponseEntity<UniteAffectationDto> removeAffectationFromUniteAffectation(@PathVariable Long uniteAffectationId, @PathVariable Long affectationId) {
        return new ResponseEntity<>(uniteAffectationService.removeAffectationFromUniteAffectation(uniteAffectationId, affectationId), HttpStatus.OK);
    }

    @PutMapping("/{uniteAffectationId}/affectations/{affectationId}")
    public ResponseEntity<UniteAffectationDto> updateUniteAffectationAffectation(@PathVariable Long uniteAffectationId,
                                                           @PathVariable Long affectationId,
                                                           @RequestBody AffectationDto affectationDto) {
        UniteAffectationDto updatedUniteAffectation = uniteAffectationService.updateUniteAffectationAffectation(uniteAffectationId, affectationId, affectationDto);
        return ResponseEntity.ok(updatedUniteAffectation);
    }

    @GetMapping("/{uniteAffectationId}/affectations")
    public ResponseEntity<List<Affectation>> getAffectationsByUnite(@PathVariable Long uniteAffectationId) {
        return new ResponseEntity<>(uniteAffectationService.getAffectationsByUniteAffectation(uniteAffectationId), HttpStatus.OK);
    }
    // Gestion des Postes
    @PostMapping("/{uniteAffectationId}/postes/{posteId}")
    public ResponseEntity<UniteAffectationDto> addPoste(@PathVariable Long uniteAffectationId, @PathVariable Long posteId) {
        Poste poste = new Poste();
        poste.setId(posteId);
        return new ResponseEntity<>(uniteAffectationService.addPosteToUniteAffectation(uniteAffectationId, posteId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{uniteAffectationId}/postes/{posteId}")
    public ResponseEntity<UniteAffectationDto> removePosteFromUniteAffectation(@PathVariable Long uniteAffectationId, @PathVariable Long posteId) {
        return new ResponseEntity<>(uniteAffectationService.removePosteFromUniteAffectation(uniteAffectationId, posteId), HttpStatus.OK);
    }

    @PutMapping("/{uniteAffectationId}/postes/{posteId}")
    public ResponseEntity<UniteAffectationDto> updateUniteAffectationPoste(@PathVariable Long uniteAffectationId,
                                                                                 @PathVariable Long posteId,
                                                                                 @RequestBody PosteDto posteDto) {
        UniteAffectationDto updatedUniteAffectation = uniteAffectationService.updateUniteAffectationPoste(uniteAffectationId, posteId, posteDto);
        return ResponseEntity.ok(updatedUniteAffectation);
    }

    @GetMapping("/{uniteAffectationId}/postes")
    public ResponseEntity<List<Poste>> getPostesByUnite(@PathVariable Long uniteAffectationId) {
        return new ResponseEntity<>(uniteAffectationService.getPostesByUniteAffectation(uniteAffectationId), HttpStatus.OK);
    }

}
