package de.fraunhofer.esk.openetcs.sysml2b.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.internal.dialogs.NewWizard;


public class TransformationWizard extends Wizard {

	private TransformationWizardPage page;
	
	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPages() {
		page = new TransformationWizardPage("Foobar");
		addPage(page);		
	}

}
