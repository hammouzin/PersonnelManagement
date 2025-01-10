package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Dtos.DiplomeDto;
import net.javaguides.personnalmanagement.Entities.Diplome;
import net.javaguides.personnalmanagement.Mappers.DiplomeMapper;
import net.javaguides.personnalmanagement.Repositories.DiplomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiplomeServiceImpl implements DiplomeService {

    private final DiplomeRepository diplomeRepository;

    public DiplomeServiceImpl(DiplomeRepository diplomeRepository) {
        this.diplomeRepository = diplomeRepository;
    }

    @Override
    public DiplomeDto createDiplome(DiplomeDto diplomeDto) {
        // Convertir le DiplomeDto en entité Diplome
        Diplome diplome = DiplomeMapper.mapDiplomeDtoToDiplome(diplomeDto);
        // Sauvegarder l'entité Diplome dans la base de données
        Diplome savedDiplome = diplomeRepository.save(diplome);
        // Retourner le DiplomeDto après l'avoir sauvegardé
        return DiplomeMapper.mapDiplomeToDiplomeDto(savedDiplome);
    }

    @Override
    public DiplomeDto updateDiplome(long id, DiplomeDto diplomeDto) {
        // Vérifier si le diplôme existe avant de le mettre à jour
        if (!diplomeRepository.existsById(id)) {
            throw new RuntimeException("Diplôme not found with id: " + id);
        }
        // Convertir le DiplomeDto en entité Diplome
        Diplome diplome = DiplomeMapper.mapDiplomeDtoToDiplome(diplomeDto);
        // Assigner l'ID du diplôme pour l'update
        diplome.setId(id);
        // Sauvegarder l'entité Diplome mise à jour dans la base de données
        Diplome savedDiplome = diplomeRepository.save(diplome);
        // Retourner le DiplomeDto après la mise à jour
        return DiplomeMapper.mapDiplomeToDiplomeDto(savedDiplome);
    }

    @Override
    public DiplomeDto deleteDiplome(long id) {
        // Chercher le diplôme par son ID
        Diplome diplome = diplomeRepository.findById(id).orElse(null);
        if (diplome == null) {
            throw new RuntimeException("Diplôme not found with id: " + id);
        }
        // Supprimer le diplôme de la base de données
        diplomeRepository.delete(diplome);
        // Retourner le DiplomeDto après suppression
        return DiplomeMapper.mapDiplomeToDiplomeDto(diplome);
    }

    @Override
    public DiplomeDto getDiplomeById(long id) {
        // Chercher le diplôme par son ID
        Diplome diplome = diplomeRepository.findById(id).orElseThrow(() -> new RuntimeException("Diplôme not found with id: " + id));
        // Retourner le DiplomeDto du diplôme trouvé
        return DiplomeMapper.mapDiplomeToDiplomeDto(diplome);
    }

    @Override
    public List<DiplomeDto> getAllDiplomes() {
        // Récupérer tous les diplômes et les transformer en DiplomeDto
        List<Diplome> diplomeList = diplomeRepository.findAll();
        return diplomeList.stream()
                .map(DiplomeMapper::mapDiplomeToDiplomeDto)
                .collect(Collectors.toList());
    }
}
