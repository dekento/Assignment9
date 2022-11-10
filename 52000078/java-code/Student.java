public class Student {
    
    private int id;
    private String name;
    private int age;
    private double score;

    public Student()
    {

    }

    public Student(int id, String name, int age, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    /**
     * Trả về xếp loại của sinh viên theo ký tự A,B,C,D,E
            + [8, 10]: Loại A
            + [7, 8): Loại B
            + [5, 7): Loại C
            + [3.5, 5): Loại D
            + Dưới 3.5: Loại E

        CẦN TỐI THIỂU: 4 testcases
     */
    public char getLetterScore() {
        if (score >= 8.0) return 'A';
        if (score > 7.0) return 'B';
        if (score > 5.0) return 'C';
        if (score >= 3.5) return 'D';
        return 'E';
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", id=" + id + ", name=" + name + ", score=" + score + "]";
    }

    
    
}