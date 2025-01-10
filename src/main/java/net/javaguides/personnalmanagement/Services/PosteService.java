package net.javaguides.personnalmanagement.Services;


import net.javaguides.personnalmanagement.Dtos.PosteDto;
import net.javaguides.personnalmanagement.Entities.*;

import java.util.List;

public interface PosteService {


      PosteDto createPoste(PosteDto poste);
      PosteDto updatePoste(long id , PosteDto posteDto);
      PosteDto deletePoste(long id);
      PosteDto getPosteById(long id);
      List<PosteDto> getAllPostes();
}
