package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Dtos.DecisionRecrutementDto;
import net.javaguides.personnalmanagement.Entities.DecisionRecrutement;
import net.javaguides.personnalmanagement.Entities.Visa;
import net.javaguides.personnalmanagement.Mappers.DecisionRecrutementMapper;
import net.javaguides.personnalmanagement.Repositories.DecisionRecrutementRepository;

public class SCFServiceImpl implements SCFService {

    private DecisionRecrutementRepository decisionRepository;
    private DecisionRecrutementMapper decisionMapper;

    @Override
    public DecisionRecrutementDto attribuerVisa(Long decisionId, Visa visa) {
        DecisionRecrutement decision = decisionRepository.findById(decisionId)
                .orElseThrow(() -> new IllegalArgumentException("La decision n'est pas trouvée"));

        decision.setVisa(visa);

        return decisionMapper.toDto(decisionRepository.save(decision));
    }
}
