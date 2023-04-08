package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.CarService;
import com.example.rentacar.business.abstracts.MaintenanceService;
import com.example.rentacar.dto.request.add.AddMaintanenceRequestDto;
import com.example.rentacar.dto.request.update.UpdateMaintenanceRequestDto;
import com.example.rentacar.dto.response.MaintenanceResponse;
import com.example.rentacar.entities.Maintenance;
import com.example.rentacar.entities.enums.State;
import com.example.rentacar.repository.MaintanenceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {

	private final MaintanenceRepository maintanenceRepository;

	private final CarService carService;

	private final ModelMapper modelMapper;

	@Override
	public List<MaintenanceResponse> getAll() {

		List<Maintenance> maintenances = maintanenceRepository.findAll();

		return maintenances.stream().map(maintenance -> modelMapper.map(maintenance, MaintenanceResponse.class)).toList();
	}

	@Override
	public MaintenanceResponse getById(int id) {

		checkIfMaintenanceExists(id);
		Maintenance maintenance = maintanenceRepository.findById(id).orElseThrow();

		return modelMapper.map(maintenance, MaintenanceResponse.class);
	}

	@Override
	public MaintenanceResponse returnCarFromMaintenance(int carId) {

		checkIfCarIsNotUnderMaintenance(carId);
		Maintenance maintenance = maintanenceRepository.findByCarIdAndIsCompletedIsFalse(carId);
		maintenance.setCompleted(true);
		maintenance.setEndDate(LocalDateTime.now());
		maintanenceRepository.save(maintenance); // Update
		carService.changeState(carId, State.AVAILABLE);

		return modelMapper.map(maintenance, MaintenanceResponse.class);
	}

	@Override
	public MaintenanceResponse add(AddMaintanenceRequestDto request) {

		checkIfCarUnderMaintenance(request);
		checkCarAvailabilityForMaintenance(request);
		Maintenance maintenance = modelMapper.map(request, Maintenance.class);
		maintenance.setId(0);
		maintenance.setCompleted(false);
		maintenance.setStartDate(LocalDateTime.now());
		maintenance.setEndDate(null);
		maintanenceRepository.save(maintenance);
		carService.changeState(request.getCarId(), State.MAINTENANCE);

		return modelMapper.map(maintenance, MaintenanceResponse.class);
	}

	@Override
	public MaintenanceResponse update(int id, UpdateMaintenanceRequestDto request) {

		checkIfMaintenanceExists(id);
		Maintenance maintenance = modelMapper.map(request, Maintenance.class);
		maintenance.setId(id);
		maintanenceRepository.save(maintenance);

		return modelMapper.map(maintenance, MaintenanceResponse.class);
	}

	@Override
	public void delete(int id) {

		checkIfMaintenanceExists(id);
		Optional<Maintenance> maintenance = maintanenceRepository.findById(id);
		carService.changeState(maintenance.get().getCar().getId(), State.AVAILABLE);
		maintanenceRepository.deleteById(id);
	}

	private void checkIfMaintenanceExists(int id) {

		if (!maintanenceRepository.existsById(id)) {
			throw new RuntimeException("Böyle bir bakım bilgisine ulaşılamadı!");
		}
	}

	private void checkIfCarIsNotUnderMaintenance(int carId) {

		if (!maintanenceRepository.existsByCarIdAndIsCompletedIsFalse(carId)) {
			throw new RuntimeException("Bakımda böyle bir araç bulunamadı!");
		}
	}

	private void checkIfCarUnderMaintenance(AddMaintanenceRequestDto request) {

		if (maintanenceRepository.existsByCarIdAndIsCompletedIsFalse(request.getCarId())) {
			throw new RuntimeException("Araç şuanda bakımda!");
		}
	}

	private void checkCarAvailabilityForMaintenance(AddMaintanenceRequestDto request) {

		if (carService.findById(request.getCarId()).getState().equals(State.RENTED)) {
			throw new RuntimeException("Araç kirada olduğu için bakıma alınamaz!");
		}
	}

}
