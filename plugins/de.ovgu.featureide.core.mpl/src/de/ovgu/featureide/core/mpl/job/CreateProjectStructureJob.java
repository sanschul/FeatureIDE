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
package de.ovgu.featureide.core.mpl.job;

import de.ovgu.featureide.core.mpl.InterfaceProject;
import de.ovgu.featureide.core.mpl.MPLPlugin;
import de.ovgu.featureide.core.mpl.job.util.AJobArguments;
import de.ovgu.featureide.core.mpl.signature.ProjectSignatures.SignatureIterator;
import de.ovgu.featureide.core.mpl.signature.ProjectStructure;
import de.ovgu.featureide.core.mpl.signature.filter.ISignatureFilter;
import de.ovgu.featureide.core.mpl.signature.fuji.FujiClassCreator;

/**
 * Constructs a {@link ProjectStructure}.
 * 
 * @author Sebastian Krieter
 */
public class CreateProjectStructureJob extends AChainJob<CreateProjectStructureJob.Arguments> {
	
	public static class Arguments extends AJobArguments {
		private final ISignatureFilter filter;
		private final ProjectStructure projectSig;
		
		public Arguments(ProjectStructure projectSig, ISignatureFilter filter) {
			super(Arguments.class);
			this.filter = filter;
			this.projectSig = projectSig;
		}
	}

	protected CreateProjectStructureJob(Arguments arguments) {
		super("Loading Project Signature", arguments);
	}
	
	@Override
	protected boolean work() {
		InterfaceProject interfaceProject = MPLPlugin.getDefault().getInterfaceProject(this.project);
		if (interfaceProject == null) {
			MPLPlugin.getDefault().logWarning(this.project.getName() + " is no Interface Project!");
			return false;
		}
		SignatureIterator it = interfaceProject.getProjectSignatures().createIterator();
		it.addFilter(arguments.filter);
		arguments.projectSig.construct(it, new FujiClassCreator());
		return true;
	}
}
