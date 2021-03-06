package de.alpharogroup.wicket.components.imprint;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;

import de.alpharogroup.wicket.components.mailto.MailToPanel;
import de.alpharogroup.wicket.components.termofuse.disclaimer.DisclaimerPanel;

/**
 * The Class ImprintPanel.
 * 
 * @author Asterios Raptis
 */
public abstract class ImprintPanel extends Panel {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private final WebMarkupContainer disclaimerContainer;
	public WebMarkupContainer getDisclaimerContainer() {
		return disclaimerContainer;
	}

	/**
	 * Instantiates a new imprint panel.
	 * 
	 * @param id
	 *            the id
	 */
	public ImprintPanel(final String id) {
		super(id);
		
		WebMarkupContainer imprintContainer = newImprintContainer("imprintContainer");
		add(imprintContainer);

		final Object[] domainNameParams = { getDomainName() };
		imprintContainer.add(new Label("imprintHeaderLbl", newImprintHeaderModel()));

		imprintContainer.add(new Label("urlWithSloganLbl", newSloganModel(domainNameParams)));

		imprintContainer.add(new Label("serviceFromLbl", newServiceFromModel()));

		imprintContainer.add(new Label("companyNameLbl", newCompanyNameModel()));

		imprintContainer.add(new Label("streetAndNumberLbl", newStreetAndNumberModel()));

		imprintContainer.add(new Label("zipAndCityLbl", newZipAndCityModel()));

		imprintContainer.add(new Label("state", newStateModel()));

		imprintContainer.add(new Label("authRepresentLabel", newAuthRepresentLabelModel()));

		imprintContainer.add(new Label("authRepresentContent", newAuthRepresentContentModel()));

		imprintContainer.add(new Label("companyRegisterEntryHeader",
				newCompanyRegisterEntryHeaderModel()));

		imprintContainer.add(new Label("companyRegisterEntryContent",
				newCompanyRegisterEntryContentModel()));

		imprintContainer.add(new Label("companyRegisterEntryNumber",
				newCompanyRegisterEntryNumberModel()));

		imprintContainer.add(new Label("companyRegisterIndedificationHeader",
				newCompanyRegisterIndedificationHeaderModel()));

		imprintContainer.add(new Label("companyRegisterIndedificationContent",
				newCompanyRegisterIndedificationContentModel()));

		imprintContainer.add(new Label("companyRegisterIndedificationNumber",
				newCompanyRegisterEntryNumberModel()));		

		disclaimerContainer = newDisclaimerContainer("disclaimerContainer");
		add(disclaimerContainer);
		disclaimerContainer.add(new DisclaimerPanel("disclaimerPanel"));

		disclaimerContainer.add(
				new MailToPanel("mailToPanel") {
			private static final long serialVersionUID = 1L;

			@Override
			protected String getDomainName() {
				return ImprintPanel.this.getDomainName();
			}
		});
	}


	/**
	 * Factory method to create a WebMarkupContainer for the disclaimer content.
	 * This method is invoked in the constructor from this class and can be
	 * overridden so users can provide their own version of a disclaimer
	 * content.
	 * 
	 * @return the WebMarkupContainer
	 */
	protected WebMarkupContainer newDisclaimerContainer(final String id) {
		return newWebMarkupContainer(id);
	}


	/**
	 * Factory method to create a WebMarkupContainer for the imprint content.
	 * This method is invoked in the constructor from this class and can be
	 * overridden so users can provide their own version of a imprint
	 * content.
	 * 
	 * @return the WebMarkupContainer
	 */
	protected WebMarkupContainer newImprintContainer(final String id) {
		return newWebMarkupContainer(id);
	}

	private WebMarkupContainer newWebMarkupContainer(final String id) {
		return new WebMarkupContainer(id);
	}

	/**
	 * Hook method for implement the specific domain name.
	 * 
	 * @return the domain name
	 */
	protected abstract String getDomainName();

	/**
	 * Creates a new StringResourceModel from the given key.
	 * 
	 * @param key
	 *            the key
	 * @return the i model
	 */
	protected IModel<String> newIModel(String key) {
		return new StringResourceModel(key, this, null);
	}

