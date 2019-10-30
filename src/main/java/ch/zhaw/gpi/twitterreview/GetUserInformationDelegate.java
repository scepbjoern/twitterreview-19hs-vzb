package ch.zhaw.gpi.twitterreview;

import java.util.Optional;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * GetUserInformationDelegate
 */
@Named("getUserInformationAdapter")
public class GetUserInformationDelegate implements JavaDelegate {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void execute(DelegateExecution bla) throws Exception {
        String userName = (String) bla.getVariable("anfrageStellenderBenutzer");

        String fullName;

        Optional<UserEntity> user = userRepository.findById(userName);

        if(user.isPresent()){
            fullName = user.get().getFirstName() + " " + user.get().getLastName();
        } else {
            fullName = "Mr. X";
        }

        bla.setVariable("vollerName", fullName);
    }

    
}