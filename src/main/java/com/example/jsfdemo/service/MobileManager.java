package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Mobile;

@ApplicationScoped
public class MobileManager {
	private List<Mobile> db = new ArrayList<Mobile>();

	public void addMobile(Mobile mobile) {
		Mobile newMobile = new Mobile();

		newMobile.setBrand(mobile.getBrand());
		newMobile.setModel(mobile.getModel());
		newMobile.setProcessor(mobile.getProcessor());
		newMobile.setRam(mobile.getRam());
		newMobile.setScreen(mobile.getScreen());
		newMobile.setType(mobile.isType());

		db.add(newMobile);
	}

	public List<Mobile> getDb() {
		return db;
	}
	
	public void deleteMobile(Mobile mobile) {
		for (Mobile e :db){
			if (e.getModel().equals(mobile.getModel())){
				db.remove(e);
				break;
			}
		}
	}
	
	public Mobile searchMobile(Mobile mobile){
		Mobile model = new Mobile();
		for (Mobile e : db){
			if (e.getModel().equals(mobile.getModel())){

				model.setBrand(mobile.getBrand());
				model.setModel(mobile.getModel());
				model.setProcessor(mobile.getProcessor());
				model.setRam(mobile.getRam());
				model.setScreen(mobile.getScreen());
				model.setType(mobile.isType());
				
			}
		}
		return model;
	}


}
