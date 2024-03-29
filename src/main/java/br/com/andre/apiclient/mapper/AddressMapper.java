package br.com.andre.apiclient.mapper;


import br.com.andre.apiclient.dto.AddressDto;
import br.com.andre.apiclient.model.Address;
import org.springframework.data.domain.Page;


public class AddressMapper {

    public Address convertToEntity(AddressDto addressDto) {
        Address address = new Address();

        address.setId(addressDto.getId());
        address.setStreet(addressDto.getStreet());
        address.setNumber(addressDto.getNumber());
        address.setComplement(addressDto.getComplement());
        address.setDistrict(addressDto.getDistrict());

        if (addressDto.getCity() != null) {
            address.setCity(
                    new CityMapper().convertToEntity(addressDto.getCity())
            );
        }

        return address;
    }

    public AddressDto convertToDto(Address address) {
        AddressDto addressDto = new AddressDto();

        addressDto.setId(address.getId());
        addressDto.setStreet(address.getStreet());
        addressDto.setNumber(address.getNumber());
        addressDto.setComplement(address.getComplement());
        addressDto.setDistrict(address.getDistrict());

        if (address.getCity() != null) {
            addressDto.setCity(
                    new CityMapper().convertToDto(address.getCity())
            );
        }

        return addressDto;
    }

    public Page<AddressDto> convertPageToDto(Page<Address> addresses){
        return addresses.map(this::convertToDto);
    }
}
