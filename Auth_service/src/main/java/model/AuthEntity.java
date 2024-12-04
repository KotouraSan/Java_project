package model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CustomerAuth")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthEntity implements Serializable {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @Column(name = "email")
    @ColumnTransformer(write = "LOWER(?)")
    String authEmail;
    @Column(name = "password")
    String authPassword;
}
