package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.Skill;

public interface SkillService {
    Skill findById(int id);

    Skill save(Skill skill);

}
