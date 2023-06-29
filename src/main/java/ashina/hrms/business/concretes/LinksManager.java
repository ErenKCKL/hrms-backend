package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.LinksService;
import ashina.hrms.dataAccess.abstracts.LinksDao;
import ashina.hrms.entities.concretes.Links;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinksManager implements LinksService {

    private LinksDao linksDao;

    @Autowired
    public LinksManager(LinksDao linksDao) {
        this.linksDao = linksDao;
    }

    @Override
    public Links findById(int id) {
        return linksDao.findById(id);
    }

    @Override
    public Links save(Links links) {
        return linksDao.save(links);
    }
}
