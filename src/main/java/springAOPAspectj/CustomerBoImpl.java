package springAOPAspectj;

public class CustomerBoImpl {
	
	@Profiling
	protected  void addCustomer(){
		System.out.println("addCustomer() is running ");
		//this.addCustomerReturnValue();
	}
	@Profiling
	public String addCustomerReturnValue(){
		System.out.println("addCustomerReturnValue() is running ");
		return "abc";
	}
	
	protected void addCustomerThrowException() throws Exception {
		System.out.println("addCustomerThrowException() is running ");
		throw new Exception("Generic Error");
	}
	
	protected void addCustomerAround(String name){
		System.out.println("addCustomerAround() is running, args : " + name);
	}
}
