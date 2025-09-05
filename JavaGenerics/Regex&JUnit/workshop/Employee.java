package workshop;

public class Employee {
		private String name;
		private Email email;
		
		Employee(String name, Email email){
			set(name,email);
			
		}
		public void set(String name,Email email) {
			this.email=email;
			this.name=name;
		}
}
