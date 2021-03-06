package de.alpharogroup.wicket.components.examples.imprint;

import de.alpharogroup.wicket.components.examples.application.WicketApplication;
import de.alpharogroup.wicket.components.imprint.ImprintPanel;

public class ApplicationImprintPanel extends ImprintPanel {

	private static final long serialVersionUID = 1L;

	public ApplicationImprintPanel(String id) {
		super(id);
	}

	@Override
	protected String getDomainName() {
		return WicketApplication.get().getDomainName();
	}

}
