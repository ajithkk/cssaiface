# Configure cssa iface registration in local machine #
> # download and install java version 6 #
> > Use following link
    * http://www.oracle.com/technetwork/java/javasebusiness/downloads/java-archive-downloads-javase6-419409.html
> > select version Java SE Development Kit 6u45 download and install
Once you have the JDK installed
Set the JAVA\_HOME System Variable

  * Right-click the My Computer icon onyour desktop and select Properties.
  * Click the Advanced tab.
  * Click the Environment Variables button.
  * Under System Variables, click New.
  * Enter the **Variable name** as JAVA\_HOME.
  * Enter the **Variable value** as java installed location path Eg:_C:\Program      Files\Java\jdk1.6.0\_45_
  * Click ok
  * Click ok
  * Click ok

## Install and configure Apache Maven ##

> Download Apache Maven 3.1.1 (Binary zip) from this link **http://mirror.metrocast.net/apache/maven/maven-3/3.1.1/binaries/apache-maven-3.1.1-bin.zip**

> Copy the zip file into any location and unzip it (Create a folder in D:\maven and move apache-maven-3.1.1-bin.zip into that folder and unzip it)

**Set M2\_HOME and M2 User Variable**

  * Right-click the My Computer icon onyour desktop and select Properties.
  * Click the Advanced tab.
  * Click the Environment Variables button.
  * Under user Variables, click New.
  * Enter the **Variable name** as M2\_HOME.
  * Enter the **Variable value** as apache-maven-3.1.1-bin location path Eg:_D:\maven\apache-maven-3.1.1_
  * Click ok
  * Enter the **Variable name** as M2.
  * Enter the **Variable value** as apache-maven-3.1.1-bin\bin location path Eg:_D:\maven\apache-maven-3.1.1\bin_
  * Click ok
  * Click ok
  * Click ok

## Install Eclipse ##
> Download eclipse from this link select appropriate edition 32 bit or 64 bit **http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/junosr2**
> Copy the zip file into any location and unzip it (Create a folder in D:\eclipse\_ide and move eclipse-jee-juno-SR2-win.zip into that folder and unzip it you will get an eclipse folder)
    * Open eclipse folder and double click eclipse.exe file
    * Set the workspace in to D:\administration
    * Click Ok
    * You'll then see the welcome screen

## Configure Eclipse ##
**Update the Installed JDK
  *** Start Eclipse and do the following
  * Choose Windows > Preferences from the Eclipse menu bar.
  * The system displays the preferences dialog.
  * Filter for or navigate to the Installed JREs page (For navigation     expanding java then click Installed JRE)
  * Select JRE in that list and remove it
  * Click the Add button.
  * The Add JRE wizard displays.
  * Make sure Standard VM is selected and press Next.
  * Press Directory.
  * The Browse For Folder dialog appears.
  * Navigate to your JDK installation. (probably in C:\Program Files\Java\jdk1.6.0\_45)
  * Press OK.

**Install the Maven Eclipse Plugin
  *** Start Eclipse and do the following:
  * Choose Help > Install New Software.
  * The Available Software dialog appears.
  * Click the Add button.
  * The Add Repository dialog appears.
  * Enter Sonatype M2Eclipse in the Name field.
  * Enter http://download.eclipse.org/technology/m2e/releases in the Location field.
  * Press OK to close the dialog.
  * Check the box and press Next.
  * Select Maven Integration for Eclipse.
  * Press Next and Next again.
  * Accept the terms of the license agreement and press Finish.
  * Eclipse calculates the dependencies and space.
  * Press Next.
  * Accept the License agreement and press Next.The installation procedure runs.
  * Restart Eclipse when prompted.

**Install the Subeclipse Eclipse Plugin
  ***Start Eclipse and do the following:
  * Choose Help > Install New Software.
  * The Available Software dialog appears.
  * Click the Add button.
  * The Add Repository dialog appears.
  * Enter SubEclipse in the Name field.
  * Enter http://subclipse.tigris.org/update_1.10.x in the Location field.
  * ress OK to close the dialog.
  * Check the box and press Next.
  * Select Subclipse	.
  * Press Next and Next again.
  * Accept the terms of the license agreement and press Finish.
  * Eclipse calculates the dependencies and space.
  * Press Next.
  * Accept the License agreement and press Next. The installation procedure runs.
  * Restart Eclipse when prompted.

# Checkout instructions #
  * Open eclipse
  * Navigate to the "SVN Repository Exploring" perspective Window > Open perspective > Other  select SVN Repository Exploring
  * Click Ok
  * Navigate to the "SVN Repositories" view (Left Side of the IDE)
  * Right Click SVN Repositories Select New > Repository Location
  * Add Url field to https://cssaiface.googlecode.com/svn/branches/cssa/
  * Click Finish
  * Right Click URL added in the VN Repositories select Check Out
> Source downloaded to your local machine

## Build and Run cssaiface ##
**Build project
  *** Right Click pom.xml file in project folder
  * 

#  #

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages