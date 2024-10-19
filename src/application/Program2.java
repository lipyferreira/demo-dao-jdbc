package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		List<Department> list = new ArrayList<>();
		
		System.out.println("=== TEST 1: department findById ====");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);
		System.out.println("End test findById");
		
		System.out.println();
		System.out.println("=== TEST 2: department findAll ====");
		list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		System.out.println("End test findAll");
		
		System.out.println();
		System.out.println("=== TEST 3: department insert ====");
		Department newDep = new Department(null,"Music");
		departmentDao.insert(newDep);
		System.out.println(newDep.getId());
		System.out.println("End test insert");
		
		System.out.println();
		System.out.println("=== TEST 4 department update ====");
		dep = departmentDao.findById(3);
		dep.setName("PlusSize");
		departmentDao.update(dep);
		System.out.println("End test update");
		
		System.out.println();
		System.out.println("=== TEST 5 department delete ====");
		System.out.print("Id a ser deletado: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("End test delete");
		
		
		sc.close();
	}

}
