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
package org.jaulp.wicket.behaviors;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

/**
 * The Class RequiredBehavior adds a span tag at the end of a component that markes it as required.
 */
public class RequiredBehavior extends Behavior {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new RequiredBehavior.
     */
    public RequiredBehavior() {
    }

    /**
     * {@inheritDoc} 
     *  for more information @see org.apache.wicket.behavior.AbstractBehavior#afterRender(org.apache.wicket.Component)
     */
    @Override
    public void afterRender(final Component component) {
        super.afterRender(component);
        component.getResponse().write("<span class=\"required\">*</span>");
    }

}
