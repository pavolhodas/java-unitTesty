package com.example.demo.extra.car;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarSearchService {

	private final List<Car> cars = new ArrayList<>();

	public void addCar(Car car) {
		cars.add(car);
	}

	public List<Car> findSportCars() {
		List<Car> sportCars = new ArrayList<>();
		for (Car car : cars) {
			if (car.getEngine().getNbOfCylinders() > 6
					&& Color.RED == car.getColor()
					&& "Ferrari".equals(car.getManufacturer().getName())) {
				sportCars.add(car);
			}
		}
		return sportCars;
	}
}
