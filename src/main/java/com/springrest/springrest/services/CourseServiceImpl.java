package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;

	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(145, "Java Fundamentals", "this course contain Java basic"));
		list.add(new Course(146, "React", "this course contain react basic"));
	}

	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(Integer courseId) {
//		Course c = null;
//		for(Course course : list) {
//			if(course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
//		return c;
		Course getCourse = list.stream().filter(c -> c.getId().equals(courseId)).findAny().orElse(new Course());
		return getCourse;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		System.out.println("INSIDE ADD_COURSE METHOD ");
		return course;
	}

	@Override
	public String updateCourse(Course course) {
		int getId = course.getId();
		Course getCourse = getCourse(getId);
		if(getCourse !=null) {
			String title = course.getTitle();
			String desc = course.getDescription();
			getCourse.setTitle(title);
			getCourse.setDescription(desc);
			return "Course Updated";
		}
		return "This Course Doesn't exist";
	}

	@Override
	public String deleteCourse(Integer courseId) {
		Course getCourse = getCourse(courseId);
	String msg = (list.remove(getCourse)) ? "course deleted" : "Course Doesn't exist";
		return msg;
	}

}
