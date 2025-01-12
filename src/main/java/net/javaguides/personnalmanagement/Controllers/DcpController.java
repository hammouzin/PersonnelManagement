package net.javaguides.personnalmanagement.Controllers;/*package net.javaguides.personnalmanagement.Controllers;

import net.javaguides.personnalmanagement.Entities.Dcp;
import net.javaguides.personnalmanagement.Services.DcpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;*/

import net.javaguides.personnalmanagement.Dtos.PosteDto;
import net.javaguides.personnalmanagement.Entities.Poste;
import net.javaguides.personnalmanagement.Services.DcpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dcp")

public class DcpController {
    private DcpService dcpService;

    public DcpController(DcpService dcpService) {
        this.dcpService = dcpService;
    }
    @GetMapping("/postes/{id}/verify")
    public ResponseEntity<Boolean> verifierPoste(@PathVariable Long posteId){
        return ResponseEntity.ok(dcpService.verifierExistencePoste(posteId));
    }

    @GetMapping("/postes/{id}")
    public ResponseEntity<PosteDto> getPoste(@PathVariable Long posteId){
        return ResponseEntity.ok(dcpService.getPosteDetails(posteId));}



    /* private final DcpService dcpService;

    @Autowired
    public DcpController(DcpService dcpService) {
        this.dcpService = dcpService;
    }
    @PostMapping
    public ResponseEntity<DcpDto> addDcp(@RequestBody DcpDto dcpDto) {
        return new ResponseEntity<>(dcpService.createDcp(dcpDto), HttpStatus.CREATED);
    }

    // Endpoint pour valider un poste manuellement
    @PostMapping("/valider/{decisionId}")
    public Dcp validerPoste(@PathVariable Long decisionId) {
        return dcpService.validerPoste(decisionId);
    }
*/
}