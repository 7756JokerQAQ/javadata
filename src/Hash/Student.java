package Hash;

import java.util.Objects;

public class Student {
    int grade;
    int cls;
    String firstName;
    String lastName;

    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return grade == student.grade && cls == student.cls && Objects.equals(firstName.toLowerCase(), student.firstName.toLowerCase())
                && Objects.equals(lastName.toLowerCase(), student.lastName.toLowerCase());
    }

    @Override
    public int hashCode() {
      int B=31;
      int hash=0;
      //可能产生整形的溢出
      hash=hash*B+grade;
      hash=hash*B+cls;
      hash=hash*B+firstName.toLowerCase().hashCode();
      hash=hash*B+lastName.toLowerCase().hashCode();
      return hash;
    }
}
