package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.EmailVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmailVerificationDao extends JpaRepository<EmailVerification, Integer> {

   Optional<EmailVerification> findByIsVerified(boolean isVerified);

}
