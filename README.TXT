Prior to version 0.0.1 you should do some manual tweaking of WTP Internals:

After updating the source folders you need to do some additional tweaking for better integration. Open the project in navigator view and edit the file .settings/org.eclipse.wst.common.component. If required open the source tab in the editor and do the following:

    * Replace /WebContent with /src/main/webapp.
    * Replace build/classes with target/classes.

Delete the entry for the following:


<wb-resource deploy-path="/WEB-INF/classes" source-path="/src/test/java"/>
<wb-resource deploy-path="/WEB-INF/classes" source-path="/src/test/resources"/>

This should be the resulting XML:


<?xml version="1.0" encoding="UTF-8"?>
<project-modules id="moduleCoreId" project-version="1.5.0">
<wb-module deploy-name="sample1">
<wb-resource deploy-path="/" source-path="/src/main/webapp"/>
<wb-resource deploy-path="/WEB-INF/classes" source-path="/src/main/java"/>
<wb-resource deploy-path="/WEB-INF/classes" source-path="/src/main/resources"/>
<property name="context-root" value="sample1"/>
<property name="java-output-path" value="target/classes"/>
</wb-module>
</project-modules>

	 
Figure 4. J2EE Module Dependencies: Link the maven2 dependencies with the J2EE Module dependencies.

Remember to save the changes when done.

Carefully move the folders META-INF and WEB-INF under /WebContent to src/main/webapp. In the navigator view, delete the folders WebContent and build

Current version does not require such modifications and WebContent folder is processed normally.  