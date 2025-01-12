package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Entities.Candidat;
import net.javaguides.personnalmanagement.Entities.DecisionRecrutement;
import net.javaguides.personnalmanagement.Entities.Poste;
import net.javaguides.personnalmanagement.Repositories.CandidatRepository;
//import net.javaguides.personnalmanagement.Repositories.DcpRepository;
import net.javaguides.personnalmanagement.Repositories.DecisionRecrutementRepository;
import net.javaguides.personnalmanagement.Repositories.PosteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DecisionRecrutementServiceImpl implements DecisionRecrutementService {

    private CandidatRepository candidatRepository;
    private  DcpService dcpService;
    private PosteRepository posteRepository;
    private DecisionRecrutementRepository decisionRecrutementRepository;
 //   private DcpRepository dcpRepository;


    // Injection des dépendances via le constructeur


    public DecisionRecrutementServiceImpl(CandidatRepository candidatRepository, PosteRepository posteRepository, DecisionRecrutementRepository decisionRecrutementRepository, DcpService dcpService1) {
        this.candidatRepository = candidatRepository;
        this.dcpService = dcpService;
        this.posteRepository = posteRepository;
        this.decisionRecrutementRepository = decisionRecrutementRepository;
        this.dcpService = dcpService1;
    }

    @Override
    public DecisionRecrutement createDecision(Long candidatId, Long posteId, String decisionNumero, LocalDate decisionDate, LocalDate dateEffetPrevisionelle) {
        // Récupérer le candidat et le poste
        Candidat candidat = candidatRepository.findById(candidatId)
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé"));

        if (candidat.getDecision() != null) {
            throw new RuntimeException("Ce candidat a déjà une décision associée");
        }

        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new RuntimeException("Poste non trouvé"));

        // Créer la décision
        DecisionRecrutement decision = new DecisionRecrutement();
        decision.setCandidat(candidat);
        decision.setPoste(poste);
        decision.setDecisionNumero(decisionNumero);
        decision.setDecisionDate(decisionDate);
        decision.setDateEffetPrevisionelle(dateEffetPrevisionelle);

      //  dcpService.verifierEtMettreAJourStatutDecision(decision);

        // Associer la décision au candidat
        candidat.setDecision(decision);

        // Sauvegarder la décision
        return decisionRecrutementRepository.save(decision);
    }





/*    @Override
    public DecisionRecrutement validerDecision(Long decisionId, Long dcpId) {
        // Récupérer la décision
        DecisionRecrutement decision = decisionRecrutementRepository.findById(decisionId)
                .orElseThrow(() -> new RuntimeException("Décision non trouvée"));

        // Récupérer le DCP
      Dcp dcp = dcpRepository.findById(dcpId)
                .orElseThrow(() -> new RuntimeException("DCP non trouvé"));

        // Associer la décision au DCP et valider le poste si applicable
        decision.setDcp(dcp);
        decision.setStatut("VALIDÉE"); // Met à jour le statut de la décision

        // Sauvegarder la décision
        return decisionRecrutementRepository.save(decision);
    }

*/
}
