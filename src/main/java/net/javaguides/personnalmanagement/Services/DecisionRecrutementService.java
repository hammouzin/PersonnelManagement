package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Entities.DecisionRecrutement;

import java.time.LocalDate;

public interface DecisionRecrutementService {
    public DecisionRecrutement createDecision(Long candidatId, Long posteId, String decisionNumero, LocalDate decisionDate, LocalDate dateEffetPrevisionelle);
}
