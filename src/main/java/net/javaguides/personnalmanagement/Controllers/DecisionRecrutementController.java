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


    private  DecisionRecrutementServiceImpl decisionRecrutementService;

    @Autowired
    public DecisionRecrutementController(DecisionRecrutementServiceImpl decisionRecrutementService) {
        this.decisionRecrutementService = decisionRecrutementService;
    }

    // Endpoint pour créer une décision de recrutement
    @PostMapping
    public DecisionRecrutement createDecision(
            @RequestParam Long candidatId,
            @RequestParam Long posteId,
            @RequestParam String decisionNumero,
            @RequestParam String decisionDate, // Format: "yyyy-MM-dd"
            @RequestParam String dateEffetPrevisionelle) { // Format: "yyyy-MM-dd"

        // Conversion des dates
        LocalDate parsedDecisionDate = LocalDate.parse(decisionDate);
        LocalDate parsedDateEffetPrevisionelle = LocalDate.parse(dateEffetPrevisionelle);

        // Appeler le service pour créer la décision
        return decisionRecrutementService.createDecision(candidatId, posteId, decisionNumero, parsedDecisionDate, parsedDateEffetPrevisionelle);
    }

    // Endpoint pour obtenir une décision par son ID

}
