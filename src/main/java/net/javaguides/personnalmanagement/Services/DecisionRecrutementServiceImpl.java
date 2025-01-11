package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Entities.Candidat;
import net.javaguides.personnalmanagement.Entities.DecisionRecrutement;
import net.javaguides.personnalmanagement.Entities.Poste;
import net.javaguides.personnalmanagement.Repositories.CandidatRepository;
import net.javaguides.personnalmanagement.Repositories.DcpRepository;
import net.javaguides.personnalmanagement.Repositories.DecisionRecrutementRepository;
import net.javaguides.personnalmanagement.Repositories.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DecisionRecrutementServiceImpl implements DecisionRecrutementService {

    private CandidatRepository candidatRepository;
    private  DcpService dcpService;
    private PosteRepository posteRepository;
    private DecisionRecrutementRepository decisionRecrutementRepository;

    // Injection des dépendances via le constructeur

    public DecisionRecrutementServiceImpl(CandidatRepository candidatRepository,
                                          PosteRepository posteRepository,
                                          DecisionRecrutementRepository decisionRecrutementRepository
                                          ) { // Ajout de DcpService ici
        this.candidatRepository = candidatRepository;
        this.posteRepository = posteRepository;
        this.decisionRecrutementRepository = decisionRecrutementRepository;
         // Injection de DcpService
    }


    @Override
    public DecisionRecrutement createDecision(Long candidatId, Long posteId, String decisionNumero, LocalDate decisionDate, LocalDate dateEffetPrevisionelle) {

        Candidat candidat = candidatRepository.findById(candidatId)
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé"));
        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new RuntimeException("Poste non trouvé"));

        // Créer une nouvelle décision
        DecisionRecrutement decision = new DecisionRecrutement();
        decision.setCandidat(candidat);
        decision.setPoste(poste);
        decision.setDecisionNumero(decisionNumero);
        decision.setDecisionDate(decisionDate);
        decision.setDateEffetPrevisionelle(dateEffetPrevisionelle);

        // Sauvegarder la décision
        DecisionRecrutement savedDecision = decisionRecrutementRepository.save(decision);

        // Envoi de la décision au DCP pour validation
        dcpService.validerPoste(savedDecision.getId()); // Validation du poste via DcpService

        return savedDecision;
    }
}
