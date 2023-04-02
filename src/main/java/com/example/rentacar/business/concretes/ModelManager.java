package com.example.rentacar.business.concretes;

import com.example.rentacar.dto.request.add.AddModelRequestDto;
import com.example.rentacar.dto.request.update.UpdateModelRequestDto;
import com.example.rentacar.dto.response.ModelResponse;
import com.example.rentacar.entities.Model;
import com.example.rentacar.business.abstracts.ModelService;
import com.example.rentacar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;

	private ModelMapper modelMapper;

	@Override
	public List<ModelResponse> getAll() {

		return modelRepository.findAll().stream().map(item -> modelMapper.map(item, ModelResponse.class)).toList();
	}

	@Override
	public ModelResponse getById(int id) {

		Model model = modelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Model bulunamadı"));
		return modelMapper.map(model, ModelResponse.class);
	}

	@Override
	public ModelResponse add(AddModelRequestDto addModelRequestDto) {

		checkIfModelExistsByName(addModelRequestDto.getName());
		Model model = modelMapper.map(addModelRequestDto, Model.class);
		model.setId(0);
		modelRepository.save(model);
		return modelMapper.map(model, ModelResponse.class);
	}

	@Override
	public ModelResponse update(int id, UpdateModelRequestDto updateModelRequestDto) {

		checkIfModelExistsById(id);
		Model model = modelMapper.map(updateModelRequestDto, Model.class);
		model.setId(id);
		modelRepository.save(model);
		return modelMapper.map(model, ModelResponse.class);
	}

	@Override
	public void delete(int id) {

		checkIfModelExistsById(id);
		modelRepository.deleteById(id);
	}

	private void checkIfModelExistsByName(String name) {

		if (modelRepository.existsByNameIgnoreCase(name))
			throw new RuntimeException("Böyle bir isimde model mevcut");
	}

	private void checkIfModelExistsById(int id) {

		if (!modelRepository.existsById(id)) {
			throw new RuntimeException("Model id bulunamadı");
		}
	}

}
