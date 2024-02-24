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
		
		System.out.println("=== TESTE 1: seller findById ===");
		Seller sel = sellerDao.findById(3);
		System.out.println(sel);

		System.out.println("\n=== TESTE 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller obj:list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 3: seller FindAll ===");
		
		list = sellerDao.findAll();
		
		for (Seller obj:list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 4: seller INSERT ===");
		
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TESTE 5: seller UPDATE ===");
		
		
		sel = sellerDao.findById(1);
		
		sel.setName("Martha Whaine");
		
		sellerDao.update(sel);
		
		System.out.println("Update completed!");
		
	}
}