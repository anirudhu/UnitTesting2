package test;
import org.junit.*;
import static org.junit.Assert.*;
import edu.worcester.cs.kwurst.*;
public class TestStudent
{
	private Grade grade;
	private Course course;
	/**
	 * setup() method is used to setup
	 * the Course and Grade objects
	 */
	@Before
	public void setup()
	{
		grade = new Grade("A");
		course = new Course("Computer Science", 5, "Data Structures", 4);
	}
	/**
	 * testID1 checks if the GetId correctly outputs the correct id
	 * for the student
	 */
	@Test
	public void testID1()
	{
		Student ani = new Student("Anirudh", "Upadhyayula");
		Student greg = new Student("Greg", "Tzkas");
		String aniId = ani.getId();
		String gregId = greg.getId();
		assertTrue(aniId.equals("0000001"));
		assertTrue(gregId.equals("0000002"));
	}
	
	/**
	 * testFirstName checks if the correct first name is returned
	 * for the student
	 */
	
	@Test
	public void testFirstName()
	{
		Student steve = new Student("Steve", "Nash");
		assertTrue(steve.getFirstName().equals("Steve"));
	}
	
	/**
	 * Checks if the getLastName and setLastName methods work correctly
	 */
	
	@Test
	public void testLastName()
	{
		Student amare = new Student("Amare", "Stoudemire");
		amare.setLastName("Nash");
		assertTrue(amare.getLastName().equals("Nash"));
	}
	
	/**
	 * Checks the getLetterGrade method to see if it
	 * returns the correct string representation of 
	 * the grade
	 */
	
	@Test
	public void testGrade()
	{
		assertTrue(grade.getLetterGrade().equals("A"));
	}
	/**
	 * Checks the getNumericGrade method to see if it
	 * returns the correct integer value of 
	 * the grade
	 */
	@Test
	public void testNumericGrade()
	{
		assertTrue(grade.getNumericGrade() == 4.0);
	}
	/**
	 * Checks the course object to see if it returns the
	 * correct department for that particular course
	 */
	@Test
	public void testDepartment()
	{
		assertTrue(course.getDepartment().equals("Computer Science"));
	}
	
	/**
	 * Checks to see if the correct credits are returned for
	 * that particular course
	 */
	
	@Test
	public void testCredits()
	{
		course.setCredits(5);
		assertTrue(course.getCredits() == 5);
	}
	
	/**
	 * Checks to see if the correct object returns the correct number
	 * for that particular course
	 */
	
	@Test
	public void testNumber()
	{
		assertTrue(course.getNumber() == 5);
	}
	
	/**
	 * Checks to see if the getCurrentRemainingCr() method
	 * returns the correct number of credits remaining based
	 * on the courses the student has taken so far
	 */
	
	@Test
	public void testCreditsRemaining()
	{
		Student ani = new Student("Ani", "Upadhyayula");
		ani.addCourse(course, "Spring", 2015, grade);
		assertTrue(ani.getCurrentRemainingCr() == 116);
	}
	
	/**
	 * Tests too see if the student met the requirements
	 * to graduate
	 */
	
	@Test
	public void testGraduation()
	{
		Student jason = new Student("Jason", "Richardson");
		Course course = new Course("Chemistry", 4, "Physics", 120);
		jason.setMajorComplete(true);
		jason.setLascComplete(true);
		jason.addCourse(course, "Fall", 2015, grade);
		assertTrue(jason.readyToGraduate());
	}
	
	/**
	 * Tests too see if the getTranscript() method
	 * contains a particular course that you have
	 * entered for that student
	 */
	
	@Test
	public void testTranscript()
	{
		Student sidhu = new Student("Sidhardh", "Upadhyayula");
		sidhu.addCourse(course, "Spring", 2018, grade);
		assertTrue(sidhu.getTranscript().contains("Data Structures"));
	}
}