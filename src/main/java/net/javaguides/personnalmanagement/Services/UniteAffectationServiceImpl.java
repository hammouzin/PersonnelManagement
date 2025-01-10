package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Dtos.AffectationDto;
import net.javaguides.personnalmanagement.Dtos.PosteDto;
import net.javaguides.personnalmanagement.Dtos.UniteAffectationDto;
import net.javaguides.personnalmanagement.Entities.Affectation;
import net.javaguides.personnalmanagement.Entities.Agent;
import net.javaguides.personnalmanagement.Entities.Poste;
import net.javaguides.personnalmanagement.Entities.UniteAffectation;
import net.javaguides.personnalmanagement.Mappers.AffectationMapper;
import net.javaguides.personnalmanagement.Mappers.AgentMapper;
import net.javaguides.personnalmanagement.Mappers.UniteAffectationMapper;
import net.javaguides.personnalmanagement.Repositories.AffectationRepository;
import net.javaguides.personnalmanagement.Repositories.PosteRepository;
import net.javaguides.personnalmanagement.Repositories.UniteAffectationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UniteAffectationServiceImpl implements UniteAffectationService {
    private final AffectationRepository affectationRepository;
    private final PosteRepository posteRepository;
    private UniteAffectationRepository uniteAffectationRepository;

    public UniteAffectationServiceImpl(UniteAffectationRepository uniteAffectationRepository, AffectationRepository affectationRepository, PosteRepository posteRepository) {
        this.uniteAffectationRepository = uniteAffectationRepository;
        this.affectationRepository = affectationRepository;
        this.posteRepository = posteRepository;
    }

    @Override
    public UniteAffectationDto createUniteAffectation(UniteAffectationDto uniteAffectationDto) {
        UniteAffectation uniteAffectation = UniteAffectationMapper.mapUniteAffectationDtoToUniteAffection(uniteAffectationDto);
        UniteAffectation savedUniteAffectation = uniteAffectationRepository.save(uniteAffectation);
        return UniteAffectationMapper.mapUniteAffectationToUniteAffectationDto(savedUniteAffectation);
    }

    @Override
    public UniteAffectationDto updateUniteAffectation(Long id, UniteAffectationDto uniteAffectationDto) {
        if (!uniteAffectationRepository.existsById(id)) {
            throw new RuntimeException("Unité Affectation not found with id: " + id);
        }
        UniteAffectation uniteAffectation = UniteAffectationMapper.mapUniteAffectationDtoToUniteAffection(uniteAffectationDto);
        uniteAffectation.setId(id);
        UniteAffectation savedUniteAffectation = uniteAffectationRepository.save(uniteAffectation);
        return UniteAffectationMapper.mapUniteAffectationToUniteAffectationDto(savedUniteAffectation);
    }


    @Override
    public UniteAffectationDto deleteUniteAffectation(Long id) {
        UniteAffectation uniteAffectation = uniteAffectationRepository.findById(id).orElse(null);
        uniteAffectationRepository.delete(uniteAffectation);
        return UniteAffectationMapper.mapUniteAffectationToUniteAffectationDto(uniteAffectation);
    }



    @Override
    public UniteAffectationDto getUniteAffectationById(Long id) {
        UniteAffectation uniteAffectation = uniteAffectationRepository.findById(id).orElseThrow(() -> new RuntimeException("Unite Affectation non trouvé"));
        return UniteAffectationMapper.mapUniteAffectationToUniteAffectationDto(uniteAffectation);
    }

    @Override
    public List<UniteAffectationDto> getAllUniteAffectations() {
        List<UniteAffectation> uniteAffectationDtoList = uniteAffectationRepository.findAll();
        return uniteAffectationDtoList.stream().map((uniteAffectation -> UniteAffectationMapper.mapUniteAffectationToUniteAffectationDto(uniteAffectation))).collect(Collectors.toList());
    }

    @Override
    public UniteAffectationDto addAffectationToUniteAffectation(Long uniteAffectationId, Long affectationId) {
         UniteAffectation uniteAffectation = uniteAffectationRepository.findById(uniteAffectationId)
                .orElseThrow(() -> new RuntimeException("Unite Affectation not found with id: " + uniteAffectationId));

        Affectation affectation = affectationRepository.findById(affectationId)
                .orElseThrow(() -> new RuntimeException("Affectation  not found with id: " + affectationId));

        affectation.setUniteAffectation(uniteAffectation);
        uniteAffectation.getAffectations().add(affectation);

        affectationRepository.save(affectation);
        UniteAffectation savedUnite = uniteAffectationRepository.save(uniteAffectation);
        return UniteAffectationMapper.mapUniteAffectationToUniteAffectationDto(savedUnite);
    }

    @Override
    public UniteAffectationDto removeAffectationFromUniteAffectation(Long uniteAffectationId, Long affectationId) {
        UniteAffectation uniteAffectation = uniteAffectationRepository.findById(uniteAffectationId)
                .orElseThrow(() -> new RuntimeException("Unite Affectation not found with id: " + uniteAffectationId));

        Affectation affectation = affectationRepository.findById(affectationId)
                .orElseThrow(() -> new RuntimeException("Affectation not found with id: " + affectationId));

        if (uniteAffectation.getAffectations().contains(affectation)) {
            uniteAffectation.getAffectations().remove(affectation);
            affectation.setUniteAffectation(null);

            affectationRepository.save(affectation);
            uniteAffectationRepository.save(uniteAffectation);
        }

        return UniteAffectationMapper.mapUniteAffectationToUniteAffectationDto(uniteAffectation);
    }

    @Override
    public UniteAffectationDto updateUniteAffectationAffectation(Long uniteAffectationId, Long affectationId, AffectationDto affectationDto) {
        UniteAffectation uniteAffectation = uniteAffectationRepository.findById(uniteAffectationId)
                .orElseThrow(() -> new RuntimeException("Unite Affectation not found with id: " + uniteAffectationId));

        Affectation affectation = uniteAffectation.getAffectations().stream()
                .filter(d -> d.getId().equals(affectationId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Affectation not found with id: " + affectationId));


        affectation.setAffectationName(affectation.getAffectationName());
        affectation.setAffectationDate(affectation.getAffectationDate());
        affectation.setEndAffectationDate(affectation.getEndAffectationDate());



        affectationRepository.save(affectation);
        return UniteAffectationMapper.mapUniteAffectationToUniteAffectationDto(uniteAffectation);
    }

    @Override
    public List<Affectation> getAffectationsByUniteAffectation(Long uniteAffectationId) {
        UniteAffectation uniteAffectation = uniteAffectationRepository.findById(uniteAffectationId)
                .orElseThrow(()
                        -> new RuntimeException("Unite Affectation not found with id: " + uniteAffectationId));
        return uniteAffectation.getAffectations();
    }

    // gestion des postes
    @Override
    public UniteAffectationDto addPosteToUniteAffectation(Long uniteAffectationId, Long posteId) {
        UniteAffectation uniteAffectation = uniteAffectationRepository.findById(uniteAffectationId)
                .orElseThrow(() -> new RuntimeException("Unite Affectation not found with id: " + uniteAffectationId));

        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new RuntimeException("Poste  not found with id: " + posteId));

        poste.setUniteAffectation(uniteAffectation);
        uniteAffectation.getPostes().add(poste);

        posteRepository.save(poste);
        UniteAffectation savedUnite = uniteAffectationRepository.save(uniteAffectation);
        return UniteAffectationMapper.mapUniteAffectationToUniteAffectationDto(savedUnite);
    }


    @Override
    public UniteAffectationDto removePosteFromUniteAffectation(Long uniteAffectationId, Long posteId) {
        UniteAffectation uniteAffectation = uniteAffectationRepository.findById(uniteAffectationId)
                .orElseThrow(() -> new RuntimeException("Unite Affectation not found with id: " + uniteAffectationId));

        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new RuntimeException("Poste not found with id: " + posteId));

        if (uniteAffectation.getPostes().contains(poste)) {
            uniteAffectation.getPostes().remove(poste);
            poste.setUniteAffectation(null);

            posteRepository.save(poste);
            uniteAffectationRepository.save(uniteAffectation);
        }

        return UniteAffectationMapper.mapUniteAffectationToUniteAffectationDto(uniteAffectation);
    }

    @Override
    public UniteAffectationDto updateUniteAffectationPoste(Long uniteAffectationId, Long posteId, PosteDto posteDto) {
        UniteAffectation uniteAffectation = uniteAffectationRepository.findById(uniteAffectationId)
                .orElseThrow(() -> new RuntimeException("Unite Affectation not found with id: " + uniteAffectationId));

        Poste poste = uniteAffectation.getPostes().stream()
                .filter(d -> d.getId().equals(posteId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Poste not found with id: " + posteId));


        poste.setPosteName(poste.getPosteName());
        poste.setPosteDescription(poste.getPosteDescription());
        poste.setPosteSalary(poste.getPosteSalary());



        posteRepository.save(poste);
        return UniteAffectationMapper.mapUniteAffectationToUniteAffectationDto(uniteAffectation);
    }


    @Override
    public List<Poste> getPostesByUniteAffectation(Long uniteAffectationId) {
        UniteAffectation uniteAffectation = uniteAffectationRepository.findById(uniteAffectationId)
                .orElseThrow(()
                        -> new RuntimeException("Unite Affectation not found with id: " + uniteAffectationId));
        return uniteAffectation.getPostes();
    }
}
