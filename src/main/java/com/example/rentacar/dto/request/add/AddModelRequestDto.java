package com.example.rentacar.dto.request.add;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddModelRequestDto {

	private String name;

	private int brandId;

}
