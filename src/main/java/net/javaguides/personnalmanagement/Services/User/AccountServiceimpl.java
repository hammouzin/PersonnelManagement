package net.javaguides.personnalmanagement.Services.User;

import lombok.AllArgsConstructor;
import net.javaguides.personnalmanagement.Entities.*;
import net.javaguides.personnalmanagement.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceimpl implements AccountService{



    private UserRepository userRepository;


    @Override
    public User addNewUser(String email, String lastname, String password, Role role, String username) {
        System.out.println("Adding new user" + username);

        User user = userRepository.findByUsername(username);
        if (user != null) {
            System.out.println("User already exists" + username);
            throw new RuntimeException("User already exists");
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);
        newUser.setEmail(email);
        newUser.setLastName(lastname);


        System.out.println("New user created : " + newUser);

        switch (role) {
            case AGENT :
                Agent agent = new Agent();
                agent.setUser(newUser);
                newUser.setAgent(agent);
                System.out.println("Agent created");
                break;
            case EMPLOYE_AR :
                EmployeAR employeAR = new EmployeAR();
                employeAR.setUser(newUser);
                newUser.setEmployeAR(employeAR);
                System.out.println("EmployeAR created");
                break;
            case SCF :
                SCF scf = new SCF();
                scf.setUser(newUser);
                newUser.setScf(scf);
                System.out.println("SCF created");
                break;
            case DCP:
                Dcp dcp = new Dcp();
                dcp.setUser(newUser);
                newUser.setDcp(dcp);
                System.out.println("DCP created");
                break;
            case RESPONSABLE_UNITE:
                ResponsableUnite responsableUnite = new ResponsableUnite();
                responsableUnite.setUser(newUser);
                newUser.setResponsableUnite(responsableUnite);
                System.out.println("ResponsableUnite created");
                break;
            default:
                System.out.println("Invalid role" + role);
                throw new IllegalArgumentException("Invalid role");
        }

        User savedUser = userRepository.save(newUser);
        System.out.println("User saved");


        return savedUser;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
