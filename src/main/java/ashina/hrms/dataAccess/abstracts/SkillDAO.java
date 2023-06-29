package ashina.hrms.dataAccess.abstracts;

import ashina.hrms.entities.concretes.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillDAO extends JpaRepository<Skill, Integer> {



    Skill findById(int id);

}
