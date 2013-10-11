package de.fraunhofer.esk.openetcs.sysml2b.transformation;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.fraunhofer.esk.openetcs.sysml2b.transformation.wizard.TransformationWizard;

public class StartTransformation implements IObjectActionDelegate {

	private Shell shell;
	private ISelection selection;

	@Override
	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
			TransformationWizard wizard = new TransformationWizard();
			WizardDialog wizarddialog = new WizardDialog(shell, wizard);
		
			try {
			if(wizarddialog.open() == Window.CANCEL)
				return;	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
		action.setEnabled(!selection.isEmpty());
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

}
