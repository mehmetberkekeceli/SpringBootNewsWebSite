package com.course.consumingrest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.course.consumingrest.model.Tag;
import com.course.consumingrest.service.HaberService;
@Controller
public class HaberContoller {
	@Autowired
	private HaberService haberService;
	@GetMapping(path = {"", "/"})
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("haberler", haberService.getAll());
		mav.setViewName("index");
		return mav;
	}
	@GetMapping(path = {"/{tag}"})
	public ModelAndView getByTag( @PathVariable("tag") String tag) {
		ModelAndView mav = new ModelAndView();
		switch (tag) {
		case "sport":
			mav.addObject("haberler", haberService.getByTag(Tag.SPORT));
			break;
		case "economy":
			mav.addObject("haberler", haberService.getByTag(Tag.ECONOMY));
			break;
		case "technology":
			mav.addObject("haberler", haberService.getByTag(Tag.TECHNOLOGY));
			break;
		default:
			mav.addObject("haberler", haberService.getByTag(Tag.GENERAL));
			break;
		}
		mav.setViewName("index");	
		return mav;
	}
}
