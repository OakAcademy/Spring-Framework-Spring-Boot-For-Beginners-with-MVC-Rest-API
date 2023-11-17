package uk.oak.Personal.services;

import org.springframework.data.domain.Page;
import uk.oak.Personal.entities.Person;

import java.util.List;

public interface PersonService {
    public List<Person> getallPersons();
    public Person save(Person person);
    public Person getById(long id);
    public Person deleteById(long id);
    public Page<Person> findpagination(long pagesize,long pageno,String sortfield, String sortdirection);

}
