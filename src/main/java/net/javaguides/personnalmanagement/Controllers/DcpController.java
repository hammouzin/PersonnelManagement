/*package net.javaguides.personnalmanagement.Controllers;

import net.javaguides.personnalmanagement.Entities.Dcp;
import net.javaguides.personnalmanagement.Services.DcpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dcp")
public class DcpController {

    private final DcpService dcpService;

    @Autowired
    public DcpController(DcpService dcpService) {
        this.dcpService = dcpService;
    }

    // Endpoint pour valider un poste manuellement
    @PostMapping("/valider/{decisionId}")
    public Dcp validerPoste(@PathVariable Long decisionId) {
        return dcpService.validerPoste(decisionId);
    }
}*/
