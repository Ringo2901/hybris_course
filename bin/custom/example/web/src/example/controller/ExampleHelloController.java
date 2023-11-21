/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package example.controller;

import static example.constants.ExampleConstants.PLATFORM_LOGO_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.service.ExampleService;


@Controller
public class ExampleHelloController
{
	@Autowired
	private ExampleService exampleService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", exampleService.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		return "welcome";
	}
}
