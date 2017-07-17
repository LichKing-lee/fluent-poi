import org.junit.Before
import org.junit.Test

class ClusterTest{
    def number = 3

    @Before
    void setUp(){

    }

    @Test
    void test(){
        def person = new Person(age:19, name:"hello")
        println person.getName()
        println person.getAge()
    }
}

class Person{
    String name
    int age
}