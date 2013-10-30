package de.fraunhofer.esk.openetcs.sysml2b.common;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.uml2.uml.Model;
import de.fraunhofer.esk.openetcs.sysml2b.constraints.ClassicalBClientSelector;

public class ClassicalBUtils {
	public static Model openUMLModel(IFile file) {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createURI(file.getFullPath().toString());
		Resource resource = resourceSet.getResource(uri, true);
		Model model = (Model) resource.getContents().get(0);
		
		return model;
	}
	
	public static IStatus validateModel(Model model) {
		ClassicalBClientSelector.running = true;

		IBatchValidator validator = (IBatchValidator)ModelValidationService.getInstance()
			.newValidator(EvaluationMode.BATCH);
		validator.setIncludeLiveConstraints(true);

		IStatus status = validator.validate(model);

		ClassicalBClientSelector.running = false;
		
		return status;
	}
	
	public static boolean isSysMLModel(Model model) {
		// TODO: implement
		return false;
	}
}
