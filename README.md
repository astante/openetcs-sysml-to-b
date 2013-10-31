openetcs-sysml-to-b
===================
Copyright (c) 2013 

Fraunhofer-Institut für Eingebettete Systeme und Kommunikationstechnik ESK, 

Hansastr. 32, 

80686 Munich, Germany

Eclipse Update Site
===================

Add the following link as an additional update site to Eclipse. 

<pre>https://raw.github.com/astante/openetcs-updatesite/master</pre>

Contents
========

Profile and UML Library
-----------------------

The plugin contains a UML profile to support the transformation of the SysML model to Classical B. The content of the profile is currently under discussion, but what has been identified so far is that not every SysML Block should be transformed to Classical B, because certain Blocks are not relevant for software generation. Furthermore, it is currently under investigation if the profile should be used to formulate invariants. The profile can be applied to a SysML model by clicking on "Apply registered profile" in the "Properties" windows of the SysML model.

The plugin also installs a registered library which containts primitive types of Classical B. The library can be imported by right clicking on the SysML model, then selecting "Import->Import Registered Package."

Model Validation 
----------------

Classical B Model generation
----------------------------
