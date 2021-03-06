package com.backend.security;

import com.backend.pojos.Companies;
import com.backend.repositories.RepositoryCompany;
import com.backend.services.ConfirmationTokenService;
import com.backend.pojos.EmailConfirmationToken;
import com.backend.pojos.Users;
import com.backend.repositories.RepositoryUser;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AccountDetailsServiceImpl implements UserDetailsService {

    private final RepositoryUser repositoryUser;
    private final RepositoryCompany repositoryCompany;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Users user = repositoryUser.findByUserEmail(email);
        Companies company = repositoryCompany.findByCompanyEmail(email);

        if (user != null) {

            return new com.backend.security.UserDetailsService(user);
        } else

        if (company != null) {

            return new CompanyDetailsService(company);
        } else {

            throw new UsernameNotFoundException("Email " + email + " not found");
        }
    }

    public String signUpUser(Users user) {

        Users userExists = repositoryUser.findByUserEmail(user.getUserEmail());
        Companies companyExists = repositoryCompany.findByCompanyEmail(user.getUserEmail());

        if (userExists != null || companyExists != null) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            return "Email already taken";
        }else {

            String encodedPassword = bCryptPasswordEncoder.encode(user.getUserPassword());

            user.setUserPassword(encodedPassword);

            repositoryUser.save(user);


            String token = UUID.randomUUID().toString();

            EmailConfirmationToken confirmationToken = new EmailConfirmationToken();

            confirmationToken.setToken(token);
            confirmationToken.setUser(user);
            confirmationToken.setCreatedDate(LocalDateTime.now());

            confirmationTokenService.saveConfirmationToken(confirmationToken);

//        TODO: SEND EMAIL

            return token;
        }

    }


    public String signUpCompany(Companies company) {

        Users userExists = repositoryUser.findByUserEmail(company.getCompanyEmail());
        Companies companyExists = repositoryCompany.findByCompanyEmail(company.getCompanyEmail());

        if (userExists != null || companyExists != null) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            return "Email already taken";
        }else {

            String encodedPassword = bCryptPasswordEncoder.encode(company.getCompanyPassword());

            company.setCompanyPassword(encodedPassword);

            repositoryCompany.save(company);


            String token = UUID.randomUUID().toString();

            EmailConfirmationToken confirmationToken = new EmailConfirmationToken();

            confirmationToken.setToken(token);
            confirmationToken.setCompany(company);
            confirmationToken.setCreatedDate(LocalDateTime.now());

            confirmationTokenService.saveConfirmationToken(confirmationToken);

//        TODO: SEND EMAIL

            return token;

        }
    }


    public void enableAppUser(String userEmail) {
        repositoryUser.enableAppUser(userEmail);
    }


    public void enableAppCompany(String companyEmail) {
        repositoryCompany.enableAppCompany(companyEmail);
    }
}
