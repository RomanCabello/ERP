package bean;

import java.util.Objects;

public class Staff {

	private Long id;
	
	private String Fname;
	
	private String Lname;
	
	private int salary;
	
//	private String area;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

//	public String getArea() {
//		return area;
//	}
//
//	public void setArea(String area) {
//		this.area = area;
//	}
	
	@Override
	
	public boolean equals(Object obj)
	{
		
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass())
		{
			return false;
		}
		
		final Staff other = (Staff) obj;
		if (this.salary != other.salary) {
			return false;
			
		}
		
		if(!Objects.deepEquals(this.Fname, other.Fname)) {
			return false;
		}
		
		return Objects.equals(this.id, other.id);
	}
	
}