	/**
	 * Factory method to create a IModel<String> for the 'service from'. This
	 * method is invoked in the constructor from this class and can be
	 * overridden so users can provide their own version of a 'service from'.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newServiceFromModel() {
		return newIModel("imprint.service.from.label");
	}

	/**
	 * Factory method to create a IModel<String> for the 'slogan'. This method
	 * is invoked in the constructor from this class and can be overridden so
	 * users can provide their own version of a 'slogan'.
	 * 
	 * @param domainNameParams
	 *            the domain name params
	 * @return the i model
	 */
	protected IModel<String> newSloganModel(final Object[] domainNameParams) {
		return new StringResourceModel(
				"main.global.company.url.and.slogan.label", this, null,
				domainNameParams);
	}

	/**
	 * Factory method to create a IModel<String> for the 'imprint header'. This
	 * method is invoked in the constructor from this class and can be
	 * overridden so users can provide their own version of a 'imprint header'.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newImprintHeaderModel() {
		return newIModel("main.global.company.masthead.label");
	}

	/**
	 * Factory method to create a IModel<String> for the 'company name'. This
	 * method is invoked in the constructor from this class and can be
	 * overridden so users can provide their own version of a 'company name'.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newCompanyNameModel() {
		return newIModel("main.global.company.name.label");
	}

	/**
	 * Factory method to create a IModel<String> for the 'street and number'.
	 * This method is invoked in the constructor from this class and can be
	 * overridden so users can provide their own version of a 'street and
	 * number'.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newStreetAndNumberModel() {
		return newIModel("main.global.company.street.and.number.label");
	}

	/**
	 * Factory method to create a IModel<String> for the 'zip and city'. This
	 * method is invoked in the constructor from this class and can be
	 * overridden so users can provide their own version of a 'zip and city'.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newZipAndCityModel() {
		return newIModel("main.global.company.zipcode.and.city.label");
	}

	/**
	 * Factory method to create a IModel<String> for the 'state'. This method is
	 * invoked in the constructor from this class and can be overridden so users
	 * can provide their own version of a 'state'.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newStateModel() {
		return newIModel("main.global.company.state.label");
	}

	/**
	 * Factory method to create a IModel<String> for the 'authorised
	 * representative label'. This method is invoked in the constructor from
	 * this class and can be overridden so users can provide their own version
	 * of a 'authorised representative label'.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newAuthRepresentLabelModel() {
		return newIModel("main.global.company.authorised.representative.label");
	}

	/**
	 * Factory method to create a IModel<String> for the 'authorised
	 * representative content'. This method is invoked in the constructor from
	 * this class and can be overridden so users can provide their own version
	 * of a 'authorised representative content'.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newAuthRepresentContentModel() {
		return newIModel("main.global.company.authorised.representative");
	}

	/**
	 * Factory method to create a IModel<String> for the 'company register entry
	 * header'. This method is invoked in the constructor from this class and
	 * can be overridden so users can provide their own version of a 'company
	 * register entry header'.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newCompanyRegisterEntryHeaderModel() {
		return newIModel("main.global.company.register.entry.header.label");
	}

	/**
	 * Factory method to create a IModel<String> for the 'company register entry
	 * content'. This method is invoked in the constructor from this class and
	 * can be overridden so users can provide their own version of a 'company
	 * register entry content'.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newCompanyRegisterEntryContentModel() {
		return newIModel("main.global.company.register.entry.label");
	}

	/**
	 * Factory method to create a IModel<String> for the 'company register entry
	 * number'. This method is invoked in the constructor from this class and
	 * can be overridden so users can provide their own version of a 'company
	 * register entry number'.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newCompanyRegisterEntryNumberModel() {
		return newIModel("main.global.company.register.entry.court.number");
	}

	/**
	 * Factory method to create a IModel<String> for the 'company register
	 * indedification header'. This method is invoked in the constructor from
	 * this class and can be overridden so users can provide their own version
	 * of a 'company register indedification header'.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newCompanyRegisterIndedificationHeaderModel() {
		return newIModel("main.global.company.register.identification.header.label");
	}

	/**
	 * Factory method to create a IModel<String> for the 'company register
	 * indedification content'. This method is invoked in the constructor from
	 * this class and can be overridden so users can provide their own version
	 * of a 'company register indedification content'.
	 * 
	 * @return the i model
	 */
	protected IModel<String> newCompanyRegisterIndedificationContentModel() {
		return newIModel("main.global.company.register.identification.label");
	}
}
