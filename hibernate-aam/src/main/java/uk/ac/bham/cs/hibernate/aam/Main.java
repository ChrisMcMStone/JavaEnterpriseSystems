package uk.ac.bham.cs.hibernate.aam;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import uk.ac.bham.cs.aam.model.AssetType;

public class Main {
	public static void main(String[] args) {
		SessionFactory factory = null;
		String cmd = null;
		
		try {
			// have we been given at least a command?
			if(args.length < 1) {
				Main.usage(); // no? then tell everyone how it should be done.
				return;
			}
			
			// get it for safe keeping
			cmd = args[0];
			
			try {
				// ensure the driver has been loaded.
				Class.forName("org.postgresql.Driver");
			} catch(ClassNotFoundException e) {
				System.err.println("driver not found.");
				System.err.println(e.getMessage());
				return;
			}

			// time to setup hibernate!
			final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure() // this reads hibernate.cfg.xml
				.build();
			
			try {
				// create a session factory
				factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
			} catch(HibernateException e) {
				StandardServiceRegistryBuilder.destroy(serviceRegistry);
				System.err.println("couldn't connect to the database.");
				System.err.println(e.getMessage());
				e.printStackTrace();
				return;
			}
			
			// create the service
			HibernateAAMExercise service = new HibernateAAMExercise(factory);
			if(cmd.equals("ListAssetTypes") && args.length == 1) {
				for(AssetType assetType: service.getAssetTypes()) {
					System.out.println(assetType.getName());
				}
			} else if(cmd.equals("AddAssetType") && args.length == 2) {
				try {
					service.addAssetType(args[1]);
				} catch(IllegalArgumentException e) {
					System.err.println(e.getMessage());
					System.err.println("Asset type `" + args[1] + "' already exists.");
				}
			}
			
		} finally {
			if(factory != null && !factory.isClosed()) {
				factory.close();
			}
		}
	}
	
	public static void usage() {
		System.out.println("Usage:\n");
	}
}
