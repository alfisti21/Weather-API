package com.example.demo2;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TemperaturesController {

	private final TemperaturesRepository repository;

	TemperaturesController(TemperaturesRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/temperatures")
	List<Temperatures> all() {
		return repository.findAll();
	}

	@PostMapping("/temperatures")
	Temperatures newTemperatures(@RequestBody Temperatures newTemperatures) {
		return repository.save(newTemperatures);
	}

	@GetMapping("/temperatures/{id}")
	Temperatures one(@PathVariable Long id) {

		return repository.findById(id)
			.orElseThrow(() -> new TemperaturesNotFoundException(id));
	}

	@PutMapping("/temperatures/{id}")
	Temperatures replaceTemperatures(@RequestBody Temperatures newTemperatures, @PathVariable Long id) {

		return repository.findById(id)
			.map(Temperatures -> {
				Temperatures.setMinTemp(newTemperatures.getMinTemp());
				Temperatures.setMaxTemp(newTemperatures.getMaxTemp());
				Temperatures.setAdvice(newTemperatures.getAdvice());
				return repository.save(Temperatures);
			})
			.orElseGet(() -> {
				newTemperatures.setId(id);
				return repository.save(newTemperatures);
			});
	}

	@DeleteMapping("/temperatures/delete/{id}")
	void deleteTemperatures(@PathVariable Long id) {
		repository.deleteById(id);
	}
}