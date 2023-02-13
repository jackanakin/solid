import { Product } from "./Product";

/**
 * Concrete Products provide various implementations of the Product interface.
 */
export class ConcreteProduct1 implements Product {
    public operation(): string {
        return '{Result of the ConcreteProduct1}';
    }
}