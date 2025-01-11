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
    public ResponseEntity<AgentDto> addAgent(@RequestBody AgentDto agentDto) {
        return new ResponseEntity<>(agentService.createAgent(agentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgentDto> modifyAgent(@PathVariable Long id, @RequestBody AgentDto agentDto) {
        return new ResponseEntity<>(agentService.updateAgent(id, agentDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgentDto> getAgent(@PathVariable Long id) {
        return new ResponseEntity<>(agentService.getAgentById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AgentDto>> getAllAgents() {
        return new ResponseEntity<>(agentService.getAllAgents(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgent(@PathVariable Long id) {
        agentService.deleteAgent(id);
        return ResponseEntity.ok("Agent deleted Successfully");
    }

    // grade
    @PostMapping("/{agentId}/grades/{gradeId}")
    public ResponseEntity<AgentDto> addGradeToAgent(@PathVariable Long agentId, @PathVariable Long gradeId) {

        return new ResponseEntity<>(agentService.addGradeToAgent(agentId, gradeId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{agentId}/grades/{gradeId}")
    public ResponseEntity<AgentDto> removeGradeFromAgent(@PathVariable Long agentId, @PathVariable Long gradeId) {
        return new ResponseEntity<>(agentService.removeGradeFromAgent(agentId, gradeId), HttpStatus.OK);
    }

    @PutMapping("/{agentId}/grades/{gradeId}")
    public ResponseEntity<AgentDto> updateGradeDiplome(@PathVariable Long agentId,
                                                       @PathVariable Long gradeId,
                                                       @RequestBody GradeDto gradeDto) {
        AgentDto updatedAgent = agentService.updateAgentGrade(agentId, gradeId, gradeDto);
        return ResponseEntity.ok(updatedAgent);
    }

    @GetMapping("/{agentId}/grades")
    public ResponseEntity<List<Grade>> getGradesByAgent(@PathVariable Long agentId) {
        return new ResponseEntity<>(agentService.getGradesByAgent(agentId), HttpStatus.OK);
    }

    // diplomes
    @PostMapping("/{agentId}/diplomes/{diplomeId}")
    public ResponseEntity<AgentDto> addDiplomeToAgent(@PathVariable Long agentId, @PathVariable Long diplomeId) {
        Diplome diplome = new Diplome();
        diplome.setId(diplomeId);  // Associe l'ID du diplôme au nouvel objet Diplome
        return new ResponseEntity<>(agentService.addDiplomeToAgent(agentId, diplomeId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{agentId}/diplomes/{diplomeId}")
    public ResponseEntity<AgentDto> removeDiplomeFromAgent(@PathVariable Long agentId, @PathVariable Long diplomeId) {
        return new ResponseEntity<>(agentService.removeDiplomeFromAgent(agentId, diplomeId), HttpStatus.OK);
    }

    @PutMapping("/{agentId}/diplomes/{diplomeId}")
    public ResponseEntity<AgentDto> updateAgentDiplome(@PathVariable Long agentId,
                                                       @PathVariable Long diplomeId,
                                                       @RequestBody DiplomeDto diplomeDto) {
        AgentDto updatedAgent = agentService.updateAgentDiplome(agentId, diplomeId, diplomeDto);
        return ResponseEntity.ok(updatedAgent);
    }

    @GetMapping("/{agentId}/diplomes")
    public ResponseEntity<List<Diplome>> getDiplomesByAgent(@PathVariable Long agentId) {
        return new ResponseEntity<>(agentService.getDiplomesByAgent(agentId), HttpStatus.OK);
    }
    // Conge :

    @PostMapping("/{agentId}/conges/{congeId}")
    public ResponseEntity<AgentDto> addCongeToAgent(@PathVariable Long agentId, @PathVariable Long congeId) {
        Conge conge = new Conge();
        conge.setId(congeId);
        return new ResponseEntity<>(agentService.addCongeToAgent(agentId, congeId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{agentId}/conges/{congeId}")
    public ResponseEntity<AgentDto> removeCongeFromAgent(@PathVariable Long agentId, @PathVariable Long congeId) {
        return new ResponseEntity<>(agentService.removeCongeFromAgent(agentId, congeId), HttpStatus.OK);
    }

    @PutMapping("/{agentId}/conges/{congeId}")
    public ResponseEntity<AgentDto> updateAgentConge(@PathVariable Long agentId,
                                                     @PathVariable Long congeId,
                                                     @RequestBody CongeDto congeDto) {
        AgentDto updatedAgent = agentService.updateAgentConge(agentId, congeId, congeDto);
        return ResponseEntity.ok(updatedAgent);
    }

    @GetMapping("/{agentId}/conges")
    public ResponseEntity<List<Conge>> getCongesByAgent(@PathVariable Long agentId) {
        return new ResponseEntity<>(agentService.getCongesByAgent(agentId), HttpStatus.OK);
    }

    // postes
    @PostMapping("/{agentId}/postes/{posteId}")
    public ResponseEntity<AgentDto> addPoste(@PathVariable Long agentId, @PathVariable Long posteId) {
        Poste poste = new Poste();
        poste.setId(posteId);
        return new ResponseEntity<>(agentService.addPosteToAgent(agentId, posteId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{agentId}/postes/{posteId}")
    public ResponseEntity<AgentDto> removePosteFromAgent(@PathVariable Long agentId, @PathVariable Long posteId) {
        return new ResponseEntity<>(agentService.removePosteFromAgent(agentId, posteId), HttpStatus.OK);
    }

    @PutMapping("/{agentId}/postes/{posteId}")
    public ResponseEntity<AgentDto> updateAgentPoste(@PathVariable Long agentId,
                                                     @PathVariable Long posteId,
                                                     @RequestBody PosteDto posteDto) {
        AgentDto updatedAgent = agentService.updateAgentPoste(agentId, posteId, posteDto);
        return ResponseEntity.ok(updatedAgent);
    }

    @GetMapping("/{agentId}/postes")
    public ResponseEntity<List<Poste>> getPostesByAgent(@PathVariable Long agentId) {
        return new ResponseEntity<>(agentService.getPostesByAgent(agentId), HttpStatus.OK);
    }

    // Gestion des qualifications
    @PostMapping("/{agentId}/qualifications/{qualificationId}")
    public ResponseEntity<AgentDto> addQualification(@PathVariable Long agentId, @PathVariable Long qualificationId) {
        Qualification qualification = new Qualification();
        qualification.setId(qualificationId);
        return new ResponseEntity<>(agentService.addQualificationToAgent(agentId, qualificationId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{agentId}/qualifications/{qualificationId}")
    public ResponseEntity<AgentDto> removeQualificationFromAgent(@PathVariable Long agentId, @PathVariable Long qualificationId) {
        return new ResponseEntity<>(agentService.removeQualificationFromAgent(agentId, qualificationId), HttpStatus.OK);
    }

    @PutMapping("/{agentId}/qualifications/{qualificationId}")
    public ResponseEntity<AgentDto> updateAgentQualification(@PathVariable Long agentId,
                                                             @PathVariable Long qualificationId,
                                                             @RequestBody QualificationDto qualificationDto) {
        AgentDto updatedAgent = agentService.updateAgentQualification(agentId, qualificationId, qualificationDto);
        return ResponseEntity.ok(updatedAgent);
    }

    @GetMapping("/{agentId}/qualifications")
    public ResponseEntity<List<Qualification>> getQualificationsByAgent(@PathVariable Long agentId) {
        return new ResponseEntity<>(agentService.getQualificationsByAgent(agentId), HttpStatus.OK);
    }

    // gestion des affectations
    @PostMapping("/{agentId}/affectations/{affectationId}")
    public ResponseEntity<AgentDto> addAffectation(@PathVariable Long agentId, @PathVariable Long affectationId) {
        Affectation affectation = new Affectation();
        affectation.setId(affectationId);
        return new ResponseEntity<>(agentService.addAffectationToAgent(agentId, affectationId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{agentId}/affectations/{affectationId}")
    public ResponseEntity<AgentDto> removeAffectationFromAgent(@PathVariable Long agentId, @PathVariable Long affectationId) {
        return new ResponseEntity<>(agentService.removeAffectationFromAgent(agentId, affectationId), HttpStatus.OK);
    }

    @PutMapping("/{agentId}/affectations/{affectationId}")
    public ResponseEntity<AgentDto> updateAgentAffectation(@PathVariable Long agentId,
                                                           @PathVariable Long affectationId,
                                                           @RequestBody AffectationDto affectationDto) {
        AgentDto updatedAgent = agentService.updateAgentAffectation(agentId, affectationId, affectationDto);
        return ResponseEntity.ok(updatedAgent);
    }

    @GetMapping("/{agentId}/affectations")
    public ResponseEntity<List<Affectation>> getAffectationsByAgent(@PathVariable Long agentId) {
        return new ResponseEntity<>(agentService.getAffectationsByAgent(agentId), HttpStatus.OK);
    }
}

