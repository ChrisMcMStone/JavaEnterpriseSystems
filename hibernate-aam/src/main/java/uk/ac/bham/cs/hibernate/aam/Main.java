package uk.ac.bham.cs.hibernate.aam;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.joda.time.LocalDate;

import uk.ac.bham.cs.aam.model.Asset;
import uk.ac.bham.cs.aam.model.AssetType;
import uk.ac.bham.cs.aam.model.Customer;
import uk.ac.bham.cs.aam.model.Work;
import uk.ac.bham.cs.aam.model.impl.AssetImpl;
import uk.ac.bham.cs.aam.model.impl.AssetTypeImpl;
import uk.ac.bham.cs.aam.model.impl.CustomerImpl;
import uk.ac.bham.cs.aam.model.impl.WorkImpl;

public class Main {
	public static void main(String[] args) {
		SessionFactory factory = null;
		String cmd = null;

		try {
			// have we been given at least a command?
			if (args.length < 1) {
				Main.usage(); // no? then tell everyone how it should be done.
				return;
			}

			// get it for safe keeping
			cmd = args[0];

			try {
				// ensure the driver has been loaded.
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.err.println("driver not found.");
				System.err.println(e.getMessage());
				return;
			}

			// time to setup hibernate!
			final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

			try {
				// create a session factory
				factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
			} catch (HibernateException e) {
				StandardServiceRegistryBuilder.destroy(serviceRegistry);
				System.err.println("couldn't connect to the database.");
				System.err.println(e.getMessage());
				e.printStackTrace();
				return;
			}

			// create the service
			HibernateAAMExercise service = new HibernateAAMExercise(factory);
			if (cmd.equals("create")) {
				Session session = factory.getCurrentSession();
				Transaction tx = session.beginTransaction();

				try {

					AssetType type1 = new AssetTypeImpl();
					type1.setName("Electricals");
					session.saveOrUpdate(type1);

					AssetType type2 = new AssetTypeImpl();
					type1.setName("Medicals");
					session.saveOrUpdate(type2);

					AssetType type3 = new AssetTypeImpl();
					type1.setName("Plumbing");
					session.saveOrUpdate(type3);

					Asset asset1 = new AssetImpl();
					asset1.setAssetType(type1);
					asset1.setName("Kettle");
					asset1.setNumber(123);
					session.saveOrUpdate(asset1);

					Asset asset2 = new AssetImpl();
					asset2.setAssetType(type2);
					asset2.setName("Bandages");
					asset2.setNumber(124);
					session.saveOrUpdate(asset2);
					
					Customer cust1 = new CustomerImpl();
					cust1.setFirstName("Chris");
					cust1.setLastName("Stone");
					cust1.setEmail("asd@asfas.com");
					session.save(cust1);

					Query query = session.createQuery("from CustomerImpl where id = 6");
					Customer cust1Persist = (Customer) query.uniqueResult();
					
					Work job1 = new WorkImpl();
					job1.setAsset(asset1);
					job1.setStartDate(new LocalDate());
					job1.setCustomer(cust1Persist);
					session.save(job1);

					tx.commit();
				} catch (HibernateException e) {
					if (tx != null && tx.getStatus().canRollback()) {
						tx.rollback();
					}
					System.err.println(e.getCause());
				}

			} else if (cmd.equals("delete")) {
				Session session = factory.getCurrentSession();
				Transaction tx = session.beginTransaction();

				try {
					Query query = session.createQuery("delete CustomerImpl where firstname = :name");
					query.setParameter("name", "Chris");
					query.executeUpdate();
					tx.commit();
				} catch (HibernateException e) {
					if (tx != null && tx.getStatus().canRollback()) {
						tx.rollback();
					}
					System.err.println(e.getCause());
				}

			} else if (cmd.equals("ListAssetTypes") && args.length == 1) {
				for (AssetType assetType : service.getAssetTypes()) {
					System.out.println(assetType.getName());
				}
			} else if (cmd.equals("AddAssetType") && args.length == 2) {
				try {
					service.addAssetType(args[1]);
					System.out.println("Asset Type " + args[1] + " added successfully.");
				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
					System.err.println("Asset type `" + args[1] + "' already exists.");
				}
			} else if (cmd.equals("UpdateAssetType") && args.length == 3) {
				try {
					service.updateAssetType(args[1], args[2]);
					System.out.println("Asset Type updated successfully.");
				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
				}
			} else if (cmd.equals("DeleteAssetType") && args.length == 2) {
				try {
					service.deleteAssetType(args[1]);
					System.out.println("AssetType deleted successfully.");
				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
				}
			} else if (cmd.equals("ListAssets")) {
				Set<Asset> assets = null;
				if (args.length == 3) {
					Integer startAssetNo = Integer.parseInt(args[1]);
					Integer endAssetNo = Integer.parseInt(args[2]);
					if (endAssetNo <= startAssetNo) {
						System.err.println("Invalid range.");
						return;
					}
					assets = service.getAssets(startAssetNo, endAssetNo);
				} else if (args.length == 2) {
					Integer assetNo = Integer.parseInt(args[1]);
					assets = service.getAssets(assetNo, null);
				} else if (args.length == 1) {
					assets = service.getAssets(null, null);
				} else {
					usage();
					return;
				}
				System.out.println("Asset Number     | Asset Name        | Asset Type Name");
				for (Asset asset : assets) {
					System.out.println(asset.getNumber() + "            " + asset.getName() + "           "
							+ asset.getAssetType().getName());
				}
			} else if (cmd.equals("AddAsset") && args.length == 4) {
				try {
					Integer assetNo = Integer.parseInt(args[1]);
					service.addAsset(assetNo, args[2], args[3]);
					System.out.println("Asset added successfully.");
				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
				}
			} else {
				usage();
			}
		} finally {
			if (factory != null && !factory.isClosed()) {
				factory.close();
			}
		}
	}

	public static void usage() {
		System.out.println("Usage:\n");
		System.out.println("ListAssetTypes");
		System.out.println("AddAssetType <name>");
		System.out.println("UpdateAssetType <oldName> <newName>");
		System.out.println("DeleteAssetType <name>");
		System.out.println("ListAssets [startAssetNo] [endAssetNo]");
		System.out.println("AddAsset <assetNo> <assetName> <assetType>");
	}
}
