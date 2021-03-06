package com.bestvike.linq.enumerable;

import com.bestvike.TestCase;
import com.bestvike.linq.Linq;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 许崇雷 on 2018-05-10.
 */
public class ReverseTest extends TestCase {
    @Test
    public void testReverse() {
        //null 在前,值相等的按原始顺序
        String s = Linq.asEnumerable(emps).concat(Linq.asEnumerable(badEmps))
                .orderBy(emp -> emp.deptno)
                .select(emp -> emp.name)
                .toList()
                .toString();
        assertEquals("[Gates, Fred, Eric, Janet, Bill, Cedric]", s);

        //reverse 与 orderByDescending 不同.reverse 是完全反序,orderByDescending  如果相等保持原始顺序
        String ss = Linq.asEnumerable(emps).concat(Linq.asEnumerable(badEmps))
                .orderBy(emp -> emp.deptno)
                .select(emp -> emp.name)
                .reverse()
                .toList()
                .toString();
        assertEquals("[Cedric, Bill, Janet, Eric, Fred, Gates]", ss);

        Character[] lst = Linq.asEnumerable(Arrays.asList('h', 'e', 'l', 'l', 'o')).reverse().toArray(Character.class);
        assertEquals(5, lst.length);
        assertEquals("h", lst[4].toString());

        Character[] arrChar = {'h', 'e', 'l', 'l', 'o'};
        Character[] arr = Linq.asEnumerable(arrChar).reverse().toArray(Character.class);
        assertEquals(5, arr.length);
        assertEquals("h", arr[4].toString());

        Character[] hello = Linq.asEnumerable("hello").reverse().toArray(Character.class);
        assertEquals(5, hello.length);
        assertEquals("h", hello[4].toString());

        Character[] h = Linq.singleton('h').reverse().toArray(Character.class);
        assertEquals(1, h.length);
        assertEquals("h", h[0].toString());

        Character[] empty = Linq.<Character>empty().reverse().toArray(Character.class);
        assertEquals(0, empty.length);
    }
}
