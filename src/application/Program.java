package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
  public static void main(String[] args) {
    SellerDao sellerDao = DaoFactory.createSellerDao();
    Department department = new Department(2, null);
//    System.out.println("+++++++ Test One: seller findById +++++++");
//    Seller seller = sellerDao.findById(4);
//    System.out.println("+++++++ Test Two: seller findByDepartment +++++++");
//    List<Seller> list = sellerDao.findByDepartment(department);
//    list.forEach(System.out::println);
//    System.out.println("+++++++ Test Three: seller findAll +++++++");
//    List<Seller> listAll = sellerDao.findAll();
//    listAll.forEach(System.out::println);
    System.out.println("+++++++ Test Four: seller insert +++++++");
    Seller newSeller = new Seller(null, "Greg Madison", "greg@gmail.com", new Date(), 3999.99, department);
    sellerDao.insert(newSeller);
    List<Seller> listAll = sellerDao.findAll();
    listAll.forEach(System.out::println);
    System.out.println("+++++++ Test Five: seller update +++++++");
    Seller seller = sellerDao.findById(1);
    seller.setName("Ricardo Ferreira");
    sellerDao.update(seller);
    listAll = sellerDao.findAll();
    listAll.forEach(System.out::println);

  }
}
