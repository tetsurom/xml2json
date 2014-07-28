xml2json
========
A simple command converting xml to json.

How to build
========
```
git clone git@github.com:tetsurom/xml2json.git
cd xml2json
mkdir bin
ant
```

How to use
========
```
java -jar xml2json.jar input.xml [output.json]
```

Example
========
Input
```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<project default="create_run_jar" name="Create Runnable Jar for Project xml2json">
    <!--this file was created by Eclipse Runnable JAR Export Wizard-->
    <!--ANT 1.7 is required                                        -->
    <target name="create_run_jar">
        <jar destfile="xml2json.jar" filesetmanifest="mergewithoutmain">
            <manifest>
                <attribute name="Main-Class" value="xml2json.Program"/>
                <attribute name="Class-Path" value="."/>
            </manifest>
            <fileset dir="bin"/>
        </jar>
    </target>
</project>
```
Output(Indent is added for readability):
```json
{ "name": "@document", "contents": [
	{ "name": "project", "attributes": {"default": "create_run_jar","name": "Create Runnable Jar for Project xml2json"}, "contents": [
		{ "name": "target", "attributes": {"name": "create_run_jar"}, "contents": [
			{ "name": "jar", "attributes": {"destfile": "xml2json.jar","filesetmanifest": "mergewithoutmain"}, "contents": [
				{ "name": "manifest", "attributes": {}, "contents": [
					{ "name": "attribute", "attributes": {"name": "Main-Class","value": "xml2json.Program"}, "contents": [] },
					{ "name": "attribute", "attributes": {"name": "Class-Path","value": "."}, "contents": [] },
				] },
				{ "name": "fileset", "attributes": {"dir": "bin"}, "contents": [] },
			] },
		] },
	] },
] }
```
