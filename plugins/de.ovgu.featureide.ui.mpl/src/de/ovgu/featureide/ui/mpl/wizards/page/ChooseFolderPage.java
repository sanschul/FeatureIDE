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
package de.ovgu.featureide.ui.mpl.wizards.page;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.ovgu.featureide.ui.mpl.wizards.WizardConstants;

/**
 * A dialog page to specify a folder name.
 * 
 * @author Reimar Schroeter
 */
public class ChooseFolderPage extends AbstractWizardPage {

	private Text folderName;
	private Label folderLabel;

	private String folderNameString;

	public ChooseFolderPage(String defaultFolderName) {
		super("Choose Folder");
		setDescription("Choose a Folder for Extended Modules");
		this.folderNameString = defaultFolderName;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		container.setLayout(gridLayout);
		setControl(container);

		GridLayout projGridLayout = new GridLayout();
		projGridLayout.numColumns = 2;

		Group configGroup = new Group(container, SWT.NONE);
		configGroup.setText("");
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		gridData.verticalSpan = 1;

		configGroup.setLayoutData(gridData);
		configGroup.setLayout(projGridLayout);

		GridData gridData2 = new GridData(GridData.FILL_HORIZONTAL);
		gridData2.horizontalSpan = 1;
		gridData2.verticalSpan = 1;

		folderLabel = new Label(configGroup, 0);
		folderLabel.setText("Name of Folder: ");
		folderName = new Text(configGroup, SWT.BORDER | SWT.SINGLE);
		folderName.setText(folderNameString);
		folderName.setLayoutData(gridData2);
		folderName.addKeyListener(new KeyPressedListener());
		updatePage();
	}

	@Override
	protected String checkPage() {
		folderNameString = folderName.getText();
		if (folderNameString.isEmpty()) {
			return "Enter a folder name";
		}
		return null;
	}

	@Override
	protected void putData() {
		abstractWizard.putData(WizardConstants.KEY_OUT_FOLDER, folderNameString);
	}
}
