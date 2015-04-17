/**
 * Copyright (C) 2010 Asterios Raptis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dropdownchoices.examples;

import java.io.File;

import net.sourceforge.jaulp.file.search.PathFinder;

import org.apache.wicket.protocol.http.ContextParamWebApplicationFactory;
import org.apache.wicket.protocol.http.WicketFilter;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import de.alpharogroup.jetty9.runner.Jetty9Runner;
import de.alpharogroup.jetty9.runner.config.FilterHolderConfiguration;
import de.alpharogroup.jetty9.runner.config.Jetty9RunConfiguration;
import de.alpharogroup.jetty9.runner.config.ServletContextHandlerConfiguration;
import de.alpharogroup.jetty9.runner.config.ServletHolderConfiguration;

import org.jaulp.wicket.dropdownchoices.examples.WicketApplication;

public class StartDropDownChoicesApplication
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("wicket.configuration", "development");
		String projectname = "jaulp.wicket.dropdownchoices.examples";
		File projectDirectory = PathFinder.getProjectDirectory();
		File webapp = PathFinder.getRelativePath(projectDirectory, projectname, "src", "main",
			"webapp");
		String filterPath = "/*";

		ServletContextHandler servletContextHandler = Jetty9Runner
			.getNewServletContextHandler(ServletContextHandlerConfiguration
				.builder()
				.filterHolderConfiguration(
					FilterHolderConfiguration
						.builder()
						.filterClass(WicketFilter.class)
						.filterPath(filterPath)
						.initParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*")
						.initParameter(ContextParamWebApplicationFactory.APP_CLASS_PARAM,
							WicketApplication.class.getName()).build())
				.servletHolderConfiguration(
					ServletHolderConfiguration.builder().servletClass(DefaultServlet.class)
						.pathSpec(filterPath).build()).contextPath("/").webapp(webapp)
				.maxInactiveInterval(300).filterPath("/*").build());

		Jetty9Runner.run(Jetty9RunConfiguration.builder()
			.servletContextHandler(servletContextHandler)
			.httpPort(WicketApplication.DEFAULT_HTTP_PORT)
			.httpsPort(WicketApplication.DEFAULT_HTTPS_PORT).keyStorePassword("wicket")
			.keyStorePathResource("/keystore").build());
	}
}
