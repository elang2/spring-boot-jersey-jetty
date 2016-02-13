package com.sample.elan.impl.config;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JettyConfig {

	@Bean
	public JettyEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory(
	        @Value("${server.port:8080}") final String port,
	        @Value("${jetty.threads.max:200}") final String maxThreads,
	        @Value("${jetty.threads.min:10}") final String minThreads,
	        @Value("${jetty.threadPool.idleTimeout:60000}") final String idleTimeout) {
		final JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory(Integer.valueOf(port));
		factory.addServerCustomizers(new JettyServerCustomizer() {
			@Override
			public void customize(final Server server) {
				final QueuedThreadPool threadPool = server.getBean(QueuedThreadPool.class);
				threadPool.setMaxThreads(Integer.valueOf(maxThreads));
				threadPool.setMinThreads(Integer.valueOf(minThreads));
				threadPool.setIdleTimeout(Integer.valueOf(idleTimeout));
			}
		});
		return factory;
	}

}
