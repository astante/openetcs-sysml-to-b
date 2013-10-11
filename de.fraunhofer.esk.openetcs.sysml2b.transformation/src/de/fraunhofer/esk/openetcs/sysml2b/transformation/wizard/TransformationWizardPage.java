package de.fraunhofer.esk.openetcs.sysml2b.transformation.wizard;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

public class TransformationWizardPage extends WizardPage implements StringConstants {

	private Text modelText;
	private Text projectText;
	
	protected TransformationWizardPage(String pageName) {
		super(pageName);
		setTitle(pageName);
		setPageComplete(false);
		setDescription(UI_WIZARDPAGE_DESCRIPTION);
	}

	@Override
	public void createControl(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, "de.fraunhofer.esk.ernest.core.cdt.help_general");
		
		// Create composite for widgets
		Composite composite = new Composite(parent, SWT.NULL);
		
		// Create layout for wizard page
		GridLayout gl = new GridLayout(2, false);
		composite.setLayout(gl);
		
		new Label(composite, SWT.NONE).setText(UI_WIZARDPAGE_SYSMLMODEL);
		modelText = new Text(composite, SWT.BOLD | SWT.BORDER);
		GridData gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		//gridData.horizontalSpan = 2;
		modelText.setLayoutData(gridData);
		
		new Label(composite, SWT.NONE).setText(UI_WIZARDPAGE_PROJECTNAME);
		projectText = new Text(composite, SWT.BOLD | SWT.BORDER);
		projectText.setLayoutData(gridData);
		projectText.addListener(SWT.CHANGED, new Listener() {
			public void handleEvent(Event e) {
				if (!projectText.getText().equals("")) {
					setPageComplete(true);
				} else {
					setPageComplete(false);
				}
			}
		});

		setControl(composite);
	}

}
