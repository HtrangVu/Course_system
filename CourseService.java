package coding.mentor.service;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.db.Database;

public class CourseService {
	public void showAllCourses() {
		for (int i = 0; i < Database.COURSES_DB.size(); i++) {
			System.out.print((i + 1) + ". " + Database.COURSES_DB.get(i).getName());
			for (Mentor teachingMentor : Database.COURSES_DB.get(i).getTeachingMentors()) {
				System.out.print(" --" + teachingMentor.getName());

			}
			System.out.println();

		}

	}

	public void showCourseDetail(int id) {

		System.out.println("Course name: " + Database.COURSES_DB.get(id - 1).getName());
		System.out.println("Begin date: " + Database.COURSES_DB.get(id - 1).getBegin());
		System.out.println("End date: " + Database.COURSES_DB.get(id - 1).getEnd());
		System.out.println("Fee: " + Database.COURSES_DB.get(id - 1).getFee());
		System.out.print("Mentor: ");
		for (Mentor teachingMentor : Database.COURSES_DB.get(id - 1).getTeachingMentors()) {
			System.out.print("  " + teachingMentor.getName());

		}
		System.out.println();

	}

	public void showMentorByCourse(int courseId) {

		for (Mentor teachingMentor : Database.COURSES_DB.get(courseId - 1).getTeachingMentors()) {
			System.out.println("Mentor name: " + teachingMentor.getName());
			System.out.println("Mentor email: " + teachingMentor.getEmail());
			System.out.println("Mentor phone number: " + teachingMentor.getPhone());
		}

	}

}
