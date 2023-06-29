package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.Level;

public interface LevelService {

    Level findById(int id);

    Level save(Level level);

}
