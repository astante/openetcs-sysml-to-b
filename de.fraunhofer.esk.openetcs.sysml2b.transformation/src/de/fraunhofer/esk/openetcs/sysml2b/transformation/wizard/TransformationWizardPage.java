package de.fraunhofer.esk.openetcs.sysml2b.transformation.wizard;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

public class TransformationWizardPage extends WizardPage implements StringConstants {

	private Text modelNameWidget;
	private Text projectNameWidget;
	private Button checkModel;
	private String modelName = "";
	
	protected TransformationWizardPage(String pageName) {
		super(pageName);
		setTitle(pageName);
		setPageComplete(false);
		setDescription(UI_WIZARDPAGE_DESCRIPTION);
		setErrorMessage(UI_WIZARDPAGE_EMSG_NAME);
	}

	@Override
	public void createControl(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, "de.fraunhofer.esk.ernest.core.cdt.help_general");
		
		// Create composite for widgets
		Composite composite = new Composite(parent, SWT.NONE);
		
		// Create layout for wizard page
		GridLayout gl = new GridLayout(2, false);
		composite.setLayout(gl);
		
		// Model
		new Label(composite, SWT.NONE).setText(UI_WIZARDPAGE_SYSMLMODEL);
		modelNameWidget = new Text(composite, SWT.BOLD | SWT.BORDER);
		modelNameWidget.setText(modelName);

		GridData gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		modelNameWidget.setLayoutData(gridData);
		

		// Project
		new Label(composite, SWT.NONE).setText(UI_WIZARDPAGE_PROJECTNAME);
		projectNameWidget = new Text(composite, SWT.BOLD | SWT.BORDER);
		projectNameWidget.setLayoutData(gridData);
		projectNameWidget.addListener(SWT.CHANGED, new Listener() {
			public void handleEvent(Event e) {
				if (!projectNameWidget.getText().equals("")) {
					setPageComplete(true);
					setErrorMessage(null);
				} else {
					setPageComplete(false);
					setErrorMessage(UI_WIZARDPAGE_EMSG_NAME);
				}
			}
		});

		// Check model
		GridData spanData = new GridData(GridData.FILL, GridData.END, true, false);
		spanData.horizontalSpan = 2;
		// spanData.grabExcessVerticalSpace = true;
		checkModel = new Button(composite, SWT.CHECK);
		checkModel.setText(UI_WIZARDPAGE_CHECK_MODEL);
		checkModel.setLayoutData(spanData);
		checkModel.setSelection(true);
		
		
		setControl(composite);
	}
	
	public String getProjectName() {
		return projectNameWidget.getText();
	}
	
	public void setModelName(String model) {
		modelName = model;
	}
	
	public String getModelName() {
		return modelNameWidget.getText();
	}
	
	public boolean performModelCheck() {
		return checkModel.getSelection();
	}
}
