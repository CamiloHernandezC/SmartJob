package com.camilo.usermicroservice.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.camilo.usermicroservice.DTO.PhoneDTO;
import com.camilo.usermicroservice.entities.Phone;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PhoneConverter {

	public PhoneDTO toDTO(final Phone Phone) {
		final ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(Phone, PhoneDTO.class);
	}
	
	public List<PhoneDTO> toDTO(final List<Phone> Phones) {
		List<PhoneDTO> resultDTO = new ArrayList<>();
		final ModelMapper modelMapper = new ModelMapper();
		for (Phone Phone : Phones) {
			resultDTO.add(modelMapper.map(Phone, PhoneDTO.class));
		}
		return resultDTO;
	}
	
	public Phone toEntity(final PhoneDTO dto) {
		final ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, Phone.class);
	}

	public List<Phone> toEntity(final List<PhoneDTO> phonesDTO) {
		final ModelMapper modelMapper = new ModelMapper();
		final List<Phone> phones = phonesDTO.stream()
				.map(phoneDTO -> modelMapper.map(phoneDTO, Phone.class))
				.collect(Collectors.toList());
		return phones;
	}
}
