package net.javaguides.personnalmanagement.Controllers;

import net.javaguides.personnalmanagement.Entities.DecisionRecrutement;
import net.javaguides.personnalmanagement.Services.DecisionRecrutementServiceImpl;
import net.javaguides.personnalmanagement.Services.DcpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("decisions")
public class DecisionRecrutementController {

    private final DecisionRecrutementServiceImpl decisionRecrutementService;
    private final DcpService dcpService;

    @Autowired
    public DecisionRecrutementController(DecisionRecrutementServiceImpl decisionRecrutementService, DcpService dcpService) {
        this.decisionRecrutementService = decisionRecrutementService;
        this.dcpService = dcpService;
    }

    // API pour créer une décision sans statut
    @PostMapping("/create")
    public ResponseEntity<?> createDecision(@RequestBody Map<String, Object> requestBody) {
        try {
            Long candidatId = Long.parseLong(requestBody.get("candidatId").toString());
            Long posteId = Long.parseLong(requestBody.get("posteId").toString());
            String decisionNumero = requestBody.get("decisionNumero").toString();
            LocalDate decisionDate = LocalDate.parse(requestBody.get("decisionDate").toString());
            LocalDate dateEffetPrevisionelle = LocalDate.parse(requestBody.get("dateEffetPrevisionelle").toString());

            // Créer la décision sans statut (statut null par défaut)
            DecisionRecrutement decision = decisionRecrutementService.createDecision(
                    candidatId,
                    posteId,
                    decisionNumero,
                    decisionDate,
                    dateEffetPrevisionelle
            );

            return ResponseEntity.ok()
                    .body(Map.of(
                            "message", "Décision créée avec succès sans statut",
                            "decision", decision
                    ));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", e.getMessage()));
        }
    }

    // API pour vérifier l'existence du poste et mettre à jour le statut de la décision
    @PostMapping("/{decisionId}/verifier-et-mettre-a-jour-statuts")
    public ResponseEntity<?> verifierEtMettreAJourStatut(@PathVariable Long decisionId) {
        try {
            // Vérifier l'existence du poste et mettre à jour le statut de la décision
            dcpService.verifierEtMettreAJourStatut(decisionId);

            return ResponseEntity.ok()
                    .body(Map.of(
                            "message", "Statut de la décision mis à jour avec succès"
                    ));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", e.getMessage()));
        }
    }
}
