package com.backend.repositories.options;

import com.backend.pojos.AutomotiveCrash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAutomotiveCrash extends JpaRepository<AutomotiveCrash , Long> {
}
