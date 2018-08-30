package sample.service;

import org.apache.tomcat.util.http.parser.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sample.model.User;
import sample.repository.UserReository;

@Service
public class UserAuntheticationService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserReository userReository;

    public void checkUserAuthorization(Authentication auth){

        String userName = auth.getName();
        if(userName == null)
            throw new UsernameNotFoundException("Please provide user name");

        User user = userReository.findUserByName(userName);
        if(user == null)
            throw new UsernameNotFoundException("Not a authorized User");



    }


}
