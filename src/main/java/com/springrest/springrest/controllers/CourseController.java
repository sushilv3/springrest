package com.springrest.springrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
@CrossOrigin
public class CourseController {
	@Autowired
	private CourseService courseService;
	
//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return this.courseService.getCourses();
		
	}

	//get the single courses
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Integer.parseInt(courseId));
	}
	//add new course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseService.addCourse(course);
	}
	//update course
	@PutMapping("courses")
	public String updateCourse(@RequestBody Course course) {
		
		return this.courseService.updateCourse(course);
	}
	
	//delete course
	@DeleteMapping("/courses/{courseId}")
	public String deleteCourse(@PathVariable String courseId) {
		return this.courseService.deleteCourse(Integer.parseInt(courseId));
		
	}
}
