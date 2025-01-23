//Employee.java
package com.vis.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Employee {

	private String employeeName;
	
	@Value("${employee.empname}")
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String greet()
	{
		return "WELCOME - "+employeeName;
	}
}

//empMain.java
package com.vis.training;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class empMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com.vis");
		  String[] beanNames=context.getBeanDefinitionNames();
		  Employee employee=(Employee)context.getBean("employee");
		  for(String g:beanNames)
		  {
			  System.out.println(g);
		  }
		  System.out.print(employee.greet());
		   
	}

}

