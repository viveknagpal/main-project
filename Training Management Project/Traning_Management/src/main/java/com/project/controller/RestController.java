package com.project.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.Status;
import com.project.model.Trainertester;
import com.project.service.DataServices;

@Controller
@RequestMapping("/trainer")
public class RestController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addEmployee(@RequestBody Trainertester trainer) {
		try {
			dataServices.addEntity(trainer);
			return new Status(1, "Success");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Trainertester getEmployee(@PathVariable("id") int id) {
		Trainertester trainer = null;
		try {
			trainer = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainer;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Trainertester> getEmployee() {

		List<Trainertester> trainerList = null;
		try {
			trainerList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return trainerList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteEmployee(@PathVariable("id") int id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Success");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
