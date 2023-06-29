package ashina.hrms.business.concretes;

import ashina.hrms.business.abstracts.CvService;
import ashina.hrms.dataAccess.abstracts.CvDao;
import ashina.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;

    @Autowired
    public CvManager(CvDao cvDao) {
        this.cvDao = cvDao;
    }

    @Override
    public List<Cv> getAll() {
        return cvDao.findAll();
    }

    @Override
    public Cv saveCv(Cv cv) {
        return cvDao.save(cv);
    }
}
