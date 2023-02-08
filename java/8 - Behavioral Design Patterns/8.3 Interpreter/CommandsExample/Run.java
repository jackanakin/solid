interface Expression {
    boolean interpret(String context);
}

class ShowInterfacesExpression implements Expression {
    public boolean interpret(String context) {
        return context.contains("show interfaces");
    }
}

class ConfigureTerminalExpression implements Expression {
    public boolean interpret(String context) {
        return context.contains("configure terminal");
    }
}

class ConfigureInterfaceExpression implements Expression {
    private Expression interfaceExpression;
    private Expression configureExpression;

    public ConfigureInterfaceExpression(Expression interfaceExpression, Expression configureExpression) {
        this.interfaceExpression = interfaceExpression;
        this.configureExpression = configureExpression;
    }

    public boolean interpret(String context) {
        return interfaceExpression.interpret(context) && configureExpression.interpret(context);
    }
}

class Run {
    public static void main(String[] args) {
        String input = "show interfaces";
        Expression showInterfaces = new ShowInterfacesExpression();
        System.out.println("show interfaces is " + showInterfaces.interpret(input));
        
        input = "configure terminal";
        Expression configureTerminal = new ConfigureTerminalExpression();
        System.out.println("configure terminal is " + configureTerminal.interpret(input));
        
        input = "configure interface FastEthernet0/0";
        Expression interfaceExpression = new ShowInterfacesExpression();
        Expression configureExpression = new ConfigureTerminalExpression();
        Expression configureInterface = new ConfigureInterfaceExpression(interfaceExpression, configureExpression);
        System.out.println("configure interface FastEthernet0/0 is " + configureInterface.interpret(input));
    }
}