package unity_communication;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;





public class Activator implements BundleActivator {

	private static BundleContext context;
	int[] position;
	 byte[] data ;
	String message;
	static BundleContext getContext() {
		return context;
	}


	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		position_parser parser=new position_parser();	
	}

	
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
