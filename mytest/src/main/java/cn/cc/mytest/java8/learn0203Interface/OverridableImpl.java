package cn.cc.mytest.java8.learn0203Interface;

public class OverridableImpl implements Defaulable {
	
	@Override
    public String notRequired() {
        return "Overridden implementation";
    }

	public static void main(String[] args) {
		System.out.println( new OverridableImpl().notRequired() );
	}

}
