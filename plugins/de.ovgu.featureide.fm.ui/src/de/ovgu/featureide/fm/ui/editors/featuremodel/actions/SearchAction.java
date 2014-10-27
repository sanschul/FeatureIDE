/* FeatureIDE - A Framework for Feature-Oriented Software Development
 * Copyright (C) 2005-2013  FeatureIDE team, University of Magdeburg, Germany
 *
 * This file is part of FeatureIDE.
 * 
 * FeatureIDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * FeatureIDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with FeatureIDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See http://www.fosd.de/featureide/ for further information.
 */
package de.ovgu.featureide.fm.ui.editors.featuremodel.actions;

import org.eclipse.jface.action.Action;

import de.ovgu.featureide.fm.core.FeatureModel;

/**
 * action that handles the stopping of a movement routine in the FeatureDiagramEditor
 * 
 * @author Guenter Ulreich
 */
public class SearchAction extends Action {
	public static final String ID = "de.ovgu.featureide.searchFeature";

	Object viewer;
	private FeatureModel featureModel;
	
	public SearchAction(Object viewer, FeatureModel featureModel, Object graphicalViewer) {
		super("Searching Feature");
		this.setId(ID);
		this.viewer = viewer;
		this.featureModel = featureModel;

	}
	@Override
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		
	}
}
