package net.javaguides.personnalmanagement.Controllers;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import net.javaguides.personnalmanagement.Dtos.CandidatDto;
import net.javaguides.personnalmanagement.Services.CandidatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

@RestController
@RequestMapping("candidats")
public class CandidatController {
    private static final Logger logger = LoggerFactory.getLogger(CandidatController.class);

    private CandidatService candidatService;
    public CandidatController(CandidatService candidatService) {
        this.candidatService = candidatService;
    }
    @PostMapping
    public ResponseEntity<CandidatDto> addCandidat(@RequestBody CandidatDto candidatDto) {
        return new ResponseEntity<>(candidatService.createCandidat(candidatDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CandidatDto> modifyCandidat( @PathVariable Long id, @RequestBody CandidatDto candidatDto) {
        return new ResponseEntity<>(candidatService.updateCandidat(id, candidatDto), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CandidatDto> geCandidat(@PathVariable Long id) {
        return new ResponseEntity<>(candidatService.getCandidatById(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<CandidatDto>> getAllcandidats() {
        return new ResponseEntity<>(candidatService.getAllCandidat(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCandidat(@PathVariable Long id) {
        candidatService.deleteCandidat(id);
        return  ResponseEntity.ok("Candidat deleted Successfully");
    }
    @PostMapping("/import")
    public ResponseEntity<String> importerCandidats(@RequestParam("file") MultipartFile file) {
        // Vérification si le fichier est vide
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Veuillez fournir un fichier.");
        }

        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();

        try {
            if (contentType == null || fileName == null) {
                return ResponseEntity.badRequest().body("Type ou nom de fichier non valide.");
            }

            // Vérification du type de fichier (CSV)
            if (contentType.equals("text/csv") || fileName.endsWith(".csv")) {
                logger.info("Fichier CSV détecté : {}", fileName);
                candidatService.importerCandidatsDepuisCSV(file);
            } else {
                logger.warn("Type de fichier non pris en charge : {}", contentType);
                return ResponseEntity.badRequest().body("Veuillez fournir un fichier CSV valide.");
            }

            logger.info("Importation réussie des candidats depuis le fichier CSV : {}", fileName);
            return ResponseEntity.ok("Importation réussie !");
        } catch (IOException e) {
            // Gestion des erreurs liées à la lecture du fichier
            logger.error("Erreur de lecture du fichier : {}", fileName, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    "Erreur lors de la lecture du fichier : " + e.getMessage());
        } catch (Exception e) {
            // Gestion des autres erreurs imprévues
            logger.error("Erreur inattendue lors de l'importation : {}", fileName, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    "Erreur lors de l'importation : " + e.getMessage());
        }
    }


}
