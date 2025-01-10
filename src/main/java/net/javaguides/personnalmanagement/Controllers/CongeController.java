package net.javaguides.personnalmanagement.Controllers;

import net.javaguides.personnalmanagement.Dtos.CongeDto;
import net.javaguides.personnalmanagement.Dtos.GradeDto;
import net.javaguides.personnalmanagement.Entities.Conge;
import net.javaguides.personnalmanagement.Services.CongeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("conges")
public class CongeController {
    private CongeService congeService;
    public CongeController(CongeService congeService) {
        this.congeService = congeService;
    }
    @PostMapping
    public ResponseEntity<CongeDto> addConge(@RequestBody CongeDto congeDto) {
        return new ResponseEntity<>(congeService.createConge(congeDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CongeDto> modifyConge( @PathVariable Long id, @RequestBody CongeDto congeDto) {
        return new ResponseEntity<>(congeService.updateConge(id, congeDto), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CongeDto> getCongeById(@PathVariable Long id) {
        return new ResponseEntity<>(congeService.getCongeById(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<CongeDto>> getAllConges() {
        return new ResponseEntity<>(congeService.getAllConges(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConge(@PathVariable Long id) {
        congeService.deleteConge(id);
        return  ResponseEntity.ok("Conge deleted Successfully");
    }
}
