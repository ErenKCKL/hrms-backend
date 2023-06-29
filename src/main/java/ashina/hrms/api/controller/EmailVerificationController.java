package ashina.hrms.api.controller;

import ashina.hrms.business.abstracts.EmailVerificationService;
import ashina.hrms.entities.concretes.EmailVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/email-verifications")
public class EmailVerificationController {

    private EmailVerificationService emailVerificationService;

    @Autowired
    public EmailVerificationController(EmailVerificationService emailVerificationService) {
        this.emailVerificationService = emailVerificationService;
    }

    @GetMapping("/verified/{isVerified}")
    public ResponseEntity<EmailVerification> findByVerifiedIs(@PathVariable boolean isVerified){
        return emailVerificationService.findByVerifiedIs(isVerified)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
