package uk.oak.Personal.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uk.oak.Personal.entities.Person;
import uk.oak.Personal.repositories.PersonRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
private final PersonRepository personRepository;
    @Override
    public List<Person> getallPersons() {
        List<Person> persons=personRepository.findAll();
        return persons;
    }

    @Override
    public Person save(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public Person getById(long id) {
        Person person=personRepository.findById(id).orElse(new Person());
        return person;
    }

    @Override
    public Person deleteById(long id) {

        personRepository.deleteById(id);
        return new Person();
    }

    @Override
    public Page<Person> findpagination(long pagesize, long pageno, String sortfield, String sortdirection) {
       Sort sort=sortdirection.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortfield).ascending():
               Sort.by(sortfield).descending();

       Pageable pageable=PageRequest.of((int) (pageno-1), (int) pagesize,sort);
       return personRepository.findAll(pageable);
    }
}
