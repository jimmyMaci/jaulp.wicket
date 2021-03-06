package de.alpharogroup.wicket.components.i18n.list;

import java.util.List;

import net.sourceforge.jaulp.locale.ResourceBundleKey;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.jaulp.wicket.base.util.resource.ResourceModelFactory;

import de.alpharogroup.wicket.components.listview.ListViewPanel;

/**
 * The Class UnorderedListPanel takes a {@link ListView} of {@link ResourceBundleKey}s
 * content resource keys that should be in a resource bundle for i18n.
 */
public abstract class UnorderedListPanel  extends ListViewPanel<ResourceBundleKey> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new unordered list panel.
	 *
	 * @param id the id
	 * @param list the list
	 */
	public UnorderedListPanel(String id, List<? extends ResourceBundleKey> list) {
		super(id, list);
	}

	/**
	 * Instantiates a new header content list panel.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 */
	public UnorderedListPanel(String id, IModel<List<? extends ResourceBundleKey>> model) {
		super(id, model);
	}

	/**
	 * New list component.
	 *
	 * @param id
	 *            the id
	 * @param item
	 *            the item
	 * @return the component
	 */
	protected Component newListComponent(String id,
			ListItem<ResourceBundleKey> item){
		return new Label(id, ResourceModelFactory.newResourceModel(item.getModel().getObject(), this));
	}

}