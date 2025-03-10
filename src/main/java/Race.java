import java.util.Scanner;

public class Race {
    private int CARS_NUMBER = 3;
    private int MAX_CAR_SPEED = 250;
    private int RACE_TIME = 24;
    Car[] cars;
    Car winner;

    Race () {
        cars = new Car[CARS_NUMBER];
        for(int memberNumber = 0; memberNumber < CARS_NUMBER; memberNumber++){
            Scanner scanner = new Scanner(System.in);
            String carName;
            while(true){
                System.out.printf("— Введите название машины №%d:\n", memberNumber + 1);
                carName = scanner.nextLine().strip(); System.out.println();
                if (!carName.isEmpty()) break;
                System.out.println("— Недопустимое название машины\n");
            }

            int carSpeed;
            while(true){
                System.out.printf("— Введите скорость машины №%d:\n", memberNumber + 1);
                /* carSpeed = scanner.hasNextInt() ? scanner.nextInt() : 0;  System.out.println();
                Пример решения выше более читаемый, но данный кейс уходит в бесконечный цикл при вводе
                числа с точкой, поэтому сделал обработку через try catch.
                Простое использование scanner.nextInt() так же может привсти к необработанному exception
                */
                try{
                    carSpeed = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e){
                    carSpeed = 0;
                }
                System.out.println();
                if(isSpeedValid(carSpeed)) break;
                System.out.println("— Неправильная скорость\n");
            }
            cars[memberNumber] = new Car(carName, carSpeed);
        }
    }

    public void runRace(){
        int[] raceResults = new int[CARS_NUMBER];
        int bestResultIndex = 0;
        for (int i = 0; i < raceResults.length; i++){
            raceResults[i] = calculateDistance(cars[i]);
            bestResultIndex = (raceResults[i] > raceResults[bestResultIndex]) ? i : bestResultIndex;
        }
        winner = cars[bestResultIndex];
    }

    private boolean isSpeedValid(int speed){
        return (0 < speed && speed <=MAX_CAR_SPEED);
    }

    private int calculateDistance(Car member){
        /*
        Подсчёт результатов гонки вынес в отдельную функцию
        для возможности доработки и расширения формулы
         */
        return member.speed * RACE_TIME;
    }
}



