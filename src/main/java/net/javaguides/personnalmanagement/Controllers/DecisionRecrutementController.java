package net.javaguides.personnalmanagement.Controllers;

import net.javaguides.personnalmanagement.Entities.DecisionRecrutement;
import net.javaguides.personnalmanagement.Services.DecisionRecrutementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("decisions")
public class DecisionRecrutementController {

    private final DecisionRecrutementServiceImpl decisionRecrutementService;

    @Autowired
    public DecisionRecrutementController(DecisionRecrutementServiceImpl decisionRecrutementService) {
        this.decisionRecrutementService = decisionRecrutementService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DecisionRecrutement createDecision(
            @RequestParam Long candidatId,
            @RequestParam Long posteId,
            @RequestParam String decisionNumero,
            @RequestParam String decisionDate,
            @RequestParam String dateEffetPrevisionelle) {

        LocalDate parsedDecisionDate = LocalDate.parse(decisionDate);
        LocalDate parsedDateEffetPrevisionelle = LocalDate.parse(dateEffetPrevisionelle);

        return decisionRecrutementService.createDecision(
                candidatId,
                posteId,
                decisionNumero,
                parsedDecisionDate,
                parsedDateEffetPrevisionelle
        );
    }
}