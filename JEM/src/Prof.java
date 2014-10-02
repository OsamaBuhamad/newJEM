/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prof {
	private String name;
	private Date midtermDate;
	private Date assignDeadline;
//	private ArrayList<Student> students;
//	private TeachingAssistant ta;
	
	//adding a list of Listeners 
	private static List <CourseListener> courseListeners ;  

	public Prof(String aName) {
		this.name = aName;
		//this.students = new ArrayList<Student>();
		setCourseListeners(new ArrayList <CourseListener>());
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date) {
		this.midtermDate = date;
		/*
		for(Student s: this.students){
			s.study(date);
		}
		ta.proctor(date);
		*/
		boolean changed = false;
		CourseEvent e = new CourseEvent(this, changed, midtermDate);
		
		for (CourseListener cl: courseListeners) {
			cl.midtermAnnounced(e);
		}

	}
	
	public void postponeMidterm(Date date){
		this.midtermDate = date;
		/*
		for(Student s: this.students){
			s.party(date);
		}
		ta.postpone(date);
		*/
		
		boolean changed = true;
		CourseEvent e = new CourseEvent(this, changed, midtermDate);
		
		for (CourseListener cl: courseListeners) {
			cl.midtermPostponed(e);
		}
	}
	
	public void assignDeadline(Date date){
		this.assignDeadline=date;
		boolean changed = false;
		CourseEvent e = new CourseEvent(this, changed, midtermDate);
		for (CourseListener cl: courseListeners) {
			cl.assignmentPostponed(e);
		}
		
	}
	
	
//	public void setTA(TeachingAssistant theTA){
//		this.ta = theTA;
//	}
//	
//	public void addStudent(Student s){
//		this.students.add(s);
//	}
//	
	//------------------------------------------------------
	//the new methods from Listener 
	//public static void addCourseListener (CourseListener c)
	//{
	//	getCourseListeners().add(c);
//	}
	
	 public synchronized static void addCourseListener (CourseListener cl){
			courseListeners.add(cl);
		}

	
	 public synchronized void removeCourseListener (CourseListener cl) {
			courseListeners.remove(cl);
		}

//	public void removeCourseListener (CourseListener c)
//	{
	//	if(getCourseListeners() != null)
	//	Prof.getCourseListeners().remove(c); 
		
	//}

	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
	
		//p.addStudent(s);
		//p.addStudent(s2);
		//p.setTA(ta);
		
		addCourseListener(s);
		addCourseListener(s2);
		addCourseListener(ta);
		
		Date midterm = new Date();
		Date assignment = new Date();
		
		p.setMidterm(midterm);
		
		System.out.println();
		
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
		
		System.out.println();
		
		p.assignDeadline(assignment);
	}

	public static List <CourseListener> getCourseListeners() {
		return courseListeners;
	}

	public static void setCourseListeners(List <CourseListener> courseListeners) {
		Prof.courseListeners = courseListeners;
	}

}
