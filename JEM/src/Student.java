/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;

public class Student implements CourseListener{
	private String name;
	private Date midterm;

	public Student(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void study(Date date){
		this.midterm = date;
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
	}
	
	public void party(Date date){
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}
	
	public void relax(Date date){
		this.midterm = date;
		System.out.println(name + " : Oh! I get to relax since my assignment is deadline isn't until " + this.midterm);
	}

	@Override
	public void midtermAnnounced(CourseEvent e) {
		// TODO Auto-generated method stub
		this.study(e.getMidtermDate());
		
	}
	
	@Override
	public void midtermPostponed(CourseEvent e) {
		// TODO Auto-generated method stub
		this.party(e.getMidtermDate());
	}

	@Override
	public void assignmentPostponed(CourseEvent e) {
		// TODO Auto-generated method stub
		this.relax(e.getAssignmentDeadline());
		
	}

	
}
