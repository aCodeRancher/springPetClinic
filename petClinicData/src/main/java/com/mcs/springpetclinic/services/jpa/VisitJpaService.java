package com.mcs.springpetclinic.services.jpa;

import com.mcs.springpetclinic.model.Visit;
import com.mcs.springpetclinic.repository.VisitRepository;
import com.mcs.springpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitJpaService extends AbstractJpaService<Visit, VisitRepository>
        implements VisitService {
    public VisitJpaService(VisitRepository repository) {
        super(repository);
    }
}
