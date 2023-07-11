package com.spring.orm;
import com.spring.orm.dao.StudentDao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.channels.NonWritableChannelException;
import java.util.List;

import javax.management.remote.SubjectDelegationPermission;
import javax.xml.transform.Source;

import org.hibernate.type.IntegerType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    	StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
       
//       Student student =new Student(123,"Khan","Ctg");
//       int r=studentDao.insert(student);
//       System.out.println(r);
    	
    	BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
    	
    	boolean go=true;
    	while(go) {
    		System.out.println("Press 1 to Insert");
        	System.out.println("Press 2 to get single data");
        	System.out.println("Press 3 to get multiple data");
        	System.out.println("Press 4 to Update");
        	System.out.println("Press 5 to Delete");
        	System.out.println("Press 6 to Exit");

        	
        	try {
        		int input=Integer.parseInt(br.readLine());
        		
        		switch (input) {
				case 1:
					System.out.println("Enter your ID:");
					int uId=Integer.parseInt(br.readLine());
					
					System.out.println("Enter your Name:");
					String uName=br.readLine();
					
					System.out.println("Enter your City:");
					String uCity=br.readLine();
					
					//create student object
					Student student=new Student();
					student.setStudentId(uId);
					student.setStudentCity(uCity);
					student.setStudentName(uName);
					
					int r=studentDao.insert(student);
					System.out.println("Student Added!");
					System.out.println("-----------------");
					break;

				case 2:
					System.out.println("Enter your ID:");
					int userId=Integer.parseInt(br.readLine());
					
					Student ssStudent=studentDao.getStudent(userId);
					System.out.println("Id:"+ ssStudent.getStudentId());
					System.out.println("Name:"+ ssStudent.getStudentName());
					System.out.println("City:"+ ssStudent.getStudentCity());
					System.out.println();
					
					
					break;
					
					
				case 3:
					System.out.println("-----------------");
					List<Student> students=studentDao.getAllStudents();
					for(Student st:students) {
						System.out.println("Id:"+ st.getStudentId());
						System.out.println("Name:"+ st.getStudentName());
						System.out.println("City:"+ st.getStudentCity());
					}
					System.out.println("-----------------");
					break;
					
				case 4:
					System.out.println("-----------------");
					System.out.println("Enter your ID:");
					int upId=Integer.parseInt(br.readLine());
					
					System.out.println("Enter your Name:");
					String upName=br.readLine();
					
					System.out.println("Enter your City:");
					String upCity=br.readLine();
					
					//create student object
					Student upStudent=new Student();
					upStudent.setStudentId(upId);
					upStudent.setStudentCity(upCity);
					upStudent.setStudentName(upName);
					
					studentDao.update(upStudent);
					System.out.println("Student Updated!");
					System.out.println("-----------------");
					System.out.println("-----------------");

					break;
				case 5:
					System.out.println("-----------------");

					System.out.println("Enter your ID:");
					int id=Integer.parseInt(br.readLine());
					studentDao.delete(id);
					System.out.println("Student Delted!");

					System.out.println("-----------------");

					break;
				
				case 6:
					go=false;
					break;
				}
				
			} catch (Exception e) {
				System.out.println("Invalid Option!! Try another one");
				System.out.println(e.getMessage());
			}
    	}
    	System.out.println("Thank your for using this application");
    	
    	
    }
}


















