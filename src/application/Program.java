package application;


import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

         SellerDao sellerDao = DaoFactory.createSellerDao();
         
         System.out.println("==== TESTE 1 : Seller findById ====");
         Seller seller = sellerDao.findById(3);
         System.out.println(seller);
         
         System.out.println("\n==== TESTE 2 : Seller findByDepartment ====");
         Department department = new Department(2, null);
         List<Seller> list = sellerDao.findByDepartment(department);         
         for(Seller obj : list) {
        	 System.out.println(obj);
         } 
         
         System.out.println("\n==== TESTE 3 : Seller findAll ====");
         List<Seller> list2 = sellerDao.findAll();         
         for(Seller obj : list2) {
        	 System.out.println(obj);
         } 
         
         System.out.println("\n==== TESTE 4 : Seller insert ====");
         Seller newSeller = new Seller(null, "Bruno","bruno@gmail.com", new Date(), 4000.0, new Department(2,null));
         sellerDao.insert(newSeller);
         System.out.println("Inserted! new id = "+ newSeller.getId());
         
         System.out.println("\n==== TESTE 5 : Seller update ====");
         seller = sellerDao.findById(11);
         seller.setEmail("brunosilva@gmail.com");
         sellerDao.update(seller);
         System.out.println("Updated completed!");
         
         System.out.println("\n==== TESTE 6 : Seller delete ====");
         seller = sellerDao.findById(14);
         sellerDao.deleteById(seller.getId());
         System.out.println("Deleted completed!");
	}

}
