package de.fraunhofer.esk.openetcs.sysml2b.transformation;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;

import de.fraunhofer.esk.openetcs.sysml2b.common.ClassicalBUtils;
import de.fraunhofer.esk.openetcs.sysml2b.transformation.wizard.TransformationWizard;

public class PerformTransformationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShell(event);
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
		Object object = selection.getFirstElement();
		IFile file;
		
		if (object instanceof IFile) {
			file = (IFile) object;
		} else if (object instanceof IPapyrusFile) {
			IPapyrusFile papyrusFile = (IPapyrusFile) object;
			file = ClassicalBUtils.getUMLFile(papyrusFile);
		} else {
			MessageDialog.openWarning(shell, "Transformation can't be called on: ", object.getClass().getName());
			return null;
		}
		
		TransformationWizard wizard = new TransformationWizard();
		wizard.setModel(file);

		WizardDialog wizarddialog = new WizardDialog(shell, wizard);

		try {
			if(wizarddialog.open() == Window.CANCEL)
				return null;	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}
}
