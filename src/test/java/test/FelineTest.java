package test;

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {


    @Test
    public void getFamilyReturnFeline() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensSetEmptyReturnOne() {
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }


    @Test
    public void getKittensSetCountReturnCount() {
        Feline feline = new Feline();
        int countKittens = 10;
        int expected = countKittens;
        int actual = feline.getKittens(countKittens);
        assertEquals(expected, actual);
    }


    @Test
    public void eatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        Assert.assertEquals(expectedFood, actualFood);
    }

}
