package vehicles;

import java.util.HashSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Main {
	public static void main(String[] args) {
		SessionFactory factory = null;
		
		try {
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
			
			Session session = factory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			try {
				// TODO add some code to play with your objects
				//      try to persist some and see what your database looks like.
				//      note the database doesn't care about duplicates,
				//        this is merely an example.
				
				Vehicle v = new Vehicle();
				v.setMake("Aston Martin");
				session.save(v);
				
				LGV t = new LGV();
				t.setMake("Volvo");
				t.setMaxWeight(15.0);
				session.save(t);
				
				VehicleTransport vt = new VehicleTransport();
				vt.setVehicles(new HashSet<Vehicle>());
				vt.getVehicles().add(v);
				vt.getVehicles().add(t);
				session.save(vt);
				
				// Make an aeroplane model and save it (see HBM).
				
				Aeroplane a = new Aeroplane();
				a.setMake("Boeing");
				a.setModel("747");
				a.setLength(250.0);
				a.setWingSpan(200.0);
				a.setMaxHeight(25.0);
				session.save(a);
				
				// Make a submarine mapping, create the model and save it.
				Submarine sub = new Submarine();
				sub.setMaxDepth(3000.0);
				session.save(sub);
				
				// Make a car model and mapping (make some properties up).
				Car car = new Car();
				car.setMake("Vauxhall");
				car.setModel("Astra");
				car.setIsFourWheelDrive(true);
				car.setMaxSpeed(120.0);
				session.save(car);
				
				tx.commit();
			} catch(HibernateException e) {
				e.printStackTrace(); // catch all.
				// roll back no matter what
				if(tx != null && tx.getStatus().canRollback()) {
					tx.rollback();
				}
			}
		} finally {
			if(factory != null && !factory.isClosed()) {
				factory.close();
			}
		}
	}
}
