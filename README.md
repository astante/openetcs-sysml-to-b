openetcs-sysml-to-b
===================
<pre>
Copyright (c) 2013
Fraunhofer-Institut für Eingebettete Systeme und Kommunikationstechnik ESK

Hansastr. 32
80686 Munich
Germany
</pre>
Eclipse Update Site
===================

Add the following link as an additional update site to Eclipse. 

<pre>https://raw.github.com/astante/openetcs-updatesite/master</pre>

Contents
========

UML Profile
-----------

The plugin contains a UML profile to support the transformation of the SysML model to Classical B. The content of the profile is currently under discussion, but what has been identified so far is that not every SysML Block should be transformed to Classical B, because certain Blocks are not relevant for software generation. Furthermore, it is currently under investigation if the profile should be used to formulate invariants. The profile can be applied to a SysML model by clicking on `Apply registered profile` in the `Properties` windows of the SysML model.

![][profile]

UML Library
-----------

The plugin also installs a registered library which containts primitive types of Classical B. The library can be imported by right clicking on the SysML model, then selecting `Import > Import Registered Package`. Currently it only contains the following datatypes:

* NAT
* BOOL
* STRING
* INT

![][library]

Model Validation 
----------------

The SysML model must hold certain rules to be able to be correctly transformed to Classical B. In order to maintain these rules, the plugin contains a definition of constraints, utilizing the Eclipse Validation Framework. Violations will be highlight within the model via markers. To start the model valdation, right click on the SysML model in the Model Explorer and select `Validation > Select constraints and Validate model`. The followin constraints are currently included:

* All parameters and return values of Operations have an associated type
* All names are valid Classical B identifier
* All SysML Block names are unique within the model
* No NamedElement uses a reserved Classical B keyword

![][validation]

Classical B Model generation
----------------------------

The plugin include the actual transformation form SysML to Classical B. Currently the transformation is in a very alpha stage and probably does not generate a valid B model. However, the transformation will be continously improved to reach the goal of a SysML to Classical B integration. To execute the transformation right click the SysML model in the `Project Explorer` or the .uml file in the `Package Explorer` and select `openETCS > Generate Classical B Model`. 
![][popup]

In the creation wizard you have to enter the new project name for the generated B model. You can also select if you want to perform the model validation before startin the transformation in order to ensure that the model does not contains any errors that would prevent the transformation.

![][generation]

[profile]: https://raw.github.com/wiki/astante/openetcs-sysml-to-b/images/openetcs-profile-small.png "Profile selection"
[library]: https://raw.github.com/wiki/astante/openetcs-sysml-to-b/images/openetcs-library-small.png "Library selection"
[validation]: https://raw.github.com/wiki/astante/openetcs-sysml-to-b/images/openetcs-validation-small.png "Validation"
[popup]: https://raw.github.com/wiki/astante/openetcs-sysml-to-b/images/openetcs-popup-small.png "Popup"
[generation]: https://raw.github.com/wiki/astante/openetcs-sysml-to-b/images/openetcs-generation-small.png "Generation"
