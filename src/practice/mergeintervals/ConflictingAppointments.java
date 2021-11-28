package practice.mergeintervals;

import java.util.*;

class ConflictingAppointmentInterval {
  int start;
  int end;

  public ConflictingAppointmentInterval(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class ConflictingAppointments {

  public static boolean canAttendAllAppointments(ConflictingAppointmentInterval[] intervals) {
    // sort the intervals by start time
    Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

    // find any overlapping appointment
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start < intervals[i - 1].end) {
        // please note the comparison above, it is "<" and not "<="
        // while merging we needed "<=" comparison, as we will be merging the two
        // intervals having condition "intervals[i].start == intervals[i - 1].end" but
        // such intervals don't represent conflicting appointments as one starts right
        // after the other
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
	
	ConflictingAppointmentInterval[] intervals = { new ConflictingAppointmentInterval(1, 4), new ConflictingAppointmentInterval(2, 5), new ConflictingAppointmentInterval(7, 9) };
    boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
    System.out.println("Can attend all appointments: " + result);

    ConflictingAppointmentInterval[] intervals1 = { new ConflictingAppointmentInterval(6, 7), new ConflictingAppointmentInterval(2, 4), new ConflictingAppointmentInterval(8, 12) };
    result = ConflictingAppointments.canAttendAllAppointments(intervals1);
    System.out.println("Can attend all appointments: " + result);

    ConflictingAppointmentInterval[] intervals2 = { new ConflictingAppointmentInterval(4, 5), new ConflictingAppointmentInterval(2, 3), new ConflictingAppointmentInterval(3, 6) };
    result = ConflictingAppointments.canAttendAllAppointments(intervals2);
    System.out.println("Can attend all appointments: " + result);
  }
}
