
class RideLoad {
	public static void main(String[] args) {
    		GrandParents ref1 = new Child();
        	Parents ref2 = new Child();
        	Child ref3 = new Child();

    		ref1.rideMethod();	// Child.rideMethod() ȣ��
        	ref2.rideMethod();	// Child.rideMethod() ȣ��
        	ref3.rideMethod();	// Child.rideMethod() ȣ��
            
        	ref1.loadMethod(); 	// GrandParents.loadMethod() ȣ��
    	  	ref2.loadMethod(1); 	// Parents.loadMethod(int n) ȣ��
	        ref3.loadMethod(1.2); 	// Child.loadMethod(double n) ȣ��     
 	}
}