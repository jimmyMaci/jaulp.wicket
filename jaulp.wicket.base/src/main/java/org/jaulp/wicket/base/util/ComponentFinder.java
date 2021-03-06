package org.jaulp.wicket.base.util;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.core.request.handler.IPageRequestHandler;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.cycle.RequestCycle;

/**
 * The Class ComponentFinder.
 */
public final class ComponentFinder {

	/**
	 * Gets the current page.
	 *
	 * @return the current page
	 */
	public static Page getCurrentPage() {
		IRequestHandler requestHandler = RequestCycle.get()
				.getActiveRequestHandler();
		if (requestHandler instanceof IPageRequestHandler) {
			IPageRequestHandler pageRequestHandler = (IPageRequestHandler) requestHandler;
			return (Page) pageRequestHandler.getPage();
		}
		return null;
	}


	/**
	 * Finds the AjaxRequestTarget from the current RequestCycle.
	 * 
	 * @return the found AjaxRequestTarget or {@code null}
	 */
	public static AjaxRequestTarget findAjaxRequestTarget() {
		return RequestCycle.get().find(AjaxRequestTarget.class);
	}


	/**
	 * Creates a new ajax request target from the given Page.
	 * 
	 * @param application the web application
	 * @param page
	 *            page on which ajax response is made
	 * @return an AjaxRequestTarget instance
	 * @see {@link WebApplication#newAjaxRequestTarget(Page)}
	 */
	public static AjaxRequestTarget newAjaxRequestTarget(WebApplication application, Page page) {
		return application.newAjaxRequestTarget(page);
	}
	
}