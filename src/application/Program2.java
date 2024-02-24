package application;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		List<Department> list = new ArrayList<>();
	
		System.out.println("=== TESTE 1: dep findById ===");
		Department dep = depDao.findById(3);
		System.out.println(dep);
		
		System.out.println("\n=== TESTE 3: seller FindAll ===");
				
		list = depDao.findAll();
		
		for (Department obj:list) {
			System.out.println(obj);
		}
		
		
		/*
		
		System.out.println("\n=== TESTE 4: dep INSERT ===");
		
		Department newDep = new Department(null, "Sales");
		
		depDao.insert(newDep);
		
		System.out.println("Inserted! New id = " + newDep.getId());
		
		*/
		
		
		System.out.println("\n=== TESTE 5: dep UPDATE ===");
		dep = depDao.findById(1);
		dep.setName("Sales");
		depDao.update(dep);
		System.out.println("Update completed!");
		
		
		System.out.println("\n=== TESTE 6: department DELETE ===");
		
		System.out.print("Enter id for deletion test: ");
		
		Scanner sc = new Scanner(System.in);
		
		int id = sc.nextInt();
		
		depDao.deleteById(id);
		
		System.out.println("Deleted!");
		
		sc.close();
		
	}
}