package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class PackAnimal extends Animal{
    private Integer maxLoad;
    private Integer maxSpeed;
    private List<Goods> goods;

    public PackAnimal(String name, Date dateOfBirth, Integer maxLoad, Integer maxSpeed) {
        super(name, dateOfBirth);
        this.maxLoad = maxLoad;
        this.maxSpeed = maxSpeed;
    }
    public List<Goods> unload(){
        List<Goods> goods = this.goods;
        this.goods = new ArrayList<>();
        System.out.println("Вы разгрузили товары");
        return goods;
    }
    public void load(List<Goods> goods){
        this.goods.addAll(goods);
        System.out.println("Вы погрузили товары");
    }
    public Integer getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(Integer maxLoad) {
        this.maxLoad = maxLoad;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String toString() {
        return "PackAnimal {" +
                "name='" + getName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", maxLoad=" + maxLoad +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

}
