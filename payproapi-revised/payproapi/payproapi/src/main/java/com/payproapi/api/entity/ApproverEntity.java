package com.payproapi.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "yugan_approver")
public class ApproverEntity {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "EmployeeID", nullable = false)
	    private int employeeId;

	    @Column(name = "FirstName", nullable = false)
	    private String firstName;

	    @Column(name = "LastName", nullable = false)
	    private String lastName;

	    @Column(name = "Department", nullable = false)
	    private String department;

	    @Column(name = "ManagerName", nullable = false)
	    private String managerName;

		public int getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getManagerName() {
			return managerName;
		}

		public void setManagerName(String managerName) {
			this.managerName = managerName;
		}
}