/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package example.service;

public interface ExampleService
{
	String getHybrisLogoUrl(String logoCode);

	void createLogo(String logoCode);
}
