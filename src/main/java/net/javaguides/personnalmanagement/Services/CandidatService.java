package net.javaguides.personnalmanagement.Services;



import net.javaguides.personnalmanagement.Dtos.CandidatDto;
import net.javaguides.personnalmanagement.Entities.Diplome;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CandidatService {
    CandidatDto createCandidat(CandidatDto candidat);
    CandidatDto updateCandidat(long id , CandidatDto candidatDto);
    CandidatDto deleteCandidat(long id);
    CandidatDto getCandidatById(long id);
    List<CandidatDto> getAllCandidat();
    public void importerCandidatsDepuisCSV(MultipartFile file) throws IOException;
     public void  AdDiplomeToCandidat(Long candidatId, Diplome diplome) ;

}
