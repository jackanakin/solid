import { ConcreteProduct2 } from "./ConcreteProduct2";
import { Creator } from "./Creator";
import { Product } from "./Product";

export class ConcreteCreator2 extends Creator {
    public factoryMethod(): Product {
        return new ConcreteProduct2();
    }
}