package test;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {

    private String sex;
    private boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "sex={0}, hasMane={1}")
    public static Object[] dataSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    Feline feline = new Feline();

    @Test
    public void getKittensSetEmptyReturnOne() throws Exception {
        Lion lion = new Lion(sex, feline);
        int expected = 1;
        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodForLine() throws Exception {
        Lion lion = new Lion(sex, feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean expected = hasMane;
        Assert.assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    public void doesHaveUnknownSexException() throws Exception {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            Lion lion = new Lion("UnknownSex", feline);
        });
        String expected = "Используйте допустимые значения пола животного - самей или самка";
        Assert.assertEquals(expected, exception.getMessage());
    }
}

