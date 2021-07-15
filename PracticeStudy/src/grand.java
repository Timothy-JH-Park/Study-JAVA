class GrandParents {
    public void rideMethod() { System.out.println("GrandParants' rideMethod"); }
    public void loadMethod() { System.out.println("GrandParants' loadMethod"); }
}
class Parents extends GrandParents {
    public void rideMethod() { System.out.println("Parants' rideMethod"); }
    public void loadMethod(int n) { System.out.println("Parants' loadMethod"); }
}
class Child extends Parents {
    public void rideMethod() { System.out.println("Child's rideMethod"); }
    public void loadMethod(double n) { System.out.println("Child's loadMethod"); }
}