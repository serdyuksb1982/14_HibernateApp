import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Courses")
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")//enum аннотация списка
    private CourseType type;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)//Многие к Одному -> Много курсов к одному учителю
    private Teacher teacher;
    public Teacher getTeacher() {
        return this.teacher;
    }



    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    @Column(name = "students_count")
    private int studentsCount;

    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;


    @ManyToMany
    @JoinTable(name = "Subscriptions",//аннотация cвязи типа - многие ко многим. У студентов может быть много курсов
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    private List<Student> students;//список студентов




    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)//mappedBy – обратная сторона связи сущности. Поле под этим атрибутом не сохраняется как часть исходной сущности в базе данных, но будет доступна по запросу.
    private List<Subscription> subscriptions;

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

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public CourseType getType() {
        return this.type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public String getDescrition() {
        return description;
    }

    public void setDescrition(String descrition) {
        this.description = descrition;
    }



    public int getStudentsCount() {
        return this.studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getPricePerHour() {
        return this.pricePerHour;
    }

    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    private void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

}
