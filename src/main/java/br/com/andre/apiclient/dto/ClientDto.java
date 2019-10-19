package br.com.andre.apiclient.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ClientDto {

    private Integer id;
    private String name;
    private String cpf;
    private Date birthDate;
    private AddressDto address;

}
