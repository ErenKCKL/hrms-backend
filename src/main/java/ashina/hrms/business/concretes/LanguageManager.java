package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.LanguageService;
import ashina.hrms.dataAccess.abstracts.LanguageDao;
import ashina.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public Language findById(int id) {
        return languageDao.findById(id);
    }

    @Override
    public Language save(Language language) {
        return languageDao.save(language);
    }
}
