package net.javaguides.personnalmanagement.Dtos;

import java.time.LocalDate;
import java.util.List;

public class CandidatDto {
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String gender;
    private LocalDate birthDate;
    private String birthPlace;
    private String city;
    private String country;
    private String statutAdmission ;


    private List<DiplomeDto> diplomes;
    private List<DecisionRecrutementDto> decisionRecrutements;


    public CandidatDto() {
    }

    public CandidatDto(Long id, String firstName, String lastName, String email, String phone, String gender, LocalDate birthDate, String birthPlace, String city, String country, String statutAdmission) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.city = city;
        this.country = country;
        this.statutAdmission = statutAdmission;


    }

    public String getStatutAdmission() {
        return statutAdmission;
    }

    public void setStatutAdmission(String statutAdmission) {
        this.statutAdmission = statutAdmission;
    }

    public List<DecisionRecrutementDto> getDecisionRecrutements() {
        return decisionRecrutements;
    }

    public void setDecisionRecrutements(List<DecisionRecrutementDto> decisionRecrutements) {
        this.decisionRecrutements = decisionRecrutements;
    }

    public List<DiplomeDto> getDiplomes() {
        return diplomes;
    }

    public void setDiplomes(List<DiplomeDto> diplomes) {
        this.diplomes = diplomes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}