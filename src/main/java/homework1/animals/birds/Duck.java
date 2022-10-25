package homework1.animals.birds;

import homework1.animals.Animal;

public class Duck extends Animal implements IFlying {

    @Override
    public void say() {
        System.out.println("кря ");
    }

        @Override
        public void fly(){
            System.out.println("я лечу ");
    }

}
