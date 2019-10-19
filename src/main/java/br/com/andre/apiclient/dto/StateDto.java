package br.com.andre.apiclient.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StateDto {

    private Integer id;
    private String name;
    private String initials;

}
