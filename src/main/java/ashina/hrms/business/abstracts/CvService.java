package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.Cv;

import java.util.List;

public interface CvService {

    List<Cv> getAll();

    Cv saveCv(Cv cv);



}
