package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.LevelService;
import ashina.hrms.dataAccess.abstracts.LevelDao;
import ashina.hrms.entities.concretes.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelManager implements LevelService {

    private LevelDao levelDao;

    @Autowired
    public LevelManager(LevelDao levelDao) {
        this.levelDao = levelDao;
    }

    @Override
    public Level findById(int id) {
        return levelDao.findById(id);
    }

    @Override
    public Level save(Level level) {
        return levelDao.save(level);
    }
}
