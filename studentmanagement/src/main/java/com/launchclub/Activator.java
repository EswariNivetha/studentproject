package com.launchclub;

import com.launchclub.view.StudentManagement;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public static Bundle bundle;

    public void start(BundleContext context) {
        System.out.println("Starting the View bundle");
        bundle = context.getBundle();
        StudentManagement.selectChoice();
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }
}