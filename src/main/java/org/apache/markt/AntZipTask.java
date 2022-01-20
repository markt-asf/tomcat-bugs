package org.apache.markt;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

public class AntZipTask {

    public static void main(String[] args) {
        Project p = new Project();
        File f = new File("/home/mark/repos/asf-tomcat-main/build.xml");
        ProjectHelper.configureProject(p, f);

        p.executeTarget("package-src-zip");
    }
}
