package br.com.andre.apiclient.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto {

    private Integer id;
    private String street;
    private String number;
    private String complement;
    private String district;
    private CityDto city;

}
