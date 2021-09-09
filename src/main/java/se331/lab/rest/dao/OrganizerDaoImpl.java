package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;
import org.springframework.data.domain.Pageable;


@Repository
public class OrganizerDaoImpl implements OrganizerDao{
    @Autowired
    OrganizerRepository organizerRepository;
    @Override
    public Page<Organizer> getOrganizer (Pageable pageRequest){
        return organizerRepository.findAll(pageRequest);
    }
}
