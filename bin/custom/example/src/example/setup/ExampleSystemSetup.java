/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package example.setup;

import static example.constants.ExampleConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import example.constants.ExampleConstants;
import example.service.ExampleService;


@SystemSetup(extension = ExampleConstants.EXTENSIONNAME)
public class ExampleSystemSetup
{
	private final ExampleService exampleService;

	public ExampleSystemSetup(final ExampleService exampleService)
	{
		this.exampleService = exampleService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		exampleService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return ExampleSystemSetup.class.getResourceAsStream("/example/sap-hybris-platform.png");
	}
}
