package ashina.hrms.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_posting")
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;

    @NotNull(message = "Job position is required")
    @ManyToOne
    @JoinColumn(name = "job_position_id", nullable = false)
    private JobPositions jobPositions;

    @ManyToOne
    @JoinColumn(name = "working_type_id")
    private WorkingType workingType;

    @ManyToOne
    @JoinColumn(name = "working_time_id")
    private WorkingTime workingTime;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "posting_date")
    private LocalDate postingDate;

    @Column(name = "closing_date")
    private LocalDate closingDate;

    @Column(name = "is_active")
    private boolean isActive;

}
