package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.SkillService;
import ashina.hrms.dataAccess.abstracts.SkillDAO;
import ashina.hrms.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillManager implements SkillService {

    private SkillDAO skillDAO;

    @Autowired
    public SkillManager(SkillDAO skillDAO) {
        this.skillDAO = skillDAO;
    }

    @Override
    public Skill findById(int id) {
        return skillDAO.findById(id);
    }

    @Override
    public Skill save(Skill skill) {
        return skillDAO.save(skill);
    }
}
