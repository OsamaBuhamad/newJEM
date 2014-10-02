import java.util.Date;
import java.util.EventObject;


public class CourseEvent extends EventObject {
	private Date midtermDate; 
   private Date assignmentDeadline;
	//Date midtermPostpone;
	boolean changed;
	

	public CourseEvent(Object source, boolean changed, Date d ) {
		super(source);
		// TODO Auto-generated constructor stub
		this.changed=changed;
		this.setAssignmentDeadline(d);
		
		if(!changed)
			this.setMidtermDate(d);
		else
			this.setMidtermDate(d);
		
	}

	
	
	
	public Date getMidtermDate() {
		return midtermDate;
	}

	public void setMidtermDate(Date midtermDate) {
		this.midtermDate = midtermDate;
	}
	

	public Date getAssignmentDeadline() {
		return midtermDate;
	}

	public void setAssignmentDeadline(Date assginmentDeadline) {
		this.assignmentDeadline = assginmentDeadline;
	}
	/**
	 * ??????????????????????
	 */
	private static final long serialVersionUID = 1L;

}
