package pro1.pro2.service;
import java.util.ArrayList;
import java.util.List;

import pro1.pro2.datamodel.*;
public class RegisterService {
	StudentsService ss = new StudentsService();
	CoursesService cs = new CoursesService();
	public Student addCourses(List<Course> courses,String studentId) {
		System.out.println("student id in register service"+studentId);
		System.out.println("courses");
		for(Course course: courses) {
			System.out.println(course.getCourseId());
		}
		Student stu = ss.getStudent(studentId);
		for(Course course: courses) {
		    Course courseInDatabase = cs.getCourse(course.getCourseId());
		    cs.subscribe(stu,course);
		    if(stu.getRegisteredCourses() == null) {
		    	stu.setRegisteredCourses(new ArrayList<String>());
		    }
		    if(stu.getRegisteredCourses().size()==3) break;
			stu.getRegisteredCourses().add(course.getCourseId());
			if(courseInDatabase.getRosters() == null) {
				courseInDatabase.setRosters(new ArrayList<String>());
			}
			courseInDatabase.getRosters().add(studentId);
		}
		return stu;
	}
}
