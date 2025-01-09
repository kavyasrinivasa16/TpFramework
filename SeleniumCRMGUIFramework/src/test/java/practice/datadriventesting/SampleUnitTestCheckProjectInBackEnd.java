package practice.datadriventesting;

import static org.testng.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;



public class SampleUnitTestCheckProjectInBackEnd {
	@Test
	public void projectname() throws SQLException 
	{
		String expectedprojectname = "ajio";
		boolean flag  =  false;
		
		//step1: load/register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2: connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("====done====");
		
		//step3 create sql statement
		Statement stat = conn.createStatement();
		
		//step4 execute select query and get result
		ResultSet resultset = stat.executeQuery("select* from project");
		
		while(resultset.next())
		{
			String actprojectname = resultset.getString(4);
			if(expectedprojectname.equals(actprojectname))
			{
				flag=true;
				System.out.println(expectedprojectname+"is available==PASS");
			}
		}
		if(flag==false)
		{
			System.out.println(expectedprojectname+"is notavailable==FAIL");
			Assert.fail();
		}
		conn.close();
		
	}
	

}
