package application;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
  public static void main(String[] args) {
    Department department = new Department(1, "Books");
    System.out.println(department);
    Seller seller = new Seller(
            21,
            "Bob",
            "bob@gmail",
            new Date(),
            3000.00,
            department
    );
    System.out.println(seller);
  }
}
