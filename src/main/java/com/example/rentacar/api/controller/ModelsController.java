package com.example.rentacar.api.controller;

import com.example.rentacar.business.abstracts.ModelService;
import com.example.rentacar.dto.request.add.AddModelRequestDto;
import com.example.rentacar.dto.request.update.UpdateModelRequestDto;
import com.example.rentacar.dto.response.ModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelsController {

	private final ModelService modelService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ModelResponse> getAll() {

		return modelService.getAll();
	}

	@GetMapping("/{id}")
	public ModelResponse getById(@PathVariable int id) {

		return modelService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ModelResponse add(@RequestBody AddModelRequestDto addModelRequestDto) {

		return modelService.add(addModelRequestDto);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ModelResponse update(@PathVariable int id, @RequestBody UpdateModelRequestDto updateModelRequestDto) {

		return modelService.update(id, updateModelRequestDto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {

		modelService.delete(id);
	}
}
