package net.javaguides.personnalmanagement.Services;


import net.javaguides.personnalmanagement.Dtos.DecisionRecrutementDto;
import net.javaguides.personnalmanagement.Entities.Visa;
import org.springframework.stereotype.Service;

@Service
public interface SCFService {

    DecisionRecrutementDto attribuerVisa(Long decisionId , Visa visa);

}
