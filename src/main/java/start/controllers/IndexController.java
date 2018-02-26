package start.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import start.classes.Language;
import start.modules.Procedures;
import start.modules.Utils;

@Controller
public class IndexController {


	@RequestMapping("/index")
	public String weather(Model model,

		@RequestParam(value = "city", required = false, defaultValue = "bologna") String city,
		@RequestParam(value = "id", required = false, defaultValue = "3181928") int id) throws Exception
	{
		// LANGUAGE
		String language = new Language().getLanguage(Utils.getPosition().getCountry_code());
		Locale locale = new Locale(language, Utils.getPosition().getCountry_code());

		// WEATHER
		Procedures.indexCreateWeather(model, language, id);

		// DATE
		Procedures.indexCreateDate(model, locale);

		// POSITION
		model.addAttribute("position", Utils.getPosition());

		// ID
    	model.addAttribute("id", id);

		return "index";
	}

}
