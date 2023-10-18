package coding.mentor;

import java.util.Scanner;

import coding.mentor.data.Course;
import coding.mentor.data.User;
import coding.mentor.db.Database;
import coding.mentor.service.CourseService;
import coding.mentor.service.UserService;

public class Main {

	public static void main(String[] args) {
		System.out.println("Main Menu");
		System.out.println("1. Register ");
		System.out.println("2. Login");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose an option:");
		int userInput = scanner.nextInt();
		if (userInput == 1) {
			System.out.println("Input user id:");
			String id = scanner.next();
			System.out.println("Input password:");
			String password = scanner.next();
			System.out.println("Input name id:");
			String name = scanner.next();

			UserService userService = new UserService();
			userService.registerNewUser(id, password, name);
		}
//		for(int i = 0; i< Database.USERS_DB.size(); i++) {
//			System.out.println(Database.USERS_DB.get(i).getName());
//			Database.USERS_DB.get(i).getFailedCount();
//		}

		boolean result;
		do {
			System.out.println("Input user id:");
			String id = scanner.next();
			System.out.println("Input password:");
			String password = scanner.next();

			UserService userService = new UserService();
			result = userService.logIn(id, password);
			System.out.println(result);

			if (userService.logIn(id, password) == true) {
				CourseService courseService = new CourseService();
				Database.initDB();
				System.out.println("0.Your course");
				courseService.showAllCourses();
				System.out.println("Choose your option: ");
				userInput = scanner.nextInt();
				if (userInput == 0) {
					userService = new UserService();
					userService.showRegisteredCoursesByUser(id);
				}
				courseService = new CourseService();
				courseService.showCourseDetail(userInput);
				System.out.println("1. Register");
				System.out.println("2.No");
				System.out.println("3. View Mentor detail");
				int userInput1 = scanner.nextInt();
				if (userInput1 == 3) {
					courseService = new CourseService();
					courseService.showMentorByCourse(userInput);

				}
				if (userInput1 == 1) {

					userService = new UserService();
					userService.registerNewCourse(userInput, id);
					userService = new UserService();
					userService.showRegisteredCoursesByUser(id);

				}

			}
			if (userService.logIn(id, password) == false) {
				System.out.println("Incorrect id or password!");

			}

		} while (result == false);

	}

}
