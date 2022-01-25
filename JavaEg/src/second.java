
import java.sql.*;
import java.util.Scanner;

public class second {
@SuppressWarnings("resource")
public static void main(String[] args) {
try {
Statement st=null;
ResultSet rs=null;
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection
("jdbc:mysql://localhost:3306/JavaEg", "root", "madhu");
//System.out.println("Simple CURD/S Operation:");
Scanner scan=new Scanner(System.in);
System.out.println("Enter a UserName : ");
String a=scan.nextLine();
System.out.println("Enter Ur Options:");
String options=scan.next();
st=con.createStatement();
PreparedStatement statement =null;
if(a.equals("admin") || a.equals("Admin")){
switch(options){
case "select":
  rs=st.executeQuery("select * from products");
 while(rs.next()) {
 System.out.println("Product : "+rs.getInt("pid")
 +"  ProductName : "+rs.getString("pname")
 +"  Price : "+rs.getDouble("pprice")
 +"  Quantity : "+rs.getInt("pqty"));
  }
 break;
case "insert":
  System.out.println("Enter Product Details:");
  String pname=scan.next();
  int pid=scan.nextInt();
  double pprice=scan.nextDouble();
  int pqty=scan.nextInt();
  String sql = "INSERT INTO products (pid,pname,pprice,pqty) VALUES (?, ?, ?, ?)";
  statement = con.prepareStatement(sql);
  statement.setInt(1, pid);
  statement.setString(2, pname);
  statement.setDouble(3, pprice);
  statement.setInt(4, pqty);
  int rowsInserted = statement.executeUpdate();
  if (rowsInserted > 0) {
      System.out.println("A new product was inserted successfully!");
  }
  break;
case "find":
  System.out.println("Enter Product name to Find:");
  String pname1=scan.next();
  String q1="select * from products where pname=?";
  statement = con.prepareStatement(q1);
  statement.setString(1,pname1);
  ResultSet rs1=statement.executeQuery();
 if(rs1.next()) {
 System.out.println("Product:"+rs1.getInt("pid")
 +"ProductName:"+rs1.getString("pname")
 +"Price:"+rs1.getDouble("pprice")
 +"QTY:"+rs1.getInt("pqty"));
  }
 break;
case "delete":
  System.out.println("Enter Product Name For Delete:");
  String pnam=scan.next();
  String q="delete from products where pname=?";
 statement = con.prepareStatement(q);
  statement.setString(1,pnam);
  int rowsDeleted = statement.executeUpdate();
  if (rowsDeleted > 0) {
      System.out.println("A product was Deleted successfully!");
  }
  break;
case "update":
  System.out.println("Enter Product Name For Update:");
  String p2=scan.next();
  boolean up=st.execute("update products set pprice=30.25 where pname='"+p2+"'");
  if(!up) {
  System.out.println("Updated");
  }else {
  System.out.println("Not Updated");
  }
  break;
}
}
if(!a.equals("admin") || !a.equals("Admin")){
if(options.equals("select") || options.equals("insert") || options.equals("find")){
switch(options) {
  case "select":
  rs=st.executeQuery("select * from products");
 while(rs.next()) {
 System.out.println("Product : "+rs.getInt("pid")
 +"  ProductName : "+rs.getString("pname")
 +"  Price : "+rs.getDouble("pprice")
 +"  Quantity : "+rs.getInt("pqty"));
  }
 break;
  case "insert":
  System.out.println("Enter Product Details:");
  String pname=scan.next();
  int pid=scan.nextInt();
  double pprice=scan.nextDouble();
  int pqty=scan.nextInt();
  String sql = "INSERT INTO products (pid,pname,pprice,pqty) VALUES (?, ?, ?, ?)";
  statement = con.prepareStatement(sql);
  statement.setInt(1, pid);
  statement.setString(2, pname);
  statement.setDouble(3, pprice);
  statement.setInt(4, pqty);
  int rowsInserted = statement.executeUpdate();
  if (rowsInserted > 0) {
      System.out.println("A new product was inserted successfully!");
  }
  break;
  case "find":
  System.out.println("Enter Product name to Find:");
  String pname1=scan.next();
  String q1="select * from products where pname=?";
  statement = con.prepareStatement(q1);
  statement.setString(1,pname1);
  ResultSet rs1=statement.executeQuery();
 if(rs1.next()) {
 System.out.println("Product:"+rs1.getInt("pid")
 +"ProductName:"+rs1.getString("pname")
 +"Price:"+rs1.getDouble("pprice")
 +"QTY:"+rs1.getInt("pqty"));
  }
 break;
}
}
else{
System.out.println("you are not authorize person !");
}
}
con.close();
scan.close();
}catch(Exception e){
e.printStackTrace();
}
}
}