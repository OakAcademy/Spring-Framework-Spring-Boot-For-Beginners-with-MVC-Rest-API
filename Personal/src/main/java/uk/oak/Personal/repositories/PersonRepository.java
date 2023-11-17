package uk.oak.Personal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.oak.Personal.entities.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
