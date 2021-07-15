
class RideLoad {
	public static void main(String[] args) {
    		GrandParents ref1 = new Child();
        	Parents ref2 = new Child();
        	Child ref3 = new Child();

    		ref1.rideMethod();	// Child.rideMethod() 호출
        	ref2.rideMethod();	// Child.rideMethod() 호출
        	ref3.rideMethod();	// Child.rideMethod() 호출
            
        	ref1.loadMethod(); 	// GrandParents.loadMethod() 호출
    	  	ref2.loadMethod(1); 	// Parents.loadMethod(int n) 호출
	        ref3.loadMethod(1.2); 	// Child.loadMethod(double n) 호출     
 	}
}