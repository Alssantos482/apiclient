package br.com.andre.apiclient.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CityDto {

    private Integer id;
    private String name;
    private StateDto state;
}
