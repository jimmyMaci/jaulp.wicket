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
package org.jaulp.wicket.dropdownchoices.examples;

import java.io.IOException;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.jaulp.wicket.PackageResourceReferences;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see wicket.myproject.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
	@Override
	public Session newSession(Request request, Response response) {
		return new WicketSession(request);
	}

	/**
	 * Constructor
	 */
	public WicketApplication() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.apache.wicket.protocol.http.WebApplication#init()
	 */
	@Override
	protected void init() {
		super.init();
		try {
			initResources();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inits the all relevant resources like css and js files.
	 * 
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void initResources() throws ClassNotFoundException, IOException {
		PackageResourceReferences prr = PackageResourceReferences.getInstance();
		prr.initializeResources("org");
	}

	/**
	 * @see wicket.Application#getHomePage()
	 */
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

}
