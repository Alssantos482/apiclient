package br.com.andre.apiclient.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CPF
    @Column(unique = true, nullable = false)
    private String cpf;

    private String name;
    private Date birthDate;

    @JoinColumn(name = "idAddress", nullable = false)
    @ManyToOne
    private Address address;


}
