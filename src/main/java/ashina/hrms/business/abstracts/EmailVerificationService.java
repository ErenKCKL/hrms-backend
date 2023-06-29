package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.EmailVerification;

import java.util.Optional;

public interface EmailVerificationService {

    Optional<EmailVerification> findByVerifiedIs(boolean isVerified);


}
