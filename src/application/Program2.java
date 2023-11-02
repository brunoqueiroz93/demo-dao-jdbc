package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        
        System.out.println("==== TESTE 1 : Department insert ====");
        Department newDep = new Department(null, "Estoque");
        departmentDao.insert(newDep);
        System.out.println("Inserted completed! id = "+ newDep.getId());
        
        System.out.println("\n==== TESTE 2 : Department findById ====");
        Department dep = departmentDao.findById(3);
        System.out.println(dep);
        
        System.out.println("\n==== TESTE 3 : Department findAll ====");
        List<Department> list = new ArrayList<>();
        list = departmentDao.findAll();
        for (Department obj : list) {
        	System.out.println(obj);
        }
        
        System.out.println("\n==== TESTE 4 : Department update ====");
        dep.setName("ALTERADO");
        departmentDao.update(dep);
        System.out.println("Updated completed!");
        
        System.out.println("\n==== TESTE 5 : Department deleteById ====");
        departmentDao.deletById(5);
        System.out.println("Deleted completed!");
	}

}
