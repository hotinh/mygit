package cn.cc.mytest.java8.learn05Js;

import javax.script.*;

public class Test {

	public static void main(String[] args) throws ScriptException {
		// TODO Auto-generated method stub

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName( "JavaScript" );
		         
		System.out.println( engine.getClass().getName() );
		System.out.println( "Result:" + engine.eval( "function f() { return 1; }; f() + 2;" ) );
	}

}
