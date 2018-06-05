import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Daniel
 * @date 04/06/2018
 */
public class MergeIntervalsTest {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));


        merge(list).forEach(p ->
                System.out.println(p.toString()));
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));

        List<Interval> list = new ArrayList<>();


        // TODO: 04/06/2018
        for (int i = 0; i < intervals.size(); i++) {
            if (list.isEmpty()) {
                list.add(intervals.get(i));
                continue;
            }

            Interval lastInterval = list.get(list.size() - 1);

            if (intervals.get(i).start >= lastInterval.start && intervals.get(i).end <= lastInterval.end) {
                continue;
            }

            if (intervals.get(i).start > lastInterval.end) {
                list.add(intervals.get(i));
                continue;
            }

            if ((intervals.get(i).start >= lastInterval.start && intervals.get(i).end >= lastInterval.end) || intervals.get(i).start == lastInterval.end) {
                lastInterval.end = intervals.get(i).end;
                continue;
            }


        }

        return list;
    }

    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }


}

