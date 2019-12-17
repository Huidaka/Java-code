package cn.Huidaka;

interface IAnimal {
    void cry();
}

class Dog implements IAnimal{
    @Override
    public void cry(){
        System.out.println("汪汪汪");
    }
}

class Cat implements IAnimal{
    @Override
    public void cry(){
        System.out.println("喵喵喵");
    }
}

class birdie implements IAnimal{
    @Override
    public void cry(){
        System.out.println("叽叽喳喳");
    }
}

class fish implements IAnimal{
    @Override
    public void cry() {

    }
}
