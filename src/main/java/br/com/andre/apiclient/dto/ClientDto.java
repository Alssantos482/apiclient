package br.com.andre.apiclient.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ClientDto {

    private Integer id;
    private String name;
    private String cpf;
    private LocalDateTime birthDate;
    private AddressDto address;

}
