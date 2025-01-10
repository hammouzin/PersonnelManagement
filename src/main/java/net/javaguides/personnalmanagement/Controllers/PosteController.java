package net.javaguides.personnalmanagement.Controllers;

import net.javaguides.personnalmanagement.Services.PosteService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import net.javaguides.personnalmanagement.Dtos.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("postes")
public class PosteController {
    private PosteService posteService;

    public PosteController(PosteService posteService) {
        this.posteService = posteService;
    }

    @PostMapping
    public ResponseEntity<PosteDto> addPoste(@RequestBody PosteDto posteDto) {
        return new ResponseEntity<>(posteService.createPoste(posteDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PosteDto> modifyPoste( @PathVariable Long id, @RequestBody PosteDto posteDto) {
        return new ResponseEntity<>(posteService.updatePoste(id, posteDto), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PosteDto> getPoste(@PathVariable Long id) {
        return new ResponseEntity<>(posteService.getPosteById(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<PosteDto>> getAllPostes() {
        return new ResponseEntity<>(posteService.getAllPostes(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostee(@PathVariable Long id) {
        posteService.deletePoste(id);
        return  ResponseEntity.ok("Poste deleted Successfully");
    }

}

