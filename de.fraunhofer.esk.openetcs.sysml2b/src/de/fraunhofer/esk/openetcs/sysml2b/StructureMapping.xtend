package de.fraunhofer.esk.openetcs.sysml2b

import org.eclipse.papyrus.sysml.blocks.Block
import org.eclipse.uml2.uml.Class
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.uml2.uml.AggregationKind
import org.eclipse.emf.common.util.EList
import org.eclipse.uml2.uml.Operation

class StructureMapping {
	def createMachine(Block block)'''
	MACHINE
		«block.base_Class.name»
	VARIABLES
		«FOR variable : block.base_Class.getValues»
		«variable.name»
		«ENDFOR»
	IMPORTS «FOR part : block.base_Class.getParts SEPARATOR ', '»«part.name».«part.type.name»«ENDFOR»
	
	INVARIANT
		«FOR variable : block.base_Class.getValues»
		«variable.name» : «variable.type.name»
		«ENDFOR»
		
	INITIALIZATION
	
	OPERATIONS
		«FOR operation : block.base_Class.ownedOperations»
		«IF operation.hasOutParameter» <-- «ENDIF»«operation.name»«IF operation.hasInParameter» ()«ENDIF» = 
		BEGIN
			skip
		END;
		
		«ENDFOR»
	END
	'''
	
	def boolean hasInParameter(Operation operation)
	{
		return false;
	}
	
	def boolean hasOutParameter(Operation operation)
	{
		return false;
	}
	
	/*
	 * Returns UML Values which are properties with aggregation of 
	 * type Composite and which have no associations
	 */
	def EList<org.eclipse.uml2.uml.Property> getValues(Class cls)
	{
		var values = new BasicEList<org.eclipse.uml2.uml.Property>
		
		for (attribute : cls.ownedAttributes) {
			if (attribute.aggregation == AggregationKind.COMPOSITE &&
				attribute.association == null) {
				values.add(attribute)					
			}
		}
		
		return values
	}
	
}