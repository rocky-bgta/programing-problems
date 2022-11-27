package core_java.design.pattern.abstract_factory_pattern.abstract_factory;

import core_java.design.pattern.abstract_factory_pattern.beans.Computer;

public class ComputerFactory {

    public static Computer createComputer(ComputerAbstractFactory computerAbstractFactory){
        return computerAbstractFactory.createComputer();
    }
}
