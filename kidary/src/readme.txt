Spouštění aplikace:
/usr/lib/jvm/java-11-openjdk-amd64/bin/java --add-modules javafx.base,javafx.graphics --add-reads javafx.base=ALL-UNNAMED --add-reads javafx.graphics=ALL-UNNAMED -javaagent:/snap/intellij-idea-ultimate/188/lib/idea_rt.jar=34059:/snap/intellij-idea-ultimate/188/bin -Dfile.encoding=UTF-8 -p /usr/share/openjfx/lib/javafx.base.jar:/usr/share/openjfx/lib/javafx.graphics.jar:/path/to/kidary/output/production/kidary:/usr/share/openjfx/lib/javafx.controls.jar:/usr/share/openjfx/lib/javafx.fxml.jar:/usr/share/openjfx/lib/javafx.media.jar:/usr/share/openjfx/lib/javafx.swing.jar:/usr/share/openjfx/lib/javafx.web.jar:/path/to/kidary/charm-glisten-4.4.1.jar:/path/to/kidary/controlsfx-11.0.0.jar:/path/to/kidary/jfoenix-9.0.8.jar -m kidary/calendar.Controllers.Kidary

Pro spuštění je nutné mít Javu verze 11 a openjfx verze 11. 
Pro lehčí tvorbu GUI je vhodné mít nainstalovaný Scene Builder. 
Pokud uživatel používá IDE, tak přidat do IDE cestu, kde se nachází knihovna JavaFX a z ní vybrat příslušné jar soubory. 
Dále je potřeba stáhnout knihovny controlsfx, charm-glisten, jfoenix a následně přidat knihovny do IDE. 
Zmíněné závilosti na knihovnách jsou v souboru module-info.java.

URL knihoven:
JavaFX: https://gluonhq.com/products/javafx/
scene builder: https://gluonhq.com/products/scene-builder/#download
controlsfx: https://repo.maven.apache.org/maven2/org/controlsfx/controlsfx/11.0.0/controlsfx-11.0.0.jar
charm-glisten: https://nexus.gluonhq.com/nexus/content/repositories/releases/com/gluonhq/charm-glisten/4.4.1/charm-glisten-4.4.1.jar
jfoenix: https://search.maven.org/remotecontent?filepath=com/jfoenix/jfoenix/9.0.8/jfoenix-9.0.8.jar

