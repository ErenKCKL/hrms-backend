package ashina.hrms.business.abstracts;

import ashina.hrms.entities.concretes.Links;

public interface LinksService {

    Links findById(int id);

    Links save(Links links);

}
