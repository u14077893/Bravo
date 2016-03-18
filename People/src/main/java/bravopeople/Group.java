package bravopeople;

class Group {
	private String name;
	private ArrayList<Entity> entities;		// Composite Pattern

	public Group() {
		this.name = "MockGroup";
		this.entities = new ArrayList<Entity>();
	}
	// Basic constructor
	public Group(String name, ArrayList<Entity> entities) {
		this.name = name;
		this.entities = entities;
	}

	public String getName() { return name; }
	public ArrayList<Entity> getEntities() { return entities; }

	public void setName(String name) {
		this.name = name;
	}	

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
