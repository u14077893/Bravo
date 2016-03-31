package reporting;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int personID;

	private String emails;

	private String firstNames;

	private String surname;

	//bi-directional many-to-one association to Organization
	@ManyToOne
	@JoinColumn(name="OrganizationID")
	private Organization organization;

	//bi-directional many-to-one association to Researchercategory
	@ManyToOne
	@JoinColumn(name="ResearchCategoryID")
	private Researchercategory researchercategory;

	//bi-directional many-to-one association to Researchgroup
	@ManyToOne
	@JoinColumn(name="ResearchGroupID")
	private Researchgroup researchgroup;

	public Person() {
	}

	public int getPersonID() {
		return this.personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public String getEmails() {
		return this.emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getFirstNames() {
		return this.firstNames;
	}

	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Researchercategory getResearchercategory() {
		return this.researchercategory;
	}

	public void setResearchercategory(Researchercategory researchercategory) {
		this.researchercategory = researchercategory;
	}

	public Researchgroup getResearchgroup() {
		return this.researchgroup;
	}

	public void setResearchgroup(Researchgroup researchgroup) {
		this.researchgroup = researchgroup;
	}

}