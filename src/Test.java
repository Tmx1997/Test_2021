import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 梦霄
 * @Date: 2021/4/15
 * @Time: 20:44
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Test extends SortTest implements Com{
	String name=new String("Tom");
	int age=0;
	public static void changeTest(Test test){
		HashMap map= (HashMap) Collections.synchronizedMap(new HashMap<>());
		Test t=new Test();
		WeakReference reference=new WeakReference(new Test());
		t.name.intern();
		t.age=1;
		t.name="jack";
		test.age=2;
		test.name="alice";
		System.out.println("change: "+t.toString());
	}

	public static void main(String[] args) {
		Test test=new Test();
		changeTest(test);
		System.out.println("test:"+test.toString());
	}

	@Override
	public String toString() {
		return "Test{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	@Override
	public int f() {
		return 100+M;
	}
}
