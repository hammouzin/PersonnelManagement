package net.javaguides.personnalmanagement.Services;

import net.javaguides.personnalmanagement.Dtos.CandidatDto;
import net.javaguides.personnalmanagement.Entities.Agent;
import net.javaguides.personnalmanagement.Entities.Candidat;
import net.javaguides.personnalmanagement.Entities.Diplome;
import net.javaguides.personnalmanagement.Entities.Grade;
import net.javaguides.personnalmanagement.Mappers.AgentMapper;
import net.javaguides.personnalmanagement.Mappers.CandidatMapper;
import net.javaguides.personnalmanagement.Repositories.CandidatRepository;
import net.javaguides.personnalmanagement.Repositories.DiplomeRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatServiceImpl implements CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;
    @Autowired
    private DiplomeRepository diplomeRepository;

    public CandidatServiceImpl(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    @Override
    public CandidatDto createCandidat(CandidatDto candidatDto) {
        Candidat candidat = CandidatMapper.mapCandidatDtoToCandidat(candidatDto);
        Candidat savedCandidat = candidatRepository.save(candidat);
        return CandidatMapper.mapCandidatToCandidatDto(savedCandidat);
    }

    @Override
    public CandidatDto updateCandidat(long id, CandidatDto candidatDto) {
        if (!candidatRepository.existsById(id)) {
            throw new RuntimeException("Candidat not found with id: " + id);
        }
        Candidat candidat = CandidatMapper.mapCandidatDtoToCandidat(candidatDto);
        candidat.setId(id);
        Candidat savedCandidat = candidatRepository.save(candidat);
        return CandidatMapper.mapCandidatToCandidatDto(savedCandidat);
    }

    @Override
    public CandidatDto deleteCandidat(long id) {
        Candidat candidat = candidatRepository.findById(id).orElse(null);
        if (candidat != null) {
            candidatRepository.delete(candidat);
            return CandidatMapper.mapCandidatToCandidatDto(candidat);
        } else {
            throw new RuntimeException("Candidat not found with id: " + id);
        }
    }

    @Override
    public CandidatDto getCandidatById(long id) {
        Candidat candidat = candidatRepository.findById(id).orElseThrow(() -> new RuntimeException("Candidat non trouvé"));
        return CandidatMapper.mapCandidatToCandidatDto(candidat);
    }

    @Override
    public List<CandidatDto> getAllCandidat() {
        List<Candidat> candidatList = candidatRepository.findAll();
        return candidatList.stream()
                .map(CandidatMapper::mapCandidatToCandidatDto)
                .collect(Collectors.toList());
    }

    @Override
    public void importerCandidatsDepuisCSV(MultipartFile file) throws IOException {
        // Lire le fichier CSV
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;
        List<Candidat> candidats = new ArrayList<>();

        // Ignorer la première ligne (en-tête)
        reader.readLine();  // Lire et ignorer la première ligne

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");

            // Vérifiez si la ligne est valide (contient des informations de candidat)
            if (data.length < 10) {
                continue;  // Ignorer les lignes mal formées ou vides
            }

            // Informations sur le candidat
            String firstName = data[0];
            String lastName = data[1];
            String email = data[2];
            String phone = data[3];
            String gender = data[4];
            LocalDate birthDate = null;

            try {
                birthDate = LocalDate.parse(data[5]);  // Convertir la date de naissance en LocalDate
            } catch (Exception e) {
                // En cas d'erreur, ignorer cette ligne et continuer
                System.out.println("Erreur de format pour la date de naissance: " + data[5]);
                continue;
            }

            String birthPlace = data[6];
            String city = data[7];
            String country = data[8];
            String statutAdmission = data[9];

            // Créer un candidat sans ID
            Candidat candidat = new Candidat();
            candidat.setFirstName(firstName);
            candidat.setLastName(lastName);
            candidat.setEmail(email);
            candidat.setPhone(phone);
            candidat.setGender(gender);
            candidat.setBirthDate(birthDate);
            candidat.setBirthPlace(birthPlace);
            candidat.setCity(city);
            candidat.setCountry(country);
            candidat.setStatuAdmission(statutAdmission);

            // Ajouter le candidat à la liste
            candidats.add(candidat);

            // Sauvegarder le candidat d'abord pour obtenir son ID généré
            Candidat savedCandidat = candidatRepository.save(candidat);  // Sauvegarde dans la base

            // Diplômes (à partir de la colonne 10)
            for (int i = 10; i < data.length; i += 3) {
                String diplome = data[i];
                String etablissement = data[i + 1];
                int anneeObtention = Integer.parseInt(data[i + 2]);

                Diplome nouveauDiplome = new Diplome();
                nouveauDiplome.setNomDiplome(diplome);
                nouveauDiplome.setEtablissement(etablissement);
                LocalDate dateObtention = LocalDate.of(anneeObtention, 1, 1);
                nouveauDiplome.setDateObtention(dateObtention);

                // Associer le diplôme au candidat sauvé avec un ID
                nouveauDiplome.setCandidat(savedCandidat);

                // Ajouter le diplôme à la liste des diplômes du candidat
                savedCandidat.addDiplome(nouveauDiplome);
            }
        }

        // Sauvegarder les candidats et leurs diplômes dans la base de données
        candidatRepository.saveAll(candidats);  // Sauvegarde les candidats
        // Sauvegarder les diplômes associés
        diplomeRepository.saveAll(candidats.stream()
                .flatMap(candidat -> candidat.getDiplomes().stream())
                .collect(Collectors.toList()));  // Sauvegarde tous les diplômes
    }


    @Override
    public void AdDiplomeToCandidat(Long candidatId, Diplome diplome) {
        Candidat candidat = candidatRepository.findById(candidatId)
                .orElseThrow(() -> new RuntimeException("Candidat not found with id: " + candidatId));

        candidat.addDiplome(diplome);
        candidatRepository.save(candidat);
    }
}
