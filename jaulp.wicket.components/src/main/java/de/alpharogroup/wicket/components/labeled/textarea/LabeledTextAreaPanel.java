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
package de.alpharogroup.wicket.components.labeled.textarea;

import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import de.alpharogroup.wicket.components.labeled.LabeledFormComponentPanel;

/**
 * Convenience class for labeled TextArea.
 *
 * @param <T> the generic type
 */
public class LabeledTextAreaPanel<T> extends LabeledFormComponentPanel<T> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
		
	/** The text area. */
	private final TextArea<T> textArea;

	/**
	 * Instantiates a new labeled text area panel.
	 *
	 * @param id the id
	 */
	public LabeledTextAreaPanel(String id) {
		this(id, null, null);
	}

	/**
	 * Instantiates a new labeled text area panel.
	 *
	 * @param id the id
	 * @param model the model
	 * @param labelModel the label model
	 */
	public LabeledTextAreaPanel(String id, IModel<T> model, IModel<String> labelModel) {
		super(id, model, labelModel);
		PropertyModel<T> textAreaModel = new PropertyModel<T>(model.getObject(), id);
		add(textArea = newTextArea("textArea", textAreaModel));

		add(feedback = newComponentFeedbackPanel("feedback", textArea));

		String markupId = textArea.getMarkupId();
		add(label = newLabel("label", markupId, getLabel()));
	}

	/**
	 * {@inheritDoc}
	 */
	protected void convertInput() {
		setConvertedInput(textArea.getConvertedInput());
	}

	/**
	 * {@inheritDoc}
	 */
	public String getInput() {
		return textArea.getInput();
	}

	/**
	 * Gets the text area.
	 *
	 * @return the text area
	 */
	public TextArea<T> getTextArea() {
		return textArea;
	}

	/**
	 * Factory method for creating the TextArea. This method is invoked in the
	 * constructor from this class and can be overridden so users can
	 * provide their own version of a TextArea.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the text area
	 */
	protected TextArea<T> newTextArea(String id, PropertyModel<T> model) {
		TextArea<T> textArea = new TextArea<T>(id, model);
		textArea.setOutputMarkupId(true);
		return textArea;
	}

	/**
	 * {@inheritDoc}
	 */
	protected void onBeforeRender() {
		textArea.setRequired(isRequired());
		super.onBeforeRender();
	}
}