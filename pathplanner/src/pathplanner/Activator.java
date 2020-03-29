package pathplanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

//import service_tracker.Activator;

import org.eclipse.osgi.framework.util.*;
import org.osgi.framework.ServiceFactory;


public class Activator implements BundleActivator {

	private static BundleContext context;
	BundleContext bundleContext;

	public Path ret;
	int index=0;
    int s1,s2,d1,d2;
	
	int[] position;
	 byte[] data = ("0,0").getBytes();
	String message;
	
	
	int x2,y2,x3,y3;
	
	static BundleContext getContext() {
		return context;
	}
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Astar astar=new Astar(s1, s2, d1, d2 );			
	      }  	
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}


