package br.com.andre.apiclient.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ClientDto {

    private Integer id;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private AddressDto address;

}
