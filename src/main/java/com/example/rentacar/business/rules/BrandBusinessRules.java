package com.example.rentacar.business.rules;

import com.example.rentacar.common.constants.Messages;
import com.example.rentacar.core.exceptions.BusinessException;
import com.example.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

	private final BrandRepository repository;

	public void checkIfBrandExistsById(int id) {

		if (!repository.existsById(id))
			throw new BusinessException(Messages.Brand.NotExists);
	}

	public void checkIfBrandExistsByName(String name) {

		if (repository.existsByNameIgnoreCase(name)) {
			throw new BusinessException(Messages.Brand.Exists);
		}
	}
}
