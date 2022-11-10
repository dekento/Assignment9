import java.util.ArrayList;
import java.util.List;

public class StudentService {
    
    private List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
    }

    // phương thức này luôn đúng, không cần test
    // có thể dùng phương thức này cho mục đích viết unit test
    public int size() {
        return students.size();
    }

    /* - Thêm sinh viên vào danh sách
         - Chỉ thêm khi mã số của sinh viên chưa tồn tại trong danh sách
         - Nếu tham số nhận vào là null thì ném ra ngoại lệ NullReferenceException
         - Nếu thêm thành công thì số lượng sinh viên tăng 1 và phương thức trả về true
         - Nếu thêm không thành công thì phương thức trả về false

         SỐ LƯỢNG TESTCASE TỐI THIỂU: 4
     * */
    public boolean addStudent(Student s)
    {
        for (Student x: students)
        {
            if (x.getId() == s.getId())
            {
                return true;
            }
        }

        students.add(s);
        return true;
    }

    /* - Lấy sinh viên tại vị trí position 
            - Nếu position nằm ngoài phạm vi của mảng (0 -> n-1) thì ném ra ngoại lệ ArrayIndexOutOfBoundsException
            - Nếu có ngoại lệ thì ngoại lệ phải có message là: 'Index {i} is not available in this array'. Trong đó {i} là giá trị của biến position.
            - Nếu vị trí nằm trong phạm vi của mảng thì cần đảm bảo trả về đúng người, đúng thông tin.

            SỐ LƯỢNG TESTCASE TỐI THIỂU: 3
    */
    public Student getStudentAt(int position)
    {
        if (position >= students.size())
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        return students.get(position);
    }

    /* - Tìm một sinh viên theo tuổi
            - Trả về sinh viên đầu tiên tìm được
            - Nếu không tìm được thì trả về null

            SỐ LƯỢNG TESTCASE TỐI THIỂU: 2
     */
    public Student findStudentByAge(int age)
    {
        Student sv = null;
        for (Student x: students)
        {
            if (x.getAge() == age)
            {
                sv = x;
                return sv;
            }
        }
        return sv;
    }

    /* - Tính điểm trung bình của toàn bộ sinh viên trong danh sách
         - Nếu chưa có sinh viên trong danh sách thì ném ra ngoại lệ RuntimeException
         - Ngoại lệ có message là "Student list is empty"

         SỐ LƯỢNG TESTCASE TỐI THIỂU: 3
     */
    public double getAverageScore()
    {
        if (students.size() == 0)
        {
            throw new RuntimeException("No student");
        }

        double sum = 0;
        for (Student x: students)
        {
            sum += x.getScore();
        }
        return sum / students.size();
    }

    /* - Tìm sinh viên có điểm số thấp nhất trong lớp
         - Nếu lớp không có sinh viên nào thì trả về null
         - Nếu lớp có nhiều sinh viên cùng có điểm thấp nhất thì trả về sinh viên nằm ở cuối

         SỐ LƯỢNG TESTCASE TỐI THIỂU: 3
     **/
    public Student findStudentWithMinScore()
    {
        if (students.size() == 0)
        {
            return null;
        }

        // find min score
        double minScore = students.get(0).getScore();
        for (Student x: students)
        {
            if (x.getScore() < minScore)
                minScore = x.getScore();
        }

        // find student with min score
        for (Student x: students)
        {
            if (x.getScore() == minScore)
            {
                return x;
            }
        }

        return null;
    }
}
