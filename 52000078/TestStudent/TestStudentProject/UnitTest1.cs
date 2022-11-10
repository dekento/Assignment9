using StudentService;
namespace TestStudentProject
{
    [TestClass]
    public class TestCalculator
    {
        [TestMethod]
        public void addNewStudent_ShouldBeSuccess ()
        {
            StudentService.StudentService service = new StudentService.StudentService();
            Student student = new Student(){Id=1, Name ="Dat Ecchi", Age=20 };
            bool addStudent = service.addStudent(student);
            int length = service.size();
            Assert.IsTrue(addStudent);
            Assert.AreEqual(1, length);

        }

        [TestMethod]
        public void AddDuplicateStudent_ShouldReturnFalse()
        {
            StudentService.StudentService service = new StudentService.StudentService();
            Student student1 = new Student() { Id = 1, Age = 30, Name = "Tuan", Score = 5.0 };
            Student student2 = new Student() { Id = 1, Age = 30, Name = "Tuan", Score = 5.0 };

            service.addStudent(student1);
            bool status = service.addStudent(student2);
            Assert.IsFalse(status);
        }

        [TestMethod]
        [ExpectedException(typeof(NullReferenceException))]
        public void passingNullParemeter_ShowThrow_NullRefException()
        {
            StudentService.StudentService sv = new StudentService.StudentService();
            sv.addStudent(null);

        }

        [TestMethod]
        public void addStudentSuccess_SizeStudentIncreaseReturnTrue()
        {
            StudentService.StudentService sv = new StudentService.StudentService();
            Student student1 = new Student() { Id = 1, Age = 20, Name = "Duy loli", Score = 7.0 };
            Student student2 = new Student() { Id = 2, Age = 30, Name = "Dat Echi", Score = 6.0 };
            sv.addStudent(student1);
            sv.addStudent(student2);
            int length1 = sv.size();
            Student student3 = new Student() { Id = 3, Age = 40, Name = "Binh haiten", Score = 8.0 };
            sv.addStudent(student3);
            int length2 = sv.size();
            Assert.AreEqual(length1+1,length2);
        }


    }
}