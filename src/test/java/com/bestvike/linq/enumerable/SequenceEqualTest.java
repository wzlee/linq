package com.bestvike.linq.enumerable;

import com.bestvike.TestCase;
import com.bestvike.collections.generic.IEqualityComparer;
import com.bestvike.linq.Linq;
import com.bestvike.linq.entity.Employee;
import org.junit.Test;

import java.util.List;

/**
 * Created by 许崇雷 on 2018-05-10.
 */
public class SequenceEqualTest extends TestCase {
    @Test
    public void testSequenceEqual() {
        List<Employee> list = Linq.asEnumerable(emps).toList();

        assertTrue(Linq.asEnumerable(list).sequenceEqual(Linq.asEnumerable(emps)));
    }

    @Test
    public void testSequenceEqualWithComparer() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {11, 12, 13};

        IEqualityComparer<Integer> comparer = new IEqualityComparer<Integer>() {
            @Override
            public boolean equals(Integer x, Integer y) {
                return x % 10 == y % 10;
            }

            @Override
            public int hashCode(Integer obj) {
                return obj % 10;
            }
        };

        assertTrue(Linq.asEnumerable(array1).sequenceEqual(Linq.asEnumerable(array2), comparer));
    }
}
