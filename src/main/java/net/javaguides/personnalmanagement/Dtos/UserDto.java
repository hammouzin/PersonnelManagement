package net.javaguides.personnalmanagement.Dtos;

import java.time.LocalDate;
import java.util.List;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String gender ;
    private String birthDate ;
    private String birthPlace ;
    private String city ;
    private String country ;
    private LocalDate joinDate ;
    private double salary ;
    private List<DiplomeDto> diplomes;
    private List<GradeDto> grades;
    private List<CongeDto> conges;
    private List<QualificationDto> qualifications;
    private List<PosteDto> postes;
    private List<AffectationDto> affectations;


    public UserDto() {

    }

    public UserDto(Long id, String firstName, String lastName, String address, String email, String phone, String gender, String birthDate, String birthPlace, String city, String country, LocalDate joinDate, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.city = city;
        this.country = country;
        this.joinDate = joinDate;
        this.salary = salary;
    }

    public List<AffectationDto> getAffectations() {
        return affectations;
    }

    public void setAffectations(List<AffectationDto> affectations) {
        this.affectations = affectations;
    }

    public List<PosteDto> getPostes() {
        return postes;
    }

    public void setPostes(List<PosteDto> postes) {
        this.postes = postes;
    }

    public List<QualificationDto> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<QualificationDto> qualifications) {
        this.qualifications = qualifications;
    }

    public List<CongeDto> getConges() {
        return conges;
    }

    public void setConges(List<CongeDto> conges) {
        this.conges = conges;
    }

    public List<GradeDto> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeDto> grades) {
        this.grades = grades;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
