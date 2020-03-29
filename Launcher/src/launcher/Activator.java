package launcher;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import reversecontroller.reverse_controller;
import unity_communication.Collision;
import unity_communication.packetsender;
import unity_communication.position_parser;

public class Activator implements BundleActivator {

	int ds;
	FirstWP one;
	SecondWP two;
	ThirdWP three;
	Collision c;
	Waypoint_determination wd;
	packetsender send;
	position_parser activation;
	reverse_controller rc;
	Scanner x= new Scanner(System.in );
	private static BundleContext context;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	
	    wd=new Waypoint_determination(2);
	}
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}


