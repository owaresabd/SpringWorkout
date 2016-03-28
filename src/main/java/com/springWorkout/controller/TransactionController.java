package com.springWorkout.controller;

import java.security.SecureRandom;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springWorkout.domain.Person;
import com.springWorkout.service.ApiUtilService;
import com.springWorkout.service.PersonService;

/**
 * @author erhun.baycelik
 *
 */
@Controller
@RequestMapping(value = "/transaction")
public class TransactionController {
	@Autowired
	private PersonService personService;
	@Autowired
	private ApiUtilService apiUtilService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("person");
		List<Person> persons = personService.getAllPerson();
		model.addObject("persons", persons);
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView doPost(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("redirect:/transaction");
		SecureRandom r = new SecureRandom();
		String personId = String.valueOf(r.nextInt());
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String tckNo = request.getParameter("tckNo");
		Person p = new Person.Builder().id(personId).name(name).surname(surname).tckNo(tckNo).build();
		String requestString = apiUtilService.getRequestString(request);
		personService.savePerson(p, requestString);
		return model;
	}

	@RequestMapping(value = "/delete/{personId}", method = RequestMethod.GET)
	public ModelAndView deletePerson(HttpServletRequest request, @PathVariable String personId) {
		ModelAndView model = new ModelAndView("redirect:/transaction");
		personService.deletePerson(personId);
		return model;
	}
}
