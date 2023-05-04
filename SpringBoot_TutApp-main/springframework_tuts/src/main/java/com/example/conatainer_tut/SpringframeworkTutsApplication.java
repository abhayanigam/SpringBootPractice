package com.example.conatainer_tut;

import com.example.conatainer_tut.ambiguitytut.AddVar;
import com.example.conatainer_tut.autowireannotut.EmployeeAutoAnno;
import com.example.conatainer_tut.autowiretut.EmployeeAuto;
import com.example.conatainer_tut.collectionsconfig.Employees;
import com.example.conatainer_tut.constructorconfig.Person;
import com.example.conatainer_tut.javaconfigwithoutxml.Example;
import com.example.conatainer_tut.javaconfigwithoutxml.JavaConfig;
import com.example.conatainer_tut.lifecycle.LifeCycle;
import com.example.conatainer_tut.lifecycle.LifeCycleUsingAnnotations;
import com.example.conatainer_tut.lifecycle.LifeCycleUsingInterface;
import com.example.conatainer_tut.objeconfig.Student;
import com.example.conatainer_tut.objrefers.ReferenceObjs;
import com.example.conatainer_tut.qualifierannowithautowire.EmployeeQualifier;
import com.example.conatainer_tut.standalonecollection.Human;
import com.example.conatainer_tut.stereotypeanno.StereoStudent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringframeworkTutsApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringframeworkTutsApplication.class, args);

		// ClassPathXmlApplicationContext will read files from your classpath.
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		Student student1 = (Student) context.getBean("student1");
		System.out.println(student1);


		//Collections xml
		ApplicationContext context1 = new ClassPathXmlApplicationContext("collections-config.xml");

		Employees employees = (Employees) context1.getBean("emp1");
		System.out.println("Name : " + employees.getName());
		System.out.println("Phone Numbers : " + employees.getPhones());
		System.out.println("Type of list : " + employees.getPhones().getClass().getName());
		System.out.println("Address : " + employees.getAddresses());
		System.out.println("Courses : " + employees.getCourses());

		//Object Reference
		ApplicationContext context2 = new ClassPathXmlApplicationContext("ref-config.xml");

		ReferenceObjs referenceObjs = (ReferenceObjs) context2.getBean("obj1_ref");
		System.out.println("Value of x in Object A : " + referenceObjs.getX());
		System.out.println("Value of y in Object Y : " + referenceObjs.getObj().getY());
		System.out.println(referenceObjs);

		//Constructor injection
		ApplicationContext context3 = new ClassPathXmlApplicationContext("constructor-config.xml");

		Person person = (Person) context3.getBean("person");
		System.out.println(person);

		//Ambiguity Problem Constructor
		ApplicationContext context4 = new ClassPathXmlApplicationContext("ambi-constructor-config.xml");

		AddVar addVar = (AddVar) context4.getBean("add");
		addVar.doSum();

		//Life Cycle Method 1:
		//Abstract application context is used because we want to use the destroy method
		AbstractApplicationContext context5 = new ClassPathXmlApplicationContext("lifecycle-config.xml");

		LifeCycle lifeCycle = (LifeCycle) context5.getBean("life_cycle");
		System.out.println(lifeCycle);

		context5.registerShutdownHook(); // this will tell the program to destroy the code now.

		//Life Cycle Method 2 using interfaces:
		LifeCycleUsingInterface lifeCycleSec = (LifeCycleUsingInterface) context5.getBean("life_cycle_sec");
		System.out.println(lifeCycleSec);

		//Life Cycle Method 3 using annotations:
		LifeCycleUsingAnnotations lifeCycleUsingAnnotations = (LifeCycleUsingAnnotations)
				context5.getBean("life_cycle_anno");
		System.out.println(lifeCycleUsingAnnotations);

		/*
			Autowiring
		 	- Feature of spring framework in which spring container inject the dependencies automatically.
		 	- Automatically can't be used to inject primitive and string values. It works with reference only.
		 		(work with object)

						[A] ----> [B]
					Manually	 Automatically
				 <ref bean=""/>	  @Autowired

		 		Autowiring :
		 					-- XML
		 							-> Autowiring Modes
		 									> no modes (That are not enabled by defaults)
		 									> byName (Beans name)
		 									> byType
		 									> Constructor
		 				    -- Annotation
		 				    		-> @Autowired

		 		Autowiring Advantages:
		 			> Automatic
		 			> less code

				Autowiring Disadvantages:
					> No control of programmer.
					> It can't be used for primitive and string values.
		*/

		ApplicationContext context6 = new ClassPathXmlApplicationContext("autowire-config.xml");
		EmployeeAuto emp = context6.getBean("emp",EmployeeAuto.class);
		System.out.println("Autowiring through xml file : \n" + emp);

		// Autowire annotation using @
		ApplicationContext context7 = new ClassPathXmlApplicationContext("autowire-anno-config.xml");
		EmployeeAutoAnno employee = context7.getBean("emp", EmployeeAutoAnno.class);
		System.out.println("Autowiring using annotation : \n" + employee);

		// Qualifier annotation with autowire
		ApplicationContext context8 = new ClassPathXmlApplicationContext("qualifier-with-autowire-anno-config.xml");
		EmployeeQualifier emp1 = context8.getBean("employee", EmployeeQualifier.class);
		System.out.println("Qualifier with Autowiring using annotation : \n" + emp1);

		// Standalone Collection Config
		ApplicationContext context9 = new ClassPathXmlApplicationContext("standalone-collections-config.xml");
		Human human = context9.getBean("human",Human.class);
		System.out.println("Standalone Collection : \n" + human);
		System.out.println("Type of list : " + human.getFriends().getClass().getName());

		// Stereotype Annotation (basically working with annotations without working in xml file or bean).
		ApplicationContext context10 = new ClassPathXmlApplicationContext("stereo-config.xml");
		StereoStudent stereoStudent = context10.getBean(/*"ob"*/"stereoStudent",StereoStudent.class);
		System.out.println(stereoStudent);

		// Removing Complete XML for Spring Configuration by using annotations
		ApplicationContext context11 = new AnnotationConfigApplicationContext(JavaConfig.class);
			// Example example = context11.getBean("student",Example.class);
		Example example = context11.getBean("getExample",Example.class);
		System.out.println(example);
		example.run();
	}
}
