package br.com.andre.apiclient.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;
    private String number;
    private String complement;
    private String district;

    @JoinColumn(name = "idCity", nullable = false)
    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    List<Client> clientList;
}
