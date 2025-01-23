//Interface -- 
package com.vis.bookapp;

import java.util.List;

public interface IBookService {
	List<String>getAll();

}

//BookServiceImpl implementsIbookService
package com.vis.bookapp;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService{

	@Override
	public List<String> getAll() {
		// TODO Auto-generated method stub
		return List.of("All about mutual funds","the Secret");
	}

}

//BookMain Class
package com.vis.bookapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new AnnotationConfigApplicationContext("com.vis");
		String[] beanNames=context.getBeanDefinitionNames();
		for(String bean:beanNames)
		{
			System.out.println(bean);
		}
		
		IBookService bookService=(IBookService) context.getBean("bookServiceImpl");
		bookService.getAll().forEach(System.out::println);
	}

}
