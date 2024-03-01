import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class S1_StreamsTest {
	@Test
	public void Test1() {
		List<String> lst = new ArrayList<String>();
		lst.add("Abc");
		lst.add("Bcd");
		lst.add("Adb");
		lst.add("Aaa");
		lst.add("Ddd");
		System.out.println("-->Test1<--");
		long x = lst.stream().filter(s->s.startsWith("A")).count();
		System.out.println(x);
	}
	
	@Test
	public void Test2() {
		long y = Stream.of("One","Two","Three","Four","Five").filter(s->{
			s.startsWith("A");
			return false;
		}).count();
		System.out.println("-->Test2<--");
		System.out.println(y);
	}
	
	@Test
	public void Test3() {
		List<String> lst = new ArrayList<String>();
		lst.add("Abcd");
		lst.add("Bcd");
		lst.add("Adb");
		lst.add("Aaae");
		lst.add("Ddd");
		System.out.println("-->Test3<--");
		lst.stream().filter(s->s.length()>3).forEach(s->System.out.println(s));
		lst.stream().filter(s->s.length()>3).limit(1).forEach(s->System.out.println(s));
	}
	
	@Test
	public void Test4() {
		List<String> lst = new ArrayList<String>();
		lst.add("Abcd");
		lst.add("Bcd");
		lst.add("Adb");
		lst.add("Aaae");
		lst.add("Ddd");
		System.out.println("-->Test4<--");
		lst.stream().filter(s->s.endsWith("d")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		lst.stream().filter(s->s.startsWith("A")).map(s->s.replaceFirst("A","Z")).sorted().forEach(s->System.out.println(s));
	}
	
	@Test
	public void Test5() {
		List<String> lst = new ArrayList<String>();
		lst.add("Abcd");
		lst.add("Bcd");
		lst.add("Adb");
		lst.add("Aaae");
		lst.add("Ddd");
		List<String> lst2 = new ArrayList<String>();
		lst.add("Abcd");
		lst.add("Bcd");
		lst.add("Adb");
		lst.add("Aaae");
		lst.add("Ddd");
		Stream<String> newStr = Stream.concat(lst.stream(), lst2.stream());
		Stream<String> newStr1 = Stream.concat(lst.stream(), lst2.stream());
		System.out.println("-->Test5<--");
		newStr.filter(s->s.endsWith("d")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		boolean b1 = newStr1.anyMatch(s->s.contains("asdas"));
		System.out.println(b1);
		Assert.assertEquals(b1, false);
	}
	
	@Test
	public void Test6() {
		String[] str = {"One","Two","Three","Four","Five"};
		List<String> lst = Arrays.asList(str);
		List<String> lst2 = lst.stream().filter(s->s.endsWith("e")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println("-->Test6<--");
		lst2.stream().limit(1).forEach(s->System.out.println(s));
	}
	
	@Test
	public void Test7() {
		List<Integer> lst = Arrays.asList(1,12,99,12,22,55,2,3,4,5,4,6,7,2);
		System.out.println("-->Test7<--");
		lst.stream().distinct().sorted().forEach(s->System.out.println(s));
	}
}
