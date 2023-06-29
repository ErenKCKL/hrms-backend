package ashina.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Email(message = "Please enter a valid e-mail address.")
    @NotNull(message = "The e-mail field cannot be empty.")
    @NotBlank(message = "The e-mail field cannot be empty.")
    @Column(name = "email", unique = true)
    private String email;

    @NotNull(message = "Password field cannot be blank.")
    @NotBlank(message = "Password field cannot be blank.")
    @Column(name = "password")
    private String password;
}
