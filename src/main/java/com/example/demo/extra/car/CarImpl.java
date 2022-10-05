package com.example.demo.extra.car;

import java.awt.*;

public class CarImpl implements Car{

	private Engine engine;
	private Color color;
	private Manufacturer manufacturer;

	public CarImpl(Engine engine, Color color, Manufacturer manufacturer) {
		this.color = color;
		this.engine = engine;
		this.manufacturer = manufacturer;
	}

	public Engine getEngine() {
		return engine;
	}

	public Color getColor() {
		return color;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}
}
