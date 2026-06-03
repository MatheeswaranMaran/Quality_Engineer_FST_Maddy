class Car {
    engineName: string = "";
    gears: number = 0;
    private speed: number;

    constructor(speed: number = 0) {
        this.speed = speed;
    }

    accelerate(): void {
        this.speed++;
    }

    throttle(): void {
        this.speed--;
    }

    getSpeed(): void {
        console.log(this.speed);
    }

    static numberOfWheels(): number {
        return 4;
    }
}

let car = new Car(5);

car.accelerate();
car.getSpeed();

console.log(Car.numberOfWheels());