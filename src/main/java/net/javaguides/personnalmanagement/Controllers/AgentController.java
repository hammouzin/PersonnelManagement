package net.javaguides.personnalmanagement.Controllers;

import net.javaguides.personnalmanagement.Dtos.*;
import net.javaguides.personnalmanagement.Entities.*;
import net.javaguides.personnalmanagement.Mappers.AffectationMapper;
import net.javaguides.personnalmanagement.Services.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController {
    private AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping
    public ResponseEntity<UserDto> addAgent(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(agentService.createAgent(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> modifyAgent(@PathVariable Long id, @RequestBody UserDto agentDto) {
        return new ResponseEntity<>(agentService.updateAgent(id, agentDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getAgent(@PathVariable Long id) {
        return new ResponseEntity<>(agentService.getAgentById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllAgents() {
        return new ResponseEntity<>(agentService.getAllAgents(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgent(@PathVariable Long id) {
        agentService.deleteAgent(id);
        return ResponseEntity.ok("Agent deleted Successfully");
    }

    // grade
    @PostMapping("/{agentId}/grades/{gradeId}")
    public ResponseEntity<UserDto> addGradeToAgent(@PathVariable Long agentId, @PathVariable Long gradeId) {

        return new ResponseEntity<>(agentService.addGradeToAgent(agentId, gradeId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{agentId}/grades/{gradeId}")
    public ResponseEntity<UserDto> removeGradeFromAgent(@PathVariable Long agentId, @PathVariable Long gradeId) {
        return new ResponseEntity<>(agentService.removeGradeFromAgent(agentId, gradeId), HttpStatus.OK);
    }

    @PutMapping("/{agentId}/grades/{gradeId}")
    public ResponseEntity<UserDto> updateGradeDiplome(@PathVariable Long agentId,
                                                       @PathVariable Long gradeId,
                                                       @RequestBody GradeDto gradeDto) {
        UserDto updatedAgent = agentService.updateAgentGrade(agentId, gradeId, gradeDto);
        return ResponseEntity.ok(updatedAgent);
    }

    @GetMapping("/{agentId}/grades")
    public ResponseEntity<List<Grade>> getGradesByAgent(@PathVariable Long agentId) {
        return new ResponseEntity<>(agentService.getGradesByAgent(agentId), HttpStatus.OK);
    }

    // diplomes
    @PostMapping("/{agentId}/diplomes/{diplomeId}")
    public ResponseEntity<UserDto> addDiplomeToAgent(@PathVariable Long agentId, @PathVariable Long diplomeId) {
        Diplome diplome = new Diplome();
        diplome.setId(diplomeId);  // Associe l'ID du diplôme au nouvel objet Diplome
        return new ResponseEntity<>(agentService.addDiplomeToAgent(agentId, diplomeId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{agentId}/diplomes/{diplomeId}")
    public ResponseEntity<UserDto> removeDiplomeFromAgent(@PathVariable Long agentId, @PathVariable Long diplomeId) {
        return new ResponseEntity<>(agentService.removeDiplomeFromAgent(agentId, diplomeId), HttpStatus.OK);
    }

    @PutMapping("/{agentId}/diplomes/{diplomeId}")
    public ResponseEntity<UserDto> updateAgentDiplome(@PathVariable Long agentId,
                                                       @PathVariable Long diplomeId,
                                                       @RequestBody DiplomeDto diplomeDto) {
        UserDto updatedAgent = agentService.updateAgentDiplome(agentId, diplomeId, diplomeDto);
        return ResponseEntity.ok(updatedAgent);
    }

    @GetMapping("/{agentId}/diplomes")
    public ResponseEntity<List<Diplome>> getDiplomesByAgent(@PathVariable Long agentId) {
        return new ResponseEntity<>(agentService.getDiplomesByAgent(agentId), HttpStatus.OK);
    }
    // Conge :

    @PostMapping("/{agentId}/conges/{congeId}")
    public ResponseEntity<UserDto> addCongeToAgent(@PathVariable Long agentId, @PathVariable Long congeId) {
        Conge conge = new Conge();
        conge.setId(congeId);
        return new ResponseEntity<>(agentService.addCongeToAgent(agentId, congeId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{agentId}/conges/{congeId}")
    public ResponseEntity<UserDto> removeCongeFromAgent(@PathVariable Long agentId, @PathVariable Long congeId) {
        return new ResponseEntity<>(agentService.removeCongeFromAgent(agentId, congeId), HttpStatus.OK);
    }

    @PutMapping("/{agentId}/conges/{congeId}")
    public ResponseEntity<UserDto> updateAgentConge(@PathVariable Long agentId,
                                                     @PathVariable Long congeId,
                                                     @RequestBody CongeDto congeDto) {
        UserDto updatedAgent = agentService.updateAgentConge(agentId, congeId, congeDto);
        return ResponseEntity.ok(updatedAgent);
    }

    @GetMapping("/{agentId}/conges")
    public ResponseEntity<List<Conge>> getCongesByAgent(@PathVariable Long agentId) {
        return new ResponseEntity<>(agentService.getCongesByAgent(agentId), HttpStatus.OK);
    }

    // postes
    @PostMapping("/{agentId}/postes/{posteId}")
    public ResponseEntity<UserDto> addPoste(@PathVariable Long agentId, @PathVariable Long posteId) {
        Poste poste = new Poste();
        poste.setId(posteId);
        return new ResponseEntity<>(agentService.addPosteToAgent(agentId, posteId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{agentId}/postes/{posteId}")
    public ResponseEntity<UserDto> removePosteFromAgent(@PathVariable Long agentId, @PathVariable Long posteId) {
        return new ResponseEntity<>(agentService.removePosteFromAgent(agentId, posteId), HttpStatus.OK);
    }

    @PutMapping("/{agentId}/postes/{posteId}")
    public ResponseEntity<UserDto> updateAgentPoste(@PathVariable Long agentId,
                                                     @PathVariable Long posteId,
                                                     @RequestBody PosteDto posteDto) {
        UserDto updatedAgent = agentService.updateAgentPoste(agentId, posteId, posteDto);
        return ResponseEntity.ok(updatedAgent);
    }

    @GetMapping("/{agentId}/postes")
    public ResponseEntity<List<Poste>> getPostesByAgent(@PathVariable Long agentId) {
        return new ResponseEntity<>(agentService.getPostesByAgent(agentId), HttpStatus.OK);
    }

    // Gestion des qualifications
    @PostMapping("/{agentId}/qualifications/{qualificationId}")
    public ResponseEntity<UserDto> addQualification(@PathVariable Long agentId, @PathVariable Long qualificationId) {
        Qualification qualification = new Qualification();
        qualification.setId(qualificationId);
        return new ResponseEntity<>(agentService.addQualificationToAgent(agentId, qualificationId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{agentId}/qualifications/{qualificationId}")
    public ResponseEntity<UserDto> removeQualificationFromAgent(@PathVariable Long agentId, @PathVariable Long qualificationId) {
        return new ResponseEntity<>(agentService.removeQualificationFromAgent(agentId, qualificationId), HttpStatus.OK);
    }

    @PutMapping("/{agentId}/qualifications/{qualificationId}")
    public ResponseEntity<UserDto> updateAgentQualification(@PathVariable Long agentId,
                                                             @PathVariable Long qualificationId,
                                                             @RequestBody QualificationDto qualificationDto) {
        UserDto updatedAgent = agentService.updateAgentQualification(agentId, qualificationId, qualificationDto);
        return ResponseEntity.ok(updatedAgent);
    }

    @GetMapping("/{agentId}/qualifications")
    public ResponseEntity<List<Qualification>> getQualificationsByAgent(@PathVariable Long agentId) {
        return new ResponseEntity<>(agentService.getQualificationsByAgent(agentId), HttpStatus.OK);
    }

    // gestion des affectations
    @PostMapping("/{agentId}/affectations/{affectationId}")
    public ResponseEntity<UserDto> addAffectation(@PathVariable Long agentId, @PathVariable Long affectationId) {
        Affectation affectation = new Affectation();
        affectation.setId(affectationId);
        return new ResponseEntity<>(agentService.addAffectationToAgent(agentId, affectationId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{agentId}/affectations/{affectationId}")
    public ResponseEntity<UserDto> removeAffectationFromAgent(@PathVariable Long agentId, @PathVariable Long affectationId) {
        return new ResponseEntity<>(agentService.removeAffectationFromAgent(agentId, affectationId), HttpStatus.OK);
    }

    @PutMapping("/{agentId}/affectations/{affectationId}")
    public ResponseEntity<UserDto> updateAgentAffectation(@PathVariable Long agentId,
                                                           @PathVariable Long affectationId,
                                                           @RequestBody AffectationDto affectationDto) {
        UserDto updatedAgent = agentService.updateAgentAffectation(agentId, affectationId, affectationDto);
        return ResponseEntity.ok(updatedAgent);
    }

    @GetMapping("/{agentId}/affectations")
    public ResponseEntity<List<Affectation>> getAffectationsByAgent(@PathVariable Long agentId) {
        return new ResponseEntity<>(agentService.getAffectationsByAgent(agentId), HttpStatus.OK);
    }
}

