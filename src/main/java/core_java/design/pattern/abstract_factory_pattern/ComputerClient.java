package core_java.design.pattern.abstract_factory_pattern;

import core_java.design.pattern.abstract_factory_pattern.abstract_factory.ComputerFactory;
import core_java.design.pattern.abstract_factory_pattern.abstract_factory.PCFactory;
import core_java.design.pattern.abstract_factory_pattern.abstract_factory.ServerFactory;
import core_java.design.pattern.abstract_factory_pattern.beans.Computer;

public class ComputerClient {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.createComputer(new PCFactory("2 GB", "500 GB","2.4 GHz"));
        Computer server = ComputerFactory.createComputer(new ServerFactory("10 GB", "10 TB","5.0 GHz"));

    }
}
