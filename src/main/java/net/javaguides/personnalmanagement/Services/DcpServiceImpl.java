package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Entities.Dcp;
import net.javaguides.personnalmanagement.Entities.DecisionRecrutement;
import net.javaguides.personnalmanagement.Entities.StatutAdmission;
import net.javaguides.personnalmanagement.Entities.StatutDecisionDcp;
import net.javaguides.personnalmanagement.Repositories.CandidatRepository;
import net.javaguides.personnalmanagement.Repositories.DcpRepository;
import net.javaguides.personnalmanagement.Repositories.DecisionRecrutementRepository;
import org.springframework.stereotype.Service;


@Service
public abstract class DcpServiceImpl implements DcpService {


      private DcpRepository dcpRepository;
      private CandidatRepository candidatRepository;

      private DecisionRecrutementRepository decisionRecrutementRepository;
      public Dcp validerPoste(Long decisionId) {
            // Récupérer la décision
            DecisionRecrutement decision = decisionRecrutementRepository.findById(decisionId)
                    .orElseThrow(() -> new RuntimeException("Décision non trouvée"));

            // Simuler la validation du poste
            boolean posteExistant = decision.getPoste().isDisponible();

            // Créer un objet DCP pour suivre l'état
            Dcp dcp = new Dcp();
            dcp.setNom("Validation DCP");
            dcp.setDescription("Validation pour la décision " + decisionId);
            dcp.setPosteValide(posteExistant);

            // Mettre à jour le statut de la décision
            if (posteExistant) {
                  decision.setStatut(StatutDecisionDcp.POSTE_EXISTANT.name()); // Enum converti en String
            } else {
                  decision.setStatut(StatutDecisionDcp.POSTE_INEXISTANT.name());
                  decision.getCandidat().setStatuAdmission("EN_ATTENTE_POSTE"); // Enum pour le statut d'admission
                  candidatRepository.save(decision.getCandidat());
            }

            // Associer la décision au DCP
            decision.setDcp(dcp);
            decisionRecrutementRepository.save(decision);

            // Sauvegarder le DCP
            return dcpRepository.save(dcp);
      }

}
