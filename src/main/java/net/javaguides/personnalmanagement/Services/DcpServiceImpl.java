package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Dtos.PosteDto;
import net.javaguides.personnalmanagement.Entities.*;
import net.javaguides.personnalmanagement.Mappers.PosteMapper;
import net.javaguides.personnalmanagement.Repositories.CandidatRepository;
 // import net.javaguides.personnalmanagement.Repositories.DcpRepository;
import net.javaguides.personnalmanagement.Repositories.DecisionRecrutementRepository;
import net.javaguides.personnalmanagement.Repositories.PosteRepository;
import org.springframework.stereotype.Service;


@Service
public  class DcpServiceImpl implements DcpService {


    private  DecisionRecrutementRepository decisionRecrutementRepository;
    private final PosteRepository posteRepository;
    public DcpServiceImpl(PosteRepository posteRepository, DecisionRecrutementRepository decisionRecrutementRepository) {
        this.posteRepository = posteRepository;
        this.decisionRecrutementRepository = decisionRecrutementRepository;
    }

    @Override
    public boolean verifierExistencePoste(Long posteId) {
        return posteRepository.findById(posteId)
                .map(Poste::isDisponible)
                .orElse(false);

    }

    @Override
    public PosteDto getPosteDetails(Long posteId) {
        return posteRepository.findById(posteId)
                .map(PosteMapper::mapPosteToPosteDto)
                .orElseThrow(() -> new RuntimeException("Poste non trouvé"));}
    @Override
    public void verifierEtMettreAJourStatut(Long decisionId) {
        // Récupérer la décision
        DecisionRecrutement decision = decisionRecrutementRepository.findById(decisionId)
                .orElseThrow(() -> new RuntimeException("Décision non trouvée"));

        // Vérifier si le poste est disponible
        boolean posteDisponible = posteRepository.findById(decision.getPoste().getId())
                .map(poste -> poste.isDisponible()) // Vérifie la disponibilité du poste
                .orElse(false);

        // Si le poste est disponible, on met à jour le statut
        if (posteDisponible) {
            decision.setStatut("POSTE_EXISTANT");
        } else {
            decision.setStatut("POSTE_INEXISTANT");
        }

        // Sauvegarder la mise à jour de la décision
        decisionRecrutementRepository.save(decision);
    }
}


/*

      private DcpRepository dcpRepository;
      private CandidatRepository candidatRepository;

      public DcpServiceImpl(DcpRepository dcpRepository) {
            this.dcpRepository = dcpRepository;
      }

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
            decisionRecrutementRepository.save(decision);

            // Sauvegarder le DCP
            return dcpRepository.save(dcp);
      }


      public DcpDto createDcp(DcpDto dcpDto){

            Dcp dcp = DCPMapper.mapDcpDtoToDcp(dcpDto);
            Dcp savedDcp = dcpRepository.save(dcp);

            return DCPMapper.mapDcpToDcpDTO(savedDcp);
      }

*/

