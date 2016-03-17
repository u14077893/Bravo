package bravopeople;

import java.util.Date;


class ResearchGroupAssociation {
	private Date startDate;
	private Date endDate;		// [0..1]
	private ResearchGroupAssociationType role;
	private Group group;
	private enum ResearchGroupAssociationType {		
		STUDENT, COLLABORATOR, MEMBER, GROUPLEADER
	}
	
	// Dummy default constructor
	public ResearchGroupAssociation() {
		this.startDate = new Date();		// This will need to be converted before adding to database
		this.endDate = null;
		this.role = ResearchGroupAssociationType.MEMBER;
		this.group = new Group("DTG");
	}
	
	public ResearchGroupAssociation(Date startDate, Group group, String role) {
		this.startDate = startDate;
		this.endDate = null;
		this.group = group;

		String s = role.toUpperCase();
		if (s.equals("STUDENT")) {
			this.role = ResearchGroupAssociationType.STUDENT;

		} else if (s.equals("COLLABORATOR")) {
			this.role = ResearchGroupAssociationType.COLLABORATOR;

		} else if (s.equals("MEMBER")) {
			this.role = ResearchGroupAssociationType.MEMBER;

		} else if (s.equals("GROUPLEADER")) {
			this.role = ResearchGroupAssociationType.GROUPLEADER;

		} else {
			this.role = ResearchGroupAssociationType.STUDENT;
		}
	} // End of Constructor

	/*
	 * Getters
	 */
	
	public Date getStartDate() { return startDate; }
	public Date getEndDate() { return endDate; }						// Can return null
	public ResearchGroupAssociationType getRole() { return role; }
	public Group getGroup() { return group; }
	
	/*
	 * Setters
	 */
	
	public void setStartDate(Date startDate) {
		if (startDate != null)
			this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		if (endDate != null)
			this.endDate = endDate;
	}

	public void setRole(String role) {
		String s = role.toUpperCase();
		if (s.equals("STUDENT")) {
			this.role = ResearchGroupAssociationType.STUDENT;

		} else if (s.equals("COLLABORATOR")) {
			this.role = ResearchGroupAssociationType.COLLABORATOR;

		} else if (s.equals("MEMBER")) {
			this.role = ResearchGroupAssociationType.MEMBER;

		} else if (s.equals("GROUPLEADER")) {
			this.role = ResearchGroupAssociationType.GROUPLEADER;

		} else {
			this.role = ResearchGroupAssociationType.STUDENT;
		}
	}

	public void setGroup(Group group) {
		if (group != null)
			this.group = group;
	}
}	// End of ResearchGroupAssociation class
