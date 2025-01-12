package net.javaguides.personnalmanagement.Controllers;

import net.javaguides.personnalmanagement.Dtos.DecisionRecrutementDto;
import net.javaguides.personnalmanagement.Entities.Visa;
import net.javaguides.personnalmanagement.Services.SCFService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scf")
public class SCFController {
    /*private final SCFService scfService;

    @PutMapping("/decisions/{id}/visa")
    public ResponseEntity<DecisionRecrutementDto> attribuerVisa(
            @PathVariable Long id,
            @RequestBody Visa request
    ) {
        return ResponseEntity.ok(
                scfService.attribuerVisa(id, request.getVisaStatus(), request.getCommentaire())
        );
    }*/
}

