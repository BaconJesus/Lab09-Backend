package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Organizer;
import org.springframework.data.domain.Pageable;

public interface OrganizerDao {
    Page<Organizer> getOrganizer(Pageable pageRequest);
}
