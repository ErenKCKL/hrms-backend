package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.Language;

public interface LanguageService {

    Language findById(int id);
    Language save(Language language);

}
