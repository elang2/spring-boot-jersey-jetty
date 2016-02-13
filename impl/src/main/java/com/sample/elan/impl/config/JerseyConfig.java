package com.sample.elan.impl.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.internal.scanning.PackageNamesScanner;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		PackageNamesScanner resourceFinder = new PackageNamesScanner(new String[] { "com.sample.elan.impl.rest" }, true);
		registerFinder(resourceFinder);
		register(JacksonFeature.class);
	}
}
