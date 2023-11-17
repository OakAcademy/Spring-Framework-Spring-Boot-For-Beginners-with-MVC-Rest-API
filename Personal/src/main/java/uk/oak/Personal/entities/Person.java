package uk.oak.Personal.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private String email;
    @NonNull
    private long age;
    @NonNull
    private String job;
    @CreationTimestamp
    private Timestamp created;
}
