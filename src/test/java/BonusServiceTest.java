import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();


        long amount = 1000;
        boolean registered = true;
        long expected = 30;


        long actual = service.calculate(amount, registered);


        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();


        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;


        long actual = service.calculate(amount, registered);


        Assertions.assertEquals(expected, actual);


    }

    @Test
    void shouldCalculateForNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 50100;
        boolean registered = false;
        long expected = 500;


        long actual = service.calculate(amount, registered);


        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();


        long amount = 99;
        boolean registered = false;
        long expected = 0;


        long actual = service.calculate(amount, registered);


        Assertions.assertEquals(expected, actual);
    }
}

