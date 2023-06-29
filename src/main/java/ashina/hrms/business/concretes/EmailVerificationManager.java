package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.EmailVerificationService;
import ashina.hrms.dataAccess.abstracts.EmailVerificationDao;
import ashina.hrms.entities.concretes.EmailVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailVerificationManager implements EmailVerificationService {

    private EmailVerificationDao emailVerificationDao;

    @Autowired
    public EmailVerificationManager(EmailVerificationDao emailVerificationDao) {
        this.emailVerificationDao = emailVerificationDao;
    }

    @Override
    public Optional<EmailVerification> findByVerifiedIs(boolean isVerified) {
        return emailVerificationDao.findByIsVerified(isVerified);
    }
}
