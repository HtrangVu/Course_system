package coding.mentor.service;

import java.util.ArrayList;

import coding.mentor.data.Course;
import coding.mentor.data.User;
import coding.mentor.db.Database;

public class UserService {

	public void registerNewUser(String id, String password, String name) {
		User user = new User(id, password, name);

		// validate if id is existed or not
		for (int i = 0; i < Database.USERS_DB.size(); i++) {
			if (user.getId() == Database.USERS_DB.get(i).getId()) {
				break;
			}
			System.out.println("Id existed. Please choose a different id!");

		}
		Database.USERS_DB.add(user);

	}

	public boolean logIn(String id, String password) {
		for (int i = 0; i < Database.USERS_DB.size(); i++) {
			if (id.equals(Database.USERS_DB.get(i).getId())
					&& password.equals(Database.USERS_DB.get(i).getPassword())) {
				return true;

			}

		}
		return false;

	}

	public void showRegisteredCoursesByUser(String userId) {

		// Take userId input then find userIndex
		for (int i = 0; i < Database.USERS_DB.size(); i++) {
			if (Database.USERS_DB.get(i).getId().equals(userId)) {
				for (Course RegisteredCourses : Database.USERS_DB.get(i).getRegisteredCourses()) {
					System.out.println("Courses registered: " + RegisteredCourses.getName());

				}

			}
		}

	}

	public void registerNewCourse(int courseId, String userId) {
		ArrayList<Course> registeredCourses = new ArrayList<Course>();

		registeredCourses.add(Database.COURSES_DB.get(courseId - 1));

		for (int i = 0; i < Database.USERS_DB.size(); i++) {
			if (userId.equals(Database.USERS_DB.get(i).getId())) {

				Database.USERS_DB.get(i).setRegisteredCourses(registeredCourses);
				System.out.println("Registered sucessfully");

			}

		}

	}

}
