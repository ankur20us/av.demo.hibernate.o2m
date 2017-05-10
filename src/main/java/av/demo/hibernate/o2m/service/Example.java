package av.demo.hibernate.o2m.service;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import av.demo.hibernate.o2m.modal.Customer;
import av.demo.hibernate.o2m.modal.Vendor;

public class Example {

	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		
		try {
			
			Configuration 	cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			System.out.println("hello");	

			factory = cfg.buildSessionFactory();
			session = factory.openSession();
			Transaction tx = null;
			
			int vendorId = 1;
			
			/***
			 * AV:
			 * 		Inserting the data
			 */
			tx = session.beginTransaction();
			Vendor vendor = new Vendor();
				vendor.setVendorId(vendorId);
				vendor.setVendorName("Ankur");
			Set<Customer> customers = new HashSet<>();
				for (int i=1; i<=5; i++) {
					customers.add(new Customer(i, "Customer " + i, vendorId));
				}
			vendor.setCustomers(customers);
			session.save(vendor);			
			tx.commit();
			
			/***
			 * AV:
			 * 		Getting the data
			 */
			vendor = (Vendor)session.load(Vendor.class, 1);
			System.out.println(vendor);
			System.out.println(vendor.getCustomers());
			
			
			/***
			 * AV:
			 * 		Deleting the data
			 */
			tx = session.beginTransaction();
				vendor = (Vendor)session.load(Vendor.class, vendorId);
				session.delete(vendor);
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null){
				session.close();
			}
			if(factory != null){
				factory.close();				
			}
		}
		
	}
	
}
