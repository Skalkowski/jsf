package com.example.jsfdemo.domain;

public class Mobile {
	private String brand = "unkown";
	private String model = "unkown";
	private int ram;
	private int processor;
	private double screen;
	private boolean type;

	public Mobile() {
		super();
	}

	public Mobile(String brand, String model, int ram, int processor,
			double screen, boolean type) {
		super();
		this.brand = brand;
		this.model = model;
		this.ram = ram;
		this.processor = processor;
		this.screen = screen;
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getProcessor() {
		return processor;
	}

	public void setProcessor(int processor) {
		this.processor = processor;
	}

	public double getScreen() {
		return screen;
	}

	public void setScreen(double screen) {
		this.screen = screen;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}
}